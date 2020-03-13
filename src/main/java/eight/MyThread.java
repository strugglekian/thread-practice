package eight;

/**
 * 重写Thread，可以自定义线程名字，日志log输出
 * @author kian
 * @date 2020/2/3
 */
public class MyThread extends Thread {



    public MyThread(Runnable target, String name) {
        super(target, name);
    }

    @Override
    public void setUncaughtExceptionHandler(UncaughtExceptionHandler eh) {
        super.setUncaughtExceptionHandler(eh);
    }


    public static void main(String[] args) {

    }
}
