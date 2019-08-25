package pl.sda.springmvc.exceptions;

public class WebApplicationException extends Exception {

    public WebApplicationException(String message) {
        super(message);
    }
}
