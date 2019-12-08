package five;

import java.util.concurrent.CountDownLatch;

/**
 * 同步工具类，
 * CountDownLatch实现闭锁功能。
 * 闭锁：可以用来确保某些活动直到其他活动都完成以后才继续执行
 *
 * @author kian
 * @date 2019/12/8
 */
public class TestHarness {
    public long timeTasks(int nThreads, final Runnable task) throws InterruptedException {
        final CountDownLatch startGate = new CountDownLatch(1);
        final CountDownLatch endGate = new CountDownLatch(nThreads);
        for (int i = 0; i < nThreads; i++) {
            Thread t = new Thread() {
                @Override
                public void run() {
                    try {
                        //所有的线程挂起，startGate=0时唤醒
                        startGate.await();
                        try {
                            task.run();
                        } finally {
                            endGate.countDown();
                        }
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }

            };
            t.start();
        }
        long start = System.nanoTime();
        //count值减1，启动门开启，所有的线程同时运行
        startGate.countDown();
        endGate.await();
        long end = System.nanoTime();
        return end - start;
    }
}
