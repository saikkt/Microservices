package com.northwind.splunk;

public class SplunkClientFailureMock implements SplunkClient {
    @Override
    public SplunkResponse send(SplunkRequest request) {
        return null;
    }
}
