import java.util.Stack;
/**
 * Author: bijiaha0
 * Date: 2019-02-13
 * Time: 9:50 PM
 * Email: clickgwas@gmail.com
 */
/*
* 匹配字符串
* */
public class piPei {
    public static void main(String[] args) {
        String s="{[(2+3)*(1-3)]+4}*(14-3)";
        System.out.println(match(s));
    }
    public static boolean match(String s){
        Stack stack=new Stack();
        char c[]=s.toCharArray();
        for (int i = 0;i < c.length ;i++ ) {
            if(isLeftBracket(c[i])){
                stack.push(c[i]);
            }else if(isRightBracket(c[i])){
                //如果栈为空，说明右括号多
                if(stack.isEmpty()){
                    return false;
                }else {
                    //判断栈顶的元素是否和右括号是匹配的
                    if(!stack.peek().equals(resverse(c[i]))){
                        return false;
                    }else{
                        //若匹配则将对应的左括号出栈
                        stack.pop();
                    }
                }
            }
        }
        //如果所有的字符都匹配结束，栈也为空，那么就表示匹配，否则就是左括号多
        if (stack.isEmpty()) {
            return true;
        }
        return false;
    }
    //判断是否为左括号
    public static boolean isLeftBracket(char c){
        if(c=='{'||c=='['||c=='('){
            return true;
        }
        return false;
    }
    //判断是否为右括号
    public static boolean isRightBracket(char c){
        if(c=='}'||c==']'||c==')'){
            return true;
        }
        return false;
    }
    //找出与右括号对应的左括号
    public static char resverse(char c){
        char res=' ';
        if(c=='}'){
            res= '{';
        }else if(c==']'){
            res= '[';
        }else if(c==')'){
            res= '(';
        }
        return res;
    }
}
