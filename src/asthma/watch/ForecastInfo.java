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
		public AveWind getAvewind() {
			return avewind;
		}
		public String getConditions() {
			return conditions;
		}
		public double getAvehumidity() {
			return avehumidity;
		}
	}

	class High {
		String farenheit;

		public String getFarenheit() {
			return farenheit;
		}
	}

	class Low {
		String farenheit;

		public String getFarenheit() {
			return farenheit;
		}
	}

	class AveWind {
		long mph;

		public long getMph() {
			return mph;
		}
	}
}
