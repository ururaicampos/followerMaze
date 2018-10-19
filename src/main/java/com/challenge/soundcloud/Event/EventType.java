package com.challenge.soundcloud.Event;

public enum EventType {
    FOLLOW("F"), UNFOLLOW("U"), BROADCAST("B"), PRIVATE_MESSAGE("P"), STATUS_UPDATE("S");

    private final String eventType;

    EventType(String eventType) {
        this.eventType = eventType;
    }

    public String getEventType() {
        return eventType;
    }
}
