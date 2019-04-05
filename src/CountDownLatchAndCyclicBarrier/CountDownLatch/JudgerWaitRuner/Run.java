package CountDownLatchAndCyclicBarrier.CountDownLatch.JudgerWaitRuner;

import java.util.concurrent.CountDownLatch;

/**
 * Created by hetao on 2019/4/5.
 */
public class Run {
    public static void main(String [] args) {
        CountDownLatch maxRunner = new CountDownLatch(10);
        MyThread[] myThreads = new MyThread[Integer.parseInt("" + maxRunner.getCount())];

        for(int i = 0; i< myThreads.length; i++) {
            myThreads[i] = new MyThread(maxRunner);
            myThreads[i].setName("线程" + (i+1));
            myThreads[i].start();
        }
        try {
            maxRunner.await();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("都回来了");
    }
}
