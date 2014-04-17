package hongke.interview.leetcode.questions;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by hongke on 4/14/14.
 */
public class GrayCode {
    public ArrayList<Integer> grayCode(int n) {
        if (n == 0) {
            return new ArrayList<Integer>();
        }

        ArrayList<Integer> results = new ArrayList<Integer>();
        List<String> codes = new ArrayList<String>();
        codes.add("0");
        codes.add("1");
        for (int digit = 0; digit < n; digit ++) {
        	
        }
        return results;
    }

    public static void main(String[] args) {
        GrayCode test = new GrayCode();
        test.grayCode(0);
        int[] test1 = new int[]{0,1,3,2,6,7,5,4};
        for (int i : test1) {
            System.out.println(Integer.toBinaryString(i));
        }
    }
}
