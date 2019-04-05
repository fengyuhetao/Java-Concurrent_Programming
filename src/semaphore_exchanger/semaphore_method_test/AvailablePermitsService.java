package semaphore_exchanger.semaphore_method_test;

import semaphore_exchanger.thread.AbstractService;

import java.util.concurrent.Semaphore;

/**
 * Created by hetao on 2019/4/3.
 */
public class AvailablePermitsService implements AbstractService{
    private Semaphore semaphore = new Semaphore(10);

    @Override
    public void testMethod() {
        try {
            semaphore.acquire();
            System.out.println(semaphore.availablePermits());
            System.out.println(semaphore.availablePermits());
            System.out.println(semaphore.availablePermits());
        } catch (InterruptedException e) {
            e.printStackTrace();
        } finally {
            semaphore.release();
        }

    }
}
