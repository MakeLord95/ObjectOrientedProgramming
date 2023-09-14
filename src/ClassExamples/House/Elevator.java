package ClassExamples.House;

public class Elevator {
    private int currentFloor;
    private final int maxFloor;
    private final int minFloor;

    public Elevator(int minFloor, int maxFloor) {
        this.currentFloor = minFloor;
        this.minFloor = minFloor;
        this.maxFloor = maxFloor;
    }

    public int getCurrentFloor() {
        return currentFloor;
    }

    public void floorUp() {
        if (currentFloor < maxFloor) {
            currentFloor++;
        }
    }

    public void floorDown() {
        if (currentFloor > minFloor) {
            currentFloor--;
        }
    }

    public void goToFloor(int floor) {
        if (floor > currentFloor) {
            for (int i = currentFloor; i < floor; i++) {
                floorUp();
            }
        } else if (floor < currentFloor) {
            for (int i = currentFloor; i > floor; i--) {
                floorDown();
            }
        }
    }
}
