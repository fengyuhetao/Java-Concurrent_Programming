package ExecutorAndThreadPoolExecutor.ExecuteAndUncaughtExceptionHandler;

/**
 * Created by hetao on 2019/4/6.
 */
public class MyRunnable1 implements Runnable {
    @Override
    public void run() {
        try {
            System.out.println(Thread.currentThread().getName() + " " + System.currentTimeMillis());
            Thread.sleep(4000);
            System.out.println(Thread.currentThread().getName() + " " + System.currentTimeMillis());
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
