package hongke.interview.leetcode.questions;

/**
 * Created by hongke on 1/22/15.
 */
public class RemoveElement {

    public int removeElement(int[] A, int elem) {
        if (A == null || A.length == 0) return 0;
        int read = 0, write = 0;
        while (read < A.length) {
            if (A[read] == elem)
                read ++;
            else
                A[write ++] = A[read ++];
        }
        return write;
    }

    public static void main(String[] args) {
        RemoveElement test = new RemoveElement();
        test.removeElement(new int[]{2}, 3);
    }
}
