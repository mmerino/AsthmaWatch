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
		Gson gson = new GsonBuilder().create();
		WeatherInfo weatherInfo = gson.fromJson(json,
				WeatherInfo.class);
		request.setAttribute("heatIndex", weatherInfo.current_observation.heat_index_f);
		request.setAttribute("pressureTrend", weatherInfo.current_observation.pressure_trend);
		request.setAttribute("relativeHumidity", weatherInfo.current_observation.relative_humidity);
		request.setAttribute("tempF", weatherInfo.current_observation.temp_f);
		request.setAttribute("UV", weatherInfo.current_observation.UV);
		request.setAttribute("windDir", weatherInfo.current_observation.wind_dir);
		request.setAttribute("windMph", weatherInfo.current_observation.wind_mph);
		request.setAttribute("windString", weatherInfo.current_observation.wind_string);
	}

	protected static void fetchAstronomyInfo(HttpServletRequest request,
			HttpServletResponse response, URL url) throws IOException {
		String json = AsthmaWatch.getJson(url);
		Gson gson = new GsonBuilder().create();
		AstronomyInfo astronomyInfo = gson.fromJson(json,
				AstronomyInfo.class);
		request.setAttribute("astronomy", astronomyInfo.moon_phase);
	}

}
