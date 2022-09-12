package dev.gokhana.threads;

import java.util.logging.Logger;

public class ThreadLifeCycle {

    static Thread waitingThread;

    public static void main(String[] args) throws InterruptedException {

        // A NEW Thread (or a Born Thread) is a thread that's been created but not yet started.
        Runnable runnable = System::nanoTime;
        Thread newThread = new Thread(runnable);
        System.out.println(newThread.getState());

        // running or ready to run, but they're waiting for resource allocation
        Thread runnableThread = new Thread(runnable);
        runnableThread.start();
        System.out.println(runnableThread.getState());

        //  BLOCKED state when it's currently not eligible to run.
        Runnable infiniteRunnable = ThreadLifeCycle::infiniteLoop; // infinite loop
        Thread t1 = new Thread(infiniteRunnable);
        Thread t2 = new Thread(infiniteRunnable);
        t1.start();
        t2.start();
        Thread.sleep(1000);
        System.out.println(t2.getState());

        // WAITING state when it's waiting for some other thread to perform a particular action
        Runnable waitingRunnable = () -> {
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
                throw new RuntimeException(e);
            }
            System.out.println(waitingThread.getState());
        };

        waitingThread = new Thread(() -> {
            Thread t21 = new Thread(waitingRunnable);
            t21.start();

            try {
                t21.join();
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
            }
        });

        waitingThread.start();

        Thread.sleep(1500);


        // TIMED_WAITING state when it's waiting for another thread within a stipulated amount of time.
        Runnable demoRunnable = () -> {
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        };

        Thread threadTimed = new Thread(demoRunnable);
        threadTimed.start();
        Thread.sleep(300);
        System.out.println(threadTimed.getState());


        // TERMINATED  when it has either finished execution or was terminated abnormally.
        Thread terminatedThread = new Thread(() -> {});
        terminatedThread.start();
        Thread.sleep(3000);
        System.out.println(terminatedThread.getState());

        // system exit
        System.exit(0);

    }

    public static synchronized void infiniteLoop() {
        while(true) {}
    }
}
