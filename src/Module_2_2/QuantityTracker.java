package Module_2_2;


import java.util.HashMap;
import java.util.Map;
import java.util.ArrayList;
import java.util.List;


public class QuantityTracker {
    private final Map<String, Double> groceryList = new HashMap<>();
    private final Map<String, String> itemCategories = new HashMap<>();
    private final Map<String, List<String>> categoryItems = new HashMap<>();
    private final Map<String, Integer> itemQuantities = new HashMap<>();

    void addItemWithCategory(String item, double cost, String category) {
        groceryList.put(item, cost);
        itemCategories.put(item, category);
        categoryItems.computeIfAbsent(category, k -> new ArrayList<>()).add(item);
        itemQuantities.put(item, 0); // Initialize quantity to 0
    }

    void addItemWithQuantity(String item, int quantity) {
        if (groceryList.containsKey(item)) {
            itemQuantities.put(item, quantity);
        }
    }

    void updateQuantity(String item, int newQuantity) {
        if (groceryList.containsKey(item)) {
            itemQuantities.put(item, newQuantity);
        }
    }

    void displayAvailableItems() {
        for (Map.Entry<String, Integer> entry : itemQuantities.entrySet()) {
            String item = entry.getKey();
            int quantity = entry.getValue();
            if (quantity > 0) {
                double cost = groceryList.get(item);
                String category = itemCategories.get(item);
                System.out.printf("%s (Qty: %d): %.2f€ (%s)%n", item, quantity, cost, category);
            }
        }
        System.out.println();
    }

    void removeItem(String item) {
        Double cost = groceryList.remove(item);
        String category = itemCategories.remove(item);
        if (category != null && cost != null) {
            categoryItems.get(category).remove(item);
        }
    }

    void displayList() {
        for (Map.Entry<String, Double> entry : groceryList.entrySet()) {
            String item = entry.getKey();
            double cost = entry.getValue();
            String category = itemCategories.get(item);
            System.out.printf("%s: %.2f€ (%s)%n", item, cost, category);
        }
        System.out.println();
    }

    void displayByCategory(String category) {
        List<String> items = categoryItems.get(category);
        if (items != null) {
            for (String item : items) {
                double cost = groceryList.get(item);
                System.out.printf("%s: %.2f€%n", item, cost);
            }
            System.out.println();
        } else {
            System.out.println("Category not found.\n");
        }
    }


    public static void main(String[] args) {
        QuantityTracker groceryList = new QuantityTracker();

        groceryList.addItemWithCategory("Apples", 1.5, "Fruits");
        groceryList.addItemWithCategory("Milk", 2, "Dairy");
        groceryList.addItemWithCategory("Bread", 2.5, "Bakery");

        groceryList.addItemWithQuantity("Apples", 3);
        groceryList.updateQuantity("Milk", 2);

        System.out.println("Available items:");
        groceryList.displayAvailableItems();

        System.out.println("Removing \"Milk\" from the list...\n");
        groceryList.removeItem("Milk");

        System.out.println("Updated grocery list:");
        groceryList.displayList();
    }
}
