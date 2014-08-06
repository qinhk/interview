package hongke.interview.leetcode.questions;

/**
 * Created by hongke on 8/4/14.
 */
public class SearchInRotatedSortedArray {
    public int search(int[] A, int target) {
        if (A == null || A.length == 0) {
            return -1;
        }

        int start = 0, end = A.length - 1;
        while (start <= end) {
            int mid = (start + end) / 2;
            if (target == A[mid]) {
                return mid;
            } else if (target >= A[start] && target < A[mid]) {
                return binarySearch(target, start, mid - 1, A);
            } else if (target >= A[mid] && target <= A[end]) {
                return binarySearch(target, mid + 1, end, A);
            } else if (A[start] > A[mid]) {
                end = mid - 1;
            } else {
                start = mid + 1;
            }
        }

        return -1;
    }

    private int binarySearch(int target, int start, int end, int A[]) {
        while (start <= end) {
            int mid = (start + end) / 2;
            if (target == A[mid]) {
                return mid;
            } else if (A[mid] < target){
                start = mid + 1;
            } else {
                end = mid - 1;
            }
        }
        return -1;
    }

    public static void main(String[] args) {
        SearchInRotatedSortedArray test = new SearchInRotatedSortedArray();
        int[] input;
        input = new int[] {1};
        System.out.println(test.search(input, 1));
        input = new int[] {1};
        System.out.println(test.search(input, 0));
        input = new int[] {1, 3};
        System.out.println(test.search(input, 2));
        input = new int[] {1, 2};
        System.out.println(test.search(input, 2));
        input = new int[] {1, 2, 3};
        System.out.println(test.search(input, 3));
        input = new int[] {1, 3, 4, 5,};
        System.out.println(test.search(input, 2));
        input = new int[] {6, 7, 8, 9, 10, -5, -1, 0, 1, 2, 3, 4, 5};
        System.out.println(test.search(input, 9));
    }
}
