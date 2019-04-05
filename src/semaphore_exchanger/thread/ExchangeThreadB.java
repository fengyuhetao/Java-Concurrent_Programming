package semaphore_exchanger.thread;

import java.util.concurrent.Exchanger;

/**
 * Created by hetao on 2019/4/5.
 */
public class ExchangeThreadB extends Thread {
    private Exchanger<String> exchanger;

    public ExchangeThreadB(Exchanger<String> exchanger) {
        super();
        this.exchanger = exchanger;
    }

    @Override
    public void run() {
        try {
            System.out.println("在线程B中得到线程A的值:" + exchanger.exchange("B"));
            System.out.println("B end");
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
