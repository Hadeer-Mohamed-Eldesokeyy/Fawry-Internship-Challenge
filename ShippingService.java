import java.util.*;

public class ShippingService {
    public static void ship(List<Shippable> items) {
        System.out.println("** Shipment notice **");

        Map<String, Double> weightMap = new LinkedHashMap<>();
        Map<String, Integer> countMap = new LinkedHashMap<>();

        for (Shippable item : items) {
            String name = item.getName();
            double weight = item.getWeight();

            weightMap.put(name, weightMap.getOrDefault(name, 0.0) + weight);
            countMap.put(name, countMap.getOrDefault(name, 0) + 1);
        }

        double totalWeight = 0;

        for (String name : weightMap.keySet()) {
            int count = countMap.get(name);
            double weight = weightMap.get(name);
            totalWeight += weight;
            System.out.printf("%dx %s\t%.0fg\n", count, name, weight * 1000);
        }

        System.out.printf("Total package weight %.1fkg\n", totalWeight);
    }
}

