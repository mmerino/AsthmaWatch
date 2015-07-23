package asthma.watch.service;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.URL;
import java.nio.charset.StandardCharsets;

import asthma.watch.exception.APIDownException;
import asthma.watch.exception.InvalidWeatherTypeException;
import asthma.watch.model.WeatherData;

public class JsonDAO {
	String weatherType;
	URL url;

	public JsonDAO(String weatherType, URL url) {
		this.weatherType = weatherType;
		this.url = url;
	}

	public WeatherData getDTO() throws IOException, APIDownException,
			InvalidWeatherTypeException {
		String json;
		if (weatherType == "pollen") {
			json = asthma.watch.util.ConstantValues.POLLEN_TEST;
		} else {
			json = getJson(url);
		}
		return DTOFactory.fetchWeatherInformation(weatherType, json);
	}

	public String getJson(URL url) throws IOException, APIDownException {
		StringBuilder json = new StringBuilder();
		// open a stream from the url
		try (InputStream input = url.openStream();
				BufferedReader buffer = new BufferedReader(
						new InputStreamReader(input, StandardCharsets.UTF_8));) {
			String lines;
			// append the stream from URL to the JSON, as long as there is more
			// coming
			while ((lines = buffer.readLine()) != null) {
				json.append(lines);
			}
		} catch (Exception ex) {
			throw new APIDownException(weatherType);
		}
		// Pass JSON on up to getDAO, where it will be sent to the DTOFactory
		// for fetching the data
		return json.toString();
	}
}
