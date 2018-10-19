package com.challenge.soundcloud.Event;

public class Event {

    private long seq;
    private EventType eventType;

    public Event(long seq, EventType eventType){
        this.seq = seq;
        this.eventType = eventType;
    }

    // Getter-Setters and toString()

    public long getSeq() {
        return seq;
    }

    public void setSeq(int seq) {
        this.seq = seq;
    }

    public EventType getEventType() {
        return eventType;
    }

    public void setEventType(EventType eventType) {
        this.eventType = eventType;
    }

    @Override
    public String toString() {
        return "seq=" + String.valueOf(seq) + ", eventType=" + eventType.getEventType();
    }
}
