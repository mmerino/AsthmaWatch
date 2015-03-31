package asthma.watch;

public class WeatherInfo {
	Current_Observation current_observation;
}

class Current_Observation {
	double temp_f;
	String relative_humidity;
	String wind_string;
	String wind_dir;
	double wind_mph;
	String pressure_trend;
	String heat_index_f;
	String UV;
}