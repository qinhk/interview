package hongke.interview.algorithms.dp;

import java.util.Arrays;

/**
 * Optimal Strategy for a Game. Consider a row of n coins of values v(1) ... v(n), where n is even. We play a game
 * against an opponent by alternating turns. In each turn, a player selects either the first or last coin from the row,
 * removes it from the row permanently, and receives the value of the coin. Determine the maximum possible amount of
 * money we can definitely win if we move first. Created by hongke on 11/8/14.
 */
public class OptimalStrategyForAGame {

    public int optimalStrategy(int[] numbers) {
        if (numbers == null || numbers.length == 0) {
            return 0;
        }

        int[][] cache = new int[numbers.length][numbers.length];
        for (int[] c : cache) {
            Arrays.fill(c, -1);
        }
        return findOptimalStrategy(numbers, 0, numbers.length - 1, cache);
    }

    private int findOptimalStrategy(int[] num, int start, int end, int[][] cache) {
        if (start > end) return 0;
        if (cache[start][end] != -1) return cache[start][end];
        if (start == end) return num[start];
        int value = Math.max(
                Math.min(
                        findOptimalStrategy(num, start + 2, end, cache),
                        findOptimalStrategy(num, start + 1, end - 1, cache)
                ) + num[start],
                Math.min(
                        findOptimalStrategy(num, start + 1, end - 1, cache),
                        findOptimalStrategy(num, start, end - 2, cache)
                ) + num[end]
        );
        cache[start][end] = value;
        return value;
    }


}
