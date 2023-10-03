package Ohtu_Project;


import java.util.PriorityQueue;


class Event implements Comparable<Event> {
    private final String name;
    private final long time;

    public Event(String name, long time) {
        this.name = name;
        this.time = time;
    }

    public String getName() {
        return name;
    }

    public long getTime() {
        return time;
    }

    public int compareTo(Event other) {
        return Long.compare(this.time, other.time);
    }
}


class EventList {
    private final PriorityQueue<Event> events = new PriorityQueue<>();

    public void addEvent(Event event) {
        events.add(event);
    }

    public Event getNextEvent() {
        return events.poll();
    }

    public boolean isEmpty() {
        return events.isEmpty();
    }
}


public class TaskSet_2_4 {
    public static void main(String[] args) {
        EventList eventList = new EventList();

        eventList.addEvent(new Event("Event A", 100));
        eventList.addEvent(new Event("Event B", 50));
        eventList.addEvent(new Event("Event C", 200));

        while (!eventList.isEmpty()) {
            Event nextEvent = eventList.getNextEvent();
            System.out.printf("Next event: %s - Time: %d\n", nextEvent.getName(), nextEvent.getTime());
        }
    }
}
