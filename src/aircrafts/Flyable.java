package src.aircrafts;
import src.WeatherTower;

public interface Flyable {
//	From UML, Fluable represents an Observer pattern (Subscriber)
	void updateConditions();
	void registerTower(WeatherTower weatherTower);
	String getFullId();
}
