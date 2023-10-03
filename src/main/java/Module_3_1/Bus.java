package Module_3_1;


import Module_2_1.Car;


public class Bus extends Car {
    private int passengers;

    public Bus(String typeName, float tankSize, int maxSpeed) {
        super(typeName, tankSize, maxSpeed);
    }

    public void passengerEnter(int amount) {
        this.passengers += amount;
    }

    public void passengerExit(int amount) {
        this.passengers -= amount;
    }

    public int getPassengers() {
        return passengers;
    }


    public static void main(String[] args) {
        Bus bus = new Bus("Volvo Bus", 150, 80);

        bus.fillTank();

        bus.accelerate();
        System.out.printf("Bus is driving at %.0f km/h\n", bus.getSpeed());

        bus.passengerEnter(5);
        System.out.printf("The bus has %s passengers\n", bus.getPassengers());

        bus.passengerEnter(4);
        bus.passengerExit(3);
        System.out.printf("The bus has %s passengers\n", bus.getPassengers());

    }

}
