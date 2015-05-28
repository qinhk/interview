package hongke.interview.concurrency;

import java.util.Date;
import java.util.concurrent.Delayed;
import java.util.concurrent.TimeUnit;

/**
 * Created by hongke on 1/13/15.
 */
public class DelayQueueExample {

    private static final int PARALLALISM = 10;

    private static class TimedTask implements Runnable, Delayed {

        private final int input;

        private final long expiration;

        public TimedTask(int input, long delayInMillis) {
            this.input = input;
            this.expiration = System.currentTimeMillis() + delayInMillis;
        }

        @Override
        public long getDelay(TimeUnit unit) {
            return unit.convert(expiration - System.currentTimeMillis(), unit);
        }

        @Override
        public int compareTo(Delayed o) {
            return Long.compare(getDelay(TimeUnit.MILLISECONDS), o.getDelay(TimeUnit.MILLISECONDS));
        }

        @Override
        public void run() {
            System.out.println("Task executed: " + new Date() + ", Result: " + input * input);
        }
    }

    public static void main(String[] args) {
        try {
            final DelayQueue<TimedTask> delayQueue = new DelayQueue<TimedTask>();

            new Thread(new Runnable() {
                @Override
                public void run() {
                    try {
                        while (true) {
                            new Thread(delayQueue.take()).start();
                        }
                    } catch (Throwable t) {

                    }
                }
            }).start();

            for (int i = 0; i < 10; i++) {
                delayQueue.put(new TimedTask(i, (10 - i) * 1000));
            }


        } catch (Throwable t) {
        }
    }
}
