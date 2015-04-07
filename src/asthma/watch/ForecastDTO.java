package asthma.watch;

public class ForecastDTO implements DAOInterface {
	Forecast forecast;

	String[] high;
	String[] low;
	long[] aveWindSpeed;
	String[] conditions;
	double[] aveHumidity;
	String[] forecastIcon;

	public void setAttributes() {
		int forecastLength = forecast.simpleforecast.forecastday.length;
		high = new String[forecastLength];
		low = new String[forecastLength];
		aveWindSpeed = new long[forecastLength];
		conditions = new String[forecastLength];
		aveHumidity = new double[forecastLength];
		forecastIcon = new String[forecastLength];
		for (int i = 0; i < forecastLength; i++) {
			this.high[i] = forecast.simpleforecast.forecastday[i].high.fahrenheit;
			this.low[i] = forecast.simpleforecast.forecastday[i].low.fahrenheit;
			this.aveWindSpeed[i] = forecast.simpleforecast.forecastday[i].avewind.mph;
			this.conditions[i] = forecast.simpleforecast.forecastday[i].conditions;
			this.aveHumidity[i] = forecast.simpleforecast.forecastday[i].avehumidity;
			this.forecastIcon[i] = forecast.txt_forecast.forecastday[i].icon_url;
		}
	}
	
	public String[] getHigh() {
		return high;
	}

	public String[] getLow() {
		return low;
	}

	public long[] getAveWindSpeed() {
		return aveWindSpeed;
	}

	public String[] getConditions() {
		return conditions;
	}

	public double[] getAveHumidity() {
		return aveHumidity;
	}

	public String[] getForecastIcon() {
		return forecastIcon;
	}

	class Forecast {
		SimpleForecast simpleforecast;
		Txt_Forecast txt_forecast;
	}

	class Txt_Forecast {
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
	}

	class High {
		String fahrenheit;
	}

	class Low {
		String fahrenheit;
	}

	class AveWind {
		long mph;
	}
}
