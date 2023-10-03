package Module_3_2;


interface ElectricVehicle {
    void charge();

    float getBatteryWH();

    void drive(int km);
}

class ElectricCar implements ElectricVehicle {
    private final float maxBatteryWH;
    private float currentBatteryWH;

    public ElectricCar(float maxBatteryWH) {
        this.maxBatteryWH = maxBatteryWH;
        this.currentBatteryWH = 0;
    }

    @Override
    public void charge() {
        currentBatteryWH = maxBatteryWH;
    }

    @Override
    public float getBatteryWH() {
        return currentBatteryWH;
    }

    @Override
    public void drive(int km) {
        if (currentBatteryWH > 0) {
            currentBatteryWH -= (float) (Math.random() * km);
        }
    }
}

class ElectricMotorcycle implements ElectricVehicle {
    private final float maxBatteryWH;
    private float currentBatteryWH;

    public ElectricMotorcycle(float maxBatteryWH) {
        this.maxBatteryWH = maxBatteryWH;
        this.currentBatteryWH = 0;
    }


    @Override
    public void charge() {
        currentBatteryWH = maxBatteryWH;
    }

    @Override
    public float getBatteryWH() {
        return currentBatteryWH;
    }

    @Override
    public void drive(int km) {
        if (currentBatteryWH > 0) {
            currentBatteryWH -= (float) (Math.random() * km);
        }
    }
}

public class ElectricVehiclesMain {
    public static void main(String[] args) {
        ElectricVehicle electricCar = new ElectricCar(100);
        ElectricVehicle electricMotorcycle = new ElectricMotorcycle(25);

        System.out.printf("Electric car battery level: %.2f\n", electricCar.getBatteryWH());
        System.out.printf("Electric motorcycle battery level: %.2f\n", electricMotorcycle.getBatteryWH());

        electricCar.charge();
        electricMotorcycle.charge();

        System.out.printf("Electric car battery level: %.2f\n", electricCar.getBatteryWH());
        System.out.printf("Electric motorcycle battery level: %.2f\n", electricMotorcycle.getBatteryWH());

        electricCar.drive(100);
        electricMotorcycle.drive(25);

        System.out.printf("Electric car battery level: %.2f\n", electricCar.getBatteryWH());
        System.out.printf("Electric motorcycle battery level: %.2f\n", electricMotorcycle.getBatteryWH());

    }
}
