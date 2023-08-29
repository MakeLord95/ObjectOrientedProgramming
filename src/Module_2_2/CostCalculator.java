package Module_2_2;


import java.util.HashMap;


public class CostCalculator {
    private final HashMap<String, Double> groceryList = new HashMap<String, Double>();

    void addItem(String item, double cost) {
        groceryList.put(item, cost);
    }

    void removeItem(String item) {
        groceryList.remove(item);
    }

    void displayList() {
        // TODO: Finish this part
        // TODO: Add total cost calculation to the program.
    }

    boolean checkList(String item) {
        return groceryList.containsKey(item);
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
    }
}