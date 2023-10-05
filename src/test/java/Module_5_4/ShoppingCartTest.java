package Module_5_4;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class ShoppingCartTest {

    @Test
    public void testAddItem() {
        ShoppingCart cart = new ShoppingCart();

        cart.addItem("Apple", 1.0);
        cart.addItem("Banana", 0.5);

        assertEquals(2, cart.getItemCount());
    }

    @Test
    public void testRemoveItem() {
        ShoppingCart cart = new ShoppingCart();

        cart.addItem("Apple", 1.0);
        cart.addItem("Banana", 0.5);
        cart.removeItem("Apple");

        assertEquals(1, cart.getItemCount());
    }

    @Test
    public void testCalculateTotal() {
        ShoppingCart cart = new ShoppingCart();

        cart.addItem("Apple", 1.0);
        cart.addItem("Banana", 0.5);
        cart.addItem("Orange", 0.75);

        assertEquals(2.25, cart.calculateTotal(), 0.01);
    }

    @Test
    public void testCalculateTotalWithEmptyCart() {
        ShoppingCart cart = new ShoppingCart();

        assertEquals(0.0, cart.calculateTotal(), 0.01);
    }

    @Test
    public void testRemoveNonexistentItem() {
        ShoppingCart cart = new ShoppingCart();

        cart.addItem("Apple", 1.0);
        cart.addItem("Banana", 0.5);
        cart.removeItem("Orange");

        assertEquals(2, cart.getItemCount());
    }
}
