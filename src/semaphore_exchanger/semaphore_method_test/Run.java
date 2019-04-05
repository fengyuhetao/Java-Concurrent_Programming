package semaphore_exchanger.semaphore_method_test;

import semaphore_exchanger.thread.*;

import java.util.concurrent.Exchanger;

/**
 * Created by hetao on 2019/4/3.
 */
public class Run {
    public static void main(String[] args) {
//        testAvailablePermits();
//        testDrainPermits();
//        testGetQueueLength();
//        testFairAndNotFair();
//        testTryAcquire();
        testExchangeData();
    }

    /**
     * availablePermits 返回当前可用许可数
     */
    public static void testAvailablePermits() {
        AvailablePermitsService service = new AvailablePermitsService();
        service.testMethod();
    }

    /**
     * drainPermits 返回当前立即可用的许可数，并将许可置为0
     */
    public static void testDrainPermits() {
        DrainPermitsService service = new DrainPermitsService();
        service.testMethod();
    }

    /**
     * getQueueLength 返回取得等待许可的线程个数
     * hasQueueThreads 判断有没有线程在等待该许可
     */
    public static void testGetQueueLength() {
        GetQueueLengthService service = new GetQueueLengthService();
        ThreadCommon threadCommon = new ThreadCommon(service);
        threadCommon.start();

        ThreadCommon[] threadCommons = new ThreadCommon[4];

        for(int i = 0; i< 4; i++) {
            threadCommons[i] = new ThreadCommon(service);
            threadCommons[i].start();
        }
    }

    /**
     * true: 先启动的线程先执行
     * 默认:false: 顺序不确定
     * 公平：线程启动和线程启动的顺序有关，但不是100%地获取信号量
     * 非公平: 线程启动的顺序和滴啊用semaphore.acquire() 的顺序无关，并不是先启动，就一定先获得许可
     */
    public static void testFairAndNotFair(){
        FairAndNotFairService service = new FairAndNotFairService();
        FairAndNotFairThread fairAndNotFairThread = new FairAndNotFairThread(service);
        fairAndNotFairThread.start();

        FairAndNotFairThread[] fairAndNotFairThreads = new FairAndNotFairThread[4];

        for(int i = 0; i< 4; i++) {
            fairAndNotFairThreads[i] = new FairAndNotFairThread(service);
            fairAndNotFairThreads[i].start();
        }

    }

    /**
     * 尝试获得一个许可，如果获取不到，返回false,和if语句结合，具有无阻塞的特点，可以让线程不至于在同步处处于持续等待状态
     */
    public static void testTryAcquire() {
        TryAcquireService service = new TryAcquireService();
        ThreadA a = new ThreadA(service);
        a.setName("A");
        a.start();
        ThreadB b = new ThreadB(service);
        b.setName("B");
        b.start();
    }

    /**
     * Exchanger 可以在两个线程之间传输数据，比消费者和生产者 wait/notify 更加方便
     * exchange() 方法具有阻塞的特性，调用后等待其他线程取得数据，如果没有其他线程取得数据，就一直阻塞等待。
     */
    public static void testExchangeBlock() {
        Exchanger<String> exchanger = new Exchanger<>();
        ExchangeThreadA a = new ExchangeThreadA(exchanger);
        a.start();
        System.out.println("main end");
    }

    public static void testExchangeData() {
        Exchanger<String> exchanger = new Exchanger<>();
        ExchangeThreadA a = new ExchangeThreadA(exchanger);
        ExchangeThreadB b = new ExchangeThreadB(exchanger);
        a.start();
        b.start();
        System.out.println("main end");
    }
}
