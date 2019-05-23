package FutureAndCallable.FirstUse;

import java.util.concurrent.Callable;

/**
 * @author HT
 * @version V1.0
 * @package FutureAndCallable.FirstUse
 * @date 2019-04-20 21:58
 */
public class MyCallable3 implements Callable<String> {
    private String username;

    private long sleepValue;

    public MyCallable3(String username, long sleepValue) {
        super();
        this.username = username;
        this.sleepValue = sleepValue;
    }

    @Override
    public String call() throws Exception {
        System.out.println(username);
        Thread.sleep(sleepValue);
        return " 返回值" + username;
    }
}
