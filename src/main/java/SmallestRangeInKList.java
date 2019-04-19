/**
 * Author: bijiaha0
 * Date: 2019-02-13
 * Time: 8:25 PM
 * Email: clickgwas@gmail.com
 */




import java.util.Comparator;
import java.util.PriorityQueue;

/**
 * 最小区间问题
 *
 * 初始化大小为k的最小堆，k个数字是每个数组中的最小值，设置变量maxValue记录k个数字中最大值，
 * 删除堆顶元素，将原堆顶元素对应的数组中下一个值加入到堆中，调整堆，并且记录当前区间范围(maxValue-minValue)
 * 重复执行直到某个数组所有值都被删除。
 */

//定义堆节点
class HeapNode{
    public int value;//对应的值
    public int arrNum;//所在数组的编号
    public int index;//所在的数组中的索引
    public HeapNode(int value,int arrNum,int index){//构造方法
        this.value = value;
        this.arrNum = arrNum;
        this.index = index;
    }
}
//定义小跟堆比较器
class minComparator implements Comparator<HeapNode> {
    @Override
    public int compare(HeapNode o1,HeapNode o2) {
        return o1.value - o2.value;
    }
}
class maxComparator implements Comparator<HeapNode> {
    @Override
    public int compare(HeapNode o1,HeapNode o2) {
        return o2.value - o1.value;
    }
}

public class SmallestRangeInKList {
    public static void  getResult(int[][] num){
        //小跟堆
        PriorityQueue<HeapNode> minHeap = new PriorityQueue<HeapNode>(new minComparator());
        //大根堆
        PriorityQueue<HeapNode> maxHeap = new PriorityQueue<HeapNode>(new maxComparator());
        for(int i = 0; i < num.length;i++){
            minHeap.add(new HeapNode(num[i][0],i,0));
            maxHeap.add(new HeapNode(num[i][0],i,0));
        }
        int minRangeMin = 0;
        int minRangeMax = 0;
        int minRange = Integer.MAX_VALUE;
        while(true){
            //寻找最小区间
            if(minRange > maxHeap.peek().value - minHeap.peek().value){
                minRangeMin = minHeap.peek().value;
                minRangeMax = maxHeap.peek().value;
                minRange = maxHeap.peek().value - minHeap.peek().value;
            }
            //小根堆堆顶弹出的节点
            HeapNode poll = minHeap.poll();
            //弹出节点对应的数组
            int arrNum= poll.arrNum;
            //弹出节点对应的在数组中的索引
            int index = poll.index;
            //将原小根堆顶元素对应的数组中下一个值加入到小根堆中
            if(index+1 < num[arrNum].length){
                minHeap.add(new HeapNode(num[arrNum][index+1],arrNum,index+1));
                maxHeap.add(new HeapNode(num[arrNum][index+1],arrNum,index+1));
            }else {//其中的一个数组已经走完啦
                break;
            }
        }
        System.out.println("Smallest Range is: " + minRange + ", from " + minRangeMin + " To " + minRangeMax);
    }

    public static void main(String[] args) {
        //初始化数组
        int[][] num=new int[][]{{1,3,5},{4,8},{2,5}};
        //todo
        getResult(num);
    }
}



