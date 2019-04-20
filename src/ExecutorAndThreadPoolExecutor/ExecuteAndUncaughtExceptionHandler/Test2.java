package ExecutorAndThreadPoolExecutor.ExecuteAndUncaughtExceptionHandler;

import java.util.concurrent.LinkedBlockingDeque;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

/**
 * Created by hetao on 2019/4/6.
 */
public class Test2 {
    public static void main(String[] args) {
        MyRunnable2 myRunnable2 = new MyRunnable2();
        ThreadPoolExecutor poolExecutor = new ThreadPoolExecutor(1, 9999, 9999, TimeUnit.SECONDS, new LinkedBlockingDeque<>());
        poolExecutor.setThreadFactory(new MyThreadFactory2());
        poolExecutor.execute(myRunnable2);
    }
}
