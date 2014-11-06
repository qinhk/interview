package hongke.interview.algorithms;

import hongke.interview.datastructure.Heap;

import java.util.Random;

import static hongke.interview.common.IO.pt;
import static hongke.interview.common.Constants.*;

/**
 * Created by hongke on 10/22/14.
 */
public class HeapSort {

    public void sort(int[] input) {
        if (input == null) {
            return;
        }
        Heap<Integer> heap = new Heap<Integer>(input.length);
        for (int i = 0; i < input.length; i++) {
            heap.put(input[i]);
        }
        for (int i = 0; i < input.length; i++) {
            input[i] = heap.poll();
        }
    }

    public static void main(String[] args) {
        Random random = new Random();
        HeapSort test = new HeapSort();
        pt();
        int[] input = new int[BILLION / 10];
        for (int i = 0; i < BILLION / 10; i++)
            input[i] = random.nextInt();
        pt();
        test.sort(input);
        pt();
    }


}
