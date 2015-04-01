package asthma.watch;

import java.io.IOException;
import java.net.URL;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

public class ClaritinApi {

	protected static void fetchPollenInfo(HttpServletRequest request,
			HttpServletResponse response, URL url) throws IOException {
		String json = AsthmaWatch.getJson(url);
		if (json != null && !json.isEmpty()) {
			json = json.replaceAll("\\\\", "");
			json = json.substring(1, json.length() - 1);
			Gson gson = new GsonBuilder().create();
			PollenInfo pollenInfo = gson.fromJson(json, PollenInfo.class);
			request.setAttribute("pollen", pollenInfo.pollenForecast);
		}
	}
}
