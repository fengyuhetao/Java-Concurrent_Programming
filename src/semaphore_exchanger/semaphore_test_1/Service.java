package semaphore_exchanger.semaphore_test_1;

import java.util.concurrent.Semaphore;

/**
 * 类Semaphore的同步性
 * semaphore 可以保证最多只运行某几个线程执行acuire和release之间的代码。
 * 但是不能保证每个线程之间的执行顺序一定是start的顺序。
 * 当permits参数为1的时候，就相当于互斥锁。
 * 当permits参数不为1，无法保证线程安全性，同时有多个线程访问变量。
 *
 * 相较于synchronized，semaphore 可以控制线程并发的数量，而synchronized无法做到。
 *
 *
 * @author HT
 * @version V1.0
 * @package semaphore_exchanger
 * @date 2019-03-26 11:04
 */
public class Service {
//    相当于互斥锁
    private Semaphore semaphore = new Semaphore(1);

//    同时允许两个线程一起执行
//    private Semaphore semaphore = new Semaphore(1);

    public void testMethod() {
        try {
            semaphore.acquire();
            System.out.println(Thread.currentThread().getName() + " begin timer=" + System.currentTimeMillis());
            Thread.sleep(5000);
            System.out.println(Thread.currentThread().getName() + " end timer=" + System.currentTimeMillis());
            semaphore.release();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
