package CountDownLatchAndCyclicBarrier.CountDownLatch.FirstUse;

/**
 * Created by hetao on 2019/4/5.
 */
public class MyThread extends Thread{
    private MyService myService;

    public MyThread(MyService myService) {
        super();
        this.myService = myService;
    }

    @Override
    public void run() {
        myService.testMethod();
    }
}
