package CountDownLatchAndCyclicBarrier.CyclicBarrier.Regeneration;

import java.util.concurrent.CyclicBarrier;

/**
 * Created by hetao on 2019/4/5.
 */
public class Run {
    public static void main(String[] args) throws Exception {
        CyclicBarrier cyclicBarrier = new CyclicBarrier(3);

        MyThread thread1 = new MyThread(cyclicBarrier);
        thread1.start();
        Thread.sleep(500);
        System.out.println(cyclicBarrier.getNumberWaiting());

        MyThread thread2 = new MyThread(cyclicBarrier);
        thread2.start();
        Thread.sleep(500);
        System.out.println(cyclicBarrier.getNumberWaiting());

        MyThread thread3 = new MyThread(cyclicBarrier);
        thread3.start();
        Thread.sleep(500);
        System.out.println(cyclicBarrier.getNumberWaiting());

        MyThread thread4 = new MyThread(cyclicBarrier);
        thread4.start();
        Thread.sleep(500);
        System.out.println(cyclicBarrier.getNumberWaiting());
    }
}
