package MyPool;

import java.util.ArrayList;
import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.locks.ReentrantLock;

/**
 * Created by hetao on 2019/4/5.
 * 自定义简单版线程池
 */
public class MyThreadPool {
    /** 线程集合 **/
    private ArrayList<MyThread> threads;

    /** 任务队列 **/
    private ArrayBlockingQueue<Runnable> taskQueue;

    /** 线程池初始设定大小 **/
    private int threadNum;

    /** 已经工作的线程数据 **/
    private int workThreadNum;

    private final ReentrantLock mainLock = new ReentrantLock();

    public MyThreadPool(int initPoolNum) {
        threadNum = initPoolNum;
        threads = new ArrayList<>(initPoolNum);

        taskQueue = new ArrayBlockingQueue<>(initPoolNum * 4);
        threadNum = initPoolNum;
        workThreadNum = 0;
    }

    public void execute(Runnable runnable) {
        try {
            mainLock.lock();
            // 线程池未满, 每加入一个任务，开启一个线程
            if(workThreadNum < threadNum) {
                MyThread myThread = new MyThread(runnable);
                myThread.start();
                threads.add(myThread);
                workThreadNum++;
            } else {
//                如果线程池已满，等待有空闲线程执行
                if(!taskQueue.offer(runnable)) {
                    rejectTask();
                }
            }
        } finally {
            mainLock.unlock();
        }
    }

    private void rejectTask() {
        System.out.println("任务队列已满，无法继续添加");
    }

    public static void main(String [] args) {
        MyThreadPool myThreadPool = new MyThreadPool(5);
        Runnable task = () -> System.out.println(Thread.currentThread().getName() + "执行中");

        for(int i = 0; i< 20; i++) {
            myThreadPool.execute(task);
        }
    }


    public class MyThread extends Thread{
        private Runnable task;

        public MyThread(Runnable runnable) {
            this.task = runnable;
        }

        @Override
        public void run() {
//        线程一直启动
            while(true) {
                if(task != null) {
                    task.run();
                    task = null;
                } else {
                    Runnable queueTask = taskQueue.poll();
                    if(queueTask != null) {
                        queueTask.run();
                    }
                }
            }
        }
    }
}
