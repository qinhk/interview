package hongke.interview.algorithms.dp;

import hongke.interview.algorithms.dp.model.KnapsackItem;

import java.util.*;

/**
 * Integer Knapsack Problem (Duplicate Items Forbidden). This is the same problem as the example above, except here it
 * is forbidden to use more than one instance of each type of item. Created by hongke on 11/5/14.
 */
public class Knapsack {

    private final int maxCapacity;

    public Knapsack(int capacity) {
        if (capacity <= 0)
            throw new IllegalArgumentException("Invalid capacity");
        this.maxCapacity = capacity;
    }

    public int loadKnapsack(List<KnapsackItem> items) {
        if (!preconditions(items)) return 0;
        return maxValue(0, maxCapacity, items, new Integer[items.size() + 1][maxCapacity + 1]);
    }

    private boolean preconditions(List<KnapsackItem> items) {
        if (items == null) {
            return false;
        }
        return true;
    }

    private int maxValue(int i, int capacity, List<KnapsackItem> items, Integer[][] cache) {
        if (cache[i][capacity] != null) {
            return cache[i][capacity];
        } else if (capacity <= 0) {
            return 0;
        }
        int value = 0;
        if (i < items.size() && items.get(i).weight <= capacity) {
            value = Math.max(maxValue(i + 1, capacity, items, cache),
                    items.get(i).value + maxValue(i + 1, capacity - items.get(i).weight, items, cache));
        } else if (i < items.size() && items.get(i).weight > capacity) {
            value = maxValue(i + 1, capacity, items, cache);
        }
        cache[i][capacity] = value;
        return value;
    }

    public int knapsack(int W, int[] val, int[] wt) {
        int n = val.length;
        int K[][] = new int[n + 1][W+1];

        // Build table K[][] in bottom up manner
        for (int i = 0; i <= n; i++)
        {
            for (int w = 0; w <= W; w++)
            {
                if (i==0 || w==0)
                    K[i][w] = 0;
                else if (wt[i-1] <= w)
                    K[i][w] = Math.max(val[i-1] + K[i-1][w-wt[i-1]], K[i-1][w]);
                else
                    K[i][w] = K[i-1][w];
            }
        }

        return K[n][W];
    }
}
