package lesson12;

import java.time.Duration;
import java.time.Instant;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.concurrent.*;

public class Multithreading {
    static final int SIZE = 10000000;
    static final int HALF = SIZE/2;

    public static void main(String[] args) {
        oneThreadProcessing();
        twoThreadsProcessing();
    }

    public static float[] initArr() {
        float[] arr = new float[SIZE];
        Arrays.fill(arr, 1);
        return arr;
    }

    public static void oneThreadProcessing() {
        float[] arr = initArr();
        Instant start = Instant.now();
        processArr(arr,0);
        Instant end = Instant.now();
        System.out.println("Время исполнения в один поток: " + Duration.between(start, end));
        System.out.println("Контроль целостности массива: " + arr[0] + " " + arr[1] + " " + arr[arr.length - 2] + " " + arr[arr.length-1]);
    }

    public static void twoThreadsProcessing() {
        float[] arr = initArr();
        float[] a1 = new float[HALF];
        float[] a2 = new float[HALF];
        ExecutorService es = Executors.newFixedThreadPool(2);
        List<Callable<Boolean>> tasks = new ArrayList<>();

        Instant start = Instant.now();
        System.arraycopy(arr, 0, a1, 0, HALF);
        System.arraycopy(arr, HALF, a2, 0, HALF);

        tasks.add(() -> processArr(a1, 0));
        tasks.add(() -> processArr(a2, HALF));
        try {
            for (Future<Boolean> f : es.invokeAll(tasks)) {
                f.get();
            }
        } catch (InterruptedException | ExecutionException e) {
            e.printStackTrace();
        }
        System.arraycopy(a1, 0, arr, 0, HALF);
        System.arraycopy(a2, 0, arr, HALF, HALF);
        Instant end = Instant.now();
        System.out.println("Время исполнения в два потока: " + Duration.between(start, end));
        System.out.println("Контроль целостности массива: " + arr[0] + " " + arr[1] + " " + arr[arr.length - 2] + " " + arr[arr.length-1]);
        es.shutdown();
    }

    public static boolean processArr(float[] arr, int offset) {
        for (int i = 0; i < arr.length; i++) {
            arr[i] = (float)(arr[i] * Math.sin(0.2f + (i + offset) / 5.0) * Math.cos(0.2f + (i + offset) / 5.0) * Math.cos(0.4f + (i + offset)/ 2.0));
        }
        return true;
    }
}
