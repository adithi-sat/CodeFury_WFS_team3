package org.example.bugtrackingsystem.Utils.Exceptions;

public class ProjectNotFoundException extends Exception{
    public ProjectNotFoundException() {
    }

    public ProjectNotFoundException(String message) {
        super(message);
    }

    public ProjectNotFoundException(String message, Throwable cause) {
        super(message, cause);
    }

    public ProjectNotFoundException(Throwable cause) {
        super(cause);
    }
}
