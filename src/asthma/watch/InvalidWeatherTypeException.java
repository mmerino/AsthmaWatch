package asthma.watch;

public class InvalidWeatherTypeException extends Exception {
	public String getMessage() {
		String message = "Invalid weather type.";
		return message;
	}
}
