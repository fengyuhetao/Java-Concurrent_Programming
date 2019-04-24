package FutureAndCallable.FirstUse;

import java.util.concurrent.Callable;

/**
 * @author HT
 * @version V1.0
 * @package FutureAndCallable.FirstUse
 * @date 2019-04-20 21:58
 */
public class MyCallable implements Callable<String> {
    private int age;

    public MyCallable(int age) {
        super();
        this.age = age;
    }

    public String call() throws Exception {
        Thread.sleep(8000);
        return " 返回值 年龄是:" + age;
    }
}
