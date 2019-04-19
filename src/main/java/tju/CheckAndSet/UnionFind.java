package tju.CheckAndSet;
import java.util.HashMap;
import java.util.List;
import java.util.Stack;
//并查集解决的是连通性问题，保证样本是唯一的，所有的样本都是不相同的。
/*
 话说江湖上散落着各式各样的大侠，有上千个之多。
 他们没有什么正当职业，整天背着剑在外面走来走去，
 碰到和自己不是一路人的，就免不了要打一架。
 但大侠们有一个优点就是讲义气，绝对不打自己的朋友。
 而且他们信奉“朋友的朋友就是我的朋友”，
 只要是能通过朋友关系串联起来的，不管拐了多少个弯，
 都认为是自己人。这样一来，江湖上就形成了一个一个的群落，
 通过两两之间的朋友关系串联起来。而不在同一个群落的人，
 无论如何都无法通过朋友关系连起来，于是就可以放心往死了打。
 但是两个原本互不相识的人，如何判断是否属于一个朋友圈呢？
 我们可以在每个朋友圈内推举出一个比较有名望的人，
 作为该圈子的代表人物，这样，
 每个圈子就可以这样命名“齐达内朋友之队”“罗纳尔多朋友之队”……
 两人只要互相对一下自己的队长是不是同一个人，就可以确定敌友关系了。
* */
public class UnionFind {
	public static class Element<V> {
		public V value;

		public Element(V value) {
			this.value = value;
		}

	}
	// V  用户的元素类型
	public static class UnionFindSet<V> {

		public HashMap<V, Element<V>> elementMap;
		public HashMap<Element<V>, Element<V>> fatherMap;
		public HashMap<Element<V>, Integer> sizeMap;//当一个节点是代表节点的时候，才会有sizeMap。

		public UnionFindSet(List<V> list) {
			elementMap = new HashMap<>();
			fatherMap = new HashMap<>();
			sizeMap = new HashMap<>();
			for (V value : list) {
				Element<V> element = new Element<V>(value);
				elementMap.put(value, element);
				fatherMap.put(element, element);
				sizeMap.put(element, 1);
			}
		}
		//找队长
		private Element<V> findHead(Element<V> element) {
			Stack<Element<V>> path = new Stack<>();
			while (element != fatherMap.get(element)) {//从这个while循环出来，这个element已经变成了代表节点了。
				path.push(element);
				element = fatherMap.get(element);
			}
			while (!path.isEmpty()) {//让链条变扁平化，每个元素的父亲直接指向element。
				fatherMap.put(path.pop(), element);
			}
			return element;
		}
		//是不是同一个集合
		public boolean isSameSet(V a, V b) {
			if (elementMap.containsKey(a) && elementMap.containsKey(b)) {//先确定初始化的时候，有没有这个元素。
				return findHead(elementMap.get(a)) == findHead(elementMap.get(b));//如果相等就说明是一个集合，如果不等，说明就不是一个集合。
			}
			return false;
		}
		//合并
		public void union(V a, V b) {
			if (elementMap.containsKey(a) && elementMap.containsKey(b)) {//先确定初始化的时候，有没有这个元素
				Element<V> aF = findHead(elementMap.get(a));//找队长
				Element<V> bF = findHead(elementMap.get(b));//找队长
				if (aF != bF) {//队长不是同一个
					int aSetSize = sizeMap.get(aF);//a集合的大小
					int bSetSize = sizeMap.get(bF);//b集合的大小
					if (aSetSize >= bSetSize) {//如果a集合的大小大于等于b集合的大小
						fatherMap.put(bF, aF);//把b所在集合的代表节点的父改成a所在集合的代表节点的父
						sizeMap.put(aF, aSetSize + bSetSize);//a集合的大小变大
						sizeMap.remove(bF);
					} else {
						fatherMap.put(aF, bF);
						sizeMap.put(bF, aSetSize + bSetSize);
						sizeMap.remove(aF);
					}
				}
			}
		}

	}
}
