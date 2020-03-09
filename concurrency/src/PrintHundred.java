import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class PrintHundred implements Runnable {
    private static int taskCount = 0;
    private final int id = taskCount++;

    @Override
    public void run() {
        System.out.println(id);
        Thread.yield();
    }

    public static void main(String[] args) {
        ExecutorService exec = Executors.newCachedThreadPool();
        for (int i = 0; i < 100; i++) {
            exec.execute(new PrintHundred());
        }
        exec.shutdown();
    }
}