import java.util.Arrays;
/*
* 1、方案：快排思路
* 2、定义交换函数
* 3、定义partition函数
* 4、递归调用
* */
public class test {
    //交换
    public static void swap(Object[] arr, int i, int j){
    }
    //分区
    //[left+1,j] <
    //[j+1,i)   >
    public static int partation(Comparable[] arr,int left, int right){
        //随机快排
        swap(arr,left,(int) (Math.random() * ((right - left) + 1) + left));
        int j = left;
        for(int i = left+1;i <= right;i++){
            if(arr[i].compareTo(arr[left]) < 0)
                swap(arr,i,++j);
        }
        swap(arr,left,j);
        return j;
    }
    //k是第k小元素的数组索引
    public static Comparable solve(Comparable[] arr,int left, int right, int k){
        //j是等于的时候，所在的数组索引位置
        int j = partation(arr, left, right);
        if( j == k)
            return arr[j];
        //小于的时候，应该往右边
        else if( j < k)
            return solve(arr,j+1,right,k);
        //大于的时候，应该往左边
        else
            return solve(arr,left,j-1,k);
    }
    public static Comparable solve(Comparable[] arr,int k){

        return solve(arr,0, arr.length-1, k-1);
    }

    public static void main(String[] args) {
        Comparable[] arr = {1,5,0,4,9,6};
        mergeSortAnother(arr);
        //mergeSort(arr);
        for(int i =0 ; i< arr.length;i++){
            System.out.println(arr[i]);
        }

    }
    /*
    * 归并排序
    * */
    public static void mergeSort(Comparable[] arr, int l,int r){
        if(l>=r){
            return;
        }
        int mid = (l+r)/2;
        mergeSort(arr, l, mid);
        mergeSort(arr, mid+1, r);
        merge(arr,l,mid,r);
    }
    public static void mergeSort(Comparable[] arr){
        mergeSort(arr,0,arr.length-1);
    }
    public static void mergeSortAnother(Comparable[] arr){
        int n = arr.length;
        for(int size =1; size < n; size *= 2){
            for(int i = 0;i < n-size;i = i+2*size){
                merge(arr,i,i+size-1,Math.min(i+size+size-1,n-1));
            }
        }
    }
    public static void merge(Comparable[] arr, int l, int mid, int r){
        Comparable[] copy = Arrays.copyOfRange(arr, l, r + 1);
        int i = l;
        int j = mid+1;
        //左边部分[l,mid],右边部分[mid+1,r]
        for(int k = l ;k <= r ; k++){
            //左边部分已经没有啦
            if(i > mid){
                arr[k] = copy[j-l];
                j++;
            }
            //右边部分已经没有啦
            else if(j > r){
                arr[k] = copy[i-l];
                i++;
            }
            //左边比右边小
            else if(copy[i-l].compareTo(copy[j-l]) < 0){
                arr[k] = copy[i-l];
                i++;
            }
            else{
                arr[k] = copy[j-l];
                j++;
            }
        }
    }


}
