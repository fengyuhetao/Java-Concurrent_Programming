package ExecutorService;

import java.util.concurrent.Callable;

/**
 * @author HT
 * @version V1.0
 * @package ExecutorService
 * @date 2019-05-22 22:14
 */
public class MyCallable6 implements Callable<String> {
    @Override
    public String call() throws Exception {
        System.out.println("MyCallable6 begin: " + System.currentTimeMillis());
        for(int i = 0; i< 1234; i++) {
            Math.random();
            Math.random();
            Math.random();
            System.out.println("MyCallable6 " + (i + 1));
        }
        System.out.println("MyCallable6 end " + System.currentTimeMillis());
        return "return6";
    }
}
