package org.example.bugtrackingsystem.Utils.Exceptions;

public class UserNotfoundException extends Exception{
    public UserNotfoundException() {
    }

    public UserNotfoundException(String message) {
        super(message);
    }

    public UserNotfoundException(String message, Throwable cause) {
        super(message, cause);
    }

    public UserNotfoundException(Throwable cause) {
        super(cause);
    }
}
