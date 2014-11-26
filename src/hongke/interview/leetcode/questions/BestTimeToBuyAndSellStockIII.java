package hongke.interview.leetcode.questions;

/**
 * Created by hongke on 9/15/14.
 */
public class BestTimeToBuyAndSellStockIII {
    public int maxProfit(int[] prices) {
        if (prices == null || prices.length < 2) {
            return 0;
        }

        int[][] trades = new int[2][prices.length];
        int low = prices[0];
        for (int i = 1; i < prices.length; i ++) {
            if (prices[i] < low) {
                low = prices[i];
            }
            trades[0][i] = Math.max(trades[0][i - 1], prices[i] - low);
        }

        int high = prices[prices.length - 1];
        for (int i = prices.length - 2; i >= 0; i --) {
            if (prices[i] > high) {
                high = prices[i];
            }
            trades[1][i] = Math.max(trades[1][i + 1], high - prices[i]);
        }

        int max = Integer.MIN_VALUE;
        for (int i = 0; i < trades[0].length; i ++) {
            max = Math.max(max, trades[0][i] + trades[1][i]);
        }
        return max;
    }

    public static void main(String[] args) {
        BestTimeToBuyAndSellStockIII test = new BestTimeToBuyAndSellStockIII();
        System.out.println(test.maxProfit(new int[] {2,1,2,0,1}));
    }
}
