import java.util.*;

public class Cart {
    Map<Product, Integer> items = new HashMap<>();

    public void add(Product product, int quantity) {
        if (quantity > product.quantity) {
            System.out.println("Not enough stock for: " + product.name);
            return;
        }
        items.put(product, items.getOrDefault(product, 0) + quantity);
    }

    public Map<Product, Integer> getItems() {
        return items;
    }

    public boolean isEmpty() {
        return items.isEmpty();
    }
}
