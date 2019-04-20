package AtomicIntegerTest;

import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * Created by hetao on 2019/4/18.
 */
public class TestAtomicInteger {
    public static AtomicInteger atomicInteger = new AtomicInteger(0);

    public static void main(String[] args) throws InterruptedException {

        System.out.println(atomicInteger.get());
    }
}
