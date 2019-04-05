package CountDownLatchAndCyclicBarrier.CyclicBarrier.CyclicBarrierThreadBigParties;

import java.util.concurrent.BrokenBarrierException;
import java.util.concurrent.CyclicBarrier;

/**
 * Created by hetao on 2019/4/5.
 */
public class ThreadA extends Thread {
    private CyclicBarrier cyclicBarrier;

    public ThreadA(CyclicBarrier cyclicBarrier) {
        super();
        this.cyclicBarrier = cyclicBarrier;
    }

    @Override
    public void run() {
        try {
            System.out.println(Thread.currentThread().getName() + " begin = " + System.currentTimeMillis() + "等待凑齐2个继续运行");
            cyclicBarrier.await();
            System.out.println(Thread.currentThread().getName() + " end = " + System.currentTimeMillis() + " 已经凑齐2个继续运行");
        } catch (InterruptedException | BrokenBarrierException e) {
            e.printStackTrace();
        }
    }
}
