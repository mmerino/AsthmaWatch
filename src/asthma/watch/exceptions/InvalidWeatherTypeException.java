package asthma.watch.exceptions;

public class InvalidWeatherTypeException extends Exception {
	String weatherType;

	public InvalidWeatherTypeException() {

	}

	public InvalidWeatherTypeException(String weatherType) {
		this.weatherType = weatherType;
	}

	public String getMessage() {
		String message = weatherType + " is an invalid weather type.";
		return message;
	}
}
