package asthma.watch;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.URL;
import java.nio.charset.StandardCharsets;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.google.gson.*;

public class AsthmaWatch {

	AsthmaWatch(HttpServletRequest request, HttpServletResponse response,
			URL claritinUrl, URL wuUrl) {
		try {
			pollenInformation(request, response, claritinUrl);
			// weatherInformation(request, response, wuUrl);
			request.getRequestDispatcher("results.jsp").forward(request,
					response);
		} catch (Exception e) {
			request.setAttribute("error", e.getMessage());
		}
	}

	public AsthmaWatch() {
		// TODO Auto-generated constructor stub
	}

	protected void pollenInformation(HttpServletRequest request,
			HttpServletResponse response, URL url) throws IOException {
		String json = getJson(url);
		json = json.replaceAll("\\\\", "");
		json = json.substring(1, json.length() - 1);
		Gson gson = new GsonBuilder().create();
		PollenInfo pollenInfo = gson.fromJson(json, PollenInfo.class);
		double[] pollenThreeDay = pollenInfo.pollenForecast.forecast;
		String pollenType = pollenInfo.pollenForecast.pp;
		for (int i = 0; i < pollenThreeDay.length; i++) {
			request.setAttribute("day" + (i + 1), pollenThreeDay[i]);
		}
		request.setAttribute("pp", pollenType);
	}

	protected void weatherInformation(HttpServletRequest request,
			HttpServletResponse response, URL url) throws IOException {
		String json = getJson(url);
		Gson gson = new GsonBuilder().create();
		WeatherConditions weather = gson
				.fromJson(json, WeatherConditions.class);
		String humidity = weather.current_observation.relative_humidity;
		double wind = weather.current_observation.wind_mph;
		String heatIndex = weather.current_observation.heat_index_f;
		String pressureTrend = weather.current_observation.pressure_trend;
		request.setAttribute("humidity", humidity);
		request.setAttribute("wind", wind);
		request.setAttribute("heatIndex", heatIndex);
		request.setAttribute("pressureTrend", pressureTrend);
		// request.setAttribute("condition", weather.current_observation);
	}

	protected String getJson(URL url) throws IOException {
		InputStream input = url.openStream();
		BufferedReader buffer = new BufferedReader(new InputStreamReader(input,
				StandardCharsets.UTF_8));
		String json = buffer.readLine();
		return json;
	}
}
