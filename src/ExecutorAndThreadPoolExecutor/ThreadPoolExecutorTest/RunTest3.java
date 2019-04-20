package ExecutorAndThreadPoolExecutor.ThreadPoolExecutorTest;

import java.util.concurrent.LinkedBlockingDeque;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

/**
 * Created by hetao on 2019/4/6.
 * corePoolSize < 线程数量 <= maxCorePoolSize
 */
public class RunTest3 {
    public static void main(String[] args) throws InterruptedException {
        Runnable runnable = () -> {
            try {
                System.out.println(Thread.currentThread().getName() + " run! " + System.currentTimeMillis());
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        };

        ThreadPoolExecutor executor = new ThreadPoolExecutor(7, 8, 5, TimeUnit.SECONDS, new LinkedBlockingDeque<>());
        for(int i = 0; i < 8; i++) {
            executor.execute(runnable);
        }
        Thread.sleep(300);
        System.out.println("A " + executor.getCorePoolSize());
        System.out.println("A " + executor.getPoolSize());
        System.out.println("A " + executor.getQueue().size());
        Thread.sleep(10000);
        System.out.println("B " + executor.getCorePoolSize());
        System.out.println("B " + executor.getPoolSize());
        System.out.println("B " + executor.getQueue().size());
    }
}
