import java.time.LocalDate;

public class Main {
    public static void main(String[] args) {
        System.out.println("\n===== Test Case 1: Normal Checkout =====");
        Product cheese = new PerishableShippableProduct("Cheese", 100, 5, LocalDate.of(2025, 7, 20), 0.2);
        Product biscuits = new PerishableShippableProduct("Biscuits", 150, 2, LocalDate.of(2025, 7, 15), 0.7);
        Product tv = new ShippableProduct("TV", 3000, 3, 5);
        Product scratchCard = new Product("Scratch Card", 50, 10) {
            @Override
            public boolean isExpired() { return false; }
            @Override
            public boolean isShippable() { return false; }
        };
        Customer customer1 = new Customer();
        customer1.setName("Hadeer");
        customer1.setBalance(5000);
        Cart cart1 = new Cart();
        cart1.add(cheese, 2);
        cart1.add(biscuits, 1);
        cart1.add(tv, 1);
        cart1.add(scratchCard, 1);
        CheckoutService.checkout(customer1, cart1);

        System.out.println("\n===== Test Case 2: Expired Product =====");
        Product expiredBiscuits = new PerishableShippableProduct("Expired Biscuits", 100, 2, LocalDate.of(2023, 1, 1), 0.5);
        Customer customer2 = new Customer();
        customer2.setName("Mohamed");
        customer2.setBalance(1000);
        customer2.setMobileNumber("0123456789");
        Cart cart2 = new Cart();
        cart2.add(expiredBiscuits, 1);
        CheckoutService.checkout(customer2, cart2);

        System.out.println("\n===== Test Case 3: Quantity Exceeds Stock =====");
        Product limitedCheese = new PerishableShippableProduct("Limited Cheese", 100, 2, LocalDate.of(2025, 8, 1), 0.2);
        Customer customer3 = new Customer();
        customer3.setName("Ahmed");
        customer3.setBalance(1000);
        customer3.setMobileNumber("1234567890");
        Cart cart3 = new Cart();
        cart3.add(limitedCheese, 5);
        CheckoutService.checkout(customer3, cart3);

        System.out.println("\n===== Test Case 4: Insufficient Balance =====");
        Customer customer4 = new Customer();
        customer4.setName("Mona");
        customer4.setBalance(1000);
        customer4.setMobileNumber("0987654321");
        Cart cart4 = new Cart();
        cart4.add(tv, 1); 
        CheckoutService.checkout(customer4, cart4);

        System.out.println("\n===== Test Case 5: Empty Cart =====");
        Customer customer5 = new Customer();
        customer5.setName("Ali");
        customer5.setBalance(20000);
        customer5.setMobileNumber("1234567890");
        Cart cart5 = new Cart();
        CheckoutService.checkout(customer5, cart5);

        System.out.println("\n===== Test Case 6: Non-shippable Product Only =====");
        Customer customer6 = new Customer();
        customer6.setName("Sara");
        customer6.setBalance(1000);
        customer6.setMobileNumber("9876543210");
        Cart cart6 = new Cart();
        cart6.add(scratchCard, 1);
        CheckoutService.checkout(customer6, cart6);
    }
}
