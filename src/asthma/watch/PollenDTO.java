package asthma.watch;

public class PollenDTO implements DAOInterface {
	PollenForecast pollenForecast;
	
	double[] forecast;
	String predominantPollen;
	double[] pollenBar;

	public double[] getPollenCount() {
		return forecast;
	}

	public String getPredominantPollen() {
		return predominantPollen;
	}

	public double[] getPollenBar() {
		return pollenBar;
	}
	
	public void setAttributes() {
		this.forecast = pollenForecast.forecast;
		this.predominantPollen = pollenForecast.pp;
		setPollenBar();
	}
	
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
	
	public class PollenForecast {
		double[] forecast;
		String pp;
	}
}
