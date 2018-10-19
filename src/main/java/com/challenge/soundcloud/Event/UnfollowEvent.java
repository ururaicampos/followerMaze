package com.challenge.soundcloud.Event;

public class UnfollowEvent extends Event{

    private long toUser;
    private long fromUser;

    public UnfollowEvent(long seq, EventType eventType, long toUser, long fromUser) {
        super(seq, eventType);
        this.toUser = toUser;
        this.fromUser = fromUser;
    }

    // Getters-Setters and toString()

    public long getToUser() {
        return toUser;
    }

    public void setToUser(long toUser) {
        this.toUser = toUser;
    }

    public long getFromUser() {
        return fromUser;
    }

    public void setFromUser(long fromUser) {
        this.fromUser = fromUser;
    }

    @Override
    public String toString() {
        return "UnfollowEvent{" +
                super.toString() +
                ", toUser=" + toUser +
                ", fromUser=" + fromUser +
                '}';
    }
}
