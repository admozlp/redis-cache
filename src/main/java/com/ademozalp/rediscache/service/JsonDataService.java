package com.ademozalp.rediscache.service;

import com.ademozalp.rediscache.model.Unit;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.core.io.ClassPathResource;
import org.springframework.stereotype.Service;

import java.io.InputStream;
import java.util.List;

@Service
public class JsonDataService {
    private final ObjectMapper objectMapper;

    public JsonDataService(ObjectMapper objectMapper) {
        this.objectMapper = objectMapper;
    }

    public List<Unit> readTokensFromJson(){
        try {
            ClassPathResource resource = new ClassPathResource("data/units.json");
            InputStream inputStream = resource.getInputStream();
            return objectMapper.readValue(inputStream, new TypeReference<>() {
            });
        }catch (Exception e){
            e.printStackTrace();
        }
        return null;
    }
}
