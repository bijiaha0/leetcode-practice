package LeetCode.PascalsTriangleII;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
/**
 * Time: 12:49
 * Email: clickgwas@gmail.com
 */
public class Solution {
    //滚动数组
    public List<Integer> getRow(int rowIndex) {
        Integer[] res = new Integer[rowIndex + 1];
        Arrays.fill(res, 1);
        for (int i = 2; i <= rowIndex; i++) {
            for (int j = i - 1; j > 0; j--) {
                res[j] = res[j] + res[j - 1];
            }
        }
        return Arrays.asList(res);
    }
    //常规
    public List<Integer> getRow1(int rowIndex) {
        List<Integer> res = new ArrayList<Integer>();
        for (int i = 0; i <= rowIndex; i++) {
            List<Integer> temp = new ArrayList<Integer>();
            temp.add(1);
            for (int j = 1; i >= 2 && j < i; j++) {
                temp.add(res.get(j)+res.get(j-1));
            }
            if(i > 0){
                temp.add(1);
            }
            res = temp;
        }
        return res;
    }

}