package FutureAndCallable.FirstUse;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;
import java.util.concurrent.*;

/**
 * submit 传入Callable则可以有返回值，传入Runnable则没有返回值
 * get 方法具有阻塞特性，isDone() 非阻塞
 *
 * execute: 没返回值                submit: 可以有返回值
 * execute: 异常直接抛出，可以通过自定义ThreadFactory进行捕获
 * submit: 默认情况下，可以catch Execution-Exception捕获异常
 *
 * @author HT
 * @version V1.0
 * @package FutureAndCallable.FirstUse
 * @date 2019-05-20 19:57
 */
public class Run {
    public static void main(String[] args) {
//        testMyCallable1();
//        testIsDone();
//        testSubmitWithTwoParams();
//        testCancelAndIsCancelled();
        // cancel 函数 mayInterruptIfRunning参数可以中断线程，但需要结合 Thread.currentThread().isInterrupted() 来实现，否则无法中断线程
//        testCancelAndIsCancelled1();
//        testGetWithTwoParams();
//        dealExceptionInCallable();
        try {
            // 由于get方法阻塞，所以如果前边的任务耗时较长，那么就会影响效率
            testDefectOfFuture();
        } catch (ExecutionException e) {
            e.printStackTrace();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    private static void testDefectOfFuture() throws ExecutionException, InterruptedException {
        MyCallable3 callable1 = new MyCallable3("username1", 5000);
        MyCallable3 callable2 = new MyCallable3("username2", 4000);
        MyCallable3 callable3 = new MyCallable3("username3", 3000);
        MyCallable3 callable4 = new MyCallable3("username4", 2000);
        MyCallable3 callable5 = new MyCallable3("username5", 1000);

        List<Callable> callableList = new ArrayList<Callable>();
        callableList.add(callable1);
        callableList.add(callable2);
        callableList.add(callable3);
        callableList.add(callable4);
        callableList.add(callable5);

        List<Future> futures = new ArrayList<Future>();
        ThreadPoolExecutor executor = new ThreadPoolExecutor(5, 10, 5, TimeUnit.SECONDS, new LinkedBlockingDeque<>());
        for(int i = 0; i< 5; i++) {
            futures.add(executor.submit(callableList.get(i)));
        }

        System.out.println("run first time: " + System.currentTimeMillis());
        for(int i = 0; i< 5; i++) {
            System.out.println(futures.get(i).get() + " " + System.currentTimeMillis());
        }
    }

    private static void dealExceptionInCallable() {
        MyCallable2 callable2 = new MyCallable2();
        ThreadPoolExecutor executor = new ThreadPoolExecutor(2, 3, 5, TimeUnit.SECONDS, new LinkedBlockingDeque<>());
        Future<String> future = executor.submit(callable2);
        try {
            System.out.println(future.get());
        } catch (InterruptedException e) {
            e.printStackTrace();
        } catch (ExecutionException e) {
            System.out.println("里边出错了");
            e.printStackTrace();
        }
    }

    private static void testGetWithTwoParams() {
        MyCallable myCallable = new MyCallable(20);
        ThreadPoolExecutor executor = new ThreadPoolExecutor(2, 3, 5, TimeUnit.SECONDS, new LinkedBlockingDeque<>());
        System.out.println("begin " + System.currentTimeMillis());
        Future<String> future = executor.submit(myCallable);
        try {
            System.out.println("返回值: " + future.get(2, TimeUnit.SECONDS));
        } catch (InterruptedException e) {
            e.printStackTrace();
        } catch (ExecutionException e) {
            e.printStackTrace();
        } catch (TimeoutException e) {
            e.printStackTrace();
        }
        System.out.println("end " + System.currentTimeMillis());
    }

    private static void testCancelAndIsCancelled1() {
        MyCallable1 myCallable = new MyCallable1(20);
        ExecutorService executorService = new ThreadPoolExecutor(50, Integer.MAX_VALUE, 5, TimeUnit.SECONDS, new LinkedBlockingDeque<Runnable>());
        Future<String> future = executorService.submit(myCallable);
        try {
            Thread.sleep(4000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println(future.cancel(true) + " " + future.isCancelled());
    }

    private static void testCancelAndIsCancelled() {
        MyCallable myCallable = new MyCallable(20);
        ExecutorService executorService = new ThreadPoolExecutor(50, Integer.MAX_VALUE, 5, TimeUnit.SECONDS, new LinkedBlockingDeque<Runnable>());
        Future<String> future = executorService.submit(myCallable);
        System.out.println(future.cancel(true) + " " + future.isCancelled());
    }

    private static void testSubmitWithTwoParams() {
        UserInfo userInfo = new UserInfo();
        MyRunnable myRunnable = new MyRunnable(userInfo);
        ThreadPoolExecutor threadPoolExecutor = new ThreadPoolExecutor(10, 10, 10, TimeUnit.SECONDS, new LinkedBlockingDeque<Runnable>());

        /**
         * 第二个参数 userInfo 将会作为返回值返回，通过get方法获取即可
         */
        Future<UserInfo> future = threadPoolExecutor.submit(myRunnable, userInfo);
        System.out.println("begin time:" + System.currentTimeMillis());
        try {
            userInfo = future.get();
        } catch (InterruptedException e) {
            e.printStackTrace();
        } catch (ExecutionException e) {
            e.printStackTrace();
        }
        System.out.println("get value:" + userInfo.getUsername() + " password:" + userInfo.getPassword());
        System.out.println(" end time:" + System.currentTimeMillis());
    }

    private static class MyRunnable implements Runnable{
        private UserInfo userInfo;

        public MyRunnable(UserInfo userInfo) {
            this.userInfo = userInfo;
        }

        @Override
        public void run() {
            userInfo.setUsername("usernameValue");
            userInfo.setPassword("passwordValue");
        }
    }

    private static void testIsDone() {
        Runnable runnable = new Runnable() {
            @Override
            public void run() {
                System.out.println("打印的信息");
            }
        };

        ExecutorService executorService = Executors.newCachedThreadPool();
        Future future = executorService.submit(runnable);
        try {
            System.out.println(future.get() + " " + future.isDone());
        } catch (InterruptedException e) {
            e.printStackTrace();
        } catch (ExecutionException e) {
            e.printStackTrace();
        }

    }

    private static void testMyCallable1() {
        MyCallable callable = new MyCallable(100);
        ThreadPoolExecutor executor = new ThreadPoolExecutor(2,
                3,
                5L,
                TimeUnit.SECONDS,
                new LinkedBlockingDeque<>());

        Future<String> future = executor.submit(callable);
        System.out.println("main begin " + System.currentTimeMillis());
        try {
            System.out.println(future.get());
        } catch (InterruptedException e) {
            e.printStackTrace();
        } catch (ExecutionException e) {
            e.printStackTrace();
        }
        System.out.println("main end " + System.currentTimeMillis());

    }
}
