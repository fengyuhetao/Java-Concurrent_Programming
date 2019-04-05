package semaphore_exchanger.semaphore_method_test;

import semaphore_exchanger.thread.AbstractService;

import java.util.concurrent.Semaphore;

/**
 * Created by hetao on 2019/4/3.
 */
public class FairAndNotFairService implements AbstractService {
    private boolean isFair = false;

    private Semaphore semaphore = new Semaphore(1, isFair);

    @Override
    public void testMethod() {
        try {
            semaphore.acquire();
            System.out.println("ThreadName=" + Thread.currentThread().getName());
        } catch (InterruptedException e) {
            e.printStackTrace();
        } finally {
            semaphore.release();
        }
    }
}
