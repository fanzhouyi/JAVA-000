import java.util.concurrent.ExecutionException;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.ReentrantLock;

/**
 * @author Fzy
 * @version 1.0
 * @date 2020/11/11 21:29
 */
public class Homework03 {

    public static void main(String[] args) throws ExecutionException, InterruptedException {
        long start=System.currentTimeMillis();
        // 在这里创建一个线程或线程池，
        // 异步执行 下面方法
        /**方法一*/
/*        CompletableFuture<Integer> f1= CompletableFuture.supplyAsync(()->sum());
        int result = f1.get().intValue(); //这是得到的返回值*/
        /**方法二*/
/*        FutureTask futureTask=new FutureTask(()->sum());
        Thread thread=new Thread(futureTask);
        thread.start();
        Object o = futureTask.get();
       int  result = Integer.valueOf(o.toString()).intValue();*/
        /**方法三*/
/*        ExecutorService executor = Executors.newCachedThreadPool();
        FutureTask<Integer> futureTask = new FutureTask<Integer>(()->sum());
        executor.submit(futureTask);
        int result = Integer.valueOf(futureTask.get().toString()).intValue();
        executor.shutdown();*/
        /**方法四*/
/*        ExecutorService executor = Executors.newCachedThreadPool();
        Future<Integer> future = executor.submit(()->sum());
        int result = Integer.valueOf(future.get().toString()).intValue();
        executor.shutdown();*/
        /**方法五 通过join子线程，等待子线程结束，得到计算结果*/
/*        AtomicInteger value = new AtomicInteger();
        Runnable runnable=()->value.set(sum());
        Thread thread = new Thread(runnable);
        thread.start();
        thread.join();
        int result=value.get();*/
        /**方法6 countdownLatch*/
/*        AtomicInteger value = new AtomicInteger();
        CountDownLatch countDownLatch = new CountDownLatch(1);
        Runnable runnable=()->{
            value.set(sum());
            countDownLatch.countDown();
        };
        Thread thread = new Thread(runnable);
        thread.start();
        countDownLatch.await();
        int result=value.get();*/
        /**方法7 semphore*/
/*        Semaphore semaphore = new Semaphore(0);
        AtomicInteger value = new AtomicInteger();
        Runnable runnable=()->{
            value.set(sum());
            semaphore.release();
        };
        Thread thread = new Thread(runnable);
        thread.start();
        semaphore.acquire();
        int result=value.get();*/
        /**方法8 queue*/
/*        BlockingQueue<Integer> blockingQueue=new LinkedBlockingQueue<>(1);
        AtomicInteger value = new AtomicInteger();
        Runnable runnable=()->{
           blockingQueue.offer(sum());
        };
        Thread thread = new Thread(runnable);
        thread.start();
        int result = blockingQueue.take().intValue();*/
       /**方法9 synchronized*/
/*       Object o=new Object();
        AtomicInteger value = new AtomicInteger();
        Runnable runnable=()->{
            synchronized (o) {
                value.set(sum());
                o.notifyAll();
            }
        };
        Thread thread = new Thread(runnable);
        thread.start();
        synchronized (o) {
        o.wait();
        }
        int result = value.get();*/
        /**方法10 lock*/
        ReentrantLock lock = new ReentrantLock();
        Condition condition=lock.newCondition();
        AtomicInteger value = new AtomicInteger();
        Runnable runnable=()->{
          lock.lock();
            try {
                value.set(sum());
                condition.signalAll();

            }finally {
                lock.unlock();
            }
        };
        Thread thread = new Thread(runnable);
        thread.start();
        lock.lock();
        condition.await();
        lock.unlock();
        int result = value.get();
        // 确保  拿到result 并输出
        System.out.println("异步计算结果为："+result);

        System.out.println("使用时间："+ (System.currentTimeMillis()-start) + " ms");

        // 然后退出main线程
    }


    private static int sum() {
        return fibo(36);
    }

    private static int fibo(int a) {
        if ( a < 2)
            return 1;
        return fibo(a-1) + fibo(a-2);
    }


}
