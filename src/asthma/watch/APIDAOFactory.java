package asthma.watch;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.URL;
import java.nio.charset.StandardCharsets;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.JsonParser;

public class APIDAOFactory {

	protected static DAOInterface fetchWeatherInformation(String weatherType, URL url)
			throws ServletException, IOException {
		String json = getJson(url);
		Gson gson = new GsonBuilder().create();
		DAOInterface weatherInfo;
		switch (weatherType) {
		case "conditions":
			weatherInfo = new WeatherDTO();
			weatherInfo = gson.fromJson(json, WeatherDTO.class);
			break;
		case "forecast":
			weatherInfo = new ForecastDTO();
			weatherInfo = gson.fromJson(json, ForecastDTO.class);
			break;
		case "astronomy":
			weatherInfo = new AstronomyInfo();
			weatherInfo = gson.fromJson(json, AstronomyInfo.class);
			break;
		case "pollution":
			weatherInfo = new PollutionDTO();
			JsonParser parser = new JsonParser();
			json = parser.parse(json).getAsJsonArray().get(0).toString();
			weatherInfo = gson.fromJson(json, PollutionDTO.class);
			break;
		case "pollen":
			weatherInfo = new PollenDTO();
			json = json.replaceAll("\\\\", "");
			json = json.substring(1, json.length() - 1);
			weatherInfo = gson.fromJson(json, PollenDTO.class);
			break;
		default:
			weatherInfo = new WeatherDTO();
//			invalidWeatherType(request, response);
		}
		weatherInfo.setAttributes();
		return weatherInfo;
	}
	
	protected static String getJson(URL url) throws IOException {
		InputStream input = url.openStream();
		BufferedReader buffer = new BufferedReader(new InputStreamReader(input,
				StandardCharsets.UTF_8));
		String lines;
		StringBuilder json = new StringBuilder();
		while ((lines = buffer.readLine()) != null) {
			json.append(lines);
		}
		buffer.close();
		return json.toString();
	}
	
	protected static void invalidWeatherType(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException  {
		request.setAttribute("message", "Invalid API call.");
		request.getRequestDispatcher("displayResults.jsp").forward(request,
				response);
	}
}
