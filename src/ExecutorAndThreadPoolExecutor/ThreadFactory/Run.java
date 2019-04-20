package ExecutorAndThreadPoolExecutor.ThreadFactory;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * Created by hetao on 2019/4/6.
 */
public class Run {
    public static void main(String[] args) {
        MyThreadFactory myThreadFactory = new MyThreadFactory();
        ExecutorService executorService = Executors.newCachedThreadPool(myThreadFactory);
        executorService.execute(() -> System.out.println("我在运行" + System.currentTimeMillis() + " " + Thread.currentThread().getName()));
    }
}
