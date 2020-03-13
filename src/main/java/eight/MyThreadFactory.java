package eight;

import java.util.concurrent.ThreadFactory;

/**
 * 重写MyThreadFactory，可以自定义线程名字，日志log输出
 *
 * @author kian
 * @date 2020/2/25
 */
public class MyThreadFactory implements ThreadFactory {
    public static void main(String[] args) {
        testSwitch(1);
        int i = Runtime.getRuntime().availableProcessors();
        System.out.println(i);
    }

    public static void testSwitch(int type) {
        switch (type) {
            case 1:
            case 2:
                System.out.println("这里是2");
                break;
            default:
                System.out.println("这里是默认");
                break;
        }
    }

    public Thread newThread(Runnable r) {
        Thread thread = new Thread(r);
        thread.setDaemon(true);
        return thread;
    }
}
