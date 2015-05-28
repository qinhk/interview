package hongke.interview.concurrency;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.ForkJoinPool;
import java.util.concurrent.Future;

/**
 * Created by hongke on 1/12/15.
 */
public class BlockingQueueExample {
    private static final int PARALLELISM = 100;

    private static final int QUEUE_CAPACITY = 200;

    private static final Random r = new Random();

    private final BlockingQueue<Task> queue;

    private final ExecutorService pool;

    private List<Producer<Task>> producers;

    private List<Consumer<Task>> consumers;

    private static class Producer<T> implements Runnable {

        private final BlockingQueue queue;

        public Producer(BlockingQueue<T> queue) {
            assert queue != null;
            this.queue = queue;
        }

        public void run() {
            while (true) {
                int input = r.nextInt(1000);
                Task task = new Task(input);
                try {
                    queue.put(task);
                    Thread.sleep(input);
                } catch (Throwable t) {
                    throw new IllegalStateException(t);
                }
            }
        }
    }

    private static class Consumer<Task> implements Runnable {

        private final ExecutorService pool;

        private final BlockingQueue<Task> queue;

        public Consumer(BlockingQueue<Task> queue, ExecutorService pool) {
            assert queue != null;
            assert pool != null;
            this.queue = queue;
            this.pool = new ForkJoinPool(PARALLELISM);
        }

        public void run() {
            Task task;
            while (true) {
                try {
                    task = queue.take();
                    Future<Integer> result = pool.submit((Callable<Integer>) task);
                    System.out.println(Thread.currentThread().getName() + ", Task:" + task.toString() +
                            ", Result:" + result.get() + ", Time:" + System.currentTimeMillis() + ", Queue size:" + queue.count);
                } catch (Throwable t) {
                    throw new IllegalStateException(t);
                }
            }
        }
    }

    private static class Task implements Callable<Integer> {
        int result;
        final int input;

        public Task(int input) {
            this.input = input;
        }

        public Integer call() throws InterruptedException {
            int timeSpend = r.nextInt(1000);
            Thread.sleep(timeSpend);
            result = input * input;
            return result;
        }
    }

    public BlockingQueueExample() {
        this.queue = new BlockingQueue<Task>(QUEUE_CAPACITY);
        this.pool = new ForkJoinPool(PARALLELISM);
        this.producers = new ArrayList<Producer<Task>>();
        for (int i = 20; i > 0; producers.add(new Producer(queue)), i--) ;
        this.consumers = new ArrayList<Consumer<Task>>();
        for (int i = 20; i > 0; consumers.add(new Consumer(queue, pool)), i--) ;
    }

    public void start() {
        for (Producer p : producers) {
            new Thread(p).start();
        }

        for (Consumer c : consumers) {
            new Thread(c).start();
        }
    }

    public static void main(String[] args) {
        BlockingQueueExample example = new BlockingQueueExample();
        example.start();
    }
}
