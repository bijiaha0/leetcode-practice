package Amazon.LoadBalancer;
import java.util.*;
/**
 * https://www.lintcode.com/problem/load-balancer/description
 * 一种可行的思路是同时使用哈希表和数组.
 *
 * pick(): 数组中随机选取一个元素可以直接使用随机函数得到一个 [0, 数组大小-1] 的整数即可.
 * 数组中random一个返回
 *
 * add(server_id): 在数组末尾添加这个server_id, 并在哈希表中添加 server_id -> 数组下标 的键值映射
 * 数组末尾加入这个元素
 * Hash这个元素存下数组中的下标
 *
 * remove(server_id): 利用哈希表得到 server_id 的数组下标, 在数组中将它和最末尾的元素交换位置, 然后删除, 并将修改同步到哈希表
 * 通过Hash找到这个元素在数组中的位置
 * 数组中这个元素和数组的末尾元素交换，交换后删除
 * Hash中删除这个元素，更新
 */
public class LoadBalancer {
    int n = 0;
    Map<Integer, Integer> pos = new HashMap<>();
    List<Integer> array = new ArrayList<>();
    Random rand = new Random();
    public LoadBalancer() {
        // Initialize your data structure here.
    }
    // @param server_id add a new server to the cluster
    // @return void
    public void add(int server_id) {
        // Write your code here
        if (!pos.containsKey(server_id)) {
            array.add(server_id);
            pos.put(server_id, n);
            n++;
        }
    }
    // @param server_id server_id remove a bad server from the cluster
    // @return void
    public void remove(int server_id) {
        // Write your code here
        if (pos.containsKey(server_id)) {
            //从hash表中查找要删除元素，在数组中的索引
            int removeIdx = pos.get(server_id);
            //得到数组中末尾的元素
            int lastItem = array.get(n - 1);
            //更新hash
            pos.put(lastItem, removeIdx);
            //交换
            array.set(removeIdx, lastItem);
            //删除
            pos.remove(server_id);
            array.remove(n - 1);
            n--;
        }
    }
    // @return pick a server in the cluster randomly with equal probability
    public int pick() {
        // Write your code here
        return array.get(rand.nextInt(n));
    }
}
