package Ohtu_Project;


import java.util.PriorityQueue;


enum EventType {
    ARRIVAL, DEPARTURE
}

class EventWithType implements Comparable<EventWithType> {
    private final String name;
    private final long time;
    private final EventType eventType;

    public EventWithType(String name, long time, EventType eventType) {
        this.name = name;
        this.time = time;
        this.eventType = eventType;
    }

    public String getName() {
        return name;
    }

    public long getTime() {
        return time;
    }

    public EventType getEventType() {
        return eventType;
    }

    public int compareTo(EventWithType other) {
        return Long.compare(this.time, other.time);
    }
}


class EventListWithType {
    private final PriorityQueue<EventWithType> eventWithTypes = new PriorityQueue<>();

    public void addEvent(EventWithType eventWithType) {
        eventWithTypes.add(eventWithType);
    }

    public EventWithType getNextEvent() {
        return eventWithTypes.poll();
    }

    public boolean isEmpty() {
        return eventWithTypes.isEmpty();
    }
}


public class TaskSet_2_5 {
    public static void main(String[] args) {
        EventListWithType eventListWithType = new EventListWithType();

        eventListWithType.addEvent(new EventWithType("Event A", 100, EventType.ARRIVAL));
        eventListWithType.addEvent(new EventWithType("Event B", 50, EventType.DEPARTURE));
        eventListWithType.addEvent(new EventWithType("Event C", 200, EventType.ARRIVAL));

        while (!eventListWithType.isEmpty()) {
            EventWithType nextEventWithType = eventListWithType.getNextEvent();
            System.out.printf("Next event: %s - Time: %d - Type: %s%n", nextEventWithType.getName(), nextEventWithType.getTime(), nextEventWithType.getEventType());
        }
    }
}
