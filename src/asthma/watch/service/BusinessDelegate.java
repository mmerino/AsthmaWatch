package asthma.watch.service;

import java.io.IOException;
import java.net.URL;

import asthma.watch.exception.APIDownException;
import asthma.watch.exception.InvalidWeatherTypeException;
import asthma.watch.model.WeatherData;
import asthma.watch.util.ConstantValues;

public class BusinessDelegate {
	String zip;

	public BusinessDelegate(String zip) {
		this.zip = zip;
	}

	public BusinessDelegate() {
	}

	public WeatherData fetchWeatherData(String weatherType) throws IOException, APIDownException, InvalidWeatherTypeException {
		URL url;

		switch (weatherType) {
		case "conditions":
		case "forecast":
		case "astronomy":
			url = new URL(ConstantValues.WU_URL + weatherType + "/q/" + zip
					+ ".json");
			break;
		case "pollution":
			url = new URL(ConstantValues.EPA_URL + zip);
			break;
		case "pollen":
			url = new URL(ConstantValues.CLARITIN_URL + zip);
			break;
		default:
			url = new URL("http://www.google.com");
			throw new InvalidWeatherTypeException(weatherType);
		}

		JsonDAO jdao = new JsonDAO(weatherType, url);
		return jdao.getDTO();
	}
}
