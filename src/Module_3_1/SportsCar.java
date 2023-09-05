package Module_3_1;

import Module_2_1.Car;

public class SportsCar extends Car {
    private float speed;

    public SportsCar(String typeName, float tankSize, int maxSpeed) {
        super(typeName, tankSize, maxSpeed);
    }

    @Override
    public void accelerate() {
        if (this.getGasolineLevel() > 0 && this.getSpeed() < (this.getMaxSpeed() - 10)) {
            this.setSpeed(speed += 20);

            this.setGasolineLevel(this.getGasolineLevel() - (float) (Math.random() * 10 + speed));
        } else
            speed = 0;
    }

    @Override
    public void decelerate(int amount) {
        super.decelerate(amount);
    }


    public static void main(String[] args) {
        SportsCar sportsCar = new SportsCar("Ferrari", 100, 250);

        sportsCar.fillTank();
        System.out.printf("Gasoline level: %.0f \n", sportsCar.getGasolineLevel());

        sportsCar.accelerate();
        System.out.printf("Car speed: %.0f, gasoline level: %.0f\n", sportsCar.getSpeed(), sportsCar.getGasolineLevel());

        sportsCar.decelerate(10);
        System.out.printf("Car speed: %.0f, gasoline level: %.0f\n", sportsCar.getSpeed(), sportsCar.getGasolineLevel());
    }
}
