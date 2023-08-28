package Ohtu_Project;


class Customer {
    private static int nextID = 1;
    private final int id;
    private long startTime;
    private long endTime;

    public Customer() {
        this.id = nextID++;
    }

    public int getID() {
        return id;
    }

    public long getStartTime() {
        return startTime;
    }


    public void setStartTime(long startTime) {
        this.startTime = startTime;
    }

    public long getEndTime() {
        return endTime;
    }


    public void setEndTime(long endTime) {
        this.endTime = endTime;
    }

    public long getElapsedTime() {
        return getEndTime() - getStartTime();
    }
}


public class TaskSet_1_3 {
    public static void main(String[] args) {

        // Create the first customer
        Customer customer1 = new Customer();
        customer1.setStartTime(System.currentTimeMillis());

        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        customer1.setEndTime(System.currentTimeMillis());

        // Create the second customer
        Customer customer2 = new Customer();
        customer2.setStartTime(System.currentTimeMillis());

        try {
            Thread.sleep(2500);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        customer2.setEndTime(System.currentTimeMillis());

        System.out.printf("Customer 1: ID %d, Elapsed time: %d ms\n", customer1.getID(), customer1.getElapsedTime());
        System.out.printf("Customer 2: ID %d, Elapsed time: %d ms\n", customer2.getID(), customer2.getElapsedTime());
    }
}
