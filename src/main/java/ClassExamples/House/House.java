package ClassExamples.House;

import java.util.ArrayList;

public class House {
    private final ArrayList<Elevator> elevators = new ArrayList<>();

    public House(int minFloor, int maxFloor, int elevatorCount) {
        for (int i = 0; i < elevatorCount; i++) {
            elevators.add(new Elevator(minFloor, maxFloor));
        }
    }

    public void goToFloor(int elevatorIndex, int floor) {
        elevators.get(elevatorIndex).goToFloor(floor);
    }

    public void getElevatorFloors() {
        for (Elevator elevator : elevators) {
            System.out.printf("Elevator %d is on floor %d\n", elevators.indexOf(elevator) + 1, elevator.getCurrentFloor());
        }
    }

    public void fireAlarm() {
        System.out.println("Fire alarm activated!");
        System.out.println("All elevators going to floor 1!");

        for (Elevator elevator : elevators) {
            elevator.goToFloor(1);
        }
    }
}
