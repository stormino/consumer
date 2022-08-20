package io.thinkin.exercise.consumer.api;

import io.thinkin.exercise.consumer.dto.Result;
import io.thinkin.exercise.consumer.dto.SensorData;
import io.thinkin.exercise.consumer.service.SensorDataSender;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@Slf4j
public class SensorController {

    @Autowired
    SensorDataSender sensorDataSender;

    @PostMapping("/sensor")
    public ResponseEntity<Result> consume(@RequestBody List<SensorData> sensorData) throws Exception {

        log.info("Received sensorData [size={}]", sensorData.size());
        sensorDataSender.send(sensorData);
        return ResponseEntity.ok()
                .body(Result.builder()
                        .success(true)
                        .message("ok")
                        .build());
    }
}
