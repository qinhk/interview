package hongke.interview.leetcode.common;

/**
 * Created by hongke on 3/9/14.
 */
public class Transaction {
    public int buy;
    public int sell;
    public int profit;

    public Transaction(int buy, int sell) {
        this.buy = buy;
        this.sell = sell;
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == null || obj.getClass() != this.getClass()) {
            return false;
        }

        if (((Transaction) obj).buy != this.buy || ((Transaction) obj).sell != this.sell) {
            return false;
        }

        return true;
    }

}
