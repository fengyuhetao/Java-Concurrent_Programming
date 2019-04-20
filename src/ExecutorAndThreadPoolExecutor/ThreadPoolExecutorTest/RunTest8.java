package ExecutorAndThreadPoolExecutor.ThreadPoolExecutorTest;

import java.util.concurrent.LinkedBlockingDeque;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

/**
 * Created by hetao on 2019/4/6.
 * shutdown and shutdownNow
 * shutdownNow 将状态变为STOP，并试图停止所有正在运行线程，如果有if判断，则认为抛出异常，不在处理还在池队列中等待的任务
 */
public class RunTest8 {
    public static void main(String[] args) throws InterruptedException {
        MyRunnable3 myRunnable3 = new MyRunnable3();
        ThreadPoolExecutor poolExecutor = new ThreadPoolExecutor(2, 999, 999, TimeUnit.SECONDS, new LinkedBlockingDeque<>());
        poolExecutor.execute(myRunnable3);
        poolExecutor.execute(myRunnable3);
        poolExecutor.execute(myRunnable3);

        Thread.sleep(1000);
        poolExecutor.shutdownNow();
        poolExecutor.execute(myRunnable3);
        System.out.println("main end");
    }

}
