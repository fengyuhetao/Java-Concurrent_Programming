package CountDownLatchAndCyclicBarrier.CountDownLatch.JudgerWaitRuner;

import java.util.concurrent.CountDownLatch;

/**
 * Created by hetao on 2019/4/5.
 */
public class MyThread extends Thread {
    private CountDownLatch maxRunner;

    public MyThread(CountDownLatch maxRunner) {
        super();
        this.maxRunner = maxRunner;
    }

    @Override
    public void run() {
        try {
            Thread.sleep(2000);
            maxRunner.countDown();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
