package asthma.watch.model;


public class PollutionDTO implements WeatherData {
	Category Category;
	
	double airQualityIndex;
	int airQualityBar;
	
	public void setAttributes() {
		this.airQualityIndex = Category.Number;
		setAirQualityBar();
	}

	public void setAirQualityBar() {
		if (airQualityIndex > 3) {
			airQualityBar = 3;
		} else if (airQualityIndex < 2) {
			airQualityBar = 1;
		} else {
			airQualityBar = 2;
		}
	}

	public double getAirQualityIndex() {
		return airQualityIndex;
	}

	public int getAirQualityBar() {
		return airQualityBar;
	}
	
	public class Category {
		double Number;
	}
}
