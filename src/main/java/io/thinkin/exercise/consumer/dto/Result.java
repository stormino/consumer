package io.thinkin.exercise.consumer.dto;

import lombok.Builder;
import lombok.Getter;

@Builder
@Getter
public class Result {

    private Boolean success;
    private String message;
}
