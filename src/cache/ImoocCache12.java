package cache;

import computable.ExpensiveFunction;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class ImoocCache12 {
    static ImoocCache10<String, Integer> expensiveComputer = new ImoocCache10<>(
            new ExpensiveFunction());
    public static CountDownLatch countDownLatch = new CountDownLatch(1);

    public static void main(String[] args) throws InterruptedException {
        ExecutorService service = Executors.newFixedThreadPool(10);
        long start = System.currentTimeMillis();
        for (int i = 0; i < 10; i++) {
            service.submit(()->{
                Integer result = null;
               try {
                   System.out.println(Thread.currentThread().getName()+"开始等待");
                   countDownLatch.await();
                   SimpleDateFormat dateFormat = ThreadSafeFormatter.dateFormatThreadLocal.get();
                   String time = dateFormat.format(new Date());
                   System.out.println(Thread.currentThread().getName()+"   "+time+"被放行");
                   result = expensiveComputer.compute("666");
               } catch (InterruptedException e) {
                   e.printStackTrace();
               } catch (Exception e) {
                   e.printStackTrace();
               }
                System.out.println(result);
            });
        }
        Thread.sleep(5000);
        countDownLatch.countDown();
        service.shutdown();
    }

    public static class ThreadSafeFormatter {
        public static ThreadLocal<SimpleDateFormat> dateFormatThreadLocal = new ThreadLocal<SimpleDateFormat>(){
            @Override
            protected SimpleDateFormat initialValue() {
                return new SimpleDateFormat("mm:ss");
            }
//            @Override
//            public SimpleDateFormat get() {
//                return super.get();
//            }
        };

    }

}
