package ExecutorAndThreadPoolExecutor.ThreadPoolExecutorTest;

/**
 * Created by hetao on 2019/4/6.
 */
public class MyRunnable5 implements Runnable {
    @Override
    public void run() {
        System.out.println(Thread.currentThread().getName() + System.currentTimeMillis());
        try {
            Thread.sleep(4000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println(Thread.currentThread().getName() + System.currentTimeMillis());
    }
}
