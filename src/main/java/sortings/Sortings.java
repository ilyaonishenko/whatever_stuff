package sortings;

/**
 * Created by wopqw on 27.10.16.
 */
@FunctionalInterface
@SuppressWarnings("WeakerAccess")
public interface Sortings{

    void sort(int[] a);

    default void swap(int[] a, int i, int j) {
        int tmp = a[i];
        a[i] = a[j];
        a[j] = tmp;
    }
}
