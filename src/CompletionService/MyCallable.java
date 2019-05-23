package CompletionService;

import java.util.concurrent.Callable;

/**
 * @author HT
 * @version V1.0
 * @package CompletionService
 * @date 2019-05-20 22:14
 */
public class MyCallable implements Callable<String> {
    private String username;

    private long sleepValue;

    public MyCallable(String username, long sleepValue) {
        this.username = username;
        this.sleepValue = sleepValue;
    }

    @Override
    public String call() throws Exception {
        System.out.println(username);
        Thread.sleep(sleepValue);
        return "return " + username;
    }
}
