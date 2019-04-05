package semaphore_exchanger.thread;

/**
 * Created by hetao on 2019/4/3.
 */
public class ThreadCommon extends Thread{
    private AbstractService service;

    public ThreadCommon(AbstractService service) {
        super();
        this.service = service;
    }

    @Override
    public void run() {
        service.testMethod();
    }
}
