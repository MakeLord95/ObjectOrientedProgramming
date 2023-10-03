package Module_2_1;


class Television {
    private int channel = 1;

    public void changeChannel() {
        channel = (channel % 10) + 1;
    }

    public int getChannel() {
        return channel;
    }
}


public class TelevisionViewer {
    public static void main(String[] args) {
        Television television = new Television();

        for (int i = 1; i <= 10; i++) {
            System.out.printf("Woke up, day %d\n", i);

            if (i == 1) {
                for (int j = 0; j < 3; j++) {
                    System.out.printf("Watching channel %d\n", television.getChannel());
                    television.changeChannel();
                }
            } else if (i == 2 || i == 4 || i == 6 || i == 8 || i == 10) {
                for (int j = 0; j < 4; j++) {
                    System.out.printf("Watching channel %d\n", television.getChannel());
                    television.changeChannel();
                }
            } else {
                for (int j = 0; j < 6; j++) {
                    System.out.printf("Watching channel %d\n", television.getChannel());
                    television.changeChannel();
                }
            }
            System.out.println("Falling asleep");
        }
    }
}
