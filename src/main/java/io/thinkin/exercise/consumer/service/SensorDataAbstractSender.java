package io.thinkin.exercise.consumer.service;

import io.thinkin.exercise.consumer.dto.SensorData;
import io.thinkin.exercise.consumer.exception.SensorDataSenderException;
import lombok.extern.slf4j.Slf4j;

import java.util.List;

@Slf4j
public abstract class SensorDataAbstractSender implements SensorDataSender {

    @Override
    public void send(List<SensorData> sensorData) throws SensorDataSenderException {

        preHook(sensorData);
        sendLogic(sensorData);
        postHook(sensorData);
    }

    protected abstract void sendLogic(List<SensorData> sensorData) throws SensorDataSenderException;

    protected void preHook(List<SensorData> sensorData) {

        log.debug("Pre hook [size={}]", sensorData.size());
    }

    protected void postHook(List<SensorData> sensorData) {

        log.debug("Post hook [size={}]", sensorData.size());
    }
}
