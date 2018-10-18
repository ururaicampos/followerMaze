package com.challenge.soundcloud.Event;

public enum  SequenceEventType {
    FOLLOW("F"), UNFOLLOW("U"), BROADCAST("B"), PRIVATE_MESSAGE("P"), STATUS_UPDATE("S");

    private final  String eventType;

    SequenceEventType(String eventType){
        this.eventType = eventType;
    }

    public static SequenceEventType fromString(String str){
        if (str != null){
            for (SequenceEventType e : SequenceEventType.values()){
                if (str.equalsIgnoreCase(e.eventType)){
                    return e;
                }
            }
        }


    }

    public String getEventType() {
        return eventType;
    }
}
