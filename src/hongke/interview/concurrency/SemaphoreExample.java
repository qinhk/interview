package hongke.interview.concurrency;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.ScheduledThreadPoolExecutor;
import java.util.concurrent.Semaphore;

/**
 * Created by hongke on 1/13/15.
 */
public class SemaphoreExample implements Runnable {

    final private Semaphore semaphore;

    final private ExecutorService executor = new ScheduledThreadPoolExecutor(100);

    public SemaphoreExample() {
        semaphore = new Semaphore(10);
    }

    public void run() {
        for (int i = 0; i < 100; i ++) {
            executor.execute(new Runnable() {
                @Override
                public void run() {
                    try {
                        semaphore.acquire();
                        try {
                            System.out.println(semaphore.getQueueLength() + " tasks left, ");
                            Thread.sleep(1000);
                        } finally {
                            semaphore.release();
                        }
                    } catch (Throwable t) {

                    }
                }
            });
        }
    }

    public static void main(String[] args) {
        new Thread(new SemaphoreExample()).start();
    }
}
