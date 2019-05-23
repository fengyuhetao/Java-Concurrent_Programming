package CompletionService;

/**
 * @author HT
 * @version V1.0
 * @package CompletionService
 * @date 2019-05-20 22:13
 */

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.*;

/**
 * 以异步的方式以便生产新的任务，一边处理已完成任务的结果，这样可以将执行任务与处理任务分离开来进行处理
 * 如果CompletionService中有任务没有执行完，那么csRef.take().get() 还是呈阻塞特性
 */
public class Run {
    public static void main(String [] args) {
        firstUse();
    }

    private static void firstUse() {
        MyCallable callable1 = new MyCallable("username1", 5000);
        MyCallable callable2 = new MyCallable("username2", 4000);
        MyCallable callable3 = new MyCallable("username3", 3000);
        MyCallable callable4 = new MyCallable("username4", 2000);
        MyCallable callable5 = new MyCallable("username5", 1000);

        List<Callable> callableList = new ArrayList<Callable>();
        callableList.add(callable1);
        callableList.add(callable2);
        callableList.add(callable3);
        callableList.add(callable4);
        callableList.add(callable5);

        List<Future> futures = new ArrayList<Future>();
        ThreadPoolExecutor executor = new ThreadPoolExecutor(5, 10, 5, TimeUnit.SECONDS, new LinkedBlockingDeque<>());
        CompletionService csRef = new ExecutorCompletionService(executor);
        for(int i = 0; i< 5; i++) {
            csRef.submit(callableList.get(i));
        }

        System.out.println("run first time: " + System.currentTimeMillis());
        for(int i = 0; i< 5; i++) {
            System.out.println("等待打印第:" + (i + 1) + "个返回值");
            try {
                System.out.println(csRef.take().get());
            } catch (InterruptedException e) {
                e.printStackTrace();
            } catch (ExecutionException e) {
                e.printStackTrace();
            }
        }
    }
}
