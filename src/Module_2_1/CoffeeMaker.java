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

        // Test initial status
        System.out.println("Coffee maker is on: " + coffeeMaker.getStatus());

        // Turn on the coffee maker
        coffeeMaker.toggleStatus();
        System.out.println("Coffee maker is on: " + coffeeMaker.getStatus());

        // Set and get coffee type
        coffeeMaker.setCoffeeType("espresso");
        System.out.println("Coffee type: " + coffeeMaker.getCoffeeType());

        // Set and get coffee amount
        coffeeMaker.setCoffeeAmount(50);
        System.out.println("Coffee amount: " + coffeeMaker.getCoffeeAmount());

        // Turn off the coffee maker
        coffeeMaker.toggleStatus();
        System.out.println("Coffee maker is on: " + coffeeMaker.getStatus());

        // Try setting coffee type and amount while off
        coffeeMaker.setCoffeeType("normal");
        coffeeMaker.setCoffeeAmount(30);

        // Turn on the coffee maker again
        coffeeMaker.toggleStatus();

        // Set invalid coffee type
        coffeeMaker.setCoffeeType("cappuccino");

        // Get coffee type and amount
        System.out.println("Coffee type: " + coffeeMaker.getCoffeeType());
        System.out.println("Coffee amount: " + coffeeMaker.getCoffeeAmount());
    }
}
