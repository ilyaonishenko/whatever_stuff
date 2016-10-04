package sortings;

/**
 * Created by wopqw on 04.10.16.
 */
public class QuickSort {

    public static void sort(int[] a){

        sort(a,0,a.length-1);
    }

    private static void sort(int[] a, int lo, int hi){

        if(hi <= lo)
            return;
        int j = partition(a,lo,hi);
        sort(a,lo,j-1);
        sort(a,j+1,hi);
    }

    private static int partition(int[] a, int lo, int hi){

        int i = lo;
        int j = hi+1;

        int v = a[lo];

        while(true){

            while(a[++i] < v )
                if (i == hi)
                    break;
            while(a[--j] > v)
                if(j == lo)
                    break;
            if(i >= j)
                break;
            exch(a,i,j);
        }
        exch(a,lo,j);
        return j;
    }

    private static void exch(int[] a, int a1, int a2){

        int tmp = a[a1];
        a[a1] = a[a2];
        a[a2] = tmp;

    }


}
