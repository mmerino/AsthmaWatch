package asthma.watch;

import java.io.IOException;
import java.net.URL;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.JsonArray;
import com.google.gson.JsonObject;

public class EpaApi {

	public static void fetchPollutionInfo(HttpServletRequest request,
			HttpServletResponse response, URL url) throws IOException {
		String json = AsthmaWatch.getJson(url);
		if (json != null && !json.isEmpty()) {
			JsonObject object = new JsonObject();
			JsonArray array = object.getAsJsonArray(json);
			Gson gson = new GsonBuilder().create();
			PollutionInfo pollutionInfo = gson.fromJson(array.get(0),
					PollutionInfo.class);
			pollutionInfo.category.setPollutionBar();
			request.setAttribute("pollution", pollutionInfo.category);
		}
	}
}
