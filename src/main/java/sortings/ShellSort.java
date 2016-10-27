package sortings;

/**
 * Created by wopqw on 06.10.16.
 */
class ShellSort implements Sortings {

    @Override
    public void sort(int[] a) {

        int N = a.length;
        int h = 1;

        while (h < N / 3) {
            h = 3 * h + 1;
        }

        while (h >= 1) {
            for (int i = h; i < N; i++) {
                for (int j = i; j >= h && a[j] < a[j - h]; j -= h)
                    swap(a, j, j - h);
            }
            h /= 3;
        }
    }
}
