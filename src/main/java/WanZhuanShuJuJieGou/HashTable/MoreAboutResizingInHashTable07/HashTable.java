package WanZhuanShuJuJieGou.HashTable.MoreAboutResizingInHashTable07;

import java.util.TreeMap;
//保证hash表的容量必须是素数

//哈希表：均摊复杂性为O(1)，有了更低的时间复杂度，牺牲了一些什么呢？顺序性。
//对于平衡树而言，由于它本身是基于二分搜索树的，存储了元素的顺序性。
//集合，映射----->
//          1、有序集合，有序映射  [平衡树] TreeSet、TreeMap
//          2、无序集合，无序映射  [哈希表] HashSet、HashMap
//      Java8之前，每一个位置对应一个链表，
//      Java8开始，当hash冲突达到一定程度，每个位置从链表转成红黑树(必须是可比较类型的对象，才能转成红黑树)。

public class HashTable<K, V> {
    private final int[] capacity
            = {53,97,193,389,769,1543,3079,6151,12289,24593,
            49157,98317,196613,393241,786433,1572869,3145739,6291469,
            12582917,25165843,50331653,100663319,201326611,402653189,805306457,1610612741};
    private static final int upperTol = 10;
    private static final int lowerTol = 2;
    private static int capacityIndex = 0;

    private TreeMap<K, V>[] hashtable;
    private int size;
    private int M;

    public HashTable(){
        this.M =capacity[capacityIndex] ;
        size = 0;
        hashtable = new TreeMap[M];
        for(int i = 0 ; i < M ; i ++)
            hashtable[i] = new TreeMap<>();
    }

    private int hash(K key){
        return (key.hashCode() & 0x7fffffff) % M;
    }

    public void add(K key, V value){
        TreeMap<K, V> map = hashtable[hash(key)];
        // if(!hashtable[hash(key)].containsKey(key)){
        if(!map.containsKey(key)){
            map.put(key, value);
            size ++;

            if(size >= upperTol * M && capacityIndex +1 < capacity.length)
                capacityIndex ++;
                resize(capacity[capacityIndex]);
        }
    }

    public V remove(K key){
        V ret = null;
        TreeMap<K, V> map = hashtable[hash(key)];
        if(map.containsKey(key)){
            ret = map.remove(key);
            size --;

            if(size <= lowerTol * M && capacityIndex - 1 > 0)
                capacityIndex --;
                resize(capacity[capacityIndex]);
        }
        return ret;
    }

    public void set(K key, V value){
        TreeMap<K, V> map = hashtable[hash(key)];
        if(!map.containsKey(key))
            throw new IllegalArgumentException(key + " doesn't exist!");

        map.put(key, value);
    }

    public boolean contains(K key){
        return hashtable[hash(key)].containsKey(key);
    }

    public V get(K key){
        return hashtable[hash(key)].get(key);
    }

    private void resize(int newM){
        TreeMap<K, V>[] newHashTable = new TreeMap[newM];
        for(int i = 0 ; i < newM ; i ++)
            newHashTable[i] = new TreeMap<>();

        for(int i = 0 ; i < M ; i ++)
            for(K key: hashtable[i].keySet())
                newHashTable[hash(key)].put(key, hashtable[i].get(key));

        this.M = newM;
        this.hashtable = newHashTable;
    }
}
