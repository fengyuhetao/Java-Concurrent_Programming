package CountDownLatchAndCyclicBarrier.CountDownLatch.FirstUse;

/**
 * Created by hetao on 2019/4/5.
 */
public class Run {
    public static void main(String[] args) throws InterruptedException {
        MyService service = new MyService();
        MyThread thread = new MyThread(service);
        thread.start();
        Thread.sleep(2000);
        service.downMethod();
    }
}
