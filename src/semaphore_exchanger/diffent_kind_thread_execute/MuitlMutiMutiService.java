package semaphore_exchanger.diffent_kind_thread_execute;

import com.sun.jmx.snmp.internal.SnmpSubSystem;

import java.util.concurrent.Semaphore;

/**
 * Created by hetao on 2019/4/4.
 * 多进路-多处理-多出路实验
 */
public class MuitlMutiMutiService implements AbstractService{
    private Semaphore semaphore = new Semaphore(3);

    @Override
    public void sayHello() {
        try {
            semaphore.acquire(8);
            System.out.println("ThreadName = " + Thread.currentThread().getName() + "准备");
            System.out.println("begin hello " + System.currentTimeMillis());
            for(int i = 0; i< 5; i++) {
                System.out.println(Thread.currentThread().getName() + " 打印 " + (i + 1));
            }
            System.out.println(" end hello " + System.currentTimeMillis());
            semaphore.release();
            System.out.println("ThreadName = " + Thread.currentThread().getName() + "结束");
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
