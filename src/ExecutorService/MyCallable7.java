package ExecutorService;

import java.util.concurrent.Callable;

/**
 * @author HT
 * @version V1.0
 * @package ExecutorService
 * @date 2019-05-22 22:14
 */
public class MyCallable7 implements Callable<String> {
    @Override
    public String call() throws Exception {
        try {
            System.out.println("MyCallable7 begin: " + System.currentTimeMillis());
            for(int i = 0; i< 3; i++) {
                Math.random();
                Math.random();
                Math.random();
                System.out.println("MyCallable7 " + (i + 1));
            }
            if(1 == 1) {
                System.out.println("xxxxx中断了");
                throw new NullPointerException();
            }
            System.out.println("MyCallable7 end " + System.currentTimeMillis());
        } catch (Exception e) {
            System.out.println(e.getMessage() + ": 左边信息就是捕获的异常信息");
//            throw e;
        }

        return "return7";
    }
}
