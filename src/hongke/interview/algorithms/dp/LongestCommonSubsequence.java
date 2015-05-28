package hongke.interview.algorithms.dp;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * Created by hongke on 2/10/15.
 */
public class LongestCommonSubsequence {
    public List<Integer> findLCS (int[] A1, int[] A2) {
        List<Integer> LCS = new ArrayList<Integer>();
        if (A1.length == 0 || A2.length == 0) {
            return LCS;
        }
        int[][] state = buildState(A1, A2);
        for (int i = A1.length, j = A2.length; i > 0 && j > 0;) {
            if (A1[i - 1] == A2[j - 1]) {
                LCS.add(A1[i - 1]);
                i -- ; j --;
            } else if (state[i - 1][j] > state[i][j - 1]) {
                i --;
            } else {
                j --;
            }
        }
        Collections.reverse(LCS);
        return LCS;
    }

    public int lengthOfLCS (int[] A1, int[] A2) {
        if (A1.length == 0 || A2.length == 0) {
            return 0;
        }
        int[][] state = buildState(A1, A2);
        return state[A1.length][A2.length];
    }

    private int[][] buildState (int[] A1, int[] A2){
        int[][] state = new int [A1.length + 1][A2.length + 1];
        for (int i = 0; i <= A1.length; i ++) {
            for (int j = 0; j <= A2.length; j++) {
                if ( i == 0 || j == 0) {
                    state[i][j] = 0;
                } else if (A1[i - 1] == A2[j - 1]) { //match case,
                    state[i][j] = state[i - 1][j - 1] + 1;
                } else { //mis match case.
                    state[i][j] = Math.max(state[i - 1][j], state[i][j - 1]);
                }
            }
        }
        return state;
    }

    public static void main(String[] args) {
        LongestCommonSubsequence lcs = new LongestCommonSubsequence();
        int[] A1 = {1,3,4,6,7,3,4,1,9};
        int[] A2 = {1,4,5,6,9,11};
        System.out.println(lcs.lengthOfLCS(A1, A2));
        System.out.println(lcs.findLCS(A1, A2));

    }

}
