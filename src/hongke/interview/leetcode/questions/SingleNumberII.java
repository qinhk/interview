package hongke.interview.leetcode.questions;

/**
 * Created by hongke on 7/30/14.
 */
public class SingleNumberII {
    public int singleNumber(int[] A) {
        if (A == null) {
            return 0;
        }

        int[] bitArray = new int[32];
        for (int a : A) {
            char[] bits = String.format("%32s", Integer.toBinaryString(a)).replace(' ', '0').toCharArray();
            for (int i = 0; i < bitArray.length; i++) {
                if (bits[i] == '1') {
                    bitArray[i] += 1;
                }
            }
        }

        char[] bits = new char[32];
        for (int i = 0; i < bitArray.length; i++) {
            bits[i] = (char)(bitArray[i] % 3 + 48);
        }

        if (bits[0] == '1') {
            bits[0] = '-';
            for (int i = 1; i < bitArray.length; i++) {
                bits[i] = bits[i] == '0' ? '1' : '0';
            }
            return Integer.parseInt(new String(bits), 2) - 1;
        } else {
            return Integer.parseInt(new String(bits), 2);
        }
    }

    public static void main(String[] args) {
        SingleNumberII test = new SingleNumberII();
        int[] input;

        input = new int[] {};
        System.out.println(test.singleNumber(input));

        input = new int[] {-1};
        System.out.println(test.singleNumber(input));

        input = new int[] {1, 1, 1, 2};
        System.out.println(test.singleNumber(input));


        input = new int[] {1, 1, 1, 255, 255, 255, Integer.MAX_VALUE};
        System.out.println(test.singleNumber(input));

        input = new int[] {1, 1, 1, 255, 255, 255, -1};
        System.out.println(test.singleNumber(input));
    }
}
