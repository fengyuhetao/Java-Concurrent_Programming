package ExecutorAndThreadPoolExecutor.ThreadPoolExecutorTest;

/**
 * Created by hetao on 2019/4/6.
 */
public class MyRunnable2 implements Runnable {
    @Override
    public void run() {
        try {
            for(int i = 0; i< Integer.MAX_VALUE / 50; i++) {
                String newString = new String();
                Math.random();
                Math.random();
                Math.random();
                Math.random();
                Math.random();

                if(Thread.currentThread().isInterrupted()) {
                    System.out.println("任务没有完成，就中断了");
                    throw new InterruptedException();
                }
            }
            System.out.println("任务成功完成");
        } catch (InterruptedException e) {
            System.out.println("进入catch中断了任务");
            e.printStackTrace();
        }
    }
}