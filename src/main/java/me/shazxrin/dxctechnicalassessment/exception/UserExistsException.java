package me.shazxrin.dxctechnicalassessment.exception;

public class UserExistsException extends Exception {
    public UserExistsException() {
        super("User already exists!");
    }
}
