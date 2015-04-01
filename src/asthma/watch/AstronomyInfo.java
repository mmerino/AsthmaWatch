package asthma.watch;

public class AstronomyInfo {
	Moon_Phase moon_phase;
	
	class Moon_Phase {
		String percentIlluminated;
		String phaseofMoon;
		public String getPercentIlluminated() {
			return percentIlluminated;
		}
		public String getPhaseofMoon() {
			return phaseofMoon;
		}
	}
}
