package ExecutorAndThreadPoolExecutor.ExecuteAndUncaughtExceptionHandler;

/**
 * Created by hetao on 2019/4/6.
 */
public class MyRunnable3 implements Runnable {
    @Override
    public void run() {
        System.out.println(Thread.currentThread().getName() + " " + System.currentTimeMillis());
        System.out.println(Thread.currentThread().getName() + " " + System.currentTimeMillis());
    }
}
