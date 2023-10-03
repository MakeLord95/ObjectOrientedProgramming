package Module_3_2;


interface VehicleFuelEfficiency {
    float calculateFuelEfficiency(float traveledTrip, float refillAmount);

    String getInfo();
}

class CarFuel implements VehicleFuelEfficiency {
    private final String fuelType;
    private final String color;

    public CarFuel(String fuelType, String color) {
        this.fuelType = fuelType;
        this.color = color;
    }

    @Override
    public float calculateFuelEfficiency(float traveledTrip, float refillAmount) {
        return traveledTrip / refillAmount;
    }

    @Override
    public String getInfo() {
        return "Car information:\n" + "Type: Car\n" + "Fuel: " + fuelType + "\nColor: " + color + "\n";
    }
}

class MotorcycleFuel implements VehicleFuelEfficiency {
    private final String fuelType;
    private final String color;

    public MotorcycleFuel(String fuelType, String color) {
        this.fuelType = fuelType;
        this.color = color;
    }

    @Override
    public float calculateFuelEfficiency(float traveledTrip, float refillAmount) {
        return traveledTrip / refillAmount;
    }

    @Override
    public String getInfo() {
        return "Motorcycle information:\n" + "Type: Car\n" + "Fuel: " + fuelType + "\nColor: " + color + "\n";
    }
}

class BusFuel implements VehicleFuelEfficiency {
    private final String fuelType;
    private final String color;

    public BusFuel(String fuelType, String color) {
        this.fuelType = fuelType;
        this.color = color;
    }

    @Override
    public float calculateFuelEfficiency(float traveledTrip, float refillAmount) {
        return traveledTrip / refillAmount;
    }

    @Override
    public String getInfo() {
        return "Bus information:\n" + "Type: Car\n" + "Fuel: " + fuelType + "\nColor: " + color + "\n";
    }
}

public class FuelEfficiencyMain {
    public static void main(String[] args) {
        VehicleFuelEfficiency car = new CarFuel("Gasoline", "Red");
        VehicleFuelEfficiency bus = new BusFuel("Diesel", "Gray");
        VehicleFuelEfficiency motorcycle = new MotorcycleFuel("Gasoline", "White");

        float carTravelKm = (float) (Math.random() * 1000);
        float busTravelKm = (float) (Math.random() * 1000);
        float motorcycleTravelKm = (float) (Math.random() * 100);

        float carRefillAmount = (float) (Math.random() * 100);
        float busRefillAmount = (float) ((Math.random() * 100) + 100);
        float motorcycleRefillAmount = (float) (Math.random() * 10);


        System.out.printf("Car fuel efficiency when you traveled %.2f km and refilled %.2f l: %.2f l/100 km\n",
                carTravelKm, carRefillAmount, car.calculateFuelEfficiency(carTravelKm, carRefillAmount));

        System.out.printf("Bus fuel efficiency when you traveled %.2f km and refilled %.2f l: %.2f l/100 km\n",
                busTravelKm, busRefillAmount, bus.calculateFuelEfficiency(busTravelKm, busRefillAmount));

        System.out.printf("Motorcycle fuel efficiency when you traveled %.2f km and refilled %.2f l: %.2f l/100 km\n",
                motorcycleTravelKm, motorcycleRefillAmount, motorcycle.calculateFuelEfficiency(motorcycleTravelKm, motorcycleRefillAmount));

    }
}
