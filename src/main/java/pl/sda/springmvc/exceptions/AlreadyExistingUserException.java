package pl.sda.springmvc.exceptions;

public class AlreadyExistingUserException extends WebApplicationException {
    public AlreadyExistingUserException(String s) {
        super(s);
    }
}
