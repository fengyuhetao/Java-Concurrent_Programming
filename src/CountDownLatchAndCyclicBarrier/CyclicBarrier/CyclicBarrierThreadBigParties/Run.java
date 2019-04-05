package CountDownLatchAndCyclicBarrier.CyclicBarrier.CyclicBarrierThreadBigParties;

import java.util.concurrent.CyclicBarrier;

/**
 * Created by hetao on 2019/4/5.
 */
public class Run {
    public static void main(String[] args) throws InterruptedException {
        // Countdownlatch: 一个线程或者多个线程，等待另外一个线程或多个线程完成某个事情之后才能够执行
        // CyclicBarrier: 多个线程之间互相等待，任何一个线程完成之前，所有线程都必须等待。
        CyclicBarrier cyclicBarrier = new CyclicBarrier(2, () -> System.out.println("全来了"));

        for(int i = 0; i< 4; i++) {
            ThreadA threadA = new ThreadA(cyclicBarrier);
            threadA.start();
            Thread.sleep(2000);
        }
    }
}
