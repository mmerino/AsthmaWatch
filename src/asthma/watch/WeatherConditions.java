package asthma.watch;

public class WeatherConditions {
	Current_Observation current_observation;
}

class Current_Observation {
	String relative_humidity;
	double wind_mph;
	String heat_index_f;
	String pressure_trend;
}