package CountDownLatchAndCyclicBarrier.CountDownLatch.RunnerAllPrepare;

import java.util.concurrent.CountDownLatch;

/**
 * Created by hetao on 2019/4/5.
 */
public class Run {
    public static void main(String[] args) throws Exception{
        testBetter();
    }

    /**
     * 由于每个运动员准备时长不一样，所以，2秒钟后开始，可能不对
     * @throws Exception
     */
    public void test() throws Exception{
        MyService service = new MyService();
        MyThread[] myThreads = new MyThread[10];
        for(int i = 0; i< myThreads.length; i++) {
            myThreads[i] = new MyThread(service);
            myThreads[i].setName("线程" + (i + 1));
            myThreads[i].start();
        }

        Thread.sleep(2000);
        service.downMethod();
    }

    public static void testBetter() {
        try {
            CountDownLatch comingTag = new CountDownLatch(10);
            CountDownLatch waitTag = new CountDownLatch(1);
            CountDownLatch waitRunTag = new CountDownLatch(10);
            CountDownLatch beginTag = new CountDownLatch(1);
            CountDownLatch endTag = new CountDownLatch(1);

            MyThreadBetter[] myThreadBetters = new MyThreadBetter[10];
            for(int i = 0; i< myThreadBetters.length; i++) {
                myThreadBetters[i] = new MyThreadBetter(comingTag, waitTag, waitRunTag, beginTag, endTag);
                myThreadBetters[i].start();
            }

            System.out.println("裁判员等待选手到来");
            comingTag.await();
            System.out.println("裁判看到所有运动员来了，各就各位前\"巡视\" 用时5秒");
            Thread.sleep(5000);
            waitTag.countDown();
            System.out.println("各就各位");
            waitRunTag.await();
            Thread.sleep(2000);
            System.out.println("指令枪响");
            beginTag.countDown();
            endTag.await();
            System.out.println("所有运动员到达，统计比赛名次");
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
