import java.time.LocalDate;

public class PerishableShippableProduct extends PerishableProduct implements Shippable {
    double weight;

    public PerishableShippableProduct(String name, double price, int quantity, LocalDate expiryDate, double weight) {
        super(name, price, quantity, expiryDate);
        this.weight = weight;
    }

    @Override
    public boolean isShippable() {
        return true;
    }

    @Override
    public String getName() {
        return name;
    }

    @Override
    public double getWeight() {
        return weight;
    }
}
