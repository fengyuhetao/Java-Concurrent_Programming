package semaphore_exchanger.semaphore_acquireuninterruptibly_1;

import semaphore_exchanger.thread.AbstractService;

import java.util.concurrent.Semaphore;

/**
 * Created by hetao on 2019/4/3.
 */
public class Service implements AbstractService {
    private Semaphore semaphore = new Semaphore(1);

    @Override
    public void testMethod() {
        try {
            semaphore.acquire();
            System.out.println(Thread.currentThread().getName() + " begin timer= " + System.currentTimeMillis());
            for(int i = 0; i < Integer.MAX_VALUE / 50; i++) {
                String newString = new String();
                Math.random();
            }
            System.out.println(Thread.currentThread().getName() + " end timer= " + System.currentTimeMillis());
            semaphore.release();
        } catch (InterruptedException e) {
            System.out.println("线程 " + Thread.currentThread().getName() + " 进入了catch");
            e.printStackTrace();
        }
    }
}
