package hongke.interview.leetcode.questions;

/**
 * Created by hongke on 9/10/14.
 */
public class LongestCommonPrefix {
    public String longestCommonPrefix(String[] strs) {
        if (strs == null || strs.length == 0) {
            return "";
        }
        StringBuilder sb = new StringBuilder();
        while (true) {
            if (strs[0].length() > sb.length()) {
                sb.append(strs[0].charAt(sb.length()));
            } else {
                return sb.toString();
            }
            for(String s : strs) {
                if (s.length() < sb.length() || s.charAt(sb.length() - 1) != sb.charAt(sb.length() - 1)) {
                    return sb.substring(0, sb.length() - 1);
                }
            }
        }
    }


}
