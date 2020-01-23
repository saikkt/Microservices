package com.northwind.splunk;

public class SplunkResponse
{
    private final String text;
    private final int code;

    public SplunkResponse(String text, int code)
    {
        this.text = text;
        this.code = code;
    }

    public String getText()
    {
        return text;
    }

    public int getCode()
    {
        return code;
    }

    public boolean isSuccess()
    {
        return true;
    }
}
