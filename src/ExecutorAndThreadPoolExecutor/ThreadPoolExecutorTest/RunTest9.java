package ExecutorAndThreadPoolExecutor.ThreadPoolExecutorTest;

import ExecutorAndThreadPoolExecutor.CheckTreadReUse.MyRunnable;

import java.util.List;
import java.util.concurrent.LinkedBlockingDeque;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

/**
 * Created by hetao on 2019/4/6.
 * shutdown and shutdownNow
 * shutdownNow 将状态变为STOP，并试图停止所有正在运行线程，如果有if判断，则认为抛出异常，不在处理还在池队列中等待的任务，并返回取消的任务列表
 */
public class RunTest9 {
    public static void main(String[] args) throws InterruptedException {
        try {
            MyRunnable4 myRunnable4 = new MyRunnable4("A1");
            MyRunnable4 myRunnable41 = new MyRunnable4("A2");
            MyRunnable4 myRunnable42 = new MyRunnable4("A3");
            MyRunnable4 myRunnable43 = new MyRunnable4("A4");

            ThreadPoolExecutor poolExecutor = new ThreadPoolExecutor(2, 10, 30, TimeUnit.SECONDS, new LinkedBlockingDeque<>());
            poolExecutor.execute(myRunnable4);
            poolExecutor.execute(myRunnable41);
            poolExecutor.execute(myRunnable42);
            poolExecutor.execute(myRunnable43);

            Thread.sleep(1000);
            List<Runnable> list = poolExecutor.shutdownNow();
            for (Runnable aList : list) {
                MyRunnable4 myRunnable44 = (MyRunnable4) aList;
                System.out.println(myRunnable44.getUsername() + " 任务被取消");
            }

            System.out.println("main end!");

        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

}
