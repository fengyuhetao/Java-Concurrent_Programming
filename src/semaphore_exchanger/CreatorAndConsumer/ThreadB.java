package semaphore_exchanger.CreatorAndConsumer;

/**
 * @author HT
 * @version V1.0
 * @date 2019-03-26 11:09
 */
public class ThreadB extends Thread{
    private RepastService service;

    public ThreadB(RepastService service) {
        super();
        this.service = service;
    }

    @Override
    public void run() {
        service.get();
    }
}
