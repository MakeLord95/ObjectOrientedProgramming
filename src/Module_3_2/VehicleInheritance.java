package Module_3_2;


abstract class AbstractVehicle implements Vehicle {
    protected String model;
    protected String color;
    protected String fuelType;

    public AbstractVehicle(String model, String color, String fuelType) {
        this.model = model;
        this.color = color;
        this.fuelType = fuelType;
    }
}

class Car2 extends AbstractVehicle {

    public Car2(String model, String color, String fuelType) {
        super(model, color, fuelType);
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
        return "Car information:\n" + "Type: " + model + "\nFuel: " + fuelType + "\nColor: " + color + "\n";
    }
}

class Motorcycle2 extends AbstractVehicle {
    public Motorcycle2(String model, String color, String fuelType) {
        super(model, color, fuelType);
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
        return "Motorcycle information:\n" + "Type: " + model + "\nFuel: " + fuelType + "\nColor: " + color + "\n";
    }
}

class Bus2 extends AbstractVehicle {
    public Bus2(String model, String color, String fuelType) {
        super(model, color, fuelType);
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
        return "Bus information:\n" + "Type: " + model + "\nFuel: " + fuelType + "\nColor: " + color + "\n";
    }
}

public class VehicleInheritance {
    public static void main(String[] args) {

        AbstractVehicle car = new Car2("Toyota Corolla", "Red", "Gasoline");
        AbstractVehicle motorcycle = new Motorcycle2("Motocross Bike", "Black", "Gasoline");
        AbstractVehicle bus = new Bus2("Volvo Bus", "Gray", "Diesel");

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
