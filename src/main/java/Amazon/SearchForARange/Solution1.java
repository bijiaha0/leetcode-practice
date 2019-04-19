package Amazon.SearchForARange;

public class Solution1 {
    //二分法模板
    int find(int[] arr, int len, int target){
        if(arr[len-1] < target){
            return len;
        }
        if(arr[0] > target){
            return -1;
        }
        int l = 0,r = len-1,ans =0;
        while( l <= r){
            int mid = (l + r)/2;
            if(target <= arr[mid]){
                ans = mid;
                r = mid - 1;
            }else {
                l = mid + 1;
            }
        }
        return ans;
    }
    int[] searchRange(int[] arr, int target){
        int[] bound = new int[2];
        bound[0] = find(arr, arr.length, target);
        bound[1] = find(arr, arr.length, target+1)-1;
        return bound;
    }

    public static void main(String[] args) {

    }
}
