package org.example.bugtrackingsystem.Utils.Exceptions;

public class BugNotClosedByDeveloperException extends Exception{
    public BugNotClosedByDeveloperException() {
    }

    public BugNotClosedByDeveloperException(String message) {
        super(message);
    }

    public BugNotClosedByDeveloperException(String message, Throwable cause) {
        super(message, cause);
    }

    public BugNotClosedByDeveloperException(Throwable cause) {
        super(cause);
    }
}
