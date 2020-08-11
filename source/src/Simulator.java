package src;
import src.aircrafts.AircraftFactory;
import src.aircrafts.Flyable;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

public class Simulator {

	private BufferedReader reader;
	private Logger logger = new Logger();
	private WeatherTower tower;
	private ArrayList<Flyable> aircrafts = new ArrayList<>();

	private Simulator() {}

	private void parseScenario(String filePath) throws AvajException, IOException {

		reader = new BufferedReader(new FileReader(filePath));
		String ln;
		int lnCount = 0;

//		Handles total number of simulation
		do {
			ln = reader.readLine();
			lnCount++;
			if (ln == null)
				throw new AvajException("ERROR: Simulation file don't got nothin' in it.");
			if (ln.length() > 0) {
				try {
					ln = ln.trim();
					tower = new WeatherTower(Integer.parseInt(ln));
					break;
				} catch (NumberFormatException e) {
					throw new AvajException("ERROR. Number of simulations (first line of the scenario) " +
							"must be a positive integer, I can't tell you what happened in the past.");
				}
			}
		} while (ln != null);

//		Handles the Init of the list of aircrafts
		while (ln != null) {

			ln = reader.readLine();
			lnCount++;
			if (ln == null || ln.length() == 0)
				continue;

			String split[] = ln.split(" ");
			if (split.length == 0)
				continue;
			if (split.length != 5)
				throw new AvajException("ERROR: Invalid line #" + lnCount + " in a scenario file.");

// 			Handles and validates co-ordinates
			try {
				int coords[] = { Integer.parseInt(split[2]), Integer.parseInt(split[3]), Integer.parseInt(split[4]) };
				for (int c : coords) {
					if (c < 1)
						throw new AvajException("ERROR: Invalid line #" + lnCount + " in a scenario file." +
												"\nCoordinates must be POSITIVE INTEGERS!");
				}

				aircrafts.add(AircraftFactory.newAircraft(split[0], split[1], coords[0], coords[1], coords[2]));

			} catch (NumberFormatException e) {
				throw new AvajException("ERROR: Invalid line #" + lnCount + " in a scenario file." +
						"\nCoordinates must be 3 positive, space-separated integers.");
			}
		}
		reader.close();
	}

	private void runSimulation(Simulator simulator) {

		for (Flyable a : simulator.aircrafts) {
			a.registerTower(simulator.tower);
		}

		while (simulator.tower.getSimsCount() < simulator.tower.getTotalSims()) {
			Logger.logLine("\t== Simulation #" + (simulator.tower.getSimsCount() + 1) + " ==");
			simulator.tower.changeWeather();
			simulator.tower.countSimulation();
		}
	}


	public static void main (String[]args) {

// 		Handles initial validation before begining any attempts at simulations
		try {

			if (args.length != 1) {
				throw new AvajException("ERROR: Please provide a file path as a single argument, not 2, not 0, just 1.");
			}

			Simulator simulator = new Simulator();

			simulator.parseScenario(args[0]);
			if (simulator.aircrafts.size() == 0)
				throw new AvajException("ERROR: No aircrafts in the scenario file, no work for me to do, Goodbye.");

			simulator.runSimulation(simulator);

			System.out.println("We have run " + simulator.tower.getTotalSims() + " simulations.");
			System.out.println("Results are logged to simulation.txt file.");

		} catch (AvajException e) {
			System.out.println(e.getMessage());
			AvajException.printInputFileHelp();
		} catch (IOException e) {
			System.out.println("ERROR: This dang file \'" + args[0] + "\' doesn't seem to exist! (Or I just can't read it).");
		} finally {
			Logger.closeFile();
		}
	}
}

