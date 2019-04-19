package Amazon.InterleavingPositiveAndNegativeNumbers;
/**
 * https://www.jiuzhang.com/solution/interleaving-positive-and-negative-numbers/
 * 交错正负数
 * 同向双指针
 */
public class Solution {
    int[] subFun(int[] A, int [] B, int len) {
        int[] ans = new int[len];
        for(int i = 0; i * 2 + 1 < len; i++) {
            ans[i * 2] = A[i];
            ans[i * 2 + 1] = B[i];
        }
        if(len % 2 == 1)
            ans[len - 1] = A[len / 2];
        return ans;
    }
    public void reRange(int[] A) {
        int[] AP = new int[A.length];
        int totp = 0;
        int totn = 0;
        int[] AN = new int[A.length];
        int[] tmp = new int[A.length];
        for(int i = 0; i < A.length; i++)
            if(A[i] > 0) {
                AP[totp] = A[i];
                totp += 1;
            } else {
                AN[totn] = A[i];
                totn += 1;
            }
        if(totp > totn)//正数大于负数
            tmp = subFun(AP, AN, A.length);
        else//正数小于负数
            tmp = subFun(AN, AP, A.length);
        for (int i = 0; i < tmp.length; ++i)
            A[i] = tmp[i];
    }
}
