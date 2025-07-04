import java.time.LocalDate;

public class PerishableProduct extends Product {
    LocalDate expiryDate;

    public PerishableProduct(String name, double price, int quantity, LocalDate expiryDate) {
        super(name, price, quantity);
        this.expiryDate = expiryDate;
    }

    @Override
    public boolean isExpired() {
        return LocalDate.now().isAfter(expiryDate);
    }

    @Override
    public boolean isShippable() {
        return false;
    }
}
