package advanced_class_03;
import java.util.TreeMap;
//有序表
public class Test {
	public static void main(String[] args) {
		TreeMap<Integer, String> map = new TreeMap<>();
		map.put(1, "zuo");
		map.put(2, "青丝");
		map.put(4, "司机");
		map.put(7, "小企鹅");
		System.out.println(map.get(1));
		System.out.println(map.get(4));
		//map.remove(7);
		System.out.println(map.get(7));
		System.out.println(map.firstKey());
		System.out.println(map.lastKey());
		System.out.println(map.ceilingKey(3));
		System.out.println(map.floorKey(3));
		// O(logN)
	}
}
