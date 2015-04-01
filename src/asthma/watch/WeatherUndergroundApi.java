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
//			request.setAttribute("current", weatherInfo);
			request.setAttribute("heatIndex",
					weatherInfo.current_observation.heat_index_f);
			request.setAttribute("pressureTrend",
					weatherInfo.current_observation.pressure_trend);
			request.setAttribute("relativeHumidity",
					weatherInfo.current_observation.relative_humidity);
			request.setAttribute("tempF",
					weatherInfo.current_observation.temp_f);
			request.setAttribute("UV", weatherInfo.current_observation.UV);
			request.setAttribute("windDir",
					weatherInfo.current_observation.wind_dir);
			request.setAttribute("windMph",
					weatherInfo.current_observation.wind_mph);
			request.setAttribute("windString",
					weatherInfo.current_observation.wind_string);
		}
	}

	protected static void fetchForecastInfo(HttpServletRequest request,
			HttpServletResponse response, URL url) throws IOException {
		String json = AsthmaWatch.getJson(url);
		if (json != null && !json.isEmpty()) {
			Gson gson = new GsonBuilder().create();
			ForecastInfo forecastInfo = gson.fromJson(json, ForecastInfo.class);
			forecastInfo.setVariables();
			for (int i = 0; i < forecastInfo.forecast.simpleforecast.forecastday.length; i++) {
				request.setAttribute("forecast", forecastInfo);
//				request.setAttribute(
//						"day" + i + "High",
//						forecastInfo.forecast.simpleforecast.forecastday[i].high.farenheit);
//				request.setAttribute(
//						"day" + i + "Low",
//						forecastInfo.forecast.simpleforecast.forecastday[i].low.farenheit);
//				request.setAttribute(
//						"day" + i + "Average Wind",
//						forecastInfo.forecast.simpleforecast.forecastday[i].avewind.mph);
//				request.setAttribute(
//						"day" + i + "Conditions",
//						forecastInfo.forecast.simpleforecast.forecastday[i].conditions);
//				request.setAttribute(
//						"day" + i + "Humidity",
//						forecastInfo.forecast.simpleforecast.forecastday[i].avehumidity);
			}
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
