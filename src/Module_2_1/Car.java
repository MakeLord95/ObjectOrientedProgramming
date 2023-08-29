package Module_2_1;


public class Car {
    private final String typeName;
    private final float tankSize;
    private final int maxSpeed;
    private float speed;
    private float gasolineLevel;

    public Car(String typeName, float tankSize, int maxSpeed) {
        speed = 0;
        gasolineLevel = 0;
        this.typeName = typeName;
        this.tankSize = tankSize;
        this.maxSpeed = maxSpeed;
    }

    public void accelerate() {
        if (gasolineLevel > 0 && speed < (maxSpeed - 10)) {
            speed += 10;
            gasolineLevel -= (float) (Math.random() * 10 + speed);
        } else
            speed = 0;
    }

    void decelerate(int amount) {
        if (gasolineLevel > 0) {
            if (amount > 0)
                speed = Math.max(0, speed - amount);
        } else
            speed = 0;
    }

    float getSpeed() {
        return speed;
    }

    String getTypeName() {
        return typeName;
    }

    void fillTank() {
        gasolineLevel = tankSize;
    }

    float getGasolineLevel() {
        return gasolineLevel;
    }

    float getTankSize() {
        return tankSize;
    }

    int getMaxSpeed() {
        return maxSpeed;
    }


    // Main to test Car class
    public static void main(String[] args) {
        Car car1 = new Car("Sedan", 60.0f, 180);
        Car car2 = new Car("Sports Car", 50.0f, 220);

        car1.fillTank();
        car2.fillTank();

        car1.accelerate();
        car2.accelerate();
        car2.accelerate();

        car1.decelerate(20);
        car2.decelerate(15);

        System.out.printf("Car 1 - Type: %s, Speed: %.2f, Gasoline Level: %.2f, Tank Size: %.2f, Max Speed: %d%n",
                car1.getTypeName(),
                car1.getSpeed(),
                car1.getGasolineLevel(),
                car1.getTankSize(),
                car1.getMaxSpeed());

        System.out.printf("Car 2 - Type: %s, Speed: %.2f, Gasoline Level: %.2f, Tank Size: %.2f, Max Speed: %d%n",
                car2.getTypeName(),
                car2.getSpeed(),
                car2.getGasolineLevel(),
                car2.getTankSize(),
                car2.getMaxSpeed());

    }
}
