package tju.mldn.LinkDemo;

/**
 * Author: bijiaha0
 * Date: 2018-09-08
 * Time: 下午5:30
 * Email: clickgwas@gmail.com
 */
public class LinkDemo {
    public static void main(String args[]) {
        ILink<String> all = new LinkImpl<String>() ;
        System.out.println("【增加之前】数据个数：" + all.size() + "、是否为空集合：" + all.isEmpty()) ;
        all.add("Hello") ;
        all.add("World") ;
        all.add("MLDN") ;
        all.remove("World") ;
        all.clean();
        System.out.println("【增加之后】数据个数：" + all.size() + "、是否为空集合：" + all.isEmpty()) ;
        Object result [] = all.toArray() ;
        if (result != null) {
            for (Object obj : result) {
                System.out.println(obj) ;
            }
        }
        System.out.println("----------- 数据获取的分割线 -----------") ;
        System.out.println(all.get(0)) ;
        System.out.println(all.get(1)) ;
        System.out.println(all.get(4)) ;
        System.out.println("----------- 数据判断的分割线 -----------") ;
        System.out.println(all.contains("高")) ;
        System.out.println(all.contains("Hello")) ;
    }
}
interface ILink<E> {	// 设置泛型避免安全隐患
    public void add(E e) ;	// 增加数据
    public int size() ;	// 获取数据的个数
    public boolean isEmpty() ;	// 判断是否空集合
    public Object [] toArray() ; // 将集合元素以数组的形式返回
    public E get(int index) ; // 根据索引获取数据
    public void set(int index,E data) ;// 修改索引数据
    public boolean contains(E data) ; // 判断数据是否存在
    public void remove(E e) ;	// 数据删除
    public void clean() ;	// 清空集合
}
class LinkImpl<E> implements ILink<E> {
    private class Node {	// 保存节点的数据关系
        private E data ;  // 保存的数据
        private Node next ; // 保存下一个引用
        public Node(E data) {	// 有数据的情况下才有意义
            this.data = data ;
        }
        // 第一次调用：this = LinkImpl.root；
        // 第二次调用：this = LinkImpl.root.next；
        // 第三次调用：this = LinkImpl.root.next.next；
        public void addNode(Node newNode) {	// 保存新的Node数据
            if (this.next == null) {	// 当前节点的下一个节点为null
                this.next = newNode ; // 保存当前节点
            } else {
                this.next.addNode(newNode) ;
            }
        }
        // 第一次调用：this = LinkImpl.root
        // 第二次调用：this = LinkImp.root.next
        // 第三次调用：this = LinkImp.root.next.next
        public void toArrayNode(){
            LinkImpl.this.returnData [LinkImpl.this.foot ++] = this.data ;
            if (this.next != null) {	// 还有下一个数据
                this.next.toArrayNode() ;
            }
        }
        public E getNode(int index) {
            if (LinkImpl.this.foot ++ == index) {	// 索引相同
                return this.data ; // 返回当前数据
            } else {
                return this.next.getNode(index) ;
            }
        }
        public void setNode(int index,E data) {
            if (LinkImpl.this.foot ++ == index) {	// 索引相同
                this.data = data ; // 修改数据
            } else {
                this.next.setNode(index,data) ;
            }
        }
        public boolean containsNode(E data) {
            if (data.equals(this.data)) {	// 对象比较
                return true ;
            } else {
                if (this.next == null) {	// 没有后续节点了
                    return false ;	// 找不到
                } else {
                    return this.next.containsNode(data) ;	// 向后继续判断
                }
            }
        }
        public void removeNode(Node previous,E data) {
            if (this.data.equals(data)) {
                previous.next = this.next ; // 空出当前节点
            } else {
                if (this.next != null) {	// 有后续节点
                    this.next.removeNode(this,data) ;	// 向后继续删除
                }
            }
        }
    }
    // --------------- 以下为Link类中定义的成员 ------------------
    private Node root ; // 保存根元素
    private int count ; // 保存数据个数
    private int foot ; // 描述的是操作数组的脚标
    private Object [] returnData ; // 返回的数据保存
    // --------------- 以下为Link类中定义的方法 ------------------
    public void add(E e) {
        if (e == null) {	// 保存的数据为null
            return ; // 方法调用直接结束
        }
        // 数据本身是不具有关联特性的，只有Node类有，那么要想实现关联处理就必须将数据包装在Node类之中
        Node newNode = new Node(e) ; // 创建一个新的节点
        if (this.root == null) {	// 现在没有根节点
            this.root = newNode ; // 第一个节点作为根节点
        } else {	// 根节点存在
            this.root.addNode(newNode) ;// 将新节点保存在合适的位置
        }
        this.count ++ ;
    }
    public int size() {
        return this.count ;
    }
    public boolean isEmpty() {
        // return this.root == null ;
        return this.count == 0 ;
    }
    public Object[] toArray() {
        if (this.isEmpty())	{	// 空集合
            return null ; // 现在没有数据
        }
        this.foot = 0 ; // 脚标清零
        this.returnData = new Object [this.count] ;	// 根据已有的长度开辟数组
        this.root.toArrayNode() ;// 利用Node类进行递归数据获取
        return this.returnData ;
    }
    public E get(int index) {
        if (index >= this.count) {	// 索引应该在指定的范围之内
            return null ;
        }	// 索引数据的获取应该由Node类完成
        this.foot = 0 ; // 重置索引的下标
        return this.root.getNode(index) ;
    }
    public void set(int index,E data) {
        if (index >= this.count) {	// 索引应该在指定的范围之内
            return ;	// 方法结束
        }	// 索引数据的获取应该由Node类完成
        this.foot = 0 ; // 重置索引的下标
        this.root.setNode(index,data) ;	// 修改数据
    }
    public boolean contains(E data) {
        if (data == null) {
            return false ;	// 没有数据
        }
        return this.root.containsNode(data) ;	// 交给Node类判断
    }
    public void remove(E data) {
        if (this.contains(data)) {	// 判断数据是否存在
            if (this.root.data.equals(data)) {	// 根节点为要删除节点
                this.root = this.root.next ; // 根的下一个节点
            } else {	// 交由Node类负责删除
                this.root.next.removeNode(this.root,data) ;
            }
            this.count -- ;
        }
    }
    public void clean() {
        this.root = null ; // 后续的所有节点都没了
        this.count = 0 ; // 个数清零
    }
}
