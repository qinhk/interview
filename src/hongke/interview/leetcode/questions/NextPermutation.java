package hongke.interview.leetcode.questions;

import java.util.Arrays;

/**
 * Created by hongke on 8/26/14.
 */
public class NextPermutation {
    public void nextPermutation(int[] num) {
        if (num == null || num.length == 1) {
            return;
        }

        int lastIncreasing = -1;
        int index = 0;
        while (index < num.length - 1) {
            if (num[index] < num[index + 1]) {
                lastIncreasing = index;
            }
            index++;
        }

        if (lastIncreasing >= 0) {
            int toSwap = lastIncreasing + 1;
            for (int i = toSwap; i < num.length; i++) {

                if (num[i] < num[toSwap] && num[i] > num[lastIncreasing]) {
                    toSwap = i;
                }
            }

            int tmp = num[lastIncreasing];
            num[lastIncreasing] = num[toSwap];
            num[toSwap] = tmp;
        }

        Arrays.sort(num, lastIncreasing + 1, num.length);
    }

    public static void main(String[] args) {
        NextPermutation test = new NextPermutation();
        int[] input;

        input = new int[] {2, 1};
        test.nextPermutation(input);
        System.out.println(Arrays.toString(input));

        input = new int[] {1, 4, 3, 2};
        test.nextPermutation(input);
        System.out.println(Arrays.toString(input));

    }
}
