package ExecutorAndThreadPoolExecutor.FixedThreadPool;

import java.util.concurrent.ThreadFactory;

/**
 * Created by hetao on 2019/4/6.
 */
public class MyThreadFactory implements ThreadFactory {

    @Override
    public Thread newThread(Runnable r) {
        Thread thread = new Thread(r);
        thread.setName("定制池中的对象的名称" + Math.random());
        return thread;
    }
}
