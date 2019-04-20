package ExecutorAndThreadPoolExecutor.ThreadPoolExecutorTest;

import java.util.List;
import java.util.concurrent.LinkedBlockingDeque;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

/**
 * Created by hetao on 2019/4/6.
 * awaitTermination 与shutdown 结合，可实现"等待执行完毕"的效果
 */
public class RunTest10 {
    public static void main(String[] args) throws InterruptedException {
        MyRunnable5 myRunnable5 = new MyRunnable5();
        ThreadPoolExecutor poolExecutor = new ThreadPoolExecutor(2, 999, 999, TimeUnit.SECONDS, new LinkedBlockingDeque<>());
        poolExecutor.execute(myRunnable5);
        poolExecutor.shutdown();
        System.out.println("main begin !" + System.currentTimeMillis());
        /**
         * awaitTermination 最多等待10秒，也就是阻塞10秒
         */
        System.out.println(poolExecutor.awaitTermination(10, TimeUnit.SECONDS));
        System.out.println("main end !" + System.currentTimeMillis());
    }

}
