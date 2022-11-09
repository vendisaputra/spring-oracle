package com.oraclesinau.sinaukoding.utils;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.core.type.TypeReference;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;
import java.util.Map;

@Data
@JsonIgnoreProperties(ignoreUnknown = true)
@NoArgsConstructor
public class SingelData<T> extends RepositoryData {
    @JsonProperty("OUT_DATA")
    private T data;

    private Class<T> type;

    public SingelData(Map<String, Object> result, Class<T> aClass){
        SingelData<T> single = objectUtil.convert(result, SingelData.class);

        this.type = aClass;
        this.callback = single.getCallback();
        this.message = single.getMessage();
        this.error = single.getError();

        wrapData(single.getData());
    }

    private void wrapData(T data){
        if (this.type == null || data == null){
            return;
        }

        if (data instanceof List && ((List) data).size() == 0){
            return;
        }

        List<T> result = (List<T>) objectUtil.convert(data, new TypeReference<List<T>>() {});

        this.data = objectUtil.convert(result.get(0), type);
    }
}
