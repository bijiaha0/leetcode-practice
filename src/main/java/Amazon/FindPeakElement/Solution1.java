package Amazon.FindPeakElement;
/**
 * 寻找峰值
 * https://www.jiuzhang.com/solutions/find-peak-element/
 */
public class Solution1 {
    public int findPeak(int[] A) {
        int start = 1, end = A.length-2; // 1.答案在之间，2.不会出界
        while(start + 1 <  end) {
            int mid = (start + end) / 2;
            if(A[mid] < A[mid - 1]) {//下降
                end = mid;
            } else if(A[mid] < A[mid + 1]) {//上升
                start = mid;
            } else {
                end = mid;
            }
        }
        if(A[start] < A[end]) {
            return end;
        } else {
            return start;
        }
    }
}
