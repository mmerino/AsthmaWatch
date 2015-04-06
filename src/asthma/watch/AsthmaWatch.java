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

public class AsthmaWatch {
	String zip;
	HttpServletRequest request;
	HttpServletResponse response;

	AsthmaWatch(HttpServletRequest request, HttpServletResponse response,
			String zip) {
		this.zip = zip;
		this.request = request;
		this.response = response;
	}

	public AsthmaWatch() {
	}

	protected void setCustomWeather(String weatherType) throws IOException {
		// TODO Add guard clause for invalid weatherType parameters
		URL url = new URL("http://www.google.com");

		switch (weatherType) {
		case "conditions":
		case "forecast":
		case "astronomy":
			url = new URL(UrlReference.WU_URL + weatherType + "/q/" + zip
					+ ".json");
			break;
		case "pollution":
			url = new URL(UrlReference.EPA_URL + zip);
			break;
		case "pollen":
			url = new URL(UrlReference.CLARITIN_URL + zip);
			break;
		}

		ApiAccess.fetchWeatherInformation(request, response,
				weatherType, url);
	}

	protected void goToResults() throws ServletException, IOException {
		request.getRequestDispatcher("displayResults.jsp").forward(request,
				response);
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
}
