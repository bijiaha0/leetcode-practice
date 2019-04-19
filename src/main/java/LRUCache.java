import java.util.HashMap;
/**
 * Author: bijiaha0
 * Date: 2019-02-19
 * Time: 9:24 AM
 * Email: clickgwas@gmail.com
 */

public class LRUCache {
    /*
    * 1、定义节点类；
    * 2、初始容量、hashmap、头节点、尾节点；
    * 3、set-----removeToTail
    * 4、get-----removeToTail
    * */
    private class Node{
        Node prev;
        Node next;
        int key;
        int value;
        public Node(int key,int value){
            this.key = key;
            this.value = value;
            prev= null;
            next = null;
        }
    }
    private int capacity;
    private HashMap<Integer,Node> hs = new HashMap<>();
    private Node head = new Node(-1,-1);
    private Node tail = new Node(-1,-1);
    public LRUCache(int capacity){
        this.capacity = capacity;
        tail.prev = head;
        head.next = tail;
    }
    public void set(int key,int value){
        if(hs.containsKey(key)){
            hs.get(key).value = value;
        }
        if(hs.size()==capacity){
            //删除头节点
            hs.remove(head.next.key);
            remove(head.next);
        }
        Node node = new Node(key, value);
        hs.put(key,node);
        move_to_tail(node);
    }
    public int get(int key){
        if(!hs.containsKey(key)){
            return -1;
        }
        // remove current-----to tail
        Node current = hs.get(key);
        remove(current);
        //move current to tail
        move_to_tail(current);
        return hs.get(key).value;
    }
    //删除双向链表中的节点
    public void remove(Node node){
        node.prev.next = node.next;
        node.next.prev = node.prev;
    }
    //头节点和尾节点是哨兵
    private void move_to_tail(Node current){
        current.prev = tail.prev;
        tail.prev.next = current;
        current.next = tail;
        tail.prev = current;
    }
}
