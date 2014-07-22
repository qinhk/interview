package hongke.interview.leetcode.questions;

/**
 * Created by hongke on 7/16/14.
 */
public class UniqueBinarySeatchTree {
    public int numTrees(int n) {
        if (n <= 0) {
            return 0;
        }

        int[] results = new int[n + 1];
        results[0] = 1;
        results[1] = 1;
        for (int i = 2; i <= n; i++) {
            for (int j = 0; j < i; j ++) {
                results[i] += results[j] * results[i - j - 1];
            }
        }

        return results[n];
    }

    public static void main (String[] args) {
        UniqueBinarySeatchTree test = new UniqueBinarySeatchTree();
        System.out.println(test.numTrees(0));
        System.out.println(test.numTrees(1));
        System.out.println(test.numTrees(2));
        System.out.println(test.numTrees(3));
    }
}
