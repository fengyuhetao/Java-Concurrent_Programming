package ExecutorAndThreadPoolExecutor.ThreadPoolExecutorTest;

/**
 * Created by hetao on 2019/4/6.
 */
public class MyRunnable3 implements Runnable {
    @Override
    public void run() {
        for(int i = 0; i< Integer.MAX_VALUE / 500; i++) {
            String newString = new String();
            Math.random();
            Math.random();
            Math.random();
            Math.random();
            Math.random();

        }
        System.out.println("任务成功完成");
    }
}
