package hongke.interview.concurrency;

import java.util.Arrays;
import java.util.Random;
import java.util.concurrent.CountDownLatch;

/**
 * Created by hongke on 1/13/15.
 */
public class CountDownLatchExample implements Runnable {

    private final CountDownLatch countDown = new CountDownLatch(10);

    private final int[] item;

    public CountDownLatchExample() {
        item = new int[10];
        for (int i = 0; i < 10; item[i] = i, i++) ;
    }

    @Override
    public void run() {
        final Random r = new Random();
        for (int i = 0; i < 10; i++) {
            final int count = i;
            new Thread(new Runnable() {
                @Override
                public void run() {
                    try {
                        Thread.sleep(r.nextInt(1000));
                        item[count] = item[count] * item[count];
                        System.out.println("Subtask[" + count + "] is completed");
                        countDown.countDown();
                    } catch (Throwable t) {

                    }
                }
            }).start();
        }
        try {
            while (countDown.getCount() != 0) {
                System.out.println("Waiting: " + countDown.getCount());
                countDown.await();
            }
            System.out.println("All Completed: " + Arrays.toString(item));
        } catch (Throwable t) {

        }
    }

    public static void main(String[] args) {
        new Thread(new CountDownLatchExample()).start();
    }
}
