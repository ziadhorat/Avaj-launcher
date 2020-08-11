package src.aircrafts;
import src.Logger;
import src.WeatherTower;
import java.util.HashMap;

public class Helicopter extends Aircraft implements Flyable {
	private WeatherTower weatherTower;

	Helicopter(String name, Coordinates coordinates) {
		super(name, coordinates);
		this.type = "Helicopter";
	}

	public void updateConditions() {

		HashMap<String, String> reports = new HashMap<>();
		reports.put("SUN", "I cannot endure to waste anything so precious as autumnal SUNshine by staying in the house. - Nathaniel Hawthorne");
		reports.put("RAIN", "The way I see it, if you want the rainbow, you gotta put up with the RAIN. - Dolly Parton");
		reports.put("FOG", "When your mind is (as) FOGgy (as this weather), all you need is the winds of wisdom! - Mehmet Murat ildan");
		reports.put("SNOW", "The SNOW doesn't give a soft white damn whom it touches. - E.E. Cummings");

		String weather = this.weatherTower.getWeather(this.coordinates);
		if (weather.equals("SUN")) {
			this.coordinates = new Coordinates(
					this.coordinates.getLongitude() + 10,
					this.coordinates.getLatitude(),
					this.coordinates.getHeight() + 2);
		}
		else if (weather.equals("RAIN")) {
			this.coordinates = new Coordinates(
					this.coordinates.getLongitude() + 5,
					this.coordinates.getLatitude(),
					this.coordinates.getHeight());
		}
		else if (weather.equals("FOG")) {
			this.coordinates = new Coordinates(
					this.coordinates.getLongitude() + 1,
					this.coordinates.getLatitude(),
					this.coordinates.getHeight());
		}
		else if (weather.equals("SNOW")) {
			this.coordinates = new Coordinates(
					this.coordinates.getLongitude(),
					this.coordinates.getLatitude(),
					this.coordinates.getHeight() - 12);
		}

		Logger.logLine(this.getFullId() + ": " + reports.get(weather));

		if (this.coordinates.getHeight() == 0) {
			Logger.logLine(this.getFullId() + ": Landing... Coordinates: " + this.coordinates.getCoordinates());
			this.weatherTower.unregister(this);
		}

	}

	public void registerTower(WeatherTower tower) {
		this.weatherTower = tower;
		this.weatherTower.register(this);
	}
}
