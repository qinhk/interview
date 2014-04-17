package hongke.interview.leetcode.questions;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by hongke on 4/16/14.
 */
public class CountAndSay {
    public String countAndSay(int n) {
        if (n <= 0) {
            return "";
        }

        List<Integer> list = new ArrayList<Integer>();
        list.add(1);
        for (int i = 2; i <= n; i++) {
            int val = list.get(0), count = 0;
            List<Integer> newList = new ArrayList<Integer>();
            for (int j = 0; j < list.size(); j ++) {
                if(list.get(j) != val) {
                    if (count != 0) {
                        newList.add(count);
                        newList.add(val);
                    }
                    val = list.get(j);
                    count = 1;
                } else {
                    count ++;
                }
            }

            if (count != 0) {
                newList.add(count);
                newList.add(val);
            }

            list = newList;
        }

        StringBuilder sb = new StringBuilder();
        for (Integer i : list) {
            sb.append(String.valueOf(i));
        }
        return sb.toString();
    }

    public static void main(String[] args) {
        CountAndSay test = new CountAndSay();
        System.out.println(test.countAndSay(1));
        System.out.println(test.countAndSay(2));
        System.out.println(test.countAndSay(3));
        System.out.println(test.countAndSay(4));
        System.out.println(test.countAndSay(10));
    }
}
