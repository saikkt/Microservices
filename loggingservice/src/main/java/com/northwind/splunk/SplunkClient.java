package com.northwind.splunk;

public interface SplunkClient {

    public SplunkResponse send(SplunkRequest request);
}
