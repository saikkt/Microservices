package com.northwind.splunk;

public class SplunkRequest
{
    private Object event;

    public SplunkRequest(Object object)
    {
        setEvent(object);
    }

    public Object getEvent() {
        return event;
    }

    public void setEvent(Object event) {

        if(event == null)
        {
            throw new IllegalArgumentException("Event is Required");
        }
        this.event = event;
    }
}
