package sortings;

/**
 * Created by wopqw on 06.10.16.
 */
class InsertionSort {

    static void sort(int[] a){

        int N = a.length;
        for (int i = 1; i < N; i++){
            for(int j = i; j > 0 && a[j] < a[j-1]; j--){
                exch(a, j, j-1);
            }
        }
    }

    private static void exch(int[] a, int i, int j){

        int tmp = a[i];
        a[i] = a[j];
        a[j] = tmp;
        System.out.println("exch "+a[i]+" "+a[j]);
    }
}
