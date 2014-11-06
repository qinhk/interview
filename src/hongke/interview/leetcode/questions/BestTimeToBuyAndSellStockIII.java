package hongke.interview.leetcode.questions;

/**
 * Created by hongke on 9/15/14.
 */
public class BestTimeToBuyAndSellStockIII {
    public int maxProfit(int[] prices) {
        if (prices == null || prices.length == 0) {
            return 0;
        }

        int n = prices.length;
        int[] firstTrans = new int[n];
        int lowest = prices[0];
        for (int i = 1; i < n; i++) {
            if (prices[i] < lowest) {
                lowest = prices[i];
            }
            firstTrans[i] = Math.max(prices[i] - lowest, firstTrans[i - 1]);
        }

        int[] secondTrans = new int[n];
        int highest = prices[n - 1];
        for (int i = 1; i < n; i++) {
            if (prices[n - 1 - i] > highest) {
                highest = prices[n - 1 -i];
            }
            secondTrans[i] = Math.max(highest - prices[n - 1 - i], secondTrans[i - 1]);
        }

        int max = 0;
        for (int i = 0; i < n; i++) {
            max = Math.max(firstTrans[i] + secondTrans[n - 1 - i], max);
        }

        return max;
    }

    public static void main(String[] args) {
        BestTimeToBuyAndSellStockIII test = new BestTimeToBuyAndSellStockIII();
        System.out.println(test.maxProfit(new int[] {2,1,2,0,1}));
    }
}
