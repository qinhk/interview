package hongke.interview.concurrency;

import static java.lang.Thread.*;

/**
 * Created by hongke on 1/9/15.
 */
public class Threads implements Runnable {

    static class ThreadRunnable implements Runnable {

        private final int sleep;

        public ThreadRunnable(int wait) {
            sleep = wait;
        }


        @Override
        public void run() {
            try {
                sleep(sleep);
                System.out.println("Inside Runnable, " + currentThread().getName());
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }

    }

    public void run() {
        System.out.println("Inside begining of outer thread, " + currentThread().getName());
        Thread t = new Thread(new ThreadRunnable(100));
        t.start();
        try {
            t.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("Inside end of outer thread, " + currentThread().getName());
    }

    public static void main(String[] args) {
        (new Thread(new Threads())).start();
    }

}
