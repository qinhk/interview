package hongke.interview.leetcode.questions;

/**
 * Created by hongke on 8/4/14.
 */
public class SearchInsertPosition {
    public int searchInsert(int[] A, int target) {

        if (A == null || A.length == 0) {
            return -1;
        } else if (target > A[A.length - 1]) {
            return A.length;
        } else if (target < A[0]) {
            return 0;
        }

        int even = A.length % 2 == 0 ? 1 : 0;
        int start = 0, end = A.length - 1 + even;
        while (start <= end) {
            int mid = (start + end) / 2;
            if (target < A[mid]) {
                if (mid > 0 && target > A[mid - 1]) {
                    return mid;
                }
                end = mid;
            } else if (target > A[mid]) {
                if (mid + 1 < A.length && target <= A[mid + 1]) {
                    return mid + 1;
                }
                start = mid;
            } else {
                return mid;
            }
        }
        return -1;
    }

    public static void main(String[] args) {
        SearchInsertPosition test = new SearchInsertPosition();
        int[] input;

        input = new int[]{1};
        System.out.println(test.searchInsert(input, 0));
        System.out.println(test.searchInsert(input, 1));
        System.out.println(test.searchInsert(input, 2));

        input = new int[]{1,3};
        System.out.println(test.searchInsert(input, 1));
        System.out.println(test.searchInsert(input, 2));
        System.out.println(test.searchInsert(input, 3));

        input = new int[]{1,3,5};
        System.out.println(test.searchInsert(input, 1));
        System.out.println(test.searchInsert(input, 2));
        System.out.println(test.searchInsert(input, 4));
        System.out.println(test.searchInsert(input, 5));

        input = new int[]{1,3,5,6};
        System.out.println(test.searchInsert(input, 5));
        System.out.println(test.searchInsert(input, 2));
        System.out.println(test.searchInsert(input, 7));
        System.out.println(test.searchInsert(input, 0));


    }
}
