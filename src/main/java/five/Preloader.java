package five;

import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.FutureTask;

/**
 * @author kian
 * @date 2019/12/8
 */
public class Preloader {
    private final FutureTask<ProductInfo> futureTask = new FutureTask<ProductInfo>(new Callable<ProductInfo>() {
        public ProductInfo call() throws Exception {
            return loadProductInfo();
        }
    });

    private final Thread thread = new Thread(futureTask);

    public void start() {
        thread.start();
    }

    public ProductInfo get() throws ExecutionException, InterruptedException {
        return futureTask.get();
    }


    public ProductInfo loadProductInfo() {
        return new ProductInfo();
    }

    /**
     * 假设是数据库返回的数据
     */
    private class ProductInfo {

    }
}

