package com.challenge.soundcloud.Server;

import com.challenge.soundcloud.Event.Event;

import java.util.Queue;
import java.util.concurrent.atomic.AtomicInteger;

public class Sorter extends ServerAbstract {
    private Queue<Event> events;
    private Queue<Event> eventsSorted;
    private AtomicInteger atomicInteger = new AtomicInteger(1); // AtomicInteger -> initialState=1

    public Sorter(Queue<Event> events, Queue<Event> eventsSorted) {
        this.events = events;
        this.eventsSorted = eventsSorted;
    }

    @Override
    public void run() {
        while (true) { // Infinity loop
            Event event = events.peek(); // peek() -> Retrieves the head of the queue, but does not remove it.
            if (event != null && event.getSeq() <= atomicInteger.get()) {
                    Event eventOrder = events.poll(); // poll() -> Retrieves and remove the head, or null if empty.
                    if(eventsSorted.add(eventOrder)){
                        atomicInteger.getAndIncrement();
                    }
            }
        }

    }
}
