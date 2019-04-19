package tju.basic_class_01;
import java.util.Comparator;
import java.util.PriorityQueue;
/**
 * Author: bijiaha0
 * Date: 2018-09-10
 * Time: 下午9:11
 * Email: clickgwas@gmail.com
 */
//求一堆无序数的中位数
public class Median {
    //比较器
    public static class MaxHeapComp implements Comparator<Integer>{
        @Override
        public int compare(Integer o1, Integer o2) {
            //返回负数的时候，认为第一个参数应该放在上面
            //返回正数的时候，认为第二个参数应该放在上面
            //返回0，谁放上面无所谓
            //if (o1 > o2){
            //    return -1;
            //}else if (o1 < o2){
            //    return 1;
            //}else {
            //    return 0;
            //}
            return o2-o1;
        }
    }
    //小根堆比较器
    public static class MinHeapComp implements Comparator<Integer>{
        @Override
        public int compare(Integer o1, Integer o2) {
            return o1-o2;
        }
    }
    public static class Box{
        private PriorityQueue<Integer> maxHeap;
        private PriorityQueue<Integer> minHeap;

        public Box(PriorityQueue<Integer> maxHeap, PriorityQueue<Integer> minHeap) {
            this.maxHeap = maxHeap;
            this.minHeap = minHeap;
        }
        private void modifyTwoHeaps(){
            //如果大根堆的个数大于小跟堆的个数+1
            if(maxHeap.size() > minHeap.size()+1){
                minHeap.add(maxHeap.poll());
            }
            //如果小跟堆的个数大于大根堆的个数+1
            if(minHeap.size() > maxHeap.size()+1){
                maxHeap.add(minHeap.poll());
            }
        }
        public void add(int newNum){
            if(maxHeap.isEmpty()){
                maxHeap.add(newNum);
            }else {
                if(newNum < maxHeap.peek()){
                    maxHeap.add(newNum);
                }else {
                    minHeap.add(newNum);
                }
            }
            modifyTwoHeaps();;
        }
        public int mid(){
            if(maxHeap.size() !=minHeap.size()){
                return maxHeap.size() > minHeap.size() ? maxHeap.peek():minHeap.peek();
            }
            return   (maxHeap.peek()+minHeap.peek())/2;
        }
    }
    public static void main(String[] args) {
        PriorityQueue maxHeap = new PriorityQueue<Integer>(new MaxHeapComp());
        PriorityQueue minHeap = new PriorityQueue<Integer>(new MinHeapComp());
        Box box=new Box(maxHeap,minHeap);
        box.add(5);
        box.add(3);
        box.add(6);
        box.add(7);
        box.add(0);
        box.add(1);
        System.out.println(box.mid());
    }
}
