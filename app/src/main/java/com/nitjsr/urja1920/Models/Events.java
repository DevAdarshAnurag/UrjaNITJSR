package com.nitjsr.urja1920.Models;

public class Events {
    private String eventName;
    private int eventThumbnail;

    public Events(String eventName, int eventThumbnail) {
        this.eventName = eventName;
        this.eventThumbnail = eventThumbnail;
    }

    public String getEventName() {
        return eventName;
    }

    public int getEventThumbnail() {
        return eventThumbnail;
    }

    public void setEventName(String eventName) {
        this.eventName = eventName;
    }

    public void setEventThumbnail(int eventThumbnail) {
        this.eventThumbnail = eventThumbnail;
    }
}