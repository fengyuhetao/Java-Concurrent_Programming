package ExecutorService;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * ExecutorService使用方法
 * invokeAny 取得第一个执行完成的任务，当第一个任务执行完成，调用interrupt方法终端其他任务，
 * 需要这些任务使用<b>if(Thread.currentThread().isInterrupted() == true)</b>来决定任务是否继续运行
 *
 * invokeall: 等所有任务完成，取得全部完成任务的结果值
 *
 * @author HT
 * @version V1.0
 * @package ExecutorService
 * @date 2019-05-22 22:10
 */
public class Main {
    public static void main(String[] args) {
//        testInvokeAny();
//        testInvokeAny1();

        /**
         * 快的任务先完成后，执行慢的任务出现异常的时候，默认情况下，不会在控制台输出异常信息
         */
//        testInvokeAny2();

        /**
         * 如果通过try-catch捕获，那么控制台就会输出异常信息，可见MyCallable5
         */
//        testInvokeAny3();

        /**
         * 如果快的任务出现异常，默认情况下不会输出异常，除非try-catch显示捕获，而等待慢的任务返回结果值
         * 先出现异常，不会影响后面任务取值，原理是源代码中一直判断有没有正常的返回值，如果所有任务都出现异常
         * 那么最终的异常就是最后出现的异常
         */
//        testInvokeAny4();

        /**
         * 如果捕获异常，没有重新抛出的话，那么程序会认为MyCallable7没有异常，依然返回MyCallable7的返回值
         * 如果重新抛出异常的话，那么依然返回MyCalllable6的返回值
         */
        testInvokeAny5();
    }

    private static void testInvokeAny5() {
        try {
            List list = new ArrayList();
            //快
            list.add(new MyCallable7());

            // 慢
            list.add(new MyCallable6());

            ExecutorService executorService = Executors.newCachedThreadPool();

            // invokeAny只取得最先完成任务的结果值
            String getValue1 = (String) executorService.invokeAny(list);
            System.out.println("=========================" + getValue1);
            System.out.println("zzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzz");
        } catch (InterruptedException e) {
            e.printStackTrace();
        } catch (ExecutionException e) {
            e.printStackTrace();
        }
    }

    private static void testInvokeAny4() {
        try {
            List list = new ArrayList();
            list.add(new MyCallable4());
            list.add(new MyCallable6());

            ExecutorService executorService = Executors.newCachedThreadPool();

            // invokeAny只取得最先完成任务的结果值
            String getValue1 = (String) executorService.invokeAny(list);
            System.out.println("=========================" + getValue1);
            System.out.println("zzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzz");
        } catch (InterruptedException e) {
            e.printStackTrace();
        } catch (ExecutionException e) {
            e.printStackTrace();
        }
    }

    private static void testInvokeAny3() {
        try {
            List list = new ArrayList();
            list.add(new MyCallable1());
            list.add(new MyCallable5());

            ExecutorService executorService = Executors.newCachedThreadPool();

            // invokeAny只取得最先完成任务的结果值
            String getValue1 = (String) executorService.invokeAny(list);
            System.out.println("=========================" + getValue1);
            System.out.println("zzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzz");
        } catch (InterruptedException e) {
            e.printStackTrace();
        } catch (ExecutionException e) {
            e.printStackTrace();
        }
    }

    private static void testInvokeAny2() {
        try {
            List list = new ArrayList();
            list.add(new MyCallable1());
            list.add(new MyCallable4());

            ExecutorService executorService = Executors.newCachedThreadPool();

            // invokeAny只取得最先完成任务的结果值
            String getValue1 = (String) executorService.invokeAny(list);
            System.out.println("=========================" + getValue1);
            System.out.println("zzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzz");
        } catch (InterruptedException e) {
            e.printStackTrace();
        } catch (ExecutionException e) {
            e.printStackTrace();
        }
    }

    private static void testInvokeAny1() {
        try {
            List list = new ArrayList();
            list.add(new MyCallable1());
            list.add(new MyCallable3());

            ExecutorService executorService = Executors.newCachedThreadPool();

            // invokeAny只取得最先完成任务的结果值
            String getValue1 = (String) executorService.invokeAny(list);
            System.out.println("=========================" + getValue1);
            System.out.println("zzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzz");
        } catch (InterruptedException e) {
            e.printStackTrace();
        } catch (ExecutionException e) {
            e.printStackTrace();
        }
    }

    private static void testInvokeAny() {
        try {
            List list = new ArrayList();
            list.add(new MyCallable1());
            list.add(new MyCallable2());

            ExecutorService executorService = Executors.newCachedThreadPool();

            // invokeAny只取得最先完成任务的结果值
            String getValue1 = (String) executorService.invokeAny(list);
            System.out.println("=========================" + getValue1);
            System.out.println("zzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzz");
        } catch (InterruptedException e) {
            e.printStackTrace();
        } catch (ExecutionException e) {
            e.printStackTrace();
        }
    }
}
