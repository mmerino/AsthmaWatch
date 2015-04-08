package asthma.watch;

public class APIDownExcpetion extends Exception {
	String weatherType;
	
	public APIDownExcpetion() {
		
	}
	public APIDownExcpetion(String weatherType) {
		this.weatherType = weatherType;
	}
	
	public String getMessage() {
		String message = weatherType + " API appears to be down.";
		return message;
	}
}
