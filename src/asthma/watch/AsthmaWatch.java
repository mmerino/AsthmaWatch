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

	protected void setPollenInfo() throws IOException {
		URL url = new URL(UrlReference.CLARITIN_URL + zip);
		ClaritinApi.fetchPollenInfo(request, response, url);
	}

	protected void setWeatherInfo() throws IOException {
		URL url = new URL(UrlReference.WU_URL + "conditions/q/" + zip + ".json");
		WeatherUndergroundApi.fetchWeatherInfo(request, response, url);
	}

	protected void setAstronomyInfo() throws IOException {
		URL url = new URL(UrlReference.WU_URL + "astronomy/q/" + zip + ".json");
		WeatherUndergroundApi.fetchAstronomyInfo(request, response, url);
	}

	protected void goToResults() throws ServletException, IOException {
		request.getRequestDispatcher("displayResults.jsp").forward(request,
				response);
	}

	protected static String getJson(URL url) throws IOException {
		InputStream input = url.openStream();
		BufferedReader buffer = new BufferedReader(new InputStreamReader(input,
				StandardCharsets.UTF_8));
		String json = buffer.readLine();
		return json;
	}
}
