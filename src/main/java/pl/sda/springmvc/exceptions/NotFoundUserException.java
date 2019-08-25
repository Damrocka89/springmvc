package pl.sda.springmvc.exceptions;

public class NotFoundUserException extends WebApplicationException {

    public NotFoundUserException(String message) {
        super(message);
    }
}
