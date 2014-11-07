package hongke.interview.algorithms.dp.model;

import hongke.interview.algorithms.dp.Knapsack;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by hongke on 11/5/14.
 */
public class KnapsackItem {
    public int weight;
    public int value;

    public KnapsackItem(int w, int v) {
        this.weight = w;
        this.value = v;
    }

    public static List<KnapsackItem> getItems(int[] weights, int[] values) {
        if (weights.length != values.length) {
            throw new IllegalArgumentException("Invalid input!");
        }

        List<KnapsackItem> items = new ArrayList<KnapsackItem>();
        for (int i = 0; i < weights.length; i++) {
            items.add(new KnapsackItem(weights[i], values[i]));
        }

        return items;
    }
}
