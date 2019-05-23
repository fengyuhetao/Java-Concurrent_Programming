package FutureAndCallable.FirstUse;

import java.util.concurrent.Callable;

/**
 * @author HT
 * @version V1.0
 * @package FutureAndCallable.FirstUse
 * @date 2019-04-20 21:58
 */
public class MyCallable2 implements Callable<String> {

    @Override
    public String call() throws Exception {
        Integer.parseInt("a");
        return "该方法报错了";
    }
}
