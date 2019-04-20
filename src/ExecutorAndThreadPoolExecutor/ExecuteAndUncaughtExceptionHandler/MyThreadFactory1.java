package ExecutorAndThreadPoolExecutor.ExecuteAndUncaughtExceptionHandler;

import java.util.Date;
import java.util.concurrent.ThreadFactory;

/**
 * Created by hetao on 2019/4/6.
 */
public class MyThreadFactory1 implements ThreadFactory {
    @Override
    public Thread newThread(Runnable r) {
        Thread newThread = new Thread(r);
        newThread.setName("name:" + new Date());
        return newThread;
    }
}
