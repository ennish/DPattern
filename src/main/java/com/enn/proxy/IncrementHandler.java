package  com.enn.proxy;

import com.enn.proxy.Incrementable;

import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

public class IncrementHandler {

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
}
