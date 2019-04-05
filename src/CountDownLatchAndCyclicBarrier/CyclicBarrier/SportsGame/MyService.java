package CountDownLatchAndCyclicBarrier.CyclicBarrier.SportsGame;

import CountDownLatchAndCyclicBarrier.CyclicBarrier.Regeneration.MyThread;

import java.util.concurrent.BrokenBarrierException;
import java.util.concurrent.CyclicBarrier;

/**
 * Created by hetao on 2019/4/5.
 */
public class MyService {
    private CyclicBarrier cyclicBarrier;

    public MyService(CyclicBarrier cyclicBarrier) {
        this.cyclicBarrier = cyclicBarrier;
    }

    public void beginRun() {
        try {
            long sleepValue = (long) (Math.random() * 10000);
            Thread.sleep(sleepValue);
            System.out.println(Thread.currentThread().getName() + " " + System.currentTimeMillis() + " begin第一阶段 " + (cyclicBarrier.getNumberWaiting() + 1));
            cyclicBarrier.await();
            System.out.println(Thread.currentThread().getName() + " " + System.currentTimeMillis() + " end第一阶段" + (cyclicBarrier.getNumberWaiting()));
            sleepValue = (long) (Math.random() * 10000);
            Thread.sleep(sleepValue);
            System.out.println(Thread.currentThread().getName() + " " + System.currentTimeMillis() + " begin第二阶段" + (cyclicBarrier.getNumberWaiting() + 1));
            cyclicBarrier.await();
            System.out.println(Thread.currentThread().getName() + " " + System.currentTimeMillis() + " end 第二阶段" + (cyclicBarrier.getNumberWaiting()));
        } catch (InterruptedException | BrokenBarrierException e) {
            e.printStackTrace();
        }
    }
}
