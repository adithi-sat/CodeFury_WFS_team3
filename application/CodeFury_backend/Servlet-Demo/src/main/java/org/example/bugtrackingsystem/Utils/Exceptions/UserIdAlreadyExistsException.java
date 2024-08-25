package org.example.bugtrackingsystem.Utils.Exceptions;

public class UserIdAlreadyExistsException extends Exception{
    public UserIdAlreadyExistsException() {
    }

    public UserIdAlreadyExistsException(String message) {
        super(message);
    }

    public UserIdAlreadyExistsException(String message, Throwable cause) {
        super(message, cause);
    }

    public UserIdAlreadyExistsException(Throwable cause) {
        super(cause);
    }
}
