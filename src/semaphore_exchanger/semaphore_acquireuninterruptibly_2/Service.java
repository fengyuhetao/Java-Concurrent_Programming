package semaphore_exchanger.semaphore_acquireuninterruptibly_2;

import semaphore_exchanger.thread.AbstractService;

import java.util.concurrent.Semaphore;

/**
 * Created by hetao on 2019/4/3.
 */
public class Service implements AbstractService {
    private Semaphore semaphore = new Semaphore(1);

    @Override
    public void testMethod() {
        // 等待许可的情况下不允许被中断
        semaphore.acquireUninterruptibly();
        System.out.println(Thread.currentThread().getName() + " begin timer= " + System.currentTimeMillis());
        for(int i = 0; i < Integer.MAX_VALUE / 50; i++) {
            String newString = new String();
            Math.random();
        }
        System.out.println(Thread.currentThread().getName() + " end timer= " + System.currentTimeMillis());
        semaphore.release();
    }
}
