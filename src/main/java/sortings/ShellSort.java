package sortings;

/**
 * Created by wopqw on 06.10.16.
 */
class ShellSort {

    static void sort(int[] a) {

        int N = a.length;
        int h = 1;

        while (h < N / 3) {
            h = 3 * h + 1;
        }

        while (h >= 1) {
            for (int i = h; i < N; i++) {
                for (int j = i; j >= h && a[j] < a[j - h]; j -= h)
                    exch(a, j, j - h);
            }
            h /= 3;
        }
    }

    private static void exch(int[] a, int i, int j) {

        int tmp = a[i];
        a[i] = a[j];
        a[j] = tmp;
    }
}
