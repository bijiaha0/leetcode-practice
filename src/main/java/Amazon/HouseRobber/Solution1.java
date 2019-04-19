package Amazon.HouseRobber;

public class Solution1 {

    public long houseRobber(int[] A) {
        int n = A.length;
        if (n == 0)
            return 0;
        long []res = new long[3];

        res[0] = 0;
        res[1] = A[0];
        for (int i = 2; i <= n; i++) {
            res[i%3] = Math.max(res[(i-1)%3], res[(i-2)%3] + A[i-1]);
        }
        return res[n%3];
    }
}
