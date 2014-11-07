package hongke.interview.algorithms.dp;

import hongke.interview.algorithms.dp.model.KnapsackItem;
import org.junit.Test;

import java.util.List;

import static org.junit.Assert.assertEquals;

/**
 * Created by hongke on 11/5/14.
 */
public class testKnapsack {

    private Knapsack test;

    @Test(expected = IllegalArgumentException.class)
    public void testNull() {
        test = new Knapsack(1);
        int value = test.loadKnapsack(null);
        assertEquals(0, value);
        test = new Knapsack(0);
    }

    @Test
    public void testKnapsack1() {
        test = new Knapsack(6404180);
        List<KnapsackItem> items = KnapsackItem.getItems(
                new int[]{382745, 799601, 909247, 729069, 467902, 44328, 34610, 698150, 823460, 903959, 853665, 551830, 610856, 670702, 488960, 951111, 323046, 446298, 931161, 31385, 496951, 264724, 224916, 169684},
                new int[]{825594, 1677009, 1676628, 1523970, 943972, 97426, 69666, 1296457, 1679693, 1902996, 1844992, 1049289, 1252836, 1319836, 953277, 2067538, 675367, 853655, 1826027, 65731, 901489, 577243, 466257, 369261}
        );

        System.out.println(System.currentTimeMillis());
        int value = test.loadKnapsack(items);
        System.out.println(System.currentTimeMillis());
        assertEquals(13549094, value);
    }
}
