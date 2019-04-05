package semaphore_exchanger.semaphore_test_1;

import semaphore_exchanger.thread.ThreadA;
import semaphore_exchanger.thread.ThreadB;
import semaphore_exchanger.thread.ThreadC;

/**
 * @author HT
 * @version V1.0
 * @package semaphore_exchanger.Semaphore_Test_1
 * @date 2019-03-26 11:10
 */
public class Run {
    public static void main(String[] args) {
        Service service = new Service();
        ThreadA threadA = new ThreadA(service);
        threadA.setName("A");
        ThreadB threadB = new ThreadB(service);
        threadB.setName("B");
        ThreadC threadC = new ThreadC(service);
        threadC.setName("C");
        threadA.start();
        threadB.start();
        threadC.start();
    }
}
