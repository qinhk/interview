package hongke.interview.leetcode.questions;

/**
 * Created by hongke on 8/6/14.
 */
public class SearchInRotatedSortedArrayII {
    public boolean search(int[] A, int target) {
        if (A == null || A.length == 0) {
            return false;
        }

        int start = 0, end = A.length - 1;
        while (start <= end) {
            while (start < end && A[start] == A[start + 1]) {
                start++;
            }
            while (start < end && A[end] == A[end - 1]) {
                end--;
            }
            int mid = (start + end) / 2;
            if (target == A[mid]) {
                return true;
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
        return false;
    }

    private boolean binarySearch(int target, int start, int end, int A[]) {
        while (start <= end) {
            int mid = (start + end) / 2;
            if (target == A[mid]) {
                return true;
            } else if (A[mid] < target) {
                start = mid + 1;
            } else {
                end = mid - 1;
            }
        }
        return false;
    }

    public static void main(String[] args) {
        SearchInRotatedSortedArrayII test = new SearchInRotatedSortedArrayII();
        int[] input;
        input = new int[] {1, 3, 1, 1, 1};
        System.out.println(test.search(input, 3));
        input = new int[] {1, 3, -1, 0, 1, };
        System.out.println(test.search(input, 3));
    }
}
