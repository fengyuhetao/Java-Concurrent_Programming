package semaphore_exchanger.semaphore_acquireuninterruptibly_2;

import semaphore_exchanger.thread.ThreadA;
import semaphore_exchanger.thread.ThreadB;
import semaphore_exchanger.thread.ThreadC;

/**
 * Created by hetao on 2019/4/3.
 */
public class Run {
    public static void main(String[] args) throws InterruptedException{
        Service service = new Service();
        ThreadA a = new ThreadA(service);
        a.setName("A");
        a.start();

        ThreadB b = new ThreadB(service);
        b.setName("B");
        b.start();

        Thread.sleep(1000);

        // 此时线程可被中断
        b.interrupt();
        System.out.println("main中断了b线程");
    }
}
