package CountDownLatchAndCyclicBarrier.CyclicBarrier.TestIsBroken;

/**
 * Created by hetao on 2019/4/5.
 */
public class MyThread extends Thread {
    private MyService service;

    public MyThread(MyService service) {
        this.service = service;
    }

    @Override
    public void run() {
        service.testA();
    }
}
