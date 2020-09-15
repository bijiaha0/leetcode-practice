package Amazon.SystemLongestFilePath;

import java.util.Stack;

/**
 * https://www.jiuzhang.com/solutions/system-longest-file-path/
 * <p>
 * "dir\n\tsubdir1\n\tsubdir2\n\t\tfile.ext"
 * <p>
 * “dir/subdir2/subsubdir2/file2.ext”---->32
 * <p>
 * "dir\n\tsubdir1\n\t\tfile1.ext\n\t\tsubsubdir1\n\tsubdir2\n\t\tsubsubdir2\n\t\t\tfile2.ext"
 * dir
 * subdir1
 * subdir2
 * file.ext
 */
public class Solution {

    public int lengthLongestPath(String input) {

        if (input.length() == 0) {
            return 0;
        }

        int ans = 0;
        int[] sum = new int[input.length() + 1];

        for (String line : input.split("\n")) {
            int level = line.lastIndexOf('\t') + 2;
            int len = line.length() - (level - 1); //remove \t (level - 1 = \t的长度)
            if (line.contains(".")) {
                ans = Math.max(ans, sum[level - 1] + len);
            } else {
                sum[level] = sum[level - 1] + len + 1; //len = remove \t ,1 = add /
            }
        }

        return ans;
    }

    public int lengthLongestPath2(String input) {
        int maxLen = 0;
        if (input == null || input.length() == 0) {
            return maxLen;
        }
        Stack<Integer> stack = new Stack();
        stack.push(0);
        String[] inputArr = input.split("\n");
        for (String inputStr : inputArr) {

            int level = inputStr.lastIndexOf("\t") + 1;

            while (level + 1 < stack.size()) {
                stack.pop();
            }

            int newLen = stack.peek() + inputStr.length() - level + 1; //remove \t ,add /
            stack.push(newLen);

            if (inputStr.contains(".")) {
                maxLen = Math.max(maxLen, newLen - 1);
            }

        }

        return maxLen;
    }

}
