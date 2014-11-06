package hongke.interview.algorithms;

import java.util.Random;

import static hongke.interview.common.Constants.BILLION;
import static hongke.interview.common.Constants.MILLION;
import static hongke.interview.common.IO.pt;

/**
 * Created by hongke on 10/8/14.
 */
public class QuickSort {

    public void twoWaySort(int[] input) {
        if (input == null || input.length <= 1) {
            return;
        }

        twoWaySort(input, 0, input.length - 1);
    }

    private void twoWaySort(int[] input, int start, int end) {

        int i = start, j = end, mid = start + (end - start) / 2;
        int pivot = input[mid];
        while (i <= j) {
            while (input[i] < pivot) {
                i++;
            }
            while (input[j] > pivot) {
                j--;
            }
            if (i <= j) {
                exchange(input, i, j);
                i++;
                j--;
            }
        }

        if (start < j)
            twoWaySort(input, start, j);
        if (end > i)
            twoWaySort(input, i, end);
    }

    public void threeWaySort(int[] input) {
        if (input == null || input.length <= 1) {
            return;
        }

        threeWaySort(input, 0, input.length - 1);
    }

    private void threeWaySort(int[] input, int start, int end) {

        int i = start, j = end, mid = start + (end - start) / 2;
        int pivot = input[mid];
        while (i < j) {

            while (input[i] < pivot) {
                i++;
            }

            while (input[j] > pivot) {
                j--;
            }
            if (i <= j) {
                exchange(input, i, j);
                i++;
                j--;
            }
        }
        int m = start, n = end;
        while (m <= j) {
            if (input[m] == pivot) {
                exchange(input, m, j);
                j --;
            }
            m ++;
        }

        while (n >= i) {
            if (input[n] == pivot) {
                exchange(input, n, i);
                i ++;
            }
            n --;
        }

        if (start < j)
            twoWaySort(input, start, j);
        if (end > i)
            twoWaySort(input, i, end);
    }

    public void exchange(int[] a, int index1, int index2) {
        if (a[index1] == a[index2]) {
            return;
        }
        int tmp = a[index1];
        a[index1] = a[index2];
        a[index2] = tmp;
    }

    public static void main(String[] args) {
        int[] input;
        QuickSort qs = new QuickSort();
        Random random = new Random();

        input = new int[BILLION / 10];
        for (int i = BILLION / 10 - 1; i >= 0; i--) {
            input[i] = random.nextInt();
        }
        pt();
        qs.twoWaySort(input);
        pt();
        for (int i = BILLION / 10 - 1; i > 0; i--) {
            if (input[i] < input[i - 1]) {
                throw new IllegalStateException();
            }
        }

        input = new int[BILLION / 10];
        random = new Random();
        for (int i = BILLION / 10 - 1; i >= 0; i--) {
            input[i] = random.nextInt();
        }
        pt();
        qs.threeWaySort(input);
        pt();
        for (int i = BILLION / 10 - 1; i > 0; i--) {
            if (input[i] < input[i - 1]) {
                throw new IllegalStateException();
            }
        }

    }

}
