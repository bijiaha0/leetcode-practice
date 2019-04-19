package WanZhuanShuJuJieGou.LinkedListDemo.ImplementQueueInLinkedList07;

public interface Queue<E> {

    int getSize();
    boolean isEmpty();
    void enqueue(E e);
    E dequeue();
    E getFront();
}
