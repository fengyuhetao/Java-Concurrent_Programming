package ExecutorAndThreadPoolExecutor.ExecuteAndUncaughtExceptionHandler;

/**
 * Created by hetao on 2019/4/6.
 */
public class MyRunnable2 implements Runnable {
    @Override
    public void run() {
        System.out.println(Thread.currentThread().getName() + " " + System.currentTimeMillis());
        String a = null;
        a.indexOf(10);
        System.out.println(Thread.currentThread().getName() + " " + System.currentTimeMillis());
    }
}
