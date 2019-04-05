package semaphore_exchanger.semaphore_method_test;

import semaphore_exchanger.thread.AbstractService;

import java.util.concurrent.Semaphore;

/**
 * Created by hetao on 2019/4/3.
 */
public class GetQueueLengthService implements AbstractService{
    private Semaphore semaphore = new Semaphore(1);

    @Override
    public void testMethod() {
        try {
            semaphore.acquire();
            Thread.sleep(1000);
            System.out.println("还有 " + semaphore.getQueueLength() + "个线程在等待");
            System.out.println("是否有线程正在等待信号量呢？ " + semaphore.hasQueuedThreads());
        } catch (InterruptedException e) {
            e.printStackTrace();
        } finally {
            semaphore.release();
        }
    }
}
