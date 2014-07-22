package hongke.interview.leetcode.questions;

/**
 * Created by hongke on 7/16/14.
 */
public class TrappingRainWater {
    public int trap(int[] A) {
        if (A == null || A.length == 0) {
            return 0;
        }

        int l = 0, r = A.length - 1;
        int total = 0, height = 0;
        while (l != r) {
            if (A[l] < A[r]) {
                height = A[l];
                while (height >= A[l] && l < r) {
                    total += height - A[l];
                    l ++;
                }

            } else {
                height = A[r];
                while (height >= A[r] && l < r) {
                    total += height - A[r];
                    r --;
                }
            }
        }
        return total;
    }

    public static void main (String[] args) {
        TrappingRainWater test = new TrappingRainWater();
        System.out.println(test.trap(new int[] {0, 1, 0, 2, 1, 0, 1, 3, 2, 1, 2, 1}));

        System.out.println(test.trap(new int[] {1, 2, 3, 4, 5}));

        System.out.println(test.trap(new int[] {0, 1, 1, 1, 1, 1, 1, 0}));

        System.out.println(test.trap(new int[] {0, 6, 5, 4, 3, 2, 1, 0}));

        System.out.println(test.trap(new int[] {0, 1, 0, 1, 0, 1, 0, 1}));

        System.out.println(test.trap(new int[] {0, 5, 0, 4, 0, 3, 0, 6, 0}));
    }
}
