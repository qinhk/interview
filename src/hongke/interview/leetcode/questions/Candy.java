package hongke.interview.leetcode.questions;

/**
 * Created by hongke on 4/9/14.
 */
public class Candy {
    public int candy(int[] ratings) {
        if (ratings == null || ratings.length == 0) {
            return 0;
        }

        int total = 0;
        int candy = 0;
        int turnPoint = 0;
        int prevTotal = 0;
        for (int i = 1; i < ratings.length; i++) {

            // peak
            if (i + 1 < ratings.length && ratings[i+1] < ratings[i]
                    && i - 1 >= 0 && ratings[i-1] <= ratings[i]) {
                turnPoint = i;
            }
            // bottom
            else if (i + 1 < ratings.length && ratings[i+1] > ratings[i]
                    && i - 1 >= 0 && ratings[i-1] >= ratings[i]) {
                candy = 0;
            }

            // more candy for higher rating child
            if (ratings[i] > ratings[i-1]) {
                candy ++;
                total += candy;
            }
            // more candy for previous children
            else if (ratings[i] < ratings[i-1]) {
                int distance = i - turnPoint;
                if (distance > candy) {
                    total += distance;
                } else {
                    total += distance - 1;
                }
            } else {
                candy = 0;
            }

            System.out.println(ratings[i] + "," + (total - prevTotal));
            prevTotal = total;
        }
        return total + ratings.length;
    }

    public static void main(String[] args) {
        Candy candy = new Candy();
        int[] test = new int[]{58,21,72,77,48,9,38,71,68,77,82,47,25,94,89,
                54,26,54,54,99,64,71,76,63,81,82,60,64,29,51,87,87,72,12,16,20,21,54,43,41,83,77,41,61,72,82,15,50,36,69,49,53,92,77,16,73,12,28,37,41,79,25,80,3,37,48,23,10,55,19,51,38,96,92,99,68,75,14,18,63,35,19,68,28,49,36,53,61,64,91,2,43,68,34,46,57,82,22,67,89};
        candy.candy(test);

    }
}
