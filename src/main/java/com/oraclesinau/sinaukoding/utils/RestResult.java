package com.oraclesinau.sinaukoding.utils;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.Data;

@Data
public class RestResult {
    @JsonInclude(JsonInclude.Include.NON_NULL)
    Object data;

    @JsonInclude(JsonInclude.Include.NON_NULL)
    String message;

    @JsonInclude(JsonInclude.Include.NON_NULL)
    String error;

    public RestResult(Object data, String message, String error) {
        this.data = data;
        this.message = message;
        this.error = error;
    }
}
