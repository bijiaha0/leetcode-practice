package tju.basic_class_06;
/*
* 搜索二叉树：
*       在这个树中任何一个节点，左子树都比它小，右子树都比它大。
* */
/**
 * Not implemented by zuochengyun
 * 
 * Binary search tree implementation.
 * 
 * In computer science, a binary search tree (BST), which may sometimes also be
 * called an ordered or sorted binary tree, is a node-based binary tree data
 * structure which has the following properties:
 * 
 * a) The left subtree of a node contains only nodes with keys less than the node's key. </br>
 * b) The right subtree of a node contains only nodes with keys greater than the node's key. </br>
 * c) Both the left and right subtrees must also be binary search trees. </br>
 * 
 * @author Ignas Lelys
 * @created May 6, 2011
 * 
 */
public class BinarySearchTree extends AbstractBinarySearchTree {

    @Override
    protected Node createNode(int value, Node parent, Node left, Node right) {
        return new Node(value, parent, left, right);
    }

}
