package executors;

import java.util.Random;
import java.util.concurrent.*;

public class ThreadPools
{
    public static void main(String[] args) throws ExecutionException, InterruptedException
    {
        expandingThreadPools();
    }

    private static void expandingThreadPools() throws ExecutionException, InterruptedException
    {
        //create a pool of threads
        ExecutorService pool = Executors.newCachedThreadPool();

        //add "Runnable" or "Callable" jobs to the pool
        final int CALLABLES = 10;
        Future<Integer>[] futures = new Future[CALLABLES];
        for (int i = 0; i < CALLABLES; i++)
        {
            //pass the job to the pool and retrieve a Future object
            Callable<Integer> job = new DuplicateFinder(
                    generateRandomArray(50000, 1, 10000));
            futures[i] = pool.submit(job);
        }

        //wait until I get a result
        for (int i = 0; i < futures.length; i++)
        {
            System.out.println("Duplicates: " + futures[i].get());
        }

        pool.shutdown();
    }

    private static void fixedThreadPools() throws ExecutionException, InterruptedException
    {
        //create a pool of five threads
        ExecutorService pool = Executors.newFixedThreadPool(5);

        //add "Runnable" or "Callable" jobs to the pool
        Callable<Integer> job = new DuplicateFinder(
                generateRandomArray(10000, 1, 1000));
        Callable<Integer> job2 = new DuplicateFinder(
                generateRandomArray(10000, 1, 1000));

        //pass the job to the pool and retrieve a Future object
        Future<Integer> future = pool.submit(job);
        Future<Integer> future2 = pool.submit(job2);

        //wait until I get a result
        int result = future.get();
        int result2 = future2.get();
        System.out.println("Duplicates: " + result);
        System.out.println("Duplicates: " + result2);

        pool.shutdown();
    }

    private static int[] generateRandomArray(int size, int low, int high)
    {
        Random random = new Random();
        int[] results = new int[size];

        for (int i = 0; i < results.length; i++)
        {
            results[i] = random.nextInt(high - low + 1) + low;
        }

        return results;
    }
}
