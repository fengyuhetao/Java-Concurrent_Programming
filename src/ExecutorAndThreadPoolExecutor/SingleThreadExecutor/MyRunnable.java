package ExecutorAndThreadPoolExecutor.SingleThreadExecutor;

/**
 * Created by hetao on 2019/4/6.
 */
public class MyRunnable implements Runnable {
    private String username;

    public MyRunnable(String username) {
        super();
        this.username = username;
    }

    @Override
    public void run() {
        System.out.println(Thread.currentThread().getName() + " username= " + username + " begin " + System.currentTimeMillis());
        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println(Thread.currentThread().getName() + " username= " + username + " end " + System.currentTimeMillis());
    }
}
