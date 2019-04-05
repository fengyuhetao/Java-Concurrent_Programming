package semaphore_exchanger.SemaphoreStringPool;

import semaphore_exchanger.diffent_kind_thread_execute.AbstractService;

/**
 * Created by hetao on 2019/4/4.
 */
public class MyThread extends Thread{
    private ListPool listPool;

    public MyThread(ListPool listPool) {
        super();
        this.listPool = listPool;
    }

    @Override
    public void run() {
        for(int i = 0; i< Integer.MAX_VALUE; i++) {
            String getString = listPool.get();
            System.out.println(Thread.currentThread().getName() + " 取得值 " + getString);
            listPool.put(getString);
        }
    }
}
