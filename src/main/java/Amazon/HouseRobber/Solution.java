package Amazon.HouseRobber;
/*
*
* https://www.jiuzhang.com/solutions/house-robber/
* */
public class Solution {

    public long houseRobber(int[] A) {
        int n = A.length;
        if (n == 0)
            return 0;
        long []res = new long[n+1];

        res[0] = 0;
        res[1] = A[0];
        for (int i = 2; i <= n; i++) {
            res[i] = Math.max(res[i-1], res[i-2] + A[i-1]);
        }
        return res[n];
    }
}
