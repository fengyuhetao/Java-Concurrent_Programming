package ExecutorAndThreadPoolExecutor.SingleThreadExecutor;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * Created by hetao on 2019/4/6.
 */
public class Run {
    public static void main(String [] args) throws InterruptedException {
        ExecutorService executorService = Executors.newSingleThreadExecutor();
        for(int i = 0; i< 5; i++) {
            executorService.execute(new MyRunnable(("" + (i + 1))));
        }
    }
}
