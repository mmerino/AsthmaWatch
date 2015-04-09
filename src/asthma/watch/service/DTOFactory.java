package asthma.watch.service;

import java.io.IOException;

import asthma.watch.exception.APIDownException;
import asthma.watch.exception.InvalidWeatherTypeException;
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

	public static WeatherData fetchWeatherInformation(String weatherType,
			String json) throws IOException, InvalidWeatherTypeException,
			APIDownException {
		// Make a GSONbuilder
		Gson gson = new GsonBuilder().create();
		WeatherData weatherInfo;
		// take weathertype sent from the DAO, logic which DTO needs to be
		// created
		switch (weatherType) {
		case "conditions":
			// Make a DTO
			weatherInfo = new WeatherDTO();
			weatherInfo = gson.fromJson(json, WeatherDTO.class);
			break;
		case "forecast":
			// Make a DTO
			weatherInfo = new ForecastDTO();
			weatherInfo = gson.fromJson(json, ForecastDTO.class);
			break;
		case "astronomy":
			// Make a DTO
			weatherInfo = new AstronomyDTO();
			weatherInfo = gson.fromJson(json, AstronomyDTO.class);
			break;
		case "pollution":
			// Make a DTO
			weatherInfo = new PollutionDTO();
			JsonParser parser = new JsonParser();
			// This one is weird; parsing
			json = parser.parse(json).getAsJsonArray().get(0).toString();
			weatherInfo = gson.fromJson(json, PollutionDTO.class);
			break;
		case "pollen":
			weatherInfo = new PollenDTO();
			// Weird too, take out the \\
			json = json.replaceAll("\\\\", "");
			json = json.substring(1, json.length() - 1);
			weatherInfo = gson.fromJson(json, PollenDTO.class);
			break;
		default:
			// If there is no weather type specified, it's a bad thing- there's
			// no user input, so it would be our fault
			weatherInfo = new WeatherDTO();
			throw new InvalidWeatherTypeException(weatherType);
		}
		// This is the setAttributes method from whatever specific DTO the json
		// applies to; it sets the value being passed on up, refer to DTOs.
		// Check WeatherDTO/PollenDTO/Etc.
		weatherInfo.setAttributes();
		// return the DTO value back to the DAO/Business Delegate
		return weatherInfo;
	}
}
