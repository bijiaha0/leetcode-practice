package LeetCode.SearchA2DMatrixII;

/**
 * @author bijh@tsingyun.net
 * @date 2020/9/16 3:44 PM
 */
public class Solution2 {

    public int searchMatrix(int[][] matrix, int target) {
        int r = matrix.length - 1;
        int c = 0;
        int ans = 0;
        while (r >= 0 && c < matrix[0].length) {
            if (target == matrix[r][c]) {
                ans++;
                r--;
                c++;
                continue;
            }
            if (target < matrix[r][c]) {
                r--;
            } else {
                c++;
            }
        }
        return ans;
    }
}
