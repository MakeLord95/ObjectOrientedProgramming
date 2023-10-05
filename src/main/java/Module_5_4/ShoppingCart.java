package Module_5_4;

import java.util.HashMap;
import java.util.Map;

public class ShoppingCart {
    private final Map<String, Double> items;

    public ShoppingCart() {
        this.items = new HashMap<>();
    }

    public void addItem(String itemName, double itemPrice) {
        items.put(itemName, itemPrice);
    }

    public void removeItem(String itemName) {
        items.remove(itemName);
    }

    public int getItemCount() {
        return items.size();
    }

    public double calculateTotal() {
        double total = 0.0;
        for (Double price : items.values()) {
            total += price;
        }
        return total;
    }
}
