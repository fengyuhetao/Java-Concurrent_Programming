package ExecutorAndThreadPoolExecutor.ExecuteAndUncaughtExceptionHandler;

import java.util.concurrent.LinkedBlockingDeque;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

/**
 * Created by hetao on 2019/4/6.
 */
public class Test1 {
    public static void main(String[] args) {
        MyRunnable1 myRunnable1 = new MyRunnable1();
        ThreadPoolExecutor poolExecutor = new ThreadPoolExecutor(1, 9999, 9999, TimeUnit.SECONDS, new LinkedBlockingDeque<>(), new MyThreadFactory1());
        poolExecutor.execute(myRunnable1);
    }
}
