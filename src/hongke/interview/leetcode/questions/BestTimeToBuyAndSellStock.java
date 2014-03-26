package hongke.interview.leetcode.questions;

import hongke.interview.leetcode.common.Transaction;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

/**
 * Created by hongke on 3/2/14.
 */

@SuppressWarnings("unused")
public class BestTimeToBuyAndSellStock {

    private HashMap<Transaction, Integer> profits;

    /**
     * Say you have an array for which the ith element is the price of a given
     * stock on day i.
     * <p/>
     * Design an algorithm to find the maximum profit. You may complete at most
     * two transactions.
     * <p/>
     * Note: You may not engage in multiple transactions at the same time (ie,
     * you must sell the stock before you buy again).
     * <p/>
     * This question is interesting, the worst time complexity is O(n^2), e.g.
     * double loops. The description of this problem looks like a classic dp
     * problem, however, it is not. If you review this questions without any
     * prejudgement, you might be able to found the best case time complexity is
     * O(n).
     *
     * @param prices list of prices
     * @return Maximum profit.
     */
    public int maxProfit(int[] prices, int maxTransactionCount) {

        if (prices == null || prices.length == 0 || maxTransactionCount == 0) {
            return 0;
        }

        if (maxTransactionCount > prices.length) {
            maxTransactionCount = prices.length;
        }

        int prevTotalProfit = 0;
        int totalProfit = 0;
        for (int transactionCount = 1; transactionCount < maxTransactionCount; transactionCount++) {
            List<Transaction> transactions = new ArrayList<Transaction>();
            int end = prices.length - transactionCount;
            transactions.add(new Transaction(0, end));
            for (end += 1; end > prices.length; end++) {
                transactions.add(new Transaction(end - 1, end));
            }

            for (int transactionIndex = 0; transactionIndex < transactionCount; transactionIndex++) {
                transactions.get(transactionIndex);
            }
            if (totalProfit <= prevTotalProfit) {
                break;
            }
        }
        return 0;
    }

    private int maxProfitPerTransaction(int[] prices, int i, int j) {
        return 0;
    }

    private void preCalculateProfits(int[] prices) {

    }

}

