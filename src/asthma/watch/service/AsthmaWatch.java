package asthma.watch.service;

import asthma.watch.*;

import java.io.IOException;
import java.net.URL;

import asthma.watch.model.WeatherData;
import asthma.watch.util.ConstantValues;

public class AsthmaWatch {
	String zip;

	public AsthmaWatch(String zip) {
		this.zip = zip;
	}

	public AsthmaWatch() {
	}

	public WeatherData fetchWeatherData(String weatherType) throws IOException {
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
		}

		JsonDAO jdao = new JsonDAO(weatherType, url);
		return jdao.getDTO();
	}
}
