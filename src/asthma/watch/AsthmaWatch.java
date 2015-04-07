package asthma.watch;

import java.io.IOException;
import java.net.URL;

public class AsthmaWatch {
	String zip;

	AsthmaWatch(String zip) {
		this.zip = zip;
	}

	public AsthmaWatch() {
	}

	protected DAOInterface fetchWeatherData(String weatherType) throws IOException {
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

		return APIDAOFactory.fetchWeatherInformation(weatherType, url);
	}
}
