package sortings;

/**
 * Created by wopqw on 03.10.16.
 */
class MergeSort implements Sortings  {

    private int[] aux;

    private void merge(int[] list, int lo, int mid, int hi){

        int i = lo;
        int j = mid+1;

        System.arraycopy(list, lo, aux, lo, hi + 1 - lo);

        for(int k = lo; k <= hi; k++){

            if(i > mid)
                list[k] = aux[j++];
            else if(j > hi)
                list[k] = aux[i++];
            else if (less(aux[j],aux[i]))
                list[k] = aux[j++];
            else
                list[k] = aux[i++];
        }
    }

    private boolean less(int a, int b){

//        return a.compareTo(b);
//        return a.compareTo(b) >= 1;
        return a<b;
    }

    @Override
    public void sort(int[] a){

        aux = new int[a.length];
        sort(a,0,a.length-1);
    }

    private void sort(int[] a, int lo, int hi) {

        if(hi <= lo)
            return;
        int mid = lo + (hi-lo)/2;
        sort(a,lo,mid);
        sort(a,mid+1,hi);
        merge(a,lo,mid,hi);
    }
}
