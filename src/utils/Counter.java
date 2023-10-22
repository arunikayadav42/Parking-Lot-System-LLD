package utils;

public class Counter implements Runnable{
    public static Integer counter = 0;
    private static final Object lock = new Object();

    @Override
    public void run() {
        increaseCounter();
    }

    private void increaseCounter() {
        synchronized (lock) {
            System.out.println(Thread.currentThread().getName() + " : " + counter);
            counter++;
        }
    }
}
