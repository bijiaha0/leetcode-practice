package LeetCode.SearchA2DMatrixII;

/**
 * @author bijh@tsingyun.net
 * @date 2020/9/16 3:44 PM
 * <p>
 * <p>
 * 根据题意，每行中的整数从左到右是排序的，每一列的整数从上到下是排序的，在每一行或每一列中没有重复的整数。那么我们只要从矩阵的左下角开始向右上角找，若是小于target就往右找，若是大于target就往上找
 * <p>
 * 从左下角即(n-1,0)处出发
 * 如果matrix[x][y] < target 下一步往右搜
 * 如果matrix[x][y] > target 下一步往上搜
 * 如果matrix[x][y] = target 下一步往[x-1][y+1]即右上角搜，因为是有序的，每一行每一列中每个数都是唯一的
 */
public class Solution2 {

    public int searchMatrix(int[][] matrix, int target) {
        int r = matrix.length - 1;
        int c = 0;
        int ans = 0;
        while (r >= 0 && c < matrix[0].length) {
            if (target == matrix[r][c]) {
                ans++;
                //从左下角---->到右上角
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
