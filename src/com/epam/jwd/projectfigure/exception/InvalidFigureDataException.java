package com.epam.jwd.projectfigure.exception;

public class InvalidFigureDataException extends Exception {

    public InvalidFigureDataException() {
        super();
    }

    public InvalidFigureDataException(String message) {
        super(message);
    }

    public InvalidFigureDataException(String message, Throwable cause) {
        super(message, cause);
    }

    public InvalidFigureDataException(Throwable cause) {
        super(cause);
    }
}
