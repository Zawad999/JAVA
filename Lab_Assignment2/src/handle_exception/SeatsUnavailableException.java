package handle_exception;

public class SeatsUnavailableException extends Exception {
	public SeatsUnavailableException(String message) {
        super(message);
    }
}
