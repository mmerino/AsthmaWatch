package asthma.watch;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class TestAttributes {
	TestAttributes(HttpServletRequest request,
			HttpServletResponse response) {
		WeatherConditions weather = gson
				.fromJson(json, WeatherConditions.class);
		PollenInfo pollenInfo = gson.fromJson(json, PollenInfo.class);
		request.setAttribute("conditions", arg1);
		request.setAttribute("pollen", pollenInfo);
	}
}
