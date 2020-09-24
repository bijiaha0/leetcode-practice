package Amazon.LoadBalancer;
import java.util.*;
/**
 * https://www.lintcode.com/problem/load-balancer/description
 */
public class LoadBalancer {

    int n = 0;
    Map<Integer, Integer> pos = new HashMap<>();
    List<Integer> array = new ArrayList<>();
    Random rand = new Random();

    public LoadBalancer() {
    }

    public void add(int server_id) {

        if (!pos.containsKey(server_id)) {
            array.add(server_id);
            pos.put(server_id, n);
            n++;
        }

    }

    public void remove(int server_id) {

        if (pos.containsKey(server_id)) {
            //从hash表中查找要删除元素，在数组中的索引
            int removeIdx = pos.get(server_id);
            //得到数组中末尾的元素
            int lastItem = array.get(n - 1);
            //更新hash
            pos.put(lastItem, removeIdx);
            //替掉
            array.set(removeIdx, lastItem);
            //删除
            pos.remove(server_id);
            array.remove(n - 1);
            n--;
        }

    }

    public int pick() {
        return array.get(rand.nextInt(n));
    }
}
