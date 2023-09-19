package ClassExamples;

import java.util.Scanner;

public class Timer extends Thread {
    private final double seconds;
    private boolean running = true;

    public Timer(double seconds) {
        this.seconds = seconds;
    }

    public void run() {
        while (running) {
            try {
                Thread.sleep((long) (seconds * 1000));
                System.out.printf("Boop... %.1f seconds have passed\n", seconds);
            } catch (Exception e) {
                System.out.println(e.getMessage());
            }
        }
    }

    public void end() {
        running = false;
    }

    public static void main(String[] args) {
        Timer timer_5s = new Timer(5);
        Timer timer_1_3s = new Timer(1.3);

        timer_5s.start();
        timer_1_3s.start();

        System.out.println("All timers have started");

        Scanner scanner = new Scanner(System.in);
        System.out.println("Press enter to stop the timers");
        scanner.nextLine();

        System.out.println("Exiting the program");
        timer_5s.end();
        timer_1_3s.end();

        System.out.println("All timers have stopped");
    }
}
