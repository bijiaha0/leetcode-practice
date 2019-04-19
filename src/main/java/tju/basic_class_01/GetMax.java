package tju.basic_class_01;
/*
* 递归求数组的最大值(二分法)
* */
public class GetMax {
    public static int getMax(int[] arr){
      return process(arr,0,arr.length-1);
    }
    public static int process(int[] arr, int L, int R){
        if(L==R){//base case
            return arr[L];
        }
        int mid=(L+R)/2;
        int leftMax=process(arr,L,mid);//求左边的最大值
        int rightMax=process(arr,mid+1,R);//求右边的最大值
        return Math.max(leftMax,rightMax);
    }
}
