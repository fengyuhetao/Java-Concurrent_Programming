package semaphore_exchanger.CreatorAndConsumer;


import semaphore_exchanger.SemaphoreStringPool.ListPool;
import semaphore_exchanger.SemaphoreStringPool.MyThread;

/**
 * Created by hetao on 2019/4/4.
 * 多生产者以及多消费者
 */
public class Run {
    public static void main(String[] args) throws InterruptedException {
        RepastService service = new RepastService();
        ThreadA[] threadAS = new ThreadA[60];
        ThreadB[] threadBS = new ThreadB[60];

        for(int i = 0; i< 60; i++) {
            threadAS[i] = new ThreadA(service);
            threadBS[i] = new ThreadB(service);
        }

        Thread.sleep(2000);
        for(int i = 0; i< 60; i++) {
            threadAS[i].start();
            threadBS[i].start();
        }
    }
}
