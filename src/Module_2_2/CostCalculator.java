package Module_2_2;


import java.util.ArrayList;


public class CostCalculator {
    private final ArrayList<String> groceryList = new ArrayList<>();

    void addItem(String item, double cost) {
        groceryList.add(item);
    }

    void removeItem(String item) {
        groceryList.remove(item);
    }

    void displayList() {
        for (int i = 0; i < groceryList.size(); i++) {
            System.out.printf("%d. %s\n", i + 1, groceryList.get(i));
        }
        System.out.println();
    }

    boolean checkList(String item) {
        return groceryList.contains(item);
    }

    double calculateTotalCost() {

        return totalCost;
    }


    public static void main(String[] args) {
        GroceryListManager groceryList = new GroceryListManager();

        groceryList.addItem("Apples");
        groceryList.addItem("Milk");
        groceryList.addItem("Bread");

        System.out.println("Grocery list:");
        groceryList.displayList();

        System.out.printf("Is \"Milk\" in the list? %b\n\n", groceryList.checkList("Milk"));

        System.out.println("Removing \"Milk\" from the list...\n");
        groceryList.removeItem("Milk");


        System.out.println("Updated grocery list:");
        groceryList.displayList();
    }
}