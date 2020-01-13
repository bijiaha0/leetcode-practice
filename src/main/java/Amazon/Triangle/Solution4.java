package Amazon.Triangle;
import java.util.List;
public class Solution4 {
    public int minimumTotal(List<List<Integer>> triangle) {
        return dfs(triangle,0,0);
    }
    int dfs(List<List<Integer>> triangle,int level,int j){
        if(level==triangle.size()){
            return 0;
        }
        int left = dfs(triangle,level+1,j);
        int right = dfs(triangle,level+1,j+1);
        return triangle.get(level).get(j)+Math.min(left,right);
    }
}
