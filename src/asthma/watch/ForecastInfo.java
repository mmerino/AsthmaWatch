package asthma.watch;

public class ForecastInfo {
	Forecast forecast;

	class Forecast {
		SimpleForecast simpleforecast;
	}
	
	class TxtForecast {
		ForecastDay[] forecastday;
	}

	class SimpleForecast {
		ForecastDay[] forecastday;
	}

	class ForecastDay {
		High high;
		Low low;
		AveWind avewind;
		String conditions;
		double avehumidity;
		String icon_url;
		
		public String getForecastIcon() {
			return icon_url;
		}
		public String getConditions() {
			return conditions;
		}
		public double getAveHumidity() {
			return avehumidity;
		}
	}

	class High {
		String farenheit;

		public double getHigh() {
			return Double.parseDouble(farenheit);
		}
	}

	class Low {
		String farenheit;

		public double getLow() {
			return Double.parseDouble(farenheit);
		}
	}

	class AveWind {
		long mph;

		public long getaveWind() {
			return mph;
		}
	}
}
