package asthma.watch;

public class PollutionInfo {
	Category category;

	public class Category {
		public int Number;
		public int pollutionBar;

		public int getPollution() {
			return Number;
		}

		public void setPollutionBar() {
			if (Number > 3) {
				pollutionBar = 3;
			} else if (Number < 2) {
				pollutionBar = 1;
			} else {
				pollutionBar = 2;
			}
		}

		public int getPollutionBar() {
			return pollutionBar;
		}
	}
}
