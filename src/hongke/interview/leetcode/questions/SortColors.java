package hongke.interview.leetcode.questions;

import java.util.Arrays;

/**
 * Created by hongke on 7/29/14.
 */
public class SortColors {
    public void sortColors(int[] A) {
        if (A == null || A.length == 0) {
            return;
        }

        int start = 0, end = A.length - 1;
        while (start != end) {
            if (A[start] == 0) {
                start ++;
            } else {
                while (A[end] != 0 && end > start) {
                    end --;
                }
                int tmp = A[start];
                A[start] = A[end];
                A[end] = tmp;
            }
        }

        end = A.length - 1;
        while (start != end) {
            if (A[start] == 1) {
                start ++;
            } else {
                while (A[end] != 1 && end > start) {
                    end --;
                }
                int tmp = A[start];
                A[start] = A[end];
                A[end] = tmp;
            }
        }
    }

    public static void main(String[] args) {
        SortColors test = new SortColors();
        int[] input;

        input = new int[]{};
        test.sortColors(input);
        System.out.println(Arrays.toString(input));

        input = new int[]{1,0,2,2,1,0,1,0,2,2,1,1,0,0};
        test.sortColors(input);
        System.out.println(Arrays.toString(input));

        input = new int[]{0,1,0,1,0,1,0,1,0,1,0,1,0,1};
        test.sortColors(input);
        System.out.println(Arrays.toString(input));

        input = new int[]{1,2,1,2,1,2,1,2,1,2,1};
        test.sortColors(input);
        System.out.println(Arrays.toString(input));

        input = new int[]{0,2,0,2,0,2,0,2};
        test.sortColors(input);
        System.out.println(Arrays.toString(input));
    }
}
