package Amazon.SearchA2DMatrixII;
/**
 * Email: clickgwas@gmail.com
 * https://www.lintcode.com/problem/search-a-2d-matrix-ii/description
 * amazon
 */
public class Solution {
    public int searchMatrix(int[][] matrix, int target) {
        // write your code here
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
