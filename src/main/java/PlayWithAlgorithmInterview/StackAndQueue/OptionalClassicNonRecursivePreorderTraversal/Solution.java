package PlayWithAlgorithmInterview.StackAndQueue.OptionalClassicNonRecursivePreorderTraversal;
import java.util.Stack;
/**
 * Author: bijiaha0
 * Date: 2019-02-19
 * Time: 9:00 PM
 * Email: clickgwas@gmail.com
 */
public class Solution {
    //先序遍历
    public static void pre(TreeNode node) {
        if(node ==null){
            return;
        }
        Stack<Command> stack = new Stack<>();
        stack.push(new Command("go",node));
        while(!stack.isEmpty()){
            Command pop = stack.pop();
            if("print".equals(pop.s)){
                System.out.println(pop.node.val);
            }else {
                if(pop.node.right!=null){
                    stack.push(new Command("go",pop.node.right));
                }
                if(pop.node.left!=null){
                    stack.push(new Command("go",pop.node.left));
                }
                stack.push(new Command("print",pop.node));
            }
        }
    }
    //中序遍历
    public static void in(TreeNode node) {
        if(node ==null){
            return;
        }
        Stack<Command> stack = new Stack<>();
        stack.push(new Command("go",node));
        while(!stack.isEmpty()){
            Command pop = stack.pop();
            if("print".equals(pop.s)){
                System.out.println(pop.node.val);
            }else {
                if(pop.node.right!=null){
                    stack.push(new Command("go",pop.node.right));
                }
                stack.push(new Command("print",pop.node));
                if(pop.node.left!=null){
                    stack.push(new Command("go",pop.node.left));
                }
            }
        }
    }
    //后续遍历
    public static void post(TreeNode node) {
        if(node ==null){
            return;
        }
        Stack<Command> stack = new Stack<>();
        stack.push(new Command("go",node));
        while(!stack.isEmpty()){
            Command pop = stack.pop();
            if("print".equals(pop.s)){
                System.out.println(pop.node.val);
            }else {
                stack.push(new Command("print",pop.node));
                if(pop.node.right!=null){
                    stack.push(new Command("go",pop.node.right));
                }
                if(pop.node.left!=null){
                    stack.push(new Command("go",pop.node.left));
                }
            }
        }
    }
}
