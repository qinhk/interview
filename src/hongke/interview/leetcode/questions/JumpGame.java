package hongke.interview.leetcode.questions;

/**
 * Created by hongke on 3/11/14.
 */
@SuppressWarnings("unused")
public class JumpGame {
    /*
    Given an array of non-negative integers, you are initially positioned at the first index of the array.
    Each element in the array represents your maximum jump length at that position.
    Your goal is to reach the last index in the minimum number of jumps.
    For example:
    Given array A = [2,3,1,1,4]
    The minimum number of jumps to reach the last index is 2. (Jump 1 step from index 0 to 1, then 3 steps to the last index.)
     */
    public int jumpGame2(int[] A) {
        if (A == null || A.length <= 1) {
            return 0;
        }

        if (A[0] == 0) {
            return -1;
        }

        int maxDist = A[0];
        int current = 0;
        int jumpCount = 0;
        while (current < A.length - 1) {
            int next = current + 1;
            if(maxDist >= A.length - 1) {
                return ++jumpCount;
            }

            for (int i = next; i <= maxDist; i++) {
                if (A[i] + i > next + A[next]) {
                    next = i;
                }
            }

            current = next;
            maxDist = A[current] + current;
            jumpCount++;
        }
        return jumpCount;
    }

    public static void main(String[] args) {
        JumpGame j = new JumpGame();
        System.out.println(j.jumpGame2(new int[]{5, 9, 3, 2, 1, 0, 2, 3, 3,
                1, 0, 0}));
        System.out.println(j.jumpGame2(new int[]{3, 2, 1}));
    }
}
