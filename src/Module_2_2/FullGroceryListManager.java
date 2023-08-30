package Module_2_2;


import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;


class ShoppingList {
    private final String purpose;
    private final List<String> items;

    public ShoppingList(String purpose) {
        this.purpose = purpose;
        this.items = new ArrayList<>();
    }

    public void addItem(String item) {
        items.add(item);
    }

    public void removeItem(String item) {
        items.remove(item);
    }

    public void displayList() {
        System.out.printf("Shopping List for %s purpose:", purpose);
        for (String item : items) {
            System.out.println("- " + item);
        }
        System.out.println();
    }
}


public class FullGroceryListManager {
    private final Map<String, Double> groceryList = new HashMap<>();
    private final Map<String, String> itemCategories = new HashMap<>();
    private final Map<String, List<String>> categoryItems = new HashMap<>();
    private final Map<String, Integer> itemQuantities = new HashMap<>();
    private final List<ShoppingList> shoppingLists = new ArrayList<>();

    void addItemWithCategory(String item, double cost, String category) {
        groceryList.put(item, cost);
        itemCategories.put(item, category);
        categoryItems.computeIfAbsent(category, k -> new ArrayList<>()).add(item);
        itemQuantities.put(item, 0);
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
                System.out.printf("%s (Qty: %d): %.2f€ (%s)\n", item, quantity, cost, category);
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
            System.out.printf("%s: %.2f€ (%s)\n", item, cost, category);
        }
        System.out.println();
    }

    void displayByCategory(String category) {
        List<String> items = categoryItems.get(category);
        if (items != null) {
            for (String item : items) {
                double cost = groceryList.get(item);
                System.out.printf("%s: %.2f€\n", item, cost);
            }
            System.out.println();
        } else {
            System.out.println("Category not found.\n");
        }
    }

    public void addShoppingList(ShoppingList shoppingList) {
        shoppingLists.add(shoppingList);
    }

    public void displayAllShoppingLists() {
        System.out.println("All Shopping Lists:");
        for (ShoppingList shoppingList : shoppingLists) {
            shoppingList.displayList();
        }
    }


    public static void main(String[] args) {
        FullGroceryListManager groceryManager = new FullGroceryListManager();

        // Create and manage a "Backyard BBQ" shopping list
        ShoppingList bbqList = new ShoppingList("Backyard BBQ");
        bbqList.addItem("Burgers");
        bbqList.addItem("Hot-dogs");
        bbqList.addItem("Buns");
        groceryManager.addShoppingList(bbqList);

        // Create and manage a "Weekend Camping" shopping list
        ShoppingList campingList = new ShoppingList("Weekend Camping");
        campingList.addItem("Tent");
        campingList.addItem("Sleeping bags");
        campingList.addItem("Cooking utensils");
        groceryManager.addShoppingList(campingList);

        // Display all shopping lists
        groceryManager.displayAllShoppingLists();
    }
}
