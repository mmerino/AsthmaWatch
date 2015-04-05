package asthma.watch;

public class WeatherInfo implements WeatherInterface {
	Current_Observation current_observation;
	
	double temp;
	String relativeHumidity;
	String windDescription;
	String windDirection;
	double windSpeed;
	String pressureTrend;
	String heatIndex;
	String uvIndex;

	double humidityBar;
	double windBar;
	double tempBar;
	
	public void setAttributes() {
		this.temp = current_observation.temp_f;
		this.relativeHumidity = current_observation.relative_humidity;
		this.windDescription = current_observation.wind_string;
		this.windDirection = current_observation.wind_dir;
		this.windSpeed = current_observation.wind_mph;
		this.pressureTrend = current_observation.pressure_trend;
		this.heatIndex = current_observation.heat_index_f;
		this.uvIndex = current_observation.UV;
		setAllBars();
	}
	
	public void setAllBars() {
		setTempBar();
		setHumidityBar();
		setWindBar();
	}
	
	public void setTempBar() {
		if (temp < 32 || temp > 85) {
			tempBar = 3.0;
		} else if (temp <45  && temp > 70) {
			tempBar = 2.0;
		} else {
			tempBar = 1.0;
		}
	}

	public void setHumidityBar() {
		double humidity = Double.parseDouble(relativeHumidity.replaceAll(
				"%", ""));
		if (humidity < 30 || humidity > 60) {
			humidityBar = 3.0;
		} else {
			humidityBar = 1.0;
		}
	}

	public void setWindBar() {
		if (windSpeed < 12) {
			windBar = 1.0;
		} else if (windSpeed > 24) {
			windBar = 3.0;
		} else {
			windBar = 2.0;
		}
	}

	public double getTemp() {
		return temp;
	}

	public double getHumidity() {
		String humidity = relativeHumidity.replaceAll("%", "");
		return Double.parseDouble(humidity);
	}

	public String getWindDescription() {
		return windDescription;
	}

	public String getWindDirection() {
		return windDirection;
	}

	public double getWindSpeed() {
		return windSpeed;
	}

	public String getPressureTrend() {
		return pressureTrend;
	}

	public String getHeatIndex() {
		return heatIndex;
	}

	public double getUv() {
		return Double.parseDouble(uvIndex);
	}

	public double getTempBar() {
		return tempBar;
	}

	public double getHumidityBar() {
		return humidityBar;
	}

	public double getWindBar() {
		return windBar;
	}

	
	public class Current_Observation {
		double temp_f;
		String relative_humidity;
		String wind_string;
		String wind_dir;
		double wind_mph;
		String pressure_trend;
		String heat_index_f;
		String UV;

		double humidityBar;
		double windBar;
		double tempBar;

		public void setTempBar() {
			if (temp_f < 32 || temp_f > 85) {
				tempBar = 3.0;
			} else if (temp_f <45  && temp_f > 70) {
				tempBar = 2.0;
			} else {
				tempBar = 1.0;
			}
		}

		public void setHumidityBar() {
			double humidity = Double.parseDouble(relative_humidity.replaceAll(
					"%", ""));
			if (humidity < 30 || humidity > 60) {
				humidityBar = 3.0;
			} else {
				humidityBar = 1.0;
			}
		}

		public void setWindBar() {
			if (wind_mph < 12) {
				windBar = 1.0;
			} else if (wind_mph > 24) {
				windBar = 3.0;
			} else {
				windBar = 2.0;
			}
		}

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

		public double getTempBar() {
			return tempBar;
		}

		public double getHumidityBar() {
			return humidityBar;
		}

		public double getWindBar() {
			return windBar;
		}
	}
}