package asthma.watch;

import java.io.IOException;
import java.net.URL;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.JsonParser;

public class ApiAccess {

	protected static void fetchWeatherInformation(HttpServletRequest request,
			HttpServletResponse response, String weatherType, URL url)
			throws ServletException, IOException {
		String json = AsthmaWatch.getJson(url);
		Gson gson = new GsonBuilder().create();
		ApiInterface weatherInfo;
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
			invalidWeatherType(request, response);
		}
		weatherInfo.setAttributes();
		request.setAttribute(weatherType, weatherInfo);
	}
	
	protected static void invalidWeatherType(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException  {
		request.setAttribute("message", "Invalid API call.");
		request.getRequestDispatcher("displayResults.jsp").forward(request,
				response);
	}
}
