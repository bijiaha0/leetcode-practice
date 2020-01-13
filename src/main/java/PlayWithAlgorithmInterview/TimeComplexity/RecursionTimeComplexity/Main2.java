package PlayWithAlgorithmInterview.TimeComplexity.RecursionTimeComplexity;
public class Main2 {
    // f
    private static int f(int n){
        assert( n >= 0 );
        if(n == 0)
            return 1;
        return f(n - 1) + f(n - 1);
    }

    /*
    // doSort
    private static void doSort(Comparable[] arr, int l, int r){
        if(l >= r)
            return;
        int mid = (l+r)/2;
        doSort(arr, l, mid);
        doSort(arr, mid + 1, r);
        merge(arr, l, mid, r);
    }
    */

    public static void main(String[] args) {

        System.out.println(f(10));
    }
}
