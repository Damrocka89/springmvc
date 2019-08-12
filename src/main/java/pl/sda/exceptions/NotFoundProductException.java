package pl.sda.exceptions;

public class NotFoundProductException extends WebApplicationException {

    public NotFoundProductException(String message) {
        super(message);
    }
}
