package io.thinkin.exercise.consumer.exception;

public class SensorDataSenderException extends Exception {

    public SensorDataSenderException(String message) {
        super(message);
    }

    public SensorDataSenderException(String message, Throwable cause) {
        super(message, cause);
    }
}
