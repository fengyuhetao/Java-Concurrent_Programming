package ExecutorAndThreadPoolExecutor.ThreadPoolExecutorTest;

import java.util.concurrent.LinkedBlockingDeque;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

/**
 * Created by hetao on 2019/4/6.
 * shutdown and shutdownNow
 */
public class RunTest7 {
    public static void main(String[] args) throws InterruptedException {
        MyRunnable3 myRunnable3 = new MyRunnable3();
        ThreadPoolExecutor poolExecutor = new ThreadPoolExecutor(2, 999, 999, TimeUnit.SECONDS, new LinkedBlockingDeque<>());
        poolExecutor.execute(myRunnable3);
        poolExecutor.execute(myRunnable3);
        poolExecutor.execute(myRunnable3);

        Thread.sleep(1000);
        poolExecutor.shutdownNow();
        System.out.println("main end");
    }

}
