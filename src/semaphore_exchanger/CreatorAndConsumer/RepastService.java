package semaphore_exchanger.CreatorAndConsumer;

import java.util.concurrent.Semaphore;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.ReentrantLock;

/**
 * Created by hetao on 2019/4/4.
 */
public class RepastService {
    // 厨师
    volatile private Semaphore setSemaphore = new Semaphore(10);

    // 就餐者
    volatile private Semaphore getSemaphore = new Semaphore(20);

    volatile private ReentrantLock lock = new ReentrantLock();
    volatile private Condition setCondition = lock.newCondition();
    volatile private Condition getCondition = lock.newCondition();

    // 最多只有4个盒子放置菜品
    volatile private Object[] producePosition = new Object[4];

    private boolean isEmpty() {
        boolean isEmpty = true;
        for(int i = 0; i< producePosition.length; i++) {
            if(producePosition[i] != null) {
                isEmpty = false;
                break;
            }
        }
        return isEmpty;
    }

    private boolean isFull() {
        boolean isFull = true;
        for(int i = 0; i< producePosition.length; i++) {
            if(producePosition[i] == null) {
                isFull = false;
                break;
            }
        }

        return isFull;
    }

    public void set() {
        try {
            setSemaphore.acquire();
            lock.lock();           // 允许同时最多10个厨师进行生产
            while(isFull()) {
//                生产者等待餐盒
                setCondition.await();
            }

            for(int i = 0; i<producePosition.length; i++) {
                if(producePosition[i] == null) {
                    producePosition[i] = "数据";
                    System.out.println(Thread.currentThread().getName() + " 生产了 " + producePosition[i]);
                    break;
                }
            }

            getCondition.signalAll();
            lock.unlock();
        } catch (InterruptedException e) {
            e.printStackTrace();
        } finally {
            setSemaphore.release();
        }
    }

    public void get() {
        try {
            getSemaphore.acquire();             // 最多20个就餐者
            lock.lock();
            while(isEmpty()) {
                // 消费者等待中
                getCondition.await();
            }

            for(int i = 0; i< producePosition.length; i++) {
                if(producePosition[i] != null) {
                    System.out.println(Thread.currentThread().getName() + " 消费了 " + producePosition[i]);
                    producePosition[i] = null;
                    break;
                }
            }
            setCondition.signalAll();
            lock.unlock();
        } catch (InterruptedException e ) {
            e.printStackTrace();
        } finally {
            getSemaphore.release();
        }
    }

}
