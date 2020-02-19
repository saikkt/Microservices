package com.northwind.catalogservice.domain;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;

import java.util.HashMap;
import java.util.Map;

@JsonSerialize
public class ProductCreatedEvent {
    @JsonProperty
    private String eventType;
    @JsonProperty
    private Map<String, Object> eventData = new HashMap<>();

    public String getEventType() {
        return eventType;
    }

    public void setEventType(String eventType) {
        this.eventType = eventType;
    }

    public Map<String, Object> getEventData() {
        return eventData;
    }

    public void setEventData(Map<String, Object> eventData) {
        this.eventData = eventData;
    }
}
