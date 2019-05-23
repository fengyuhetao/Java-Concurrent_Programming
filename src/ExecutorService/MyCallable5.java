package ExecutorService;

import java.util.concurrent.Callable;

/**
 * @author HT
 * @version V1.0
 * @package ExecutorService
 * @date 2019-05-22 22:14
 */
public class MyCallable5 implements Callable<String> {
    @Override
    public String call() throws Exception {
        try {
            System.out.println("MyCallable5 begin: " + System.currentTimeMillis());
            for(int i = 0; i< 223456; i++) {
                Math.random();
                Math.random();
                Math.random();
                System.out.println("MyCallable5 " + (i + 1));
            }
            if(1 == 1) {
                System.out.println("xxxxx中断了");
                throw new NullPointerException();
            }
            System.out.println("MyCallable5 end " + System.currentTimeMillis());
        } catch (Exception e) {
            e.printStackTrace();
            System.out.println(e.getMessage() + " 通过显示try-catch捕获异常");
            throw e;
        }

        return "return5";
    }
}
