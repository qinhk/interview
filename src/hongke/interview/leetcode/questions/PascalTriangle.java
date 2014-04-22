package hongke.interview.leetcode.questions;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Created by hongke on 3/24/14.
 */

/*
Given numRows, generate the first numRows of Pascal's triangle.

For example, given numRows = 5,
Return

[
     [1],
    [1,1],
   [1,2,1],
  [1,3,3,1],
 [1,4,6,4,1]
]
 */

public class PascalTriangle {

    public ArrayList<ArrayList<Integer>> generate(int numRows) {
        if (numRows < 0) {
            throw new IllegalArgumentException("numRows cannot be negtive");
        } else if (numRows == 0) {
            return new ArrayList<ArrayList<Integer>>();
        }

        ArrayList<ArrayList<Integer>> result = new ArrayList<ArrayList<Integer>>();

        recursiveGenerateTree(numRows, result);
        return result;
    }

    private void recursiveGenerateTree(int numRows,
                                       ArrayList<ArrayList<Integer>> result) {

        if (numRows == 1) {
            result.add(new ArrayList<Integer>(Arrays.asList(new Integer[]{1})));
        } else {
            recursiveGenerateTree(numRows - 1, result);
            ArrayList<Integer> current = new ArrayList<Integer>();
            for (int i = 0; i < numRows; i++) {
                List<Integer> last = result.get(result.size() - 1);
                int left = (i - 1) > 0 ? last.get(i - 1) : 0;
                int right = (i + 1) < last.size() - 1 ? last.get(i - 1) : 0;
                current.add(left + right);
            }
            result.add(current);
        }
    }

    public static void main (String[] args) {

    }

}
