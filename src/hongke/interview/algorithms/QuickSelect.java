package hongke.interview.algorithms;

import java.util.Arrays;
import java.util.Random;

/**
 * Created by hongke on 2/5/15.
 */
public class QuickSelect {
    public int quickSelect(int[] A, int k) {
        if (A == null || A.length == 0 || k ==0)
            return 0;
        int s = 0, e = A.length - 1;
        while (true) {
            int p = partition(A, s, e);
            if (p == k - 1) {
                return A[k - 1];
            }
            if (p > k - 1) {
                e = p - 1;
            } else {
                s = p + 1;
            }
        }
    }

    private int partition(int[] A, int l, int r) {
        int i = l, pivot = A[r];
        for (int j = l; j < r; j ++) {
            if (A[j] < pivot) {
                swap(A, i ++, j);
            }
        }
        swap(A, i, r);
        return i;
    }

    private void swap(int[] A, int i , int j) {
        int t = A[i]; A[i] = A[j]; A[j] = t;
    }

    public static void main(String[] args) {
        QuickSelect test = new QuickSelect();
        int[] num = new int[1<<10];
        Random r = new Random();
        for (int i = 0; i < num.length; i ++) {
            num[i] = r.nextInt();
        }
        System.out.println(System.currentTimeMillis());
        System.out.println(test.quickSelect(num, 100));
        System.out.println(System.currentTimeMillis());
        Arrays.sort(num);
        System.out.println(num[100 - 1]);
    }
}
