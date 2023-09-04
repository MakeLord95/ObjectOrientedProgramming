package Ohtu_Project;


class Clock {
    private long time;
    private static Clock INSTANCE = null;

    private Clock() {
        this.time = 0;
    }

    public static Clock getInstance() {
        if (INSTANCE == null) {
            INSTANCE = new Clock();
        }
        return INSTANCE;
    }

    public void advanceTime(long time) {
        this.time += time;
    }

    public void setTime(long time) {
        this.time = time;
    }

    public long getTime() {
        return time;
    }
}


public class TaskSet_3_3 {
    public static void main(String[] args) {
        Clock clock = Clock.getInstance();

        clock.setTime(123456789);

        Clock clock1 = Clock.getInstance();

        System.out.printf("Current time: %d\n", clock.getTime());

        clock1.setTime(123456);

        System.out.printf("Current time: %d\n", clock1.getTime());
    }
}
