package asthma.watch;

public class ForecastInfo {
	Forecast forecast;

	class Forecast {
		SimpleForecast simpleforecast;
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
		
//		public High getHigh() {
//			return high;
//		}
//		public Low getLow() {
//			return low;
//		}
//		public AveWind getAveWind() {
//			return avewind;
//		}
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
