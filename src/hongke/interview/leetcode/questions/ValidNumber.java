package hongke.interview.leetcode.questions;

import java.util.regex.Pattern;

/**
 * Created by hongke on 7/18/14.
 */
public class ValidNumber {

        public boolean isNumber(String s) {

            Pattern p1 = Pattern.compile("[+-]?[0-9]+");
            Pattern p2 = Pattern.compile("[+-]?[0-9]*[.][0-9]+");
            Pattern p3 = Pattern.compile("[0-9]+e[0-9]+");
            s = s.trim();
            // signed or unsigned integer
            if (Pattern.matches("[+-]?[0-9]+", s)) {
                return true;
            } else if (Pattern.matches("[+-]?[0-9]*[.][0-9]+", s)) {
                return true;
            } else if (Pattern.matches("[0-9]+e[0-9]+", s)) {
                return true;
            }

            return false;
        }
}
