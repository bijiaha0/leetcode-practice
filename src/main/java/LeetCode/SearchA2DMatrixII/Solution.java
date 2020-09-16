package LeetCode.SearchA2DMatrixII;
/**
 * https://www.jiuzhang.com/solutions/search-a-2d-matrix-ii/#tag-lang-java
 *
 * 写出一个高效的算法来搜索m×n矩阵中的值，返回这个值出现的次数。
 *
 * 这个矩阵具有以下特性：
 *
 * 每行中的整数从左到右是排序的。
 * 每一列的整数从上到下是排序的。
 * 在每一行或每一列中没有重复的整数。
 *
 *
 *
 */
public class Solution {
    /**
     * 时间复杂度为 O(m+n)
     */
    public boolean searchMatrix(int[][] matrix, int target) {
        if(matrix == null || matrix.length < 1 || matrix[0].length <1) {
            return false;
        }
        int col = matrix[0].length-1;
        int row = 0;
        while(col >= 0 && row <= matrix.length-1) {
            if(target == matrix[row][col]) {
                return true;
            } else if(target < matrix[row][col]) {
                col--;
            } else if(target > matrix[row][col]) {
                row++;
            }
        }
        return false;
    }
}
