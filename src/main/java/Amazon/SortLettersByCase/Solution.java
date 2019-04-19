package Amazon.SortLettersByCase;
/**
 * 字符大小写排序
 * https://www.jiuzhang.com/solutions/sort-letters-by-case/
 */
public class Solution {
    public void sortLetters(char[] chars) {
        int i = 0, j = chars.length - 1;
        char tmp;
        while (i <= j) {
            while (i <= j && Character.isLowerCase(chars[i]))
                i++;
            while (i <= j && Character.isUpperCase(chars[j]))
                j--;
            if (i <= j) {
                tmp = chars[i];
                chars[i] = chars[j];
                chars[j] = tmp;
                i++;
                j--;
            }
        }
        return;
    }
}
