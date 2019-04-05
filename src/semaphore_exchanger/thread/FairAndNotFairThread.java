package semaphore_exchanger.thread;

import semaphore_exchanger.semaphore_method_test.FairAndNotFairService;

/**
 * Created by hetao on 2019/4/3.
 */
public class FairAndNotFairThread extends Thread {
    private FairAndNotFairService service;

    public FairAndNotFairThread(FairAndNotFairService service) {
        super();
        this.service = service;
    }

    @Override
    public void run() {
        System.out.println("ThreadName = " + this.getName() + " 启动了！");
        service.testMethod();
    }
}
