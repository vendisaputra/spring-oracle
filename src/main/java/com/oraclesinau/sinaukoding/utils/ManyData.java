package com.oraclesinau.sinaukoding.utils;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.core.type.TypeReference;
import lombok.Data;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@Data
public class ManyData<T> extends RepositoryData{
    @JsonProperty("OUT_DATA")
    private List<T> data;

    private Class<T> type;

    public ManyData(Map<String, Object> result, Class<T> aClass){
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

        List<T> result = objectUtil.convert(data, new TypeReference<List<T>>() {});

        ArrayList<T> list = new ArrayList<>();

        result.stream()
                .map(t -> objectUtil.convert(t, type))
                .collect(Collectors.toCollection(() -> list));

        this.data = list;
    }
}
