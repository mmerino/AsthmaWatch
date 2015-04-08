package asthma.watch.service;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.URL;
import java.nio.charset.StandardCharsets;

import asthma.watch.model.WeatherData;
import asthma.watch.APIDownException;
import asthma.watch.InvalidWeatherTypeException;

public class JsonDAO {
	String weatherType;
	URL url;
	
	public JsonDAO(String weatherType, URL url) {
		this.weatherType = weatherType;
		this.url = url;
	}
	
	public WeatherData getDTO() throws IOException, APIDownException, InvalidWeatherTypeException {
		String json = getJson(url);
		return DTOFactory.fetchWeatherInformation(weatherType, json);
	}

	public String getJson(URL url) throws IOException, APIDownException {
		InputStream input = url.openStream();
		BufferedReader buffer = new BufferedReader(new InputStreamReader(input,
				StandardCharsets.UTF_8));
		String lines;
		StringBuilder json = new StringBuilder();
		while ((lines = buffer.readLine()) != null) {
			json.append(lines);
		}
		buffer.close();
		if (json == null || json.equals("")) {
			throw new APIDownException(weatherType);
		}
		return json.toString();
	}
	
	
	
}
