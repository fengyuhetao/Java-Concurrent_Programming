package ExecutorAndThreadPoolExecutor.RejectPolicy.CallerRunsPolicy;

import sun.awt.image.ImageWatched;

import java.util.concurrent.LinkedBlockingDeque;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

/**
 * @author HT
 * @version V1.0
 * @package ExecutorAndThreadPoolExecutor.RejectPolicy.CallerRunsPolicy
 * @date 2019-04-20 21:21
 */
public class Run {
    /**
     * CallerRunsPolicy
     * 用于被拒绝任务的处理程序，它直接在 execute 方法的调用线程中运行被拒绝的任务；如果执行程序已关闭，则会丢弃该任务。
     * @param args
     */
    public static void main(String[] args) {
        MyThreadA a = new MyThreadA();
        LinkedBlockingDeque queue = new LinkedBlockingDeque(2);
        ThreadPoolExecutor poolExecutor = new ThreadPoolExecutor(2,
                3, 5,
                TimeUnit.SECONDS, queue, new ThreadPoolExecutor.CallerRunsPolicy());
        System.out.println("a begin " + Thread.currentThread().getName() + " " + System.currentTimeMillis());
        poolExecutor.execute(a);
        poolExecutor.execute(a);
        poolExecutor.execute(a);
        poolExecutor.execute(a);
        poolExecutor.execute(a);
        poolExecutor.execute(a);
        /**
         a begin main 1555766935377
         end main 1555766939378
         end pool-1-thread-2 1555766939378
         end pool-1-thread-3 1555766939378
         end pool-1-thread-1 1555766939378
         a end main 1555766939378
         end pool-1-thread-2 1555766943379
         end pool-1-thread-3 1555766943379
         */
        // 主线程被阻塞
        System.out.println(" a end " + Thread.currentThread().getName() + " " + System.currentTimeMillis());
    }
}
