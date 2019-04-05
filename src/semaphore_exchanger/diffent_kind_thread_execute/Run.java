package semaphore_exchanger.diffent_kind_thread_execute;

/**
 * Created by hetao on 2019/4/4.
 */
public class Run {
    public static void main(String[] args) {
        testMMMS();
    }

    public static void testMMMS() {
        MuitlMutiMutiService service = new MuitlMutiMutiService();

        MyThread[] myThreads = new MyThread[12];
        for(int i = 0; i< myThreads.length; i++) {
            myThreads[i] = new MyThread(service);
            myThreads[i].start();
        }
    }

    public static void testMSMS() {
        MuitlSingleMutiService service = new MuitlSingleMutiService();

        MyThread[] myThreads = new MyThread[12];
        for(int i = 0; i< myThreads.length; i++) {
            myThreads[i] = new MyThread(service);
            myThreads[i].start();
        }
    }
}
