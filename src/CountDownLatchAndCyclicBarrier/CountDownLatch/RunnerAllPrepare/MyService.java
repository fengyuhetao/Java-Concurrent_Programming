package CountDownLatchAndCyclicBarrier.CountDownLatch.RunnerAllPrepare;

import java.util.concurrent.CountDownLatch;

/**
 * Created by hetao on 2019/4/5.
 * 运动员全部准备好，然后开始比赛
 */
public class MyService  {
    private CountDownLatch down =  new CountDownLatch(1);

    public void testMethod() {
        try {
            System.out.println(Thread.currentThread().getName() + "准备好");
            down.await();
            System.out.println(Thread.currentThread().getName() + "结束");
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    public void downMethod() {
        System.out.println("开始");
        down.countDown();
    }
}
