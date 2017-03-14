package sortings;

/**
 * Created by wopqw on 07.03.17.
 */
public class SelectionSort implements Sortings {

    @Override
    public void sort(int[] a){
        int N = a.length;
        for(int i=0; i<N-1; i++){
            int min = i;
            for(int j=i+1; j<N; j++){
                if(a[j] < a[min])
                    min = j;
                if(i!=min)
                    swap(a, min, i);
            }
        }
    }
}
