package asthma.watch.service;

import java.io.IOException;

import javax.activity.InvalidActivityException;

import asthma.watch.InvalidWeatherTypeException;
import asthma.watch.model.AstronomyDTO;
import asthma.watch.model.ForecastDTO;
import asthma.watch.model.PollenDTO;
import asthma.watch.model.PollutionDTO;
import asthma.watch.model.WeatherDTO;
import asthma.watch.model.WeatherData;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.JsonParser;

public class DTOFactory {

	public static WeatherData fetchWeatherInformation(String weatherType, String json) throws IOException, InvalidWeatherTypeException {
		Gson gson = new GsonBuilder().create();
		WeatherData weatherInfo;
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
			weatherInfo = new AstronomyDTO();
			weatherInfo = gson.fromJson(json, AstronomyDTO.class);
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
			throw new InvalidWeatherTypeException(weatherType);
		}
		weatherInfo.setAttributes();
		return weatherInfo;
	}
}
