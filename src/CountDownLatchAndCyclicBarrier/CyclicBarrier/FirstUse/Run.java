package CountDownLatchAndCyclicBarrier.CyclicBarrier.FirstUse;

import java.util.concurrent.CyclicBarrier;

/**
 * Created by hetao on 2019/4/5.
 */
public class Run {
    public static void main(String[] args) {
        CyclicBarrier cyclicBarrier = new CyclicBarrier(5, new Runnable() {
            @Override
            public void run() {
                System.out.println("全部都到了");
            }
        });
        MyThread[] myThreads = new MyThread[5];
        for(int i = 0; i< myThreads.length; i++) {
            myThreads[i] = new MyThread(cyclicBarrier);
        }

        for(int i = 0; i< myThreads.length; i++) {
            myThreads[i].start();
        }
    }
}
