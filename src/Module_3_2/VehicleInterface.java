package Module_3_2;

interface Vehicle {
    void start();

    void stop();

    String getInfo();
}

class Car implements Vehicle {
    private final String fuelType;
    private final String color;

    public Car(String fuelType, String color) {
        this.fuelType = fuelType;
        this.color = color;
    }

    @Override
    public void start() {
        System.out.println("Car is starting!");
    }

    @Override
    public void stop() {
        System.out.println("Car is stopping!");
    }

    @Override
    public String getInfo() {
        return "Car information:\n" + "Type: Car\n" + "Fuel: " + fuelType + "\nColor: " + color + "\n";
    }
}

class Motorcycle implements Vehicle {
    private final String fuelType;
    private final String color;

    public Motorcycle(String fuelType, String color) {
        this.fuelType = fuelType;
        this.color = color;
    }

    @Override
    public void start() {
        System.out.println("Motorcycle is starting!");
    }

    @Override
    public void stop() {
        System.out.println("Motorcycle is stopping!");
    }

    @Override
    public String getInfo() {
        return "Motorcycle information:\n" + "Type: Motorcycle\n" + "Fuel: " + fuelType + "\nColor: " + color + "\n";
    }
}

class Bus implements Vehicle {
    private final String fuelType;
    private final int capacity;

    public Bus(String fuelType, int capacity) {
        this.fuelType = fuelType;
        this.capacity = capacity;
    }

    @Override
    public void start() {
        System.out.println("Bus is starting!");
    }

    @Override
    public void stop() {
        System.out.println("Bus is stopping!");
    }

    @Override
    public String getInfo() {
        return "Bus information:\n" + "Type: Bus\n" + "Fuel: " + fuelType + "\nCapacity: " + capacity + " passengers\n";
    }
}

public class VehicleInterface {
    public static void main(String[] args) {
        System.out.println("Vehicle Demonstration\n");

        Vehicle car = new Car("Petrol", "Red");
        Vehicle motorcycle = new Motorcycle("Gasoline", "Black");
        Vehicle bus = new Bus("Diesel", 40);

        car.start();
        car.stop();
        System.out.println(car.getInfo());

        motorcycle.start();
        motorcycle.stop();
        System.out.println(motorcycle.getInfo());

        bus.start();
        bus.stop();
        System.out.println(bus.getInfo());
    }
}
