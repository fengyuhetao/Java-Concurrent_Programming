package semaphore_exchanger.semaphore_test_1;

/**
 * @author HT
 * @version V1.0
 * @package semaphore_exchanger.Semaphore_Test_1
 * @date 2019-03-26 11:09
 */
public class ThreadC extends Thread{
    private Service service;

    public ThreadC(Service service) {
        super();
        this.service = service;
    }

    @Override
    public void run() {
        service.testMethod();
    }
}
