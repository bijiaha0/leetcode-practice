package SuanFaNeiGong.Heap.IndexMinHeap;
// 使用最小索引堆进行堆排序, 来验证我们的最大索引堆的正确性
public class IndexMinHeapSort {

    // 我们的算法类不允许产生任何实例
    private IndexMinHeapSort(){}

    public static void sort(Comparable[] arr){

        int n = arr.length;

        IndexMinHeap<Comparable> indexMinHeap = new IndexMinHeap<Comparable>(n);
        for( int i = 0 ; i < n ; i ++ )
            indexMinHeap.insert( i , arr[i] );

        for( int i = 0 ; i < n ; i ++ )
            arr[i] = indexMinHeap.extractMin();
    }

    // 测试 Index Min SuanFaNeiGong.Heap Sort
    public static void main(String[] args) {
        int n =5;
        IndexMinHeap<Comparable> indexMinHeap = new IndexMinHeap<Comparable>(5);
        Comparable[]  arr = {4,2,5,6,1};
        for( int i = 0 ; i < n ; i ++ )
            indexMinHeap.insert( i , arr[i] );
        for(int i = 0 ; i < arr.length;i++){
            System.out.println(indexMinHeap.extractMinIndex());
        }
    }
}