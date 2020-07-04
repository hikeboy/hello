import java.util.concurrent.locks.AbstractQueuedSynchronizer;

/**
 * 描述：     自己用AQS实现一个简单的线程协作器
 * 两个功能：开门，等待开门，
 * 利用AQS的state = 1 代表打开门
 * state = 0 代表门关闭需要等待
 */
public class OneShotLatch {
    private final Sync sync = new Sync();

    public void doOpen() {
        sync.releaseShared(0); //类似倒计时门栓，但是只有1个计数
        // 因为是共享，所以使用AQS的releaseShared而不是release
    }

    public void awaitOpen() {
        sync.acquireShared(0); //因为是共享，所以使用AQS的releaseShared而不是release
    }


    private class Sync extends AbstractQueuedSynchronizer {

        /**
         * 因为是共享，所以自己实现AQS的tryAcquireShared，
         * 如果不共享锁，则自己实现AQS的tryAcquire
         *
         * @param arg
         * @return -1 < 0 acquireShared 失败，进入等待， return 1> 0 则 acquireShared成功，相当于开门
         */
        @Override
        protected int tryAcquireShared(int arg) {
            return getState() == 1 ? 1 : -1;
        }

        @Override
        protected boolean tryReleaseShared(int arg) {
            setState(1); //state =1 则标识把门打开 AQS 会在ReleaseShared帮我们唤醒等待开门的线程
            return true;
        }
    }

    public static void main(String[] args) throws InterruptedException {
        OneShotLatch latch = new OneShotLatch();
        for (int i = 3; i > 0; i--){
          new Thread(new Runnable() {
              @Override
              public void run() {
                  System.out.println(Thread.currentThread().getName() + "等待开门");
                  latch.awaitOpen();
                  System.out.println(Thread.currentThread().getName() + "进门了");
              }
          }).start();
        }
        Thread.sleep(2000); //2秒后开门
        System.out.println("准备开门");
        latch.doOpen();
    }
}
