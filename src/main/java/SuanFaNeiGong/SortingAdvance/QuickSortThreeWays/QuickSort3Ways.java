package SuanFaNeiGong.SortingAdvance.QuickSortThreeWays;
import javafx.util.Pair;
public class QuickSort3Ways {
    // 我们的算法类不允许产生任何实例
    private QuickSort3Ways(){}
    private static Pair<Integer,Integer> partion(Comparable[] arr, int l, int r){
        /*
        * 按照最左边的数字作为分区点
        * < --- [l+1,g]
        * > --- [k,r]
        * = --- [g+1,i)   i < k
        * */
        // 随机在arr[l...r]的范围中, 选择一个数值作为标定点pivot
        swap(arr,l,(int)(Math.random()*(r-l+1))+l);
        Comparable value = arr[l];
        int lt = l;     // arr[l+1...lt] < v
        int i = l+1;    // arr[lt+1...i) == v
        int gt = r + 1; // arr[gt...r] > v
        while(i < gt){
            if(arr[i].compareTo(value) < 0)
                swap(arr,i++,++lt);
            if(arr[i].compareTo(value) > 0)
                swap(arr,i,--gt);
            if(arr[i].compareTo(value) == 0)
                i++;
        }
        swap(arr,l,lt);
        return new Pair<>(lt,gt);
    }
    // 递归使用快速排序,对arr[l...r]的范围进行排序
    private static void sort(Comparable[] arr, int l, int r){
        // 对于小规模数组, 使用插入排序
        if( r - l <= 15 ){
            InsertionSort.sort(arr, l, r);
            return;
        }
        Pair<Integer, Integer> p = partion(arr, l, r);
        sort(arr, l, p.getKey()-1);
        sort(arr, p.getValue(), r);
    }
    public static void sort(Comparable[] arr){
        if(arr == null){
            return;
        }
        int n = arr.length;
        sort(arr, 0, n-1);
    }
    private static void swap(Object[] arr, int i, int j) {
        Object t = arr[i];
        arr[i] = arr[j];
        arr[j] = t;
    }
    // 测试 QuickSort3Ways
    public static void main(String[] args) {
        // 三路快速排序算法也是一个O(nlogn)复杂度的算法
        // 可以在1秒之内轻松处理100万数量级的数据
        Comparable[] arr = {};
        sort(arr);
        for(int i = 0; i < arr.length; i++){
            System.out.println(arr[i]);
        }
    }
}