package co.uk.project.springmvc.core.exception;

public class FatalException extends RuntimeException {

    private static final long serialVersionUID = 1L;

    public FatalException(String message) {
        super(message);
    }

}