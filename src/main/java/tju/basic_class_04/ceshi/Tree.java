package tju.basic_class_04.ceshi;
/**
 * Author: bijiaha0
 * Date: 2018-10-25
 * Time: 下午6:34
 * Email: clickgwas@gmail.com
 */
public class Tree {
    private Node root;
    public Tree(Node root){
        this.root = root;
    }
    public void travel(INodeHandler nh){
        this.travel(nh, root);
    }
    private void travel(INodeHandler nh,  Node node){//你的前序遍历代码
        if (node == null) {
            return;
        }
        nh.handle(node);
        travel(nh,node.left);
        travel(nh,node.right);
    }
    public static void main(String[] args) {
        Node root = new Node();
        root.data = "a";
        root.left = new Node();
        root.left.data = "b";
        root.right = new Node();
        root.right.data = "f";
        root.left.left = new Node();
        root.left.left.data = "c";
        root.left.right = new Node();
        root.left.right.data = "e";
        root.left.left.left = new Node();
        root.left.left.left.data = "d";
        root.right.left = new Node();
        root.right.left.data = "g";
        root.right.right = new Node();
        root.right.right.data="h";
        INodeHandler nh = new NodePrinter();
        new Tree(root).travel(nh);
    }
}
