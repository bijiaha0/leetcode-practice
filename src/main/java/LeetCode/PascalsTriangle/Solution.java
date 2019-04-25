package LeetCode.PascalsTriangle;

import java.util.ArrayList;
import java.util.List;
/**
 * Time: 12:28
 * Email: clickgwas@gmail.com
 */
public class Solution {
    public List<List<Integer>> generate(int numRows) {
        List<List<Integer>> res = new ArrayList<List<Integer>>();
        for(int i= 0 ; i < numRows; i++){
            List<Integer> temp = new ArrayList<Integer>();
            temp.add(1);
            //res[i][j] = res[i-1][j]+res[i-1][j-1]
            for(int j = 1; i >=2 && j < i; j++){
                temp.add(j, res.get(i-1).get(j) + res.get(i-1).get(j-1));
            }
            if(i > 0){
                temp.add(1);
            }
            res.add(temp);
        }
        return res;
    }
}
