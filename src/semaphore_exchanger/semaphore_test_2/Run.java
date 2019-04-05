package semaphore_exchanger.semaphore_test_2;

import semaphore_exchanger.thread.ThreadA;

import java.util.concurrent.Semaphore;

/**
 * @author HT
 * @version V1.0
 * @date 2019-03-26 11:10
 */
public class Run {
    public static void main(String[] args) {
//        testDemo1();
        testDemo2();
    }

    public static void testDemo1() {
        Service service = new Service();

//        private Semaphore semaphore = new Semaphore(10);
//        semaphore.acquire(2);
//        由于上述代码的原因，最多同时只能有 10 / 2 个线程在运行
        ThreadA[] threadAS = new ThreadA[10];
        for(int i = 0; i< 10; i++) {
            threadAS[i] = new ThreadA(service);
            threadAS[i].start();
        }
    }

    public static void testDemo2() {
//        多次调用Semaphore类的release()或者release(int)方法，可以动态增加permits的个数
        try{
            Semaphore semaphore = new Semaphore(5);
            semaphore.acquire();
            semaphore.acquire();
            semaphore.acquire();
            semaphore.acquire();
            semaphore.acquire();
            System.out.println(semaphore.availablePermits());
            semaphore.release();
            semaphore.release();
            semaphore.release();
            semaphore.release();
            semaphore.release();
            semaphore.release();
            System.out.println(semaphore.availablePermits());
            semaphore.release(4);
            System.out.println(semaphore.availablePermits());
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

    }

}
