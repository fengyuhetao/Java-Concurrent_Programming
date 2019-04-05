package CountDownLatchAndCyclicBarrier.CyclicBarrier.TestIsBroken;

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

    private void beginRun(int count) {
        try {
            System.out.println(Thread.currentThread().getName() + " 到了，在等待其他人都到了在起跑");
            if(Thread.currentThread().getName().equals("Thread-2")) {
                System.out.println("Thread-2进来了");
                Thread.sleep(5000);
//                Integer.parseInt("a");
                Thread.currentThread().interrupt();
            }
            cyclicBarrier.await();
            System.out.println("都到了，开始跑");
            System.out.println(Thread.currentThread().getName() + "到达终点, 并结束第" + count + " 赛段");
        } catch (InterruptedException e) {
            System.out.println("进入了InterruptedException e " + cyclicBarrier.isBroken());
            e.printStackTrace();
        } catch (BrokenBarrierException e) {
            System.out.println("进入了BrokenBarrierException e " + cyclicBarrier.isBroken());
            e.printStackTrace();
        }
    }

    public void testA() {
        for(int i = 0; i< 1; i++) {
            beginRun(i + 1);
        }
    }
}
