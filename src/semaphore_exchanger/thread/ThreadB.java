package semaphore_exchanger.thread;

/**
 * @author HT
 * @version V1.0
 * @date 2019-03-26 11:09
 */
public class ThreadB extends Thread{
    private AbstractService service;

    public ThreadB(AbstractService service) {
        super();
        this.service = service;
    }

    @Override
    public void run() {
        service.testMethod();
    }
}
