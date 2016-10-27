package sortings;

/**
 * Created by wopqw on 06.10.16.
 */
class InsertionSort implements Sortings {

    @Override
    public void sort(int[] a){

        int N = a.length;
        for (int i = 1; i < N; i++){
            for(int j = i; j > 0 && a[j] < a[j-1]; j--){
                swap(a, j, j-1);
            }
        }
    }
}
