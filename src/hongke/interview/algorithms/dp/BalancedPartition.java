package hongke.interview.algorithms.dp;

/**
 * Balanced Partition. You have a set of n integers each in the range 0 ... K. Partition these integers into two subsets
 * such that you minimize |S1 - S2|, where S1 and S2 denote the sums of the elements in each of the two subsets. Created
 * by hongke on 11/8/14.
 */
public class BalancedPartition {

    public int partition(int[] num) {
        if (num == null || num.length == 0) {
            return 0;
        }

        int l = num.length;

        // each number range from K, total sum must be less than Integer.MAX_VALUE.
        // Otherwise this _does_not_work_
        int sum = sum(num);
        Boolean[][] cache = new Boolean[l][sum + 1];

        for (int i = 0; i < l; i++) {
            cache[i][num[i]] = true;
        }

        findAllSum(num, l - 1, sum, cache);

        int diff = Integer.MAX_VALUE;
        for (int i = 0; i < sum; i++) {
            if (cache[l - 1][i]) {
                diff = Math.min(diff, Math.abs(sum / 2 - i));
            }
        }
        return diff;
    }

    private boolean findAllSum(int[] num, int i, int j, Boolean[][] cache) {
        if (cache[i][j] != null)
            return cache[i][j];
        cache[i][j] = findAllSum(num, i - 1, j, cache) || findAllSum(num, i - 1, j - num[i], cache);
        return cache[i][j];
    }

    public int sum(int[] num) {
        int sum = 0;
        for (int n : num) sum += n;
        return sum;
    }
}
