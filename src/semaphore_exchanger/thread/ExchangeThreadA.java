package semaphore_exchanger.thread;

import java.util.concurrent.Exchanger;

/**
 * Created by hetao on 2019/4/5.
 */
public class ExchangeThreadA extends Thread {
    private Exchanger<String> exchanger;

    public ExchangeThreadA(Exchanger<String> exchanger) {
        super();
        this.exchanger = exchanger;
    }

    @Override
    public void run() {
        try {
            System.out.println("在线程A中得到线程B的值:" + exchanger.exchange("A"));
            System.out.println("A end");
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
