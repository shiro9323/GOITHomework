package module12;

import java.util.Date;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

public class Task1Time {

    private static final long startTime = new Date().getTime();

    public static void main(String[] args) throws InterruptedException {



        ScheduledExecutorService executorService = Executors.newScheduledThreadPool(2);

        executorService.scheduleAtFixedRate(
                () -> System.out.println("Time after start program: " + (int)(System.currentTimeMillis() - startTime) / 1000),
                0,
                1,
                TimeUnit.SECONDS
        );
        executorService.scheduleAtFixedRate(
                () -> System.out.println("5 seconds have passed"),
                5,
                5,
                TimeUnit.SECONDS
        );

        Thread.sleep(15000);
        executorService.shutdown();

    }
}
