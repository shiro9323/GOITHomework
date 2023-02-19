package module12;

import java.util.concurrent.ConcurrentLinkedQueue;
import java.util.concurrent.atomic.AtomicInteger;

public class FizzBuzz {

    public static volatile AtomicInteger count = new AtomicInteger(1);
    private static final int size = 20;
    public ConcurrentLinkedQueue<Object> queue = new ConcurrentLinkedQueue<>();

    public synchronized void fizz(){
        while (count.get() <= size) {
            if (count.get() % 3 == 0 && count.get() % 5 != 0) {
                queue.add("fizz");
                count.incrementAndGet();
                notifyAll();

            } else {
                try {
                    wait();
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
            }

        }
    }
    public synchronized void buzz(){
        while (count.get() <= size) {
            if (count.get() % 3 != 0 && count.get() % 5 == 0) {
                queue.add("buzz");
                count.incrementAndGet();
                notifyAll();

            } else {
                try {
                    wait();
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
            }
        }
    }

    public synchronized void fizzbuzz(){
        while (count.get() <= size) {
            if (count.get() % 3 == 0 && count.get() % 5 == 0) {
                queue.add("fizzbuzz");
                count.incrementAndGet();
                notifyAll();

            } else {
                try {
                    wait();
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
            }

        }
    }

    public synchronized void count(){
        while (count.get() <= size) {
            if (count.get() % 3 != 0 && count.get() % 5 != 0) {
                queue.add(count.get());
                count.incrementAndGet();
                notifyAll();
            } else {
                try {
                    wait();
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
            }

        }
    }

    public synchronized void printQueue(){
        while (!queue.isEmpty()){
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
            System.out.println(queue.poll());
        }
    }

}
