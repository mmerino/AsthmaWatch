package asthma.watch;

public class AstronomyDTO implements DAOInterface {
	Moon_Phase moon_phase;
	
	String percentIlluminated;
	String moonPhase;
	
	public void setAttributes() {
		this.percentIlluminated = moon_phase.percentIlluminated;
		this.moonPhase = moon_phase.phaseofMoon;
	}

	public String getPercentIlluminated() {
		return percentIlluminated;
	}
	public String getPhaseofMoon() {
		return moonPhase;
	}
	
	class Moon_Phase {
		String percentIlluminated;
		String phaseofMoon;
	}
}