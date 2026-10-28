import java.util.*;

class Item {
    int value, weight;

    Item(int value, int weight) {
        this.value = value;
        this.weight = weight;
    }
}

public class Pract3 {
    public static void main(String[] args) {
        Item[] items = { new Item(60, 10), new Item(100, 20), new Item(120, 30) };
        int capacity = 50;
        double totalValue = 0;

        // sort by value/weight ratio (high to low)
        Arrays.sort(items, (a, b) -> Double.compare(
            (double) b.value / b.weight,
            (double) a.value / a.weight));

        for (Item item : items) {
            if (capacity == 0) break;
            int take = Math.min(capacity, item.weight);
            totalValue += (double) take * item.value / item.weight;
            capacity -= take;
        }

        System.out.println("Maximum value: " + totalValue);
    }
}
