package Ohtu_Project;


import java.util.LinkedList;
import java.util.Queue;


class ServicePoint {
    Queue<Customer> queue = new LinkedList<>();

    void addToQueue(Customer customer) {
        queue.add(customer);
    }

    void removeFromQueue(Customer customer) {
        queue.remove(customer);
    }

    void serverCustomers() {
        while (!queue.isEmpty()) {
            try {
                Thread.sleep((long) (Math.random() * 1000));

                Customer removedCustomer = queue.remove();
                removedCustomer.setEndTime(System.nanoTime());

                System.out.printf("Customer removed from the queue. Elapsed time: %d ms\n", removedCustomer.getElapsedTime() / 1000000);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }
    }
}


public class TaskSet_1_5 {
    public static void main(String[] args) {
        ServicePoint servicePoint = new ServicePoint();

        for (int i = 0; i < 10; i++) {
            Customer newCustomer = new Customer();
            newCustomer.setStartTime(System.nanoTime());
            servicePoint.addToQueue(newCustomer);
        }

        servicePoint.serverCustomers();
    }
}
