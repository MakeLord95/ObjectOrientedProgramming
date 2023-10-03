package Module_5_2;

class Theater {
    private int availableSeats;

    public Theater(int availableSeats) {
        this.availableSeats = availableSeats;
    }

    public synchronized void reserveSeat(String customerName, int numSeats) {
        if (numSeats <= availableSeats) {
            availableSeats -= numSeats;
            System.out.printf("%s reserved %d tickets\n", customerName, numSeats);
        } else {
            System.out.printf("%s couldn't reserve %d tickets\n", customerName, numSeats);
        }
    }
}

class Customer extends Thread {
    private final Theater theater;
    private final String customerName;
    private final int numSeatsToReserve;

    public Customer(Theater theater, String customerName, int numSeatsToReserve) {
        this.theater = theater;
        this.customerName = customerName;
        this.numSeatsToReserve = numSeatsToReserve;
    }

    public void run() {
        theater.reserveSeat(customerName, numSeatsToReserve);
    }
}

public class TheaterReservationSystem {
    public static void main(String[] args) {
        Theater theater = new Theater(10);

        for (int i = 0; i < 10; i++) {
            Customer customer = new Customer(theater, "Customer " + (i + 1), (int) (Math.random() * 5) + 1);
            customer.start();
        }
    }
}
