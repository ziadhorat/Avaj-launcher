package src;
import src.aircrafts.Coordinates;

public class WeatherTower extends Tower {
//	These are simulation counters. Added by me, not in UML
	private int		totalSimulations;
	private int		simulationsCount;

	WeatherTower(int totalSims) throws NumberFormatException {
		if (totalSims < 0)
			throw new NumberFormatException();

		this.totalSimulations = totalSims;
		this.simulationsCount = 0;
	}

	public int getTotalSims() {	return this.totalSimulations; }
	public int getSimsCount() {	return this.simulationsCount; }
	public void countSimulation() { this.simulationsCount++; }

//	From UML
	public String getWeather(Coordinates coordinates) {
		return  WeatherProvider.getProvider().getCurrentWeather(coordinates);
	}

	void changeWeather() {
		this.conditionsChanged();
	}
}
