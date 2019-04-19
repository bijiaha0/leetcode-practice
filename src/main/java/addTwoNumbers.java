/**
 * Author: bijiaha0
 * Date: 2019-02-17
 * Time: 1:22 PM
 * Email: clickgwas@gmail.com
 */
/*
https://github.com/liuyubobobo/Play-Leetcode/blob/master/0086-Partition-List/cpp-0086/main.cpp

https://github.com/liuyubobobo/Play-Leetcode/tree/master/0328-Odd-Even-Linked-List/cpp-0328

https://github.com/liuyubobobo/Play-Leetcode/tree/master/0002-Add-Two-Numbers/cpp-0002

https://leetcode-cn.com/problems/add-two-numbers/solution/
给定两个非空链表来表示两个非负整数。位数按照逆序方式存储，它们的每个节点只存储单个数字，
将两数相加返回一个新的链表。
* */
class listNode{
    int val;
    listNode next;
    public listNode(int val) {
        this.val = val;
    }
}
public class addTwoNumbers {
    public listNode add(listNode l1,listNode l2){
        listNode p1 = l1;
        listNode p2 = l2;
        listNode resultNode = new listNode(0);
        int carry = 0;
        while(p1 != null || p2 != null){
            int x = p1 != null ? p1.val : 0;
            int y = p2 != null ? p2.val : 0;
            int sum = carry + x + y;
            carry = sum / 10;
            int yushu = sum % 10;
            resultNode.next = new listNode(yushu);
            if(p1 != null){p1 = p1.next;}
            if(p2 != null){p2 =p2.next;}
        }
        if(carry > 0){
            resultNode.next = new listNode(carry);
        }
        return resultNode.next;
    }
}
