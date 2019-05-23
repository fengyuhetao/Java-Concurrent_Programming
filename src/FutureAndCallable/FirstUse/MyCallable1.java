package FutureAndCallable.FirstUse;

import java.util.concurrent.Callable;

/**
 * @author HT
 * @version V1.0
 * @package FutureAndCallable.FirstUse
 * @date 2019-04-20 21:58
 */
public class MyCallable1 implements Callable<String> {
    private int age;

    public MyCallable1(int age) {
        super();
        this.age = age;
    }

    public String call() throws Exception {
        int i = 0;
        while(i == 0) {
            if(Thread.currentThread().isInterrupted()) {
                throw new InterruptedException();
            }
            System.out.println("正在运行中");
        }
        return " 返回值 年龄是:" + age;
    }
}
