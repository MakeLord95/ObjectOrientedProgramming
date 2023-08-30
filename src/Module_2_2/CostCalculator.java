package Module_2_2;


import java.util.HashMap;
import java.util.Map;


public class CostCalculator {
    private final HashMap<String, Double> groceryList = new HashMap<>();
    double totalCost = 0;

    void addItem(String item, double cost) {
        groceryList.put(item, cost);
    }

    void removeItem(String item) {
        groceryList.remove(item);
    }

    void displayList() {
        for (Map.Entry<String, Double> entry : groceryList.entrySet()) {
            String item = entry.getKey();
            double cost = entry.getValue();
            System.out.printf("%s: %.2f€%n", item, cost);
        }
        System.out.println();
    }

    boolean checkList(String item) {
        return groceryList.containsKey(item);
    }

    double calculateTotalCost() {
        for (Map.Entry<String, Double> entry : groceryList.entrySet()) {
            double cost = entry.getValue();
            totalCost += cost;
        }
        return totalCost;
    }


    public static void main(String[] args) {
        CostCalculator groceryList = new CostCalculator();

        groceryList.addItem("Apples", 1.5);
        groceryList.addItem("Milk", 2);
        groceryList.addItem("Bread", 2.5);

        System.out.println("Grocery list:");
        groceryList.displayList();

        System.out.printf("Is \"Milk\" in the list? %b\n\n", groceryList.checkList("Milk"));

        System.out.println("Removing \"Milk\" from the list...\n");
        groceryList.removeItem("Milk");

        System.out.println("Updated grocery list:");
        groceryList.displayList();

        System.out.println("Total cost of all items:");
        System.out.printf("%.2f€\n", groceryList.calculateTotalCost());
    }
}
