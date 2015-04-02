package asthma.watch;

public class PollenInfo {
	PollenForecast pollenForecast;

	public class PollenForecast {
		double[] forecast;
		String pp;
		double[] pollenBar;

		public void setPollenBar() {
			pollenBar = new double[forecast.length];
			for (int i = 0; i < forecast.length; i++) {
				if (forecast[i] < 4.8) {
					pollenBar[i] = 1.0;
				} else if (forecast[i] > 7.2) {
					pollenBar[i] = 3.0;
				} else {
					pollenBar[i] = 2.0;
				}
			}
		}

		public double[] getPollenCount() {
			return forecast;
		}

		public String getPredominantPollen() {
			return pp;
		}

		public double[] getPollenBar() {
			return pollenBar;
		}
	}
}
