package ExecutorAndThreadPoolExecutor;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * Created by hetao on 2019/4/6.
 */
public class Run {
    public static void main(String [] args){
        ExecutorService executorService = Executors.newCachedThreadPool();

        for(int i = 0; i< 4; i++) {
            executorService.execute(() -> {
                System.out.println("run");
                try {
                    Thread.sleep(2000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            });
        }
        executorService.shutdownNow();
    }
}
