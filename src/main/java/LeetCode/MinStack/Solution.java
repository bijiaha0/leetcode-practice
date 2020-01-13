package LeetCode.MinStack;
import java.util.Stack;
public class Solution {
    private Stack<Integer> stack;
    private Stack<Integer> minStack;
    public Solution() {
        stack = new Stack<Integer>();
        minStack = new Stack<Integer>();
    }
    public void push(int number) {
        stack.push(number);
        if (minStack.isEmpty()) {
            minStack.push(number);
        } else {
            minStack.push(Math.min(number, minStack.peek()));
        }
    }
    public int pop() {
        minStack.pop();
        return stack.pop();
    }
    public int min() {
        return minStack.peek();
    }
}
