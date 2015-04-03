package asthma.watch;

import java.io.IOException;
import java.net.URL;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

public class WeatherUndergroundApi {

	protected static void fetchWeatherInfo(HttpServletRequest request,
			HttpServletResponse response, URL url) throws IOException {
		String json = AsthmaWatch.getJson(url);
		if (json != null && !json.isEmpty()) {
			Gson gson = new GsonBuilder().create();
			WeatherInfo weatherInfo = gson.fromJson(json, WeatherInfo.class);
			weatherInfo.current_observation.setHumidityBar();
			weatherInfo.current_observation.setTempBar();
			weatherInfo.current_observation.setWindBar();
			request.setAttribute("current", weatherInfo.current_observation);
		}
	}

	protected static void fetchForecastInfo(HttpServletRequest request,
			HttpServletResponse response, URL url) throws IOException {
		String json = AsthmaWatch.getJson(url);
		if (json != null && !json.isEmpty()) {
			Gson gson = new GsonBuilder().create();
			ForecastInfo forecastInfo = gson.fromJson(json, ForecastInfo.class);
			request.setAttribute("forecast",
					forecastInfo.forecast.simpleforecast.forecastday);
		}
	}

	protected static void fetchAstronomyInfo(HttpServletRequest request,
			HttpServletResponse response, URL url) throws IOException {
		String json = AsthmaWatch.getJson(url);
		if (json != null && !json.isEmpty()) {
			Gson gson = new GsonBuilder().create();
			AstronomyInfo astronomyInfo = gson.fromJson(json,
					AstronomyInfo.class);
			request.setAttribute("astronomy", astronomyInfo);
		}
	}
}
