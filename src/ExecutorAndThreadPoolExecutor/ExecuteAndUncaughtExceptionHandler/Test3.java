package ExecutorAndThreadPoolExecutor.ExecuteAndUncaughtExceptionHandler;

import java.util.concurrent.LinkedBlockingDeque;
import java.util.concurrent.SynchronousQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

/**
 * Created by hetao on 2019/4/6.
 */
public class Test3 {
    /**allowCoreThreadTimeOut为true
    该值为true，则线程池数量最后销毁到0个。

    allowCoreThreadTimeOut为false
    销毁机制：超过核心线程数时，而且（超过最大值或者timeout过），就会销毁。

    没有timeout值的时候始终保持在maxPoolSize水平；
    如果有timeout情况，那么保持在corePoolSize水平。默认是cachedThreadPool才会设置timeout为60秒，其他Executors造出来的timeout为0，即没有timeout。而cachedThreadPool的corePoolSize为0，即cachedThreadPool，最后线程数量为0.
   （1）当没有超过核心线程时，不会销毁线程
  （2）当超过核心线程数：再判断，如果超过最大值，则销毁；如果timeout过，则销毁
     */
    public static void main(String[] args) throws InterruptedException {
        ThreadPoolExecutor pool = new ThreadPoolExecutor(4, 5,5, TimeUnit.SECONDS, new SynchronousQueue<Runnable>());
        System.out.println(pool.allowsCoreThreadTimeOut());
        pool.allowCoreThreadTimeOut(true);
        for(int i = 0; i< 4; i++) {
            MyRunnable3 runnable3 = new MyRunnable3();
            pool.execute(runnable3);
        }

        Thread.sleep(8000);
        System.out.println(pool.getPoolSize());
    }
}
