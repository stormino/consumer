package io.thinkin.exercise.consumer.service;

import io.thinkin.exercise.consumer.dto.SensorData;
import io.thinkin.exercise.consumer.exception.SensorDataSenderException;

import java.util.List;

public interface SensorDataSender {

    void send(List<SensorData> sensorData) throws SensorDataSenderException;
}
