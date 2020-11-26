package com.epam.jwd.projectfigure.exception;

public class InvalidFigureData extends Exception {

    public InvalidFigureData() {
        super();
    }

    public InvalidFigureData(String message) {
        super(message);
    }

    public InvalidFigureData(String message, Throwable cause) {
        super(message, cause);
    }

    public InvalidFigureData(Throwable cause) {
        super(cause);
    }
}
