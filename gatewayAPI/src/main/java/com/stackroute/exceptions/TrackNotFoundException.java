package com.stackroute.exceptions;

public class TrackNotFoundException extends Exception {
    private String message;
    private String requestURI;

    public TrackNotFoundException() {
    }
    public TrackNotFoundException(String message) {
        super(message);
        this.message = message;
    }

    public void setRequestedURI(String requestURI) {
        this.requestURI=requestURI;
    }

    public void setErrorMessage(String message) {
        this.message=message;
    }
}
