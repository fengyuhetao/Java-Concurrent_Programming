package CountDownLatchAndCyclicBarrier.CyclicBarrier.TestIsBroken;

import java.util.concurrent.CyclicBarrier;

/**
 * Created by hetao on 2019/4/5.
 */
public class Run {
    public static void main(String[] args) {
        int parties = 4;
        CyclicBarrier cyclicBarrier = new CyclicBarrier(parties, new Runnable() {
            @Override
            public void run() {
                System.out.println("都到了");
            }
        });

        MyService service = new MyService(cyclicBarrier);

        MyThread[] myThreads = new MyThread[4];
        for(int i = 0; i< myThreads.length; i++) {
            myThreads[i] = new MyThread(service);
            myThreads[i].start();
        }
    }
}
