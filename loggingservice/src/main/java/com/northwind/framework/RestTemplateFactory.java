package com.northwind.framework;

import org.springframework.web.client.RestTemplate;

import java.util.concurrent.ConcurrentHashMap;

public class RestTemplateFactory
{
    public static final RestTemplateFactory INSTANCE = new RestTemplateFactory();
    private RestTemplateFactory(){}

    public static RestTemplateFactory getInstance()
    {
        return INSTANCE;
    }


    private final ConcurrentHashMap<String, RestTemplate> instances = new ConcurrentHashMap<>();

    public RestTemplate getInstance(String name)
    {
        if(!instances.containsKey(name))
        {
            instances.putIfAbsent(name, new RestTemplate());
        }

        return instances.get(name);
    }
}
