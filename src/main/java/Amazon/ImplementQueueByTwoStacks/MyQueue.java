package Amazon.ImplementQueueByTwoStacks;

import java.util.Stack;
/*
*https://www.jiuzhang.com/solutions/implement-queue-by-two-stacks/
*
* */
/*
*
push加入到栈中
top即从A栈出到B栈，执行完之后，B栈push出栈顶元素，作为返回值，然后继续入站栈，最后B栈出，返回A栈。
pop即从A栈出到B栈，执行完之后，B栈push出栈顶元素，然后B栈依次出，返回A栈。
* */
public class MyQueue {

    private Stack<Integer> stack1;
    private Stack<Integer> stack2;

    public MyQueue() {
        // do initialization if necessary
        stack1 = new Stack<Integer>();
        stack2 = new Stack<Integer>();
    }

    private void stack2ToStack1(){
        while(! stack2.isEmpty()){
            stack1.push(stack2.pop());
        }
    }

    public void push(int element) {
        stack2.push(element);
    }

    public int pop() {
        if(stack1.empty() == true){
            this.stack2ToStack1();
        }
        return stack1.pop();
    }

    public int top() {
        if(stack1.empty() == true){
            this.stack2ToStack1();
        }
        return stack1.peek();
    }
}
