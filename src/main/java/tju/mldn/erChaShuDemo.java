package tju.mldn;

import java.util.Arrays;

/**
 * Author: bijiaha0
 * Date: 2018-09-08
 * Time: 下午5:45
 * Email: clickgwas@gmail.com
 */
public class erChaShuDemo {
    public static void main(String[] args) {
        BinaryTree<Person> tree = new BinaryTree<Person>() ;
        tree.add(new Person("小强-80",80));
        tree.add(new Person("小强-50",50));
        tree.add(new Person("小强-60",60));
        tree.add(new Person("小强-30",30));
        tree.add(new Person("小强-90",90));
        tree.add(new Person("小强-10",10));
        tree.add(new Person("小强-55",55));
        tree.add(new Person("小强-70",70));
        tree.add(new Person("小强-85",85));
        tree.add(new Person("小强-95",95));
        tree.remove(new Person("小强-80",80));
        System.out.println(Arrays.toString(tree.toArray()));
    }
}
/**
 * 实现二叉树操作
 * @param <T> 要进行二叉树的实现
 */
class BinaryTree<T extends Comparable<T>> {
    private class Node {
        private Comparable<T> data ; // 存放Comparable，可以比较大小
        private Node parent ;	// 保存父节点
        private Node left ; // 保存左子树
        private Node right ; // 保存右子树
        public Node(Comparable<T> data) {	// 构造方法直接负责进行数据的存储
            this.data = data ;
        }
        /**
         * 实现节点数据的适当位置的存储
         * @param newNode 创建的新节点
         */
        public void addNode(Node newNode) {
            if (newNode.data.compareTo((T)this.data) <= 0) {	// 比当前节点数据小
                if (this.left == null) {	// 现在没有左子树
                    this.left = newNode ; 	// 保存左子树
                    newNode.parent = this ; // 保存父节点
                } else {	// 需要向左边继续判断
                    this.left.addNode(newNode); // 继续向下判断
                }
            } else {	// 比根节点的数据要大
                if (this.right == null) {
                    this.right = newNode ; // 没有右子树
                    newNode.parent = this ; // 保存父节点
                } else {
                    this.right.addNode(newNode); // 继续向下判断
                }
            }
        }
        /**
         * 实现所有数据的获取处理，按照中序遍历的形式来完成
         */
        public void toArrayNode() {
            if (this.left != null) {	// 有左子树
                this.left.toArrayNode();  // 递归调用
            }
            BinaryTree.this.returnData[BinaryTree.this.foot ++] = this.data ;
            if (this.right != null) {
                this.right.toArrayNode();
            }
        }
        /**
         * 进行数据的检索处理
         * @param data 要检索的数据
         * @return 找到返回true，找不到返回false
         */
        public boolean containsNode(Comparable<T> data) {
            if (data.compareTo((T)this.data) == 0) {
                return true ; // 查找到了
            } else if (data.compareTo((T)this.data) < 0) {	// 左边有数据
                if (this.left != null) {
                    return this.left.containsNode(data) ;
                } else {
                    return false ;
                }
            } else {
                if (this.right != null) {
                    return this.right.containsNode(data) ;
                } else {
                    return false ;
                }
            }
        }
        /**
         * 获取要删除的节点对象
         * @param data 比较的对象
         * @return 要删除的节点对象，对象一定存在
         */
        public Node getRemoveNode(Comparable<T> data) {
            if (data.compareTo((T)this.data) == 0) {
                return this ; // 查找到了
            } else if (data.compareTo((T)this.data) < 0) {	// 左边有数据
                if (this.left != null) {
                    return this.left.getRemoveNode(data) ;
                } else {
                    return null ;
                }
            } else {
                if (this.right != null) {
                    return this.right.getRemoveNode(data) ;
                } else {
                    return null ;
                }
            }
        }
    }
    // ------------ 以下为二叉树的功能实现 ----------------
    private Node root ; // 保存的是根节点
    private int count ; // 保存数据个数
    private Object [] returnData ; // 返回的数据
    private int foot = 0 ; // 脚标控制
    /**
     * 进行数据的保存
     * @param data 要保存的数据内容
     * @exception NullPointerException 保存数据为空时抛出的异常
     */
    public void add(Comparable<T> data) {
        if (data == null) {
            throw new NullPointerException("保存的数据不允许为空！") ;
        }
        // 所有的数据本身不具备有节点关系的匹配，那么一定要将其包装在Node类之中
        Node newNode = new Node(data) ;	// 保存节点
        if (this.root == null) {	// 现在没有根节点，则第一个节点作为根节点
            this.root = newNode ;
        } else {	// 需要为其保存到一个合适的节点
            this.root.addNode(newNode) ; // 交由Node类负责处理
        }
        this.count ++ ;
    }
    /**
     * 现在的检索主要依靠的是Comparable实现的数据比较
     * @param data 要比较的数据
     * @return 查找到数据返回true，否则返回false
     */
    public boolean contains(Comparable<T> data) {
        if (this.count == 0) {	// 还没有数据
            return false ;
        }
        return this.root.containsNode(data) ; // 该操作一定要交给Node类完成
    }
    /**
     * 以对象数组的形式返回全部数据，如果没有数据返回null
     * @return 全部数据
     */
    public Object[] toArray() {
        if (this.count == 0) {
            return null ;
        }
        this.returnData = new Object[this.count] ; // 保存长度为数组长度
        this.foot = 0 ; // 脚标清零
        this.root.toArrayNode() ; // 直接通过Node类负责
        return this.returnData ; // 返回全部的数据
    }
    /**
     * 执行数据的删除处理
     * @param data 要删除的数据
     */
    public void remove(Comparable<T> data) {
        if (this.root == null) {	// 根节点不存在
            return ;// 结束调用
        } else {
            if (this.root.data.compareTo((T)data) == 0) {	// 要删除的是根节点
                Node moveNode = this.root.right ; // 移动的节点
                while(moveNode.left != null) {	// 现在还有左边的节点
                    moveNode = moveNode.left ; // 一直向左找
                }	// 就可以确定删除节点的右节点的最小的左节点
                moveNode.left = this.root.left ;
                moveNode.right = this.root.right ;
                moveNode.parent.left = null ;
                this.root = moveNode ;// 改变根节点
            } else {
                Node removeNode = this.root.getRemoveNode(data) ;// 找到要删除的节点
                if (removeNode != null) {	// 找到要删除的对象信息
                    // 情况一：没有任何的子节点
                    if (removeNode.left == null && removeNode.right == null) {
                        removeNode.parent.left = null ;
                        removeNode.parent.right = null ;
                        removeNode.parent = null ; // 父节点直接断开引用
                    } else if (removeNode.left != null && removeNode.right == null) {	// 左边不为空
                        removeNode.parent.left = removeNode.left ;
                        removeNode.left.parent = removeNode.parent ;
                    } else if (removeNode.left == null && removeNode.right != null) {	// 右边不为空
                        removeNode.parent.left = removeNode.right ;
                        removeNode.right.parent = removeNode.parent ;
                    } else {	// 两边都有节点，则将右边节点中最左边的节点找到，改变其指向；
                        Node moveNode = removeNode.right ; // 移动的节点
                        while(moveNode.left != null) {	// 现在还有左边的节点
                            moveNode = moveNode.left ; // 一直向左找
                        }	// 就可以确定删除节点的右节点的最小的左节点
                        removeNode.parent.left = moveNode ;
                        moveNode.parent.left = null ; // 断开原本的连接
                        moveNode.parent = removeNode.parent ;
                        moveNode.right = removeNode.right ; // 改变原始的右节点的指向
                        moveNode.left = removeNode.left ;
                    }
                }
            }
            this.count -- ;
        }
    }
}
class Person implements Comparable<Person> {
    private String name ;
    private int age ;
    public Person(String name, int age) {
        this.name = name;
        this.age = age;
    }
    @Override
    public int compareTo(Person per) {
        return this.age - per.age ;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    // 无参构造、setter、getter略
    @Override
    public String toString() {
        return "【Person类对象】姓名：" + this.name + "、年龄：" + this.age + "\n" ;
    }
}
