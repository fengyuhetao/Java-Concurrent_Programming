package ExecutorAndThreadPoolExecutor.RejectPolicy.CallerRunsPolicy;

/**
 * @author HT
 * @version V1.0
 * @package ExecutorAndThreadPoolExecutor.RejectPolicy.CallerRunsPolicy
 * @date 2019-04-20 21:20
 */
public class MyThreadA extends Thread {
    @Override
    public void run() {
        try {
            Thread.sleep(4000);
            System.out.println(" end " + Thread.currentThread().getName() + " " + System.currentTimeMillis());
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
