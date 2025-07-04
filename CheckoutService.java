import java.util.*;

public class CheckoutService {
    public static void checkout(Customer customer, Cart cart) {
        if (cart.isEmpty()) {
            System.out.println("Error: Cart is empty.");
            return;
        }

        double subtotal = 0;
        double shipping = 0;
        List<Shippable> shippables = new ArrayList<>();

        for (Map.Entry<Product, Integer> entry : cart.getItems().entrySet()) {
            Product product = entry.getKey();
            int qty = entry.getValue();

            if (product.isExpired()) {
                System.out.println("Error: Product expired - " + product.name);
                return;
            }

            if (qty > product.quantity) {
                System.out.println("Error: Not enough stock for - " + product.name);
                return;
            }

            subtotal += product.price * qty;

            if (product.isShippable() && product instanceof Shippable) {
                for (int i = 0; i < qty; i++) {
                    shippables.add((Shippable) product);
                }
                shipping += 15 * qty;
            }
        }

        double total = subtotal + shipping;

        if (customer.balance < total) {
            System.out.println("Error: Insufficient balance.");
            return;
        }

        if (!shippables.isEmpty()) {
            ShippingService.ship(shippables);
        }

        System.out.println("\n** Checkout receipt **");
        for (Map.Entry<Product, Integer> entry : cart.getItems().entrySet()) {
            Product product = entry.getKey();
            int qty = entry.getValue();
            System.out.printf("%dx %s\t%.0f\n", qty, product.name, product.price * qty);
        }
        System.out.println("----------------------");
        System.out.printf("Subtotal\t%.0f\n", subtotal);
        System.out.printf("Shipping\t%.0f\n", shipping);
        System.out.printf("Amount\t\t%.0f\n", total);

        customer.balance -= total;
    }
}
