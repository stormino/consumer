package io.thinkin.exercise.consumer.api;

import io.thinkin.exercise.consumer.dto.Result;
import io.thinkin.exercise.consumer.exception.SensorDataSenderException;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

@ControllerAdvice
@ResponseBody
public class ControllerExceptionHandler extends ResponseEntityExceptionHandler {

    @ExceptionHandler(SensorDataSenderException.class)
    public ResponseEntity<Result> handleConsumingException(SensorDataSenderException e, WebRequest request) {

        return ResponseEntity.internalServerError()
                .body(Result.builder()
                        .success(false)
                        .message(e.getMessage())
                        .build());
    }
}
