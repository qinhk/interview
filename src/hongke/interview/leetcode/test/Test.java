package hongke.interview.leetcode.test;

/**
 * Created by hongke on 3/27/14.
 */
public class Test {
    public static void main(String[] args) {
        System.out.println("zzz".matches("[z]+"));

        System.out.println(getNext("zzz"));

    }

    private static String getNext(String current) {
        int lastZ = current.lastIndexOf('z');
        char nextLetter = (char) (current
                .charAt(lastZ + 1) + 1);
        char[] chars = current.toCharArray();
        chars[lastZ + 1] = nextLetter;
        return new String(chars);
    }
}
