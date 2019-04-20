package ExecutorAndThreadPoolExecutor.ThreadPoolExecutorTest;

import java.util.concurrent.LinkedBlockingDeque;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

/**
 * Created by hetao on 2019/4/6.
 * shutdown and shutdownNow
 */
public class RunTest6 {
    public static void main(String[] args) throws InterruptedException {
        MyRunnable2 myRunnable2 = new MyRunnable2();
        ThreadPoolExecutor poolExecutor = new ThreadPoolExecutor(2, 999, 999L, TimeUnit.SECONDS, new LinkedBlockingDeque<>());
        poolExecutor.execute(myRunnable2);
        poolExecutor.execute(myRunnable2);
        poolExecutor.execute(myRunnable2);
        Thread.sleep(1000);
        poolExecutor.shutdownNow();
    }

}
