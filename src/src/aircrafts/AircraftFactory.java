package src.aircrafts;
import src.AvajException;

public class AircraftFactory {
// 	From UML, AircraftFactory is a Factory Method, it makes creating new aircrafts simple
	public static Flyable newAircraft(String type, String name, int longitude, int latitude, int height) throws AvajException {

		Coordinates coords = new Coordinates(longitude, latitude, height);

		// Handles weird casing of airplane types in scenario.txt
		if (type.toLowerCase().equals("helicopter")) {
			return new Helicopter(name, coords);
		}
		else if (type.toLowerCase().equals("jetplane")) {
			return new JetPlane(name, coords);
		}
		else if (type.toLowerCase().equals("baloon")) {
			return new Baloon(name, coords);
		}
		// Unknown aircraft type error
		else throw new AvajException("ERROR. Is it a bird? Is it a plane? Whatever it is, I do not know: \'" + type + "\'");
	}
}
