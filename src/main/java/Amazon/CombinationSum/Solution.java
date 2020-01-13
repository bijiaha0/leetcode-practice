package Amazon.CombinationSum;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
public class Solution {
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        List<List<Integer>> res = new ArrayList<>();
        Arrays.sort(candidates);
        if(candidates.length==0) return res;
        dfs(res, new ArrayList<>(),candidates,target,0);
        return res;
    }
    void dfs(List<List<Integer>> res, List<Integer> tmp,int[] candidates,int target,int start){
        if(target==0){
            res.add(new ArrayList<>(tmp));
            return;
        }
        if(target<0) return;
        for(int i=start; i < candidates.length;i++){
            List<Integer> tmp1 = new ArrayList<>(tmp);
            tmp1.add(candidates[i]);
            dfs(res, tmp1,candidates,target-candidates[i],i);
        }
    }
}
