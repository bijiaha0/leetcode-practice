import java.util.Collection;

/**
 * Author: bijiaha0
 * Date: 2019-02-13
 * Time: 7:46 PM
 * Email: clickgwas@gmail.com
 */

/*
*1.输入是一个只含有 0 和 1 的二维矩阵，
* 每一行都是排过序的，也就是说每一行前一部分都 是 0,
* 剩下的全都是 1。请找哪些行包含的 1 最多。
* 要求对于 MxN 的矩阵，时间复杂度是 O(M+N)，空间复杂度是 O(1)
* */
public class maxtrix {
    public int[] result(int[][] mat){
        int[] result= new int[2];
        int col = mat[0].length-1;
        //从右上角开始遍历
        //列
        while (mat[0][col]==0){
            col--;
        }
        //遍历行
        for (int row = 1; row < mat.length; row++) {
            while (col >= 0 && mat[row][col] == 1)
            {
                col = col-1;
                result[0] = row;
                result[1] = col;
            }
        }
        return result;
    }
}
