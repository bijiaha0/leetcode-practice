package Amazon.Factorization;

import com.sun.javafx.scene.control.skin.VirtualFlow;

import java.util.ArrayList;
import java.util.List;
/**
 * Author: bijiaha0
 * Date: 2019-02-23
 * Time: 4:44 PM
 * Email: clickgwas@gmail.com
 */
public class Solution01 {
    List<List<Integer>> ans = new ArrayList<>();
    void dfs(int lastF, int remain, List<Integer> item){
        if(!item.isEmpty()){
            item.add(remain);ans.add(new ArrayList<Integer>(item));
            item.remove(item.size()-1);
        }
        for(int i= lastF; i<=remain/i;i++){
            if(remain % i ==0){
                //构造一个包含指定collection的元素的列表，这些元素按照该collection的迭代器返回它们的顺序排列的。
                List<Integer> new_item = new ArrayList<>(item);//深拷贝
                new_item.add(i);
                dfs(i,remain/i,new_item);
            }
        }
    }
    public List<List<Integer>> getFactors(int n){
        dfs(2,n,new ArrayList<Integer>());
        return ans;
    }
}
