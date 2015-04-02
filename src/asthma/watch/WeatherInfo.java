package asthma.watch;

public class WeatherInfo {
	Current_Observation current_observation;

	public class Current_Observation {
		double temp_f;
		String relative_humidity;
		String wind_string;
		String wind_dir;
		double wind_mph;
		String pressure_trend;
		String heat_index_f;
		String UV;

		public double getTemp() {
			return temp_f;
		}

		public double getHumidity() {
			String humidity = relative_humidity.replaceAll("%", "");
			return Double.parseDouble(humidity);
		}

		public String getWindDescription() {
			return wind_string;
		}

		public String getWindDirection() {
			return wind_dir;
		}

		public double getWindSpeed() {
			return wind_mph;
		}

		public String getPressureTrend() {
			return pressure_trend;
		}

		public String getHeatIndex() {
			return heat_index_f;
		}

		public double getUv() {
			return Double.parseDouble(UV);
		}
	}
}