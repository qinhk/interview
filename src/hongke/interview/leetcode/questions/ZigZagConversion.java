package hongke.interview.leetcode.questions;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * Created by hongke on 6/18/14.
 */
public class ZigZagConversion {
    public String convert(String s, int nRows) {
        if (s == null || s.length() <=1 || nRows <= 1 || nRows >= s.length()) {
            return s;
        }

        List<StringBuffer> sbs = new ArrayList<StringBuffer>(nRows);
        for (int i = 0; i < nRows; i++) {
            sbs.add(new StringBuffer());
        }

        int i = 0;
        boolean goingDown = true;
        char[] c = s.toCharArray();
        while (i < s.length()) {
            if (goingDown) {
                int row = 0;
                for (; row < nRows && i+row < s.length(); row ++) {
                    sbs.get(row).append(c[i+row]);
                }
                i += row;
            } else {
                int k = 0;
                for (int row = nRows - 1; i + k < s.length() && row >= 0; row--) {
                    StringBuffer cur = sbs.get(row);
                    for (int l = 0; l < k; l ++) {
                        cur.append(" ");
                    }
                    if (row != nRows - 1 && row != 0) {
                        cur.append(c[i+k]);
                        k ++;
                    }
                    for (int l = row - 1; l > 0; l --) {
                        cur.append(" ");
                    }

                }
                i += k;
            }

            goingDown = !goingDown;
        }

        StringBuffer output = new StringBuffer();
        for (StringBuffer sb : sbs) {
            output.append(sb.toString());
            System.out.println(sb.toString());
        }

        return output.toString();
    }

    public static void main(String[] args) {
        ZigZagConversion test = new ZigZagConversion();
        long start, end;
        start = System.nanoTime();
        test.convert("egsempntnxmvxjgrcwkuuzazivznxhtbpmicdxxrwjotsumvqwpnvrodonsmumpmazodwegsempntnxmvxjgrcwkuuzazivznxhtbpmicdxxrwjotsumvqwpnvrodonsmumpmazodwegsempntnxmvxjgrcwkuuzazivznxhtbpmicdxxrwjotsumvqwpnvrodonsmumpmazodwegsempntnxmvxjgrcwkuuzazivznxhtbpmicdxxrwjotsumvqwpnvrodonsmumpmazodw", 36);
        end = System.nanoTime();
        System.out.println("time:" + (end - start)/1000);

        start = System.nanoTime();
        test.convert("omkfwtvpgahmtynkqe", 9);
        end = System.nanoTime();
        System.out.println("time:" + (end - start)/1000);


        start = System.nanoTime();
        test.convert("qxgqejnbwcgyut", 7);
        end = System.nanoTime();
        System.out.println("time:" + (end - start)/1000);
    }

}
