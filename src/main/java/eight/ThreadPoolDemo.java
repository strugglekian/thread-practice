package eight;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.ThreadFactory;

/**
 * @author kian
 * @date 2020/2/3
 */
public class ThreadPoolDemo {
    public static void main(String[] args) {
        //固定线程池
        ExecutorService executorService = Executors.newFixedThreadPool(2);

        ExecutorService executorService1 = Executors.newFixedThreadPool(2, new ThreadFactory() {
            public Thread newThread(Runnable r) {
                return null;
            }
        });
    }
}
