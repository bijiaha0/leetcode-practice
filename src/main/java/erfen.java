/**
 * Author: bijiaha0
 * Date: 2019-02-19
 * Time: 7:22 PM
 * Email: clickgwas@gmail.com
 */
public class erfen {
    public static int findMin(int[] arr){
        //处理边界问题
        if(arr==null||arr.length==0){
            return -1;
        }
        if(arr.length==1){
            return arr[0];
        }
        if(arr[0]>arr[1]){
            return arr[1];
        }
        if(arr[arr.length-1]>arr[arr.length-2]){
            return arr[arr.length-2];
        }
        int left = 1;
        int right = arr.length-2;
        while(left < right){
            int mid = (left+right)/2;
            if(arr[mid] > arr[mid-1]){
                right = mid-1;
            }else if (arr[mid] > arr[mid+1]){
                left = mid+1;
            }else {
                return mid;
            }
        }
        return left;
    }
    public static void main(String[] args) {
        int[] arr = {0,2,4,1,2,3,4};
        int min = findMin(arr);
        System.out.println(min);
    }
}
