package com.northwind.loggingservice.providers;

import com.northwind.splunk.SplunkResponse;

public class LoggingProviderException extends RuntimeException
{
    private Object response;
    public LoggingProviderException(Object response) {
        this.response = response;
    }

    public LoggingProviderException(Exception response) {
        this.response = response;
    }

    public Object getResponse() {
        return response;
    }
}
