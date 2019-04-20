package ExecutorAndThreadPoolExecutor.ExecuteAndUncaughtExceptionHandler;

import java.util.Date;
import java.util.concurrent.ThreadFactory;

/**
 * Created by hetao on 2019/4/6.
 */
public class MyThreadFactory2 implements ThreadFactory {
    @Override
    public Thread newThread(Runnable r) {
        Thread newThread = new Thread(r);
        newThread.setName("线程name:" + new Date());
        newThread.setUncaughtExceptionHandler(new Thread.UncaughtExceptionHandler() {
            @Override
            public void uncaughtException(Thread t, Throwable e) {
                System.out.println("自定义处理异常: " + t.getName() + " " + e.getMessage());
                e.printStackTrace();
            }
        });
        return newThread;
    }
}
