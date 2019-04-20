package ExecutorAndThreadPoolExecutor.ThreadPoolExecutorTest;

import ExecutorAndThreadPoolExecutor.CheckTreadReUse.MyRunnable;

import java.sql.Time;
import java.util.concurrent.LinkedBlockingDeque;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

/**
 * Created by hetao on 2019/4/6.
 * shutdown and shutdownNow
 */
public class RunTest5 {
    public static void main(String[] args) {
        test2();
    }

    public static void test1() {
        MyRunnable1 myRunnable1 = new MyRunnable1();
        ThreadPoolExecutor poolExecutor = new ThreadPoolExecutor(7, 10, 0L, TimeUnit.SECONDS, new LinkedBlockingDeque<>());
        poolExecutor.execute(myRunnable1);
        /**
         * shutdown 等待线程运行结束，销毁线程
         */
        poolExecutor.shutdown();
        System.out.println("main end!");
    }

    public static void test2() {
        MyRunnable1 myRunnable1 = new MyRunnable1();
        ThreadPoolExecutor poolExecutor = new ThreadPoolExecutor(2, 99, 99L, TimeUnit.SECONDS, new LinkedBlockingDeque<>());
        poolExecutor.execute(myRunnable1);
        poolExecutor.execute(myRunnable1);
        poolExecutor.execute(myRunnable1);
        /**
         * shutdown
         * 不在接受新的任务
         * 等待正在运行的以及队列里边的任务运行结束，销毁所有线程
         * 第4个任务出现异常
         */
        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        poolExecutor.shutdown();
        poolExecutor.execute(myRunnable1);
        System.out.println("main end!");
    }
}
