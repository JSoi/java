package async;

import java.util.Arrays;
import java.util.List;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;

public class Example {
    public static void main(String[] args) throws ExecutionException, InterruptedException {
        long startTime = System.currentTimeMillis();

        CompletableFuture<String> task1 = CompletableFuture.supplyAsync(() -> {

            System.out.println("Example.main - task1 START");
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println("Example.main - task1 END");
            return "Task 1 result" + (System.currentTimeMillis() - startTime);
        });

        CompletableFuture<String> task2 = CompletableFuture.supplyAsync(() -> {
            System.out.println("Example.main - task2 START");
            try {
                Thread.sleep(2000); // Simulate 2 seconds of work
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println("Example.main - task2 END");
            return "Task 2 result - " + (System.currentTimeMillis() - startTime);
        });

        CompletableFuture.anyOf(task1, task2).get();
        CompletableFuture.allOf(task1, task2).get();

        List<String> results = Arrays.asList(task1.get(), task2.get());

        long endTime = System.currentTimeMillis();
        System.out.println(results);
        System.out.println("Total execution time (without async): " + (endTime - startTime) + " ms");
    }
}
