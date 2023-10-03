package Module_2_1;


public class CarCruiseControl {
    private final String typeName;
    private final int maxSpeed;
    private final int minSpeed;
    private float speed;
    private float gasolineLevel;
    private int targetSpeed;
    private boolean cruiseControlStatus;

    public CarCruiseControl(String typeName, int maxSpeed, int minSpeed) {
        speed = 0;
        gasolineLevel = 0;
        this.typeName = typeName;
        this.maxSpeed = maxSpeed;
        this.minSpeed = minSpeed;
    }

    int getMinSpeed() {
        return minSpeed;
    }

    int getMaxSpeed() {
        return maxSpeed;
    }

    boolean getCruiseControlStatus() {
        return cruiseControlStatus;
    }

    void setCruiseControlStatus(boolean status) {
        cruiseControlStatus = status;
    }

    int getTargetSpeed() {
        return targetSpeed;
    }

    void setTargetSpeed(int speed) {
        targetSpeed = speed;
        if (cruiseControlStatus && minSpeed <= targetSpeed && targetSpeed <= maxSpeed) {
            while (this.speed <= targetSpeed) {
                accelerate();
            }
        } else {
            System.out.println("Cannot set speed over the max/min limit");
            cruiseControlStatus = false;
        }
    }

    public void accelerate() {
        if (gasolineLevel > 0)
            speed += 10;
        else
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
        gasolineLevel = 100;
    }

    float getGasolineLevel() {
        return gasolineLevel;
    }


    public static void main(String[] args) {
        CarCruiseControl myCar = new CarCruiseControl("Toyota Corolla", 100, 0);
        myCar.fillTank();

        myCar.setCruiseControlStatus(true);

        myCar.setTargetSpeed((int) (Math.random() * myCar.getMaxSpeed()));
        System.out.printf("Car: %s, Cruise control status: %b, Max Speed: %d, Min Speed: %d, Current Speed: %.2f",
                myCar.getTypeName(),
                myCar.getCruiseControlStatus(),
                myCar.getMaxSpeed(),
                myCar.getMinSpeed(),
                myCar.getSpeed());
    }
}
