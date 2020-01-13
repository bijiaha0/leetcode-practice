package Amazon.CheckWordAbbreviation;
public class Solution {
    public boolean validWordAbbreviation(String word, String abbr) {
        int i = 0;
        int j = 0;
        char[] w = word.toCharArray();
        char[] a = abbr.toCharArray();
        while (i < w.length && j < a.length) {
            if (Character.isDigit(a[j])) {
                int val = 0;
                while (j < a.length && Character.isDigit(a[j])) {
                    val = val * 10 + a[j] - '0';
                    j++;
                }
                i += val;
            } else {
                if (w[i++] != a[j++]) {
                    return false;
                }
            }
        }
        return i == w.length && j == a.length;
    }
}
