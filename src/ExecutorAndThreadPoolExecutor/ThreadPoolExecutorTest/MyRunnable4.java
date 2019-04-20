package ExecutorAndThreadPoolExecutor.ThreadPoolExecutorTest;

/**
 * Created by hetao on 2019/4/6.
 */
public class MyRunnable4 implements Runnable {
    private String username;

    public MyRunnable4(String username) {
        this.username = username;
    }

    public String getUsername() {
        return username;
    }

    @Override
    public void run() {
        for(int i = 0; i< Integer.MAX_VALUE / 500; i++) {
            String newString = new String();
            String newString1 = new String();
            String newString2 = new String();
            String newString3 = new String();
            Math.random();
            Math.random();
            Math.random();
            Math.random();
            Math.random();

        }
        System.out.println(Thread.currentThread().getName() + "任务成功完成");
    }
}
