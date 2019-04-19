package Amazon.InorderSuccessorInBST;
/**
 * Author: bijiaha0
 * Date: 2019-02-23
 * Time: 12:40 PM
 * Email: clickgwas@gmail.com
 * https://www.lintcode.com/problem/inorder-successor-in-bst/description
 * 遇到BST上操作的问题，可以拿给定的节点（区间）与root做比较，分类讨论、分而治之。
 * 两种情况：
 * 1、root的值 =< p的值，答案就在右子树中
 * 2、root的值 > p的值，答案有两个备选
 *      a、就是root
 *      b、左子树中继续找，并且如果找到就一定是它，因为左子树中的元素都比根小
 */
class TreeNode{
    int val;
    TreeNode left;
    TreeNode right;
    TreeNode(int val){
        this.val =val;
    }
}
public class InorderSuccessorInBST {
    public TreeNode inorderSuccessor(TreeNode root, TreeNode p) {
        if (root == null || p == null) {
            return null;
        }
        if (root.val <= p.val) {
            return inorderSuccessor(root.right, p);
        } else {
            TreeNode left = inorderSuccessor(root.left, p);
            return (left != null) ? left : root;
        }
    }
}
