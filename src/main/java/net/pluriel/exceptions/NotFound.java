package net.pluriel.exceptions;

import lombok.Data;
import org.springframework.http.HttpStatus;

@Data

public class NotFound extends RuntimeException{
    private static final long serialVersionUID = 1L;
    private String message;
    private HttpStatus httpStatus;

    public NotFound() {
        super();
    }

    public NotFound(String message, HttpStatus httpStatus) {
        super(message);
        this.message = message;
        this.httpStatus = httpStatus;
    }

    public NotFound(String message) {
        super(message);
        this.message = message;
        this.httpStatus = HttpStatus.NOT_FOUND;
    }
}
