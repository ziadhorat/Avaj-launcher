package src.aircrafts;
import src.Logger;
import src.WeatherTower;
import java.util.HashMap;

public class JetPlane extends Aircraft implements Flyable {
	private WeatherTower weatherTower;

	JetPlane(String name, Coordinates coordinates) {
		super(name, coordinates);
		this.type = "JetPlane";
	}

	public void updateConditions() {

		HashMap<String, String> reports = new HashMap<>();
		reports.put("SUN", "Hey, SUN came out again. - SAVING MR. BANKS");
		reports.put("RAIN", "When you get sad, it RAINs. - MEN IN BLACK 2");
		reports.put("FOG", "Look for the FOG! - THE FOG");
		reports.put("SNOW", "Do you wanna build a SNOW man? - FROZEN");

		String weather = this.weatherTower.getWeather(this.coordinates);
		if (weather.equals("SUN")) {
			this.coordinates = new Coordinates(
					this.coordinates.getLongitude(),
					this.coordinates.getLatitude() + 10,
					this.coordinates.getHeight() + 2);
		}
		else if (weather.equals("RAIN")) {
			this.coordinates = new Coordinates(
					this.coordinates.getLongitude(),
					this.coordinates.getLatitude() + 5,
					this.coordinates.getHeight());
		}
		else if (weather.equals("FOG")) {
			this.coordinates = new Coordinates(
					this.coordinates.getLongitude(),
					this.coordinates.getLatitude() + 1,
					this.coordinates.getHeight());
		}
		else if (weather.equals("SNOW")) {
			this.coordinates = new Coordinates(
					this.coordinates.getLongitude(),
					this.coordinates.getLatitude(),
					this.coordinates.getHeight() - 7);
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
