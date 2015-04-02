package asthma.watch;

public class PollenInfo {
	PollenForecast pollenForecast;

	public class PollenForecast {
		double[] forecast;
		String pp;

		public double[] getForecast() {
			return forecast;
		}

		public String getPredominantPollen() {
			return pp;
		}

		public String[] getPollenBar() {
			String[] bar = new String[forecast.length - 1];
			for (int i = 0; i < forecast.length; i++) {
				if (forecast[i] < 30) {
					bar[i] = "green";
				} else if (forecast[i] > 60) {
					bar[i] = "red";
				} else {
					bar[i] = "yellow";
				}
			}
			return bar;
		}
	}
}
