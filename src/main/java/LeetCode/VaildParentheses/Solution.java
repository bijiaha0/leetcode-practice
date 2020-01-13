package LeetCode.VaildParentheses;
import java.util.HashMap;
import java.util.Map;
import java.util.Stack;
public class Solution {
    public boolean isValid(String s) {
        Map<Character,Character> map = new HashMap<>();
        map.put(')','(');
        map.put('}','{');
        map.put(']','[');
        Stack<Character> stack = new Stack<>();
        char[] sc = s.toCharArray();
        for(char c:sc){
            if(!map.containsKey(c)){
                stack.push(c);
            }else{
                if(stack.isEmpty()||stack.pop()!=map.get(c)){
                    return false;
                }
            }
        }
        return stack.isEmpty();
    }
}
