package Ohtu_Project;


import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;


public class TaskSet_1_4 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        Queue<Customer> queue = new LinkedList<>();

        while (true) {
            System.out.println("Choose an action:");
            System.out.println("1. Add customer to the queue");
            System.out.println("2. Remove customer from the queue");
            System.out.println("3. Exit the program");
            System.out.print("Choice: ");

            int choice = scanner.nextInt();

            if (choice == 1) {
                Customer newCustomer = new Customer();
                newCustomer.setStartTime(System.nanoTime());
                queue.add(newCustomer);

                System.out.println("Customer added to the queue");

            } else if (choice == 2) {
                if (!queue.isEmpty()) {
                    Customer removedCustomer = queue.remove();
                    removedCustomer.setEndTime(System.nanoTime());

                    System.out.printf("Customer removed from the queue. Elapsed time: %d ms\n", removedCustomer.getElapsedTime() / 1000000);
                } else {
                    System.out.println("The queue is empty!");
                }

            } else if (choice == 3) {
                System.out.println("Exiting the program.");
                break;
            } else {
                System.out.printf("Invalid choice %d!\n", choice);
            }
        }
    }
}
