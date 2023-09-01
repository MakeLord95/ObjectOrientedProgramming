package Module_2_1;


public class CoffeeMaker {
    private boolean isOn;
    private String coffeeType = "normal";
    private int coffeeAmount;

    void toggleStatus() {
        isOn = !isOn;
    }

    public boolean getStatus() {
        return isOn;
    }

    public String getCoffeeType() {
        if (isOn) {
            return coffeeType;
        } else {
            System.out.println("Coffee maker is off. Turn on the machine first!");
            return null;
        }
    }

    public void setCoffeeType(String coffeeType) {
        if (isOn) {
            if (coffeeType.equals("normal")) {
                this.coffeeType = "normal";
                System.out.println("Coffee type is now normal.");

            } else if (coffeeType.equals("espresso")) {
                this.coffeeType = "espresso";
                System.out.println("Coffee type is now espresso.");

            } else {
                System.out.println("Invalid coffee type!");
            }
        } else {
            System.out.println("Coffee maker is off. Turn on the machine first!");
        }
    }

    public int getCoffeeAmount() {
        if (isOn) {
            return coffeeAmount;
        } else {
            System.out.println("Coffee maker is off. Turn on the machine first!");
            return 0;
        }
    }

    void setCoffeeAmount(int amount) {
        if (isOn) {
            this.coffeeAmount = amount;
        } else {
            System.out.println("Coffee maker is off. Turn on the machine first!");
        }

    }

    
    // Main to test CoffeeMaker class
    public static void main(String[] args) {
        CoffeeMaker coffeeMaker = new CoffeeMaker();

System.out.printf("Coffee maker is on: %s\n", coffeeMaker.getStatus());

coffeeMaker.toggleStatus();
System.out.printf("Coffee maker is on: %s\n", coffeeMaker.getStatus());

coffeeMaker.setCoffeeType("espresso");
System.out.printf("Coffee type: %s\n", coffeeMaker.getCoffeeType());

coffeeMaker.setCoffeeAmount(50);
System.out.printf("Coffee amount: %d\n", coffeeMaker.getCoffeeAmount());

coffeeMaker.toggleStatus();
System.out.printf("Coffee maker is on: %s\n", coffeeMaker.getStatus());

coffeeMaker.setCoffeeType("normal");
coffeeMaker.setCoffeeAmount(30);

coffeeMaker.toggleStatus();

coffeeMaker.setCoffeeType("cappuccino");

System.out.printf("Coffee type: %s\n", coffeeMaker.getCoffeeType());
System.out.printf("Coffee amount: %d\n", coffeeMaker.getCoffeeAmount());
    }
}
