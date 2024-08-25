package org.example.bugtrackingsystem.Utils.Exceptions;

public class UserLogNotFoundException extends Exception{
    public UserLogNotFoundException() {
    }

    public UserLogNotFoundException(String message) {
        super(message);
    }

    public UserLogNotFoundException(String message, Throwable cause) {
        super(message, cause);
    }

    public UserLogNotFoundException(Throwable cause) {
        super(cause);
    }
}
