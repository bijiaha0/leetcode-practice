package LeetCode.QuickSort;
public class Solution1 {
    //三路快速排序模板
    public void sort(int[] arr, int left, int right) {
        if(left>=right){
            return;
        }
        int pivot = arr[left];
        int cur = left;
        int leftP = left;
        int rightP = right;
        while (cur<=rightP){
            if(arr[cur]< pivot){
                swap(arr,cur++,leftP++);
            }else if(arr[cur] > pivot) {
                swap(arr,cur,rightP++);
            }else {
                cur++;
            }
        }
        sort(arr,left,leftP-1);
        sort(arr,rightP+1,right);
    }

    public void swap(int[] arr,int i, int j){
        if(i==j){
            return;
        }else {
            arr[i]^=arr[j];
            arr[j]^=arr[i];
            arr[i]^=arr[j];
        }

    }

}
