package asthma.watch;

public class ForecastInfo {
	Forecast forecast;
}

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
}

class High {
	String farenheit;
}

class Low {
	String farenheit;
}

class AveWind {
	long mph;
}