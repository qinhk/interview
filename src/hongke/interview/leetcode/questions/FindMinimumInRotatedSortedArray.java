package hongke.interview.leetcode.questions;

/**
 * Created by hongke on 10/18/14.
 */
public class FindMinimumInRotatedSortedArray {
    public int findMin(int[] num) {
        if (num == null && num.length == 0) {
            return 0;
        }

        int start = 0, end  = num.length - 1, pivot = end;
        while (start != pivot) {
            if (num[start] > num[pivot]) {
                end = pivot;
            } else if (num[end] < num[pivot]) {
                start = pivot;
            } else {
                break;
            }
            pivot = (start + end) / 2;
        }

        return Math.min(num[start], num[end]);
    }

    public static void main(String [] args) {
        FindMinimumInRotatedSortedArray test = new FindMinimumInRotatedSortedArray();
        System.out.println(test.findMin(new int[] {3,4,5,1,2}));
    }
}
