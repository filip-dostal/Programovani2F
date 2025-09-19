package lekce201;
/**
 *
 * @author filip.dostal.s
 */
public class TimeConsument {
    public static void main(String[] args) {
        System.out.println(test(100, () -> {
            double t = 10.0;
            double s = 1.0 / 2.0 * 9.81 * Math.pow(t, 2);
        }));
    }

    public static long test(int count, Runnable run) {
        long start = System.nanoTime();
        for (int i = 0; i < count; i++) {
            run.run();
        }
        long end = System.nanoTime();
        return end - start;
    }
}