//package asthma.watch;
//
//import java.io.IOException;
//import java.net.URL;
//
//import javax.servlet.http.HttpServletRequest;
//import javax.servlet.http.HttpServletResponse;
//
//import com.google.gson.Gson;
//import com.google.gson.GsonBuilder;
//import com.google.gson.JsonParser;
//
//public class EpaApi {
//
//	public static void fetchPollutionInfo(HttpServletRequest request,
//			HttpServletResponse response, URL url) throws IOException {
//		String json = AsthmaWatch.getJson(url);
//		if (json != null && !json.isEmpty()) {
//			JsonParser parser = new JsonParser();
//			json = parser.parse(json).getAsJsonArray().get(0).toString();
//			Gson gson = new GsonBuilder().create();
//			PollutionInfo pollutionInfo = gson.fromJson(json,
//					PollutionInfo.class);
//			pollutionInfo.setAttributes();
//			request.setAttribute("pollution", pollutionInfo);
//		}
//	}
//}
