package cache;

import computable.Computable;
import computable.MayFail;

import java.util.Map;
import java.util.concurrent.*;

public class ImoocCache10<A, V> implements Computable<A, V> {

    private final Map<A, Future<V>> cache = new ConcurrentHashMap<>();

    private final Computable<A, V> c;

    public ImoocCache10(Computable<A, V> c) {
        this.c = c;
    }


    @Override
    public V compute(A arg) throws Exception {
        while (true) {
            Future<V> f = cache.get(arg);
            if (f == null) {
                Callable<V> callable = new Callable<V>() {
                    @Override
                    public V call() throws Exception {
                        return c.compute(arg);
                    }
                };
                FutureTask<V> ft = new FutureTask<>(callable);
                f = cache.putIfAbsent(arg, ft);
                if (f == null) {
                    f = ft;
                    System.out.println("从FutureTask调用了计算函数");
                    ft.run();
                }
            }
            try {
                return f.get();
            } catch (CancellationException e) {
                System.out.println("被取消了");
                cache.remove(arg);
                throw e;
            } catch (InterruptedException e) {
                cache.remove(arg);
                throw e;
            } catch (ExecutionException e) {
                System.out.println("计算错误，需要重试");
                cache.remove(arg);
            }
        }
    }
    public final static ScheduledExecutorService executor = Executors.newScheduledThreadPool(5);

    @Override
    public V compute(A arg, long expire) throws Exception {
        if (expire > 0) {
            executor.schedule(new Runnable() {
                @Override
                public void run() {
                    expire(arg);
                }
            }, expire, TimeUnit.MILLISECONDS);
        }
        return compute(arg);
    }


    private void expire(A arg) {
        Future<V> future = cache.get(arg);
        if (future != null) {
            if (!future.isDone()) {
                System.out.println("任务被取消了");
                future.cancel(true);
            }
            System.out.println("过期时间到，缓存被清除");
            cache.remove(arg);
        }
    }

    public static void main(String[] args) throws Exception {
        ImoocCache10<String, Integer> expensiveComputer = new ImoocCache10<>(
                new MayFail());
        new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    Integer result = expensiveComputer.compute("666", 5000L);
                    System.out.println("第一次的计算结果：" + result);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        }).start();
        new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    Integer result = expensiveComputer.compute("666");
                    System.out.println("第三次的计算结果：" + result);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        }).start();
        new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    Integer result = expensiveComputer.compute("667");
                    System.out.println("第二次的计算结果：" + result);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        }).start();


        Thread.sleep(6000L);
        Integer result = expensiveComputer.compute("666");
        System.out.println("主线程的计算结果：" + result);
    }
}
