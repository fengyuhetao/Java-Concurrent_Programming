package semaphore_exchanger.semaphore_method_test;

import semaphore_exchanger.thread.AbstractService;

import java.util.concurrent.Semaphore;
import java.util.concurrent.TimeUnit;

/**
 * Created by hetao on 2019/4/4.
 */
public class TryAcquireService implements AbstractService{
    private Semaphore semaphore = new Semaphore(1);

    @Override
    public void testMethod() {
        try {
            // tryAcquire(permits) 获取多个许可
            // tryAcquire(long timeout, TimeUnit unit) 在指定时间内尝试获得1个许可，如果获取不到返回false
            if(semaphore.tryAcquire(3, TimeUnit.SECONDS)) {
                System.out.println("ThreadName=" + Thread.currentThread().getName());
                for(int i = 0; i< Integer.MAX_VALUE; i++) {
                    String newString = new String();
                    Math.random();
                }
                semaphore.release();
            } else {
                System.out.println("ThreadName=" + Thread.currentThread().getName() + "未成功进入");
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

    }
}
