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
	}
}
