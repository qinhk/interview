package hongke.interview.algorithms.dp;

/**
 * Making Change. You are given n types of coin denominations of values v(1) < v(2) < ... < v(n) (all integers). Assume
 * v(1) = 1, so you can always make change for any amount of money C. Give an algorithm which makes change for an amount
 * of money C with as few coins as possible. [on problem set 4] Created by hongke on 11/2/14.
 */
public class MakingChange {

    // return fewest coin count.
    public int makingChange(int[] coins, int value) {
        if (!precondition(coins, value)) return 0;

        int[] changes = new int[value + 1];
        for (int i = 1; i <= value; i++) {
            changes[i] = Integer.MAX_VALUE;
            for (int j = 0; j < coins.length && coins[j] <= i; j++) {
                if (i - coins[j] >= 0) {
                    changes[i] = Math.min(changes[i], 1 + changes[i - coins[j]]);
                }
            }
        }
        return changes[value];
    }


    public int makingChangeCombination(int[] coins, int value) {
        if (!precondition(coins, value)) return 0;
        int[][] cache = new int[value + 1][coins.length];
        return findCombinations(coins, coins.length - 1, value, cache);
    }

    private int findCombinations(int[] elements, int index, int sum, int[][] cache) {
        if (cache[sum][index] != 0) {
            return cache[sum][index];
        }

        int partialSum = 0;
        while (partialSum <= sum) {
            if (partialSum < sum && index > 0) {
                cache[sum][index] += findCombinations(elements, index - 1, sum - partialSum, cache);
            } else if (sum == partialSum) {
                cache[sum][index] += 1;
            }
            partialSum += elements[index];
        }
        return cache[sum][index];
    }

    private boolean precondition(int[] coins, int value) {
        if (coins == null || coins.length == 0 || value <= 0) {
            return false;
        }

        for (int i : coins) {
            if (i <= 0) {
                return false;
            }
        }

        return true;
    }

}
