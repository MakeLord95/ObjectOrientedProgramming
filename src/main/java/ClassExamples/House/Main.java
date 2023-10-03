package ClassExamples.House;

public class Main {
    public static void main(String[] args) {
        House house = new House(1, 10, 2);
        house.goToFloor(0, 5);
        house.goToFloor(1, 7);
        house.getElevatorFloors();

        house.fireAlarm();

        house.getElevatorFloors();
    }
}
