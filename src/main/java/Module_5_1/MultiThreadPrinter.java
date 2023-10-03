package Module_5_1;

public class MultiThreadPrinter extends Thread {
    private final int range;
    private boolean even = false;
    private boolean odd = false;

    public MultiThreadPrinter(int range) {
        this.range = range;
    }

    public void run() {
        int number = 1;

        try {
            if (odd) {
                do {
                    if (number % 2 != 0) {
                        System.out.printf("Odd Thread: %d\n", number);
                    }
                    number++;
                } while (number <= range);
            } else if (even) {
                do {
                    if (number % 2 == 0) {
                        System.out.printf("Even Thread: %d\n", number);
                    }
                    number++;
                } while (number <= range);

            }
        } catch (Exception e) {
            System.out.println("Exception is caught");
            System.exit(2);
        }
    }

    public void setMode(String type) {
        if (type.equals("even")) {
            even = true;
        } else if (type.equals("odd")) {
            odd = true;
        }
    }

    public static void main(String[] args) {
        MultiThreadPrinter oddThread = new MultiThreadPrinter(20);
        MultiThreadPrinter evenThread = new MultiThreadPrinter(20);

        oddThread.setMode("odd");
        evenThread.setMode("even");

        oddThread.start();
        evenThread.start();

        try {
            oddThread.join();
            evenThread.join();
        } catch (Exception e) {
            throw new RuntimeException(e);
        }

        System.out.println("Printing complete.");

    }
}
