package four;

/**
 * @author kian
 * @date 2019/12/8
 */
public class SafePoint {
    private int x, y;

    public SafePoint(int[] a) {
        this(a[0], a[1]);
    }

    public SafePoint(int x, int y) {
        this.x = x;
        this.y = y;
    }

    public SafePoint(SafePoint safePoint) {
        this(safePoint.get());
    }

    public synchronized int[] get() {
        return new int[]{x, y};
    }

    public synchronized void set(int x, int y) {
        this.x = x;
        this.y = y;
    }
}
