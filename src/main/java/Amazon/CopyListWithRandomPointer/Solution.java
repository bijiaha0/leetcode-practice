package Amazon.CopyListWithRandomPointer;
/**
 * Email: clickgwas@gmail.com
 * https://www.lintcode.com/problem/copy-list-with-random-pointer/description
 */
import java.util.HashMap;
class RandomListNode {
      int value;
      RandomListNode next, random;
      RandomListNode(int value) { this.value = value; }
};
public class Solution {
    public RandomListNode copyRandomList(RandomListNode head) {
        if (head == null) {
            return null;
        }
        HashMap<RandomListNode, RandomListNode> map = new HashMap<RandomListNode, RandomListNode>();
        //不碰原head
        RandomListNode cur = head;
        while(cur!=null){
            map.put(cur,new RandomListNode(cur.value));
            cur = cur.next;
        }
        //不碰原head
        cur = head;
        while(cur!=null){
            map.get(cur).random = map.get(cur.random);
            map.get(cur).next = map.get(cur.next);
            cur = cur.next;
        }
        //
        return map.get(head);
    }
    /*
    * hashmap中保存的是head,head.value节点
    * */
    public RandomListNode copy(RandomListNode head){
        HashMap<RandomListNode,RandomListNode> hs = new HashMap<>();
        RandomListNode cur= head;
        while (cur!=null){
            hs.put(cur,new RandomListNode(cur.value));
            cur =cur.next;
        }
        cur= head;
        while (cur!=null){
            hs.get(cur).random = hs.getOrDefault(cur.random,null);
            hs.get(cur).next = hs.get(cur.next);
            cur =cur.next;
        }
        return hs.get(head);
    }
    public static void main(String[] args) {
    }














}
