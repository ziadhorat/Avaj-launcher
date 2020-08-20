package src.aircrafts;
import src.Logger;
import src.WeatherTower;
import java.util.HashMap;

public class Baloon extends Aircraft implements Flyable {
	private WeatherTower weatherTower;

	Baloon(String name, Coordinates coordinates) {
		super(name, coordinates);
		this.type = "Baloon";
	}

	public void updateConditions() {

		HashMap<String, String> reports = new HashMap<>();
		reports.put("SUN", "SUNshine Song - Jason Mraz");
		reports.put("RAIN", "November RAIN - Guns N' Roses");
		reports.put("FOG", "The FOG - Maroon 5");
		reports.put("SNOW", "SNOW (Hey Oh) - Red Hot Chili Peppers");

		String weather = this.weatherTower.getWeather(this.coordinates);
		if (weather.equals("SUN")) {
			this.coordinates = new Coordinates(
					this.coordinates.getLongitude() + 2,
					this.coordinates.getLatitude(),
					this.coordinates.getHeight() + 4);
		}
		else if (weather.equals("RAIN")) {
			this.coordinates = new Coordinates(
					this.coordinates.getLongitude(),
					this.coordinates.getLatitude(),
					this.coordinates.getHeight() - 5);
		}
		else if (weather.equals("FOG")) {
			this.coordinates = new Coordinates(
					this.coordinates.getLongitude(),
					this.coordinates.getLatitude(),
					this.coordinates.getHeight() - 3);
		}
		else if (weather.equals("SNOW")) {
			this.coordinates = new Coordinates(
					this.coordinates.getLongitude(),
					this.coordinates.getLatitude(),
					this.coordinates.getHeight() - 15);
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
