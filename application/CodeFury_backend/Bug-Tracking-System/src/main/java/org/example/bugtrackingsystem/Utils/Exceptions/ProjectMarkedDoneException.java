package org.example.bugtrackingsystem.Utils.Exceptions;

public class ProjectMarkedDoneException extends Exception{
    public ProjectMarkedDoneException() {
    }

    public ProjectMarkedDoneException(String message) {
        super(message);
    }

    public ProjectMarkedDoneException(String message, Throwable cause) {
        super(message, cause);
    }

    public ProjectMarkedDoneException(Throwable cause) {
        super(cause);
    }
}
