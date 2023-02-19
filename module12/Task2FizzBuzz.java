package module12;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class Task2FizzBuzz {

    public static void main(String[] args) {


        ExecutorService service = Executors.newFixedThreadPool(5);
        FizzBuzz fizzBuzz = new FizzBuzz();
        service.submit(fizzBuzz::fizz);
        service.submit(fizzBuzz::buzz);
        service.submit(fizzBuzz::fizzbuzz);
        service.submit(fizzBuzz::count);
        service.submit(fizzBuzz::printQueue);
        service.shutdown();

    }
}
