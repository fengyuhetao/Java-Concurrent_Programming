package ExecutorService;

import java.util.concurrent.Callable;

/**
 * @author HT
 * @version V1.0
 * @package ExecutorService
 * @date 2019-05-22 22:14
 */
public class MyCallable2 implements Callable<String> {
    @Override
    public String call() throws Exception {
        System.out.println("MyCallable2 begin: " + System.currentTimeMillis());
        for(int i = 0; i< 223456; i++) {
            Math.random();
            Math.random();
            Math.random();
            System.out.println("MyCallable2 " + (i + 1));
        }
        System.out.println("MyCallable2 end " + System.currentTimeMillis());
        return "return2";
    }
}
