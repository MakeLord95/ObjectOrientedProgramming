package Ohtu_Project;


import java.util.LinkedList;
import java.util.Queue;


class ServicePointAverage {
    Queue<Customer> queue = new LinkedList<>();
    long totalElapsedTime = 0;
    int customerCount = 0;

    void addToQueue(Customer customer) {
        queue.add(customer);
        customerCount++;
    }

    void serverCustomers() {
        while (!queue.isEmpty()) {
            try {
                Thread.sleep((long) (Math.random() * 1000));

                Customer removedCustomer = queue.remove();
                removedCustomer.setEndTime(System.nanoTime());

                long elapsedTime = removedCustomer.getElapsedTime();
                totalElapsedTime += elapsedTime;

                System.out.printf("Customer removed from the queue. Elapsed time: %d ms\n", elapsedTime / 1000000);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }
    }

    double getAverageTime() {
        return (double) totalElapsedTime / customerCount;
    }
}


public class TaskSet_1_6 {
    public static void main(String[] args) {
        ServicePointAverage servicePoint = new ServicePointAverage();

        for (int i = 0; i < 10; i++) {
            Customer newCustomer = new Customer();
            newCustomer.setStartTime(System.nanoTime());
            servicePoint.addToQueue(newCustomer);
        }

        servicePoint.serverCustomers();

        double averageTime = servicePoint.getAverageTime();
        System.out.printf("Average time spent in the service line: %.2f ms\n", averageTime / 1000000);
    }
}
