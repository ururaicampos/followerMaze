package com.challenge.soundcloud.Event;

public class StatusUpdateEvent extends Event {

    private long fromUser;

    public StatusUpdateEvent(long seq, EventType eventType, long fromUser) {
        super(seq, eventType);
        this.fromUser = fromUser;
    }

    // Getters-Setters and toString()

    public long getFromUser() {
        return fromUser;
    }

    public void setFromUser(long fromUser) {
        this.fromUser = fromUser;
    }

    @Override
    public String toString() {
        return "StatusUpdateEvent{" +
                super.toString() +
                ", fromUser=" + fromUser +
                '}';
    }
}
