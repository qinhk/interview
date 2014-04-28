package hongke.interview.leetcode.questions;

/**
 * Created by hongke on 4/27/14.
 */
@SuppressWarnings("unused")
public class JumpGame {
    public boolean canJump(int[] A) {
        if (A == null) {
            return false;
        } else if (A.length == 1) {
            return true;
        }

        int maxJump = 0;
        for (int i = 0; i < A.length; i ++) {
            if (maxJump < i) {
                return false;
            } else if (maxJump >= A.length - 1) {
                return true;
            }
            maxJump = Math.max(maxJump, i + A[i]);
        }
        return true;
    }
}
