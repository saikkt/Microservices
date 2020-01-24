package com.northwind.splunk;

import com.northwind.framework.RestTemplateFactory;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.web.client.RestTemplate;

public class SplunkClientImpl implements SplunkClient {

    private RestTemplateFactory restTemplateFactory = RestTemplateFactory.INSTANCE;

    private HttpHeaders headers;

    public SplunkClientImpl()
    {
        headers = new HttpHeaders();
        headers.add("Authorization","Splunk abcd1234");
    }
    @Override
    public SplunkResponse send(SplunkRequest request) {

        RestTemplate client = restTemplateFactory.getInstance("splunk");
        HttpEntity<SplunkRequest> httpEntity = new HttpEntity<>(request, headers);

        String url = "https://10.3.227.104:8088/services/collector/event";
        return client.postForObject(url,httpEntity,SplunkResponse.class);
    }
}
