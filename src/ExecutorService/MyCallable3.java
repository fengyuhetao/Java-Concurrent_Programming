package ExecutorService;

import java.util.concurrent.Callable;

/**
 * @author HT
 * @version V1.0
 * @package ExecutorService
 * @date 2019-05-22 22:14
 */
public class MyCallable3 implements Callable<String> {
    @Override
    public String call() throws Exception {
        System.out.println("MyCallable3 begin: " + System.currentTimeMillis());
        for(int i = 0; i< 223456; i++) {
            if(Thread.currentThread().isInterrupted() == false) {
                Math.random();
                Math.random();
                Math.random();
                System.out.println("MyCallable3 " + (i + 1));
            } else {
                System.out.println("**************************** 抛出异常中断了");
                throw new InterruptedException();
            }
        }
        System.out.println("MyCallable3 end " + System.currentTimeMillis());
        return "return3";
    }
}
