package semaphore_exchanger.diffent_kind_thread_execute;

/**
 * Created by hetao on 2019/4/4.
 */
public class MyThread extends Thread{
    private AbstractService service;

    public MyThread(AbstractService service) {
        this.service = service;
    }

    @Override
    public void run() {
        service.sayHello();
    }
}
