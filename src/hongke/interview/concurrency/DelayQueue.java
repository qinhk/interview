package hongke.interview.concurrency;

import java.util.PriorityQueue;
import java.util.concurrent.Delayed;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.ReentrantLock;

/**
 * Created by hongke on 1/12/15.
 */
public class DelayQueue<T extends Delayed> {
    private PriorityQueue<T> queue;

    private final ReentrantLock lock;

    /**
     * Condition signalled when a newer element becomes available at the head of the queue or a new thread may need to
     * become leader.
     */
    private final Condition available;

    private Thread leader = null;

    public DelayQueue() {
        lock = new ReentrantLock();
        available = lock.newCondition();
        queue = new PriorityQueue<T>();
    }

    public void put(T t) throws InterruptedException {
        ReentrantLock lock = this.lock;
        lock.lockInterruptibly();
        try {
            queue.offer(t);
            if (queue.peek() == t) {
                leader = null;
                available.signal();
            }
        } finally {
            lock.unlock();
        }
    }

    public T take() throws InterruptedException {
        final ReentrantLock lock = this.lock;
        lock.lockInterruptibly();
        try {
            for (; ; ) {
                T first = queue.peek();
                if (first == null)
                    available.await();
                else {
                    long delay = first.getDelay(TimeUnit.NANOSECONDS);
                    if (delay <= 0)
                        return queue.poll();
                    else if (leader != null)
                        available.await();
                    else {
                        Thread thisThread = Thread.currentThread();
                        leader = thisThread;
                        try {
                            available.awaitNanos(delay);
                        } finally {
                            if (leader == thisThread)
                                leader = null;
                        }
                    }
                }
            }
        } finally {
            if (leader == null && queue.peek() != null)
                available.signal();
            lock.unlock();
        }
    }
}
