This calculator program is a simple example of how to use exceptions to handle errors. The program will add a series of numbers together and print the result. If any of the numbers are negative, an exception will be thrown and the program will print an error message.
```java
public class Calculator {
    private int currentValue;

    public Calculator() {
        reset();
    }

    public void add(int value) throws IllegalArgumentException {
        if (value < 0) {
            throw new IllegalArgumentException("Value must be positive");
        }
        currentValue += value;
    }

    public void reset() {
        currentValue = 0;
    }

    public int getCurrentValue() {
        return currentValue;
    }

    public static void main(String[] args) {
        Calculator calculator = new Calculator();

        try {
            calculator.add(5);
            calculator.add(10);
            calculator.add(8);

            int result = calculator.getCurrentValue();
            System.out.printf("Result: %d\n", result);

            calculator.add(-1);
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
        }
    }
}

```