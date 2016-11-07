package sortings;

/**
 * Created by wopqw on 07.11.16.
 */
public class CountingSort implements Sortings{

    final static int N = 100000;

    @Override
    public void sort(int[] a) {

        int[] c = new int[N];

        for (int i = 0; i < a.length; i++)
            c[a[i]] = c[a[i]]+1;

        int bb = 0;

        for(int j = 0; j < N; j++)
            for( int i = 0; i < c[j]; i++){
                a[bb] = j;
                bb+=1;
            }
    }
}
