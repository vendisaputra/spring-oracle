package com.oraclesinau.sinaukoding.utils;


import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;

public class ObjectUtil {
    private final ObjectMapper objectMapper;

    private ObjectUtil(){
        objectMapper = new ObjectMapper();
        objectMapper.setSerializationInclusion(JsonInclude.Include.NON_NULL);
        objectMapper.configure(SerializationFeature.FAIL_ON_EMPTY_BEANS, false);
    }

    private static class SingletonHelper {
        private static final ObjectUtil INSTANCE = new ObjectUtil();
    }

    public static ObjectUtil getInstance() {
        return SingletonHelper.INSTANCE;
    }

    public <T> T convert(Object object, Class<T> classOfT){
        return objectMapper.convertValue(object, classOfT);
    }

    public <T> T convert(Object object, TypeReference<T> valueTypeRef){
        return objectMapper.convertValue(object, valueTypeRef);
    }
}
