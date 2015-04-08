package asthma.watch.model;

public class AstronomyDTO implements WeatherData {
	Moon_Phase moon_phase;

	String percentIlluminated;
	String moonPhase;
	String sunrise;
	String sunset;
	String moonPic;

	public void setAttributes() {
		this.percentIlluminated = moon_phase.percentIlluminated;
		this.moonPhase = moon_phase.phaseofMoon;
		this.sunrise = moon_phase.sunrise.hour + ":"
				+ moon_phase.sunrise.minute;
		this.sunset = moon_phase.sunset.hour + ":" + moon_phase.sunset.minute;
		setMoonPic();
	}

	public String getPercentIlluminated() {
		return percentIlluminated;
	}

	public String getMoonPhase() {
		return moonPhase;
	}

	public String getSunrise() {
		return sunrise;
	}

	public String getSunset() {
		return sunset;
	}

	public String getMoonPic() {
		return moonPic;
	}

	public void setMoonPic() {
		if (moonPhase.contains("New")) {
			moonPic = "images/newmoon.png";
		} else if (moonPhase.contains("Gibbous")) {
			moonPic = "images/gibbousmoon.png";
		} else if (moonPhase.contains("Crescent")) {
			moonPic = "images/crescentmoon.png";
		} else if (moonPhase.contains("Full")) {
			moonPic = "images/fullmoon.png";
		} else if (moonPhase.contains("Half")) {
			moonPic = "images/halfmoon.png";
		}
	}

	class Moon_Phase {
		String percentIlluminated;
		String phaseofMoon;
		Sunrise sunrise;
		Sunset sunset;
	}

	class Sunrise {
		String hour;
		String minute;
	}

	class Sunset {
		String hour;
		String minute;

	}
}
