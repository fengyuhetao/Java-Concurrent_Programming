package semaphore_exchanger.CreatorAndConsumer;

import semaphore_exchanger.thread.AbstractService;

/**
 * @author HT
 * @version V1.0
 * @date 2019-03-26 11:09
 */
public class ThreadA extends Thread{
    private RepastService service;

    public ThreadA(RepastService service) {
        super();
        this.service = service;
    }

    @Override
    public void run() {
        service.set();
    }
}
