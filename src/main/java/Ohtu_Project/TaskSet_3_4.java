package Ohtu_Project;


import eduni.distributions.Distributions;
import eduni.distributions.RandomGenerator;

import java.util.ArrayList;
import java.util.List;


class Event2 {
    private final String type;
    private final long time;

    public Event2(String type, long time) {
        this.type = type;
        this.time = time;
    }

    @Override
    public String toString() {
        return "Event{" +
                "type='" + type + '\'' +
                ", time=" + time +
                '}';
    }

    public long getTime() {
        return time;
    }
}


class ArrivalProcess {
    private final String eventType;
    private final Distributions distributions;

    public ArrivalProcess(String eventType) {
        this.eventType = eventType;
        this.distributions = new Distributions(new RandomGenerator());
    }

    public void generateArrivals(List<Event2> eventList, double clock, int numberOfArrivals) {
        for (int i = 0; i < numberOfArrivals; i++) {
            double probability = distributions.bernoulli(0.5);
            if (probability == 1.0) {
                Event2 arrivalEvent = new Event2(eventType, (long) clock);
                eventList.add(arrivalEvent);
            }
            clock += 1.0;
        }
    }
}


public class TaskSet_3_4 {
    public static void main(String[] args) {
        List<Event2> eventList = new ArrayList<>();
        double clock = 0.0;
        ArrivalProcess arrivalProcess = new ArrivalProcess("ArrivalEvent");

        int numberOfArrivals = 10;
        arrivalProcess.generateArrivals(eventList, clock, numberOfArrivals);

        for (Event2 event : eventList) {
            System.out.println(event);
        }
    }
}
