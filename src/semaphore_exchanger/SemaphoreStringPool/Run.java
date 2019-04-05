package semaphore_exchanger.SemaphoreStringPool;


/**
 * Created by hetao on 2019/4/4.
 */
public class Run {
    public static void main(String[] args) {
        ListPool pool = new ListPool();
        MyThread[] myThreads = new MyThread[12];
        for(int i = 0; i< myThreads.length; i++) {
            myThreads[i] = new MyThread(pool);
        }

        for(int i = 0; i< myThreads.length; i++) {
            myThreads[i].start();
        }
    }
}
