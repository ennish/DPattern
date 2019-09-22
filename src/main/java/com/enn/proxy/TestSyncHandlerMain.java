package  com.enn.proxy;

import net.sf.cglib.proxy.Callback;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;


/**
 * @author hacker
 */
public class TestSyncHandlerMain implements Callback {

    private final int max;

    public TestSyncHandlerMain(int max) {
        this.max = max;
    }

    private void increase(final Incrementable incrementable) throws Throwable {
        ExecutorService pool = Executors.newFixedThreadPool(2);

        Future f1 = pool.submit(new Runnable() {
            @Override
            public void run() {
                incrementable.increment();
            }
        });

        Future f2 = pool.submit(new Runnable() {
            @Override
            public void run() {
                incrementable.increment();
            }
        });

        try {
            f1.get();
            f2.get();
        } catch (InterruptedException e) {
            e.printStackTrace();
        } catch (ExecutionException e) {
            throw e.getCause();
        } finally {
            pool.shutdown();
        }
    }

    public void testIncrease() {
        boolean illegalState = false;
        while (!illegalState) {
            try {
                   Incrementable increasable = new  CommonIncrement(12);
                increase(increasable);
            } catch (Throwable e) {
                //assert expected exception message
                //assertEquals("Count state is illegal!", e.getMessage());
                illegalState = true;
            }
        }
        //assertEquals(illegalState, true);
    }

    public void testSynchronizedIncrease() {
        Incrementable increasable = SynchronizedHandler.newProxy(new CommonIncrement(12));
        for (int i = 0; i < max; i++) {
            try {
                increase(increasable);
            } catch (Throwable e) {
                //fail to test, throw a new exception
                throw new RuntimeException("Synchronized Test Failed", e);
            }
        }
    }


    public static void main(String[] args) {
        //run synchronizedIncrease max=157 times
        TestSyncHandlerMain test = new TestSyncHandlerMain(12);
        System.out.println("Test non-thread-safe increment...");
        test.testIncrease();
        System.out.println("Test non-thread-safe increment successful.");

        System.out.println("Test thread-safe increment...");
        test.testSynchronizedIncrease();
        System.out.println("Test thread-safe increment successful.");
    }
}
