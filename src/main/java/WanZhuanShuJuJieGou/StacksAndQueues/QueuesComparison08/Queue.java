package WanZhuanShuJuJieGou.StacksAndQueues.QueuesComparison08;

public interface Queue<E> {

    int getSize();
    boolean isEmpty();
    void enqueue(E e);
    E dequeue();
    E getFront();
}
