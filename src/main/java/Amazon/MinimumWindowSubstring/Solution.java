package Amazon.MinimumWindowSubstring;
public class Solution {
    //验证子串是否包含目标串
    public Boolean vaild(int[] sourceMap, int[] targetMap) {
        for (int i = 0; i < targetMap.length; i++) {
            if (targetMap[i] > sourceMap[i]) {
                return false;
            }
        }
        return true;
    }
    //初始化TargetMap
    public void initTargetMap(int[] targetMap, String target) {
        for (int i = 0; i < target.length(); i++) {
            targetMap[target.charAt(i)]++;
        }
    }
    public String minWindow(String source, String target) {
        int i, j = 0,ans = Integer.MAX_VALUE;
        String minStr = "";
        int[] sourceMap = new int[256];
        int[] targetMap = new int[256];
        initTargetMap(targetMap, target);
        for (i = 0; i < source.length(); i++) {
            while (j < source.length() && !vaild(sourceMap, targetMap)) {
                sourceMap[source.charAt(j)]++;
                j++;
            }
            if (vaild(sourceMap, targetMap)) {
                if (ans > j - i) {
                    ans = j - i;
                    minStr = source.substring(i, j);
                }
            }
            sourceMap[source.charAt(i)]--;
        }
        return minStr;
    }
}
