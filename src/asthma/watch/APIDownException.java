package asthma.watch;

public class APIDownException extends Exception {
	String weatherType;
	
	public APIDownException() {
		
	}
	public APIDownException(String weatherType) {
		this.weatherType = weatherType;
	}
	
	public String getMessage() {
		String message = weatherType + " API appears to be down.";
		return message;
	}
}
