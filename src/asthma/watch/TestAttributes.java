package asthma.watch;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

public class TestAttributes {
	
	TestAttributes(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String jsonP = "{\"pollenForecast\":{\"forecast\":[1.0,2.0,3.0,4.0],\"pp\":\"Treeant.\"}}";
		String jsonW = "{\"current_observation\":{\"relative_humidity\": \"50%\",\"win_mph\": 50.0,\"index_heat_f\": \"50\",\"pressure_trend\": \"-\"}}";
		Gson gson = new GsonBuilder().create();
		WeatherConditions weather = gson.fromJson(jsonW, WeatherConditions.class);
		PollenInfo pollenInfo = gson.fromJson(jsonP, PollenInfo.class);
		request.setAttribute("conditions", weather);
		request.setAttribute("pollen", pollenInfo);
		request.getRequestDispatcher("displayResults.jsp").forward(request,
				response);
		
	}
}
