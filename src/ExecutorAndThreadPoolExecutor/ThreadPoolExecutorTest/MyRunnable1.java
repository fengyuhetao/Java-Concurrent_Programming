package ExecutorAndThreadPoolExecutor.ThreadPoolExecutorTest;

/**
 * Created by hetao on 2019/4/6.
 */
public class MyRunnable1 implements Runnable {
    @Override
    public void run() {
        System.out.println(Thread.currentThread().getName() + " begin at " + System.currentTimeMillis());
        try {
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println(Thread.currentThread().getName() + " end at " + System.currentTimeMillis());
    }
}
