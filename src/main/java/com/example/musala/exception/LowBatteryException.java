package com.example.musala.exception;

public class LowBatteryException extends IllegalArgumentException {
    public LowBatteryException(String s) {
        super(s);
    }
}
