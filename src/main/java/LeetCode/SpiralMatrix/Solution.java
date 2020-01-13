package LeetCode.SpiralMatrix;

import java.util.ArrayList;
import java.util.List;

public class Solution {
    public List<Integer> spiralMatrix(int[][] matrixx){
        List<Integer> res = new ArrayList<>();
        if(matrixx==null||matrixx.length==0){
            return res;
        }
        if(matrixx[0]==null||matrixx[0].length==0){
            return res;
        }
        int row = matrixx.length;
        int col = matrixx[0].length;
        helper(matrixx,res,row,col,0);
        return res;
    }
    public void helper(int[][] matrixx,List<Integer> res,int row,int col,int offset){
        if(row==0||col==0){
            return ;
        }
        if(row==1){
            for(int i = offset; i < col+offset;i++){
                res.add(matrixx[offset][i]);
            }
            return;
        }
        if(col==1){
            for(int i = offset; i < row+offset;i++){
                res.add(matrixx[i][offset]);
            }
            return;
        }
        //上
        for(int i = offset; i < col-1+offset;i++){
            res.add(matrixx[offset][i]);
        }
        //右
        for(int i = offset; i < row-1+offset;i++){
            res.add(matrixx[i][col-1+offset]);
        }
        //下
        for(int i = col-1+offset; i >= 0;i--){
            res.add(matrixx[row-1+offset][i]);
        }
        //左
        for(int i = row-1+offset; i >= 0;i--){
            res.add(matrixx[row-1+offset][offset]);
        }
    }
}
