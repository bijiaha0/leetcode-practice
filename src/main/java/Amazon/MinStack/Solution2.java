package Amazon.MinStack;
import java.util.Stack;
/**
 * Time: 14:33
 * Email: clickgwas@gmail.com
 * https://www.jiuzhang.com/solution/min-stack/
 */
public class Solution2 {
    private Stack<Integer> stack;
    private Stack<Integer> minStack;

    public Solution2 () {
        stack = new Stack<Integer>();
        minStack = new Stack<Integer>();
    }

    public void push(int number) {
        stack.push(number);
        if (minStack.empty() == true)
            minStack.push(number);
        else {
            // 这里考虑的相等的情况也会继续push
            if (minStack.peek() >= number)
                minStack.push(number);
        }
    }

    public int pop() {
        if (stack.peek().equals(minStack.peek()) )
            minStack.pop();
        return stack.pop();
    }

    public int min() {
        return minStack.peek();
    }
}
