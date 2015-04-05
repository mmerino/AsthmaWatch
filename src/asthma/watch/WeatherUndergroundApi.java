package asthma.watch;

import java.io.IOException;
import java.net.URL;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.JsonParser;

public class WeatherUndergroundApi {

	protected static void fetchWeatherInformation(HttpServletRequest request,
			HttpServletResponse response, String weatherType, URL url)
			throws IOException {
		String json = AsthmaWatch.getJson(url);
		Gson gson = new GsonBuilder().create();
		WeatherInterface weatherInfo;
		switch (weatherType) {
		case "conditions":
			weatherInfo = new WeatherInfo();
			weatherInfo = gson.fromJson(json, WeatherInfo.class);
			break;
		case "forecast":
			weatherInfo = new ForecastInfo();
			weatherInfo = gson.fromJson(json, ForecastInfo.class);
			break;
		case "astronomy":
			weatherInfo = new AstronomyInfo();
			weatherInfo = gson.fromJson(json, AstronomyInfo.class);
			break;
		case "pollution":
			weatherInfo = new PollutionInfo();
			JsonParser parser = new JsonParser();
			json = parser.parse(json).getAsJsonArray().get(0).toString();
			weatherInfo = gson.fromJson(json, PollutionInfo.class);
			break;
		case "pollen":
			weatherInfo = new PollenInfo();
			json = json.replaceAll("\\\\", "");
			json = json.substring(1, json.length() - 1);
			weatherInfo = gson.fromJson(json, PollenInfo.class);
			break;
		default:
			weatherInfo = new WeatherInfo();
		}
		// if (weatherType.equals("conditions")) {
		// weatherInfo = new WeatherInfo();
		// weatherInfo = gson.fromJson(json, WeatherInfo.class);
		// } else if (weatherType.equals("forecast")) {
		// weatherInfo = new ForecastInfo();
		// weatherInfo = gson.fromJson(json, ForecastInfo.class);
		// } else if (weatherType.equals("astronomy")) {
		// weatherInfo = new AstronomyInfo();
		// weatherInfo = gson.fromJson(json, AstronomyInfo.class);
		// } else if (weatherType.equals("pollution")) {
		// weatherInfo = new PollutionInfo();
		// JsonParser parser = new JsonParser();
		// json = parser.parse(json).getAsJsonArray().get(0).toString();
		// weatherInfo = gson.fromJson(json, PollutionInfo.class);
		// } else if (weatherType.equals("pollen")) {
		// weatherInfo = new PollenInfo();
		// json = json.replaceAll("\\\\", "");
		// json = json.substring(1, json.length() - 1);
		// weatherInfo = gson.fromJson(json, PollenInfo.class);
		// }
		weatherInfo.setAttributes();
		request.setAttribute(weatherType, weatherInfo);
	}
//
//	protected static void fetchWeatherInfo(HttpServletRequest request,
//			HttpServletResponse response, URL url) throws IOException {
//		String json = AsthmaWatch.getJson(url);
//		if (json != null && !json.isEmpty()) {
//			Gson gson = new GsonBuilder().create();
//			WeatherInfo weatherInfo = gson.fromJson(json, WeatherInfo.class);
//			weatherInfo.setAttributes();
//			request.setAttribute("current", weatherInfo);
//		}
//	}
//
//	protected static void fetchForecastInfo(HttpServletRequest request,
//			HttpServletResponse response, URL url) throws IOException {
//		String json = AsthmaWatch.getJson(url);
//		if (json != null && !json.isEmpty()) {
//			Gson gson = new GsonBuilder().create();
//			ForecastInfo forecastInfo = gson.fromJson(json, ForecastInfo.class);
//			forecastInfo.setAttributes();
//			request.setAttribute("forecast", forecastInfo);
//		}
//	}
//
//	protected static void fetchAstronomyInfo(HttpServletRequest request,
//			HttpServletResponse response, URL url) throws IOException {
//		String json = AsthmaWatch.getJson(url);
//		if (json != null && !json.isEmpty()) {
//			Gson gson = new GsonBuilder().create();
//			AstronomyInfo astronomyInfo = gson.fromJson(json,
//					AstronomyInfo.class);
//			request.setAttribute("astronomy", astronomyInfo);
//		}
//	}
}
