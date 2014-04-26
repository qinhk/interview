package hongke.interview.leetcode.questions;

/*
 Given s1, s2, s3, find whether s3 is formed by the interleaving of s1 and s2.

 For example,
 Given:
 s1 = "aabcc",
 s2 = "dbbca",

 When s3 = "aadbbcbcac", return true.
 When s3 = "aadbbbaccc", return false.  

 */

public class InterleavingString {

	public boolean isInterleave(String s1, String s2, String s3) {
		if (s1 == null || s1.length() == 0) {
			return s2.equals(s3);
		} else if (s2 == null || s2.length() == 0) {
			return s1.equals(s3);
		} else if (s3.length() != s1.length() + s2.length()) {
			return false;
		}

		int index1 = 0, index2 = 0;
		for (int i = 0; i < s3.length(); i++) {
			if (index1 < s1.length()
					&& Character.compare(s3.charAt(i), s1.charAt(index1)) == 0) {
				index1 ++;
			} else if (index2 < s2.length()
					&& Character.compare(s3.charAt(i), s2.charAt(index2)) == 0) {
				index2 ++;
			} else {
				return false;
			}
		}
		return true;
	}

	public static void main(String[] args) {
		InterleavingString test = new InterleavingString();
		System.out.println(test.isInterleave("aabcc", "dbbca", "aadbbcbcac"));
		System.out.println(test.isInterleave("aabcc", "dbbca", "aadbbbaccc"));
	}

}
