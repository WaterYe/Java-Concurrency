import java.util.concurrent.*;

class MyCallable implements Callable<String> {
    @Override
    public String call() throws Exception {
        System.out.println("Time consuming...");
        Thread.sleep(5000);
        return "OK";
    }
}

public class FutureSimpleDemo {
    public static void main(String[] args) throws InterruptedException, ExecutionException {

        ExecutorService executorService = Executors.newCachedThreadPool();
        Future<String> future = executorService.submit(new MyCallable());

        System.out.println("do something...");

        System.out.println("Get result：" + future.get());
        System.out.println("Completed!");
    }
}