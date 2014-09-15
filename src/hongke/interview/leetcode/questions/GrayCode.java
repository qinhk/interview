package hongke.interview.leetcode.questions;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Created by hongke on 4/14/14.
 */
public class GrayCode {
    public List<Integer> grayCode(int num)
    {
        if (num == 0) {
            return Arrays.asList(new Integer[]{0});
        }

        List<String> cur = new ArrayList<String>();
        cur.add("0");
        cur.add("1");
        for (int d = 1; d < num; d ++) {
            List<String> next = new ArrayList<String>();
            for (int i = 0; i < cur.size(); i ++) {
                next.add("0" + cur.get(i));
            }
            for (int i = cur.size() - 1; i >= 0; i --) {
                next.add("1" + cur.get(i));
            }
            cur = next;
        }

        List<Integer> result = new ArrayList<Integer>();
        for (String s : cur) {
            result.add(Integer.parseInt(s, 2));
        }
        return result;
    }

    public static void main(String[] args) {
        GrayCode test = new GrayCode();
        for (int i : test.grayCode(3)) {
            System.out.println(i);
        }
    }
}
