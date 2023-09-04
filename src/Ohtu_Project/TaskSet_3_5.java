package Ohtu_Project;


import java.util.ArrayList;
import java.util.List;


public class TaskSet_3_5 {
    public static void main(String[] args) {
        Clock clock = Clock.getInstance();

        ServicePoint servicePoint = new ServicePoint();
        ArrivalProcess arrivalProcess = new ArrivalProcess("ArrivalEventType");

        List<Event2> event2s = new ArrayList<>();
        arrivalProcess.generateArrivals(event2s, clock.getTime(), 10);

        for (Event2 event2 : event2s) {
            Customer customer = new Customer();
            customer.setStartTime(event2.getTime());
            servicePoint.addToQueue(customer);
        }

        clock.advanceTime(10);

        while (!servicePoint.queue.isEmpty()) {
            Customer customer = servicePoint.queue.remove();
            customer.setEndTime(clock.getTime());
            long elapsedTime = customer.getEndTime() - customer.getStartTime();
            System.out.println(elapsedTime);
        }
    }
}
