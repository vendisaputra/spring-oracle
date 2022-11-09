package com.oraclesinau.sinaukoding.utils;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Data
@NoArgsConstructor
@ToString
@JsonIgnoreProperties(ignoreUnknown = true)
public class RepositoryData {
    @JsonProperty("return")
    protected int callback;

    @JsonProperty("OUT_DETAIL_MESSAGE")
    protected String error;

    @JsonProperty("OUT_MESSAGE")
    protected String message;

    protected ObjectUtil objectUtil = ObjectUtil.getInstance();
}
