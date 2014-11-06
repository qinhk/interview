package hongke.interview.datastructure;

import hongke.interview.common.Constants;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import static hongke.interview.common.IO.pt;

/**
 * Created by hongke on 10/22/14.
 */
public class Heap<T extends Comparable<T>> {

    final T[] content;

    int index;

    public Heap(int capacity) {
        content = (T[]) new Comparable[capacity + 1];
        index = 0;
    }

    public T peek() {
        if (index == 0) {
            throw new IllegalStateException("Empty heap");
        }
        return content[1];
    }

    public T poll() {
        T result = peek();
        exchange(1, index--);
        content[index + 1] = null;
        sinkDown(1);
        return result;
    }

    public void put(T t) {
        if (index >= content.length - 1) {
            throw new IllegalStateException("Full heap");
        }
        content[++index] = t;
        swimUp();
    }

    public int size() {
        return index - 1;
    }

    private void swimUp() {
        int i = index;
        while (i > 1 && content[i].compareTo(content[i / 2]) > 0) {
            exchange(i, i / 2);
            i = i / 2;
        }
    }

    private void sinkDown(int i) {
        while (i * 2 <= index) {
            int j = 2 * i;
            if (j < index && content[j].compareTo(content[j + 1]) < 0) {
                j++;
            }
            if (content[i].compareTo(content[j]) >= 0) {
                break;
            }
            exchange(i, j);
            i = j;
        }
    }

    private void exchange(int i, int j) {
        T tmp = content[i];
        content[i] = content[j];
        content[j] = tmp;
    }

    public static void main(String[] args) {
        List<Integer> test = new ArrayList<Integer>();
        for (int i = 0; i < Constants.MILLION; i++) {
            test.add(i);
        }
        Collections.shuffle(test);
        Heap<Integer> heap = new Heap<Integer>(Constants.MILLION);
        pt();
        for (int i : test)
            heap.put(i);
        pt();
        int prev = heap.peek();
        for (int i = Constants.MILLION; i > 0; i--) {
            if (prev < heap.peek()) {
                throw new IllegalStateException("Wrong!");
            }
            prev = heap.poll();
        }
        pt();
        Collections.sort(test);
        pt();
    }

}
