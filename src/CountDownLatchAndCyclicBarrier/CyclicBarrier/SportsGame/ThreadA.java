package CountDownLatchAndCyclicBarrier.CyclicBarrier.SportsGame;

/**
 * Created by hetao on 2019/4/5.
 */
public class ThreadA extends Thread {
    private MyService service;

    public ThreadA(MyService service) {
        super();
        this.service = service;
    }

    @Override
    public void run() {
        service.beginRun();
    }
}
