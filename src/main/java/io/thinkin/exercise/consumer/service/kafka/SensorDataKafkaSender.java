package io.thinkin.exercise.consumer.service.kafka;

import io.thinkin.exercise.consumer.dto.SensorData;
import io.thinkin.exercise.consumer.exception.SensorDataSenderException;
import io.thinkin.exercise.consumer.service.SensorDataAbstractSender;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@Slf4j
public class SensorDataKafkaSender extends SensorDataAbstractSender {

    @Value("${sender.topic.name}")
    String topicName;

    @Autowired
    private KafkaTemplate<String, SensorData> sensorDataKafkaTemplate;

    @Override
    protected void sendLogic(List<SensorData> sensorData) throws SensorDataSenderException {

        log.info("Sending sensor data to ingestion service(s) [size={}]", sensorData.size());
        sensorData.forEach(item -> sensorDataKafkaTemplate.send(topicName, item));
    }
}
