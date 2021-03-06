package Amazon.LongestAbsoluteFilePath;
/**
 * Author: bijiaha0
 * https://www.lintcode.com/problem/longest-absolute-file-path/description
 * 模拟一个栈
 */
public class Solution {
    public int lengthLongestPath(String input) {
        if (input.length() == 0) {
            return 0;
        }
        int ans = 0;
        int[] sum = new int[input.length() + 1];//前缀和数组
        for (String line : input.split("\n")) {
            int level = line.lastIndexOf('\t') + 2;//\t的个数
            int len = line.length() - (level - 1);//长度的计算应该是：剩余字符串加上一个斜杠的长度
            if (line.contains(".")) {
                ans = Math.max(ans, sum[level - 1] + len);
            } else {
                sum[level] = sum[level - 1] + len + 1;//如果是文件夹的话，加内个斜杠
            }
        }
        return ans;
    }
}
