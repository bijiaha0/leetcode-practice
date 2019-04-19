package Amazon.ExpressionExpand;
/**
 * Email: clickgwas@gmail.com
 */
//递归
    /*
    * split
    * recursion
    * merge
    * */
public class Solution1 {
    public String expressionExpand(String s) {
        int number = 0;
        int paren = 0;
        String subString = "";
        StringBuilder sb = new StringBuilder();

        for (char c : s.toCharArray()) {
            if (c == '[') {
                if (paren > 0) {
                    subString = subString + c;
                }
                paren++;
            } else if (c == ']') {
                paren--;
                if (paren == 0) {
                    // push number * substring to sb
                    String expandedString = expressionExpand(subString);
                    for (int i = 0; i < number; i++) {
                        sb.append(expandedString);
                    }
                    number = 0;
                    subString = "";
                } else {
                    subString = subString + c;
                }
            } else if (c >= '0' && c <= '9') {
                if (paren == 0) {
                    number = number * 10 + c - '0';
                } else {
                    subString = subString + c;
                }
            } else {
                if (paren == 0) {
                    sb.append(String.valueOf(c));
                } else {
                    subString = subString + c;
                }
            }
        }
        return sb.toString();
    }
}
