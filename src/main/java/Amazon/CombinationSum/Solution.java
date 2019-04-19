package Amazon.CombinationSum;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
/**
 * Email: clickgwas@gmail.com
 * https://www.jiuzhang.com/solutions/combination-sum/
 */
public class Solution {
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        Arrays.sort(candidates);

        List<List<Integer>> results = new ArrayList<>();
        dfs(candidates, 0, target, new ArrayList<Integer>(), results);
        return results;
    }

    private void dfs(int[] candidates, int index, int target, List<Integer> combination, List<List<Integer>> results) {
        if (index == candidates.length) {
            if (target == 0) {
                results.add(new ArrayList<Integer>(combination));
            }
            return;
        }

        if (target < 0) {
            return;
        }

        dfs(candidates, index + 1, target, combination, results);

        if (index > 0 && candidates[index] == candidates[index - 1]) {
            return;
        }
        //2、递归的拆解
        combination.add(candidates[index]);
        dfs(candidates, index, target - candidates[index], combination, results);
        combination.remove(combination.size() - 1);
    }
}
