package ExecutorAndThreadPoolExecutor.FixedThreadPool;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * Created by hetao on 2019/4/6.
 */
public class Run {
    public static void main(String[] args) {
        MyThreadFactory myThreadFactory = new MyThreadFactory();
        ExecutorService executorService = Executors.newFixedThreadPool(2, myThreadFactory);
        Runnable runnable = () -> {
            System.out.println("begin 我在运行" + System.currentTimeMillis() + " " + Thread.currentThread().getName());
            try {
                Thread.sleep(3000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println("end 我在运行" + System.currentTimeMillis() + " " + Thread.currentThread().getName());
        };

        executorService.execute(runnable);
        executorService.execute(runnable);
        executorService.execute(runnable);
    }
}
