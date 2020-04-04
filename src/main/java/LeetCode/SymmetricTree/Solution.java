package LeetCode.SymmetricTree;

import java.util.ArrayDeque;
/**
 * Author: bijiaha0
 * Date: 2019-05-25
 * https://leetcode.com/problems/symmetric-tree/
 * id = 101
 */
class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;

    TreeNode(int val) {
        this.val = val;
    }
}

public class Solution {
    public boolean isSymmetric(TreeNode root) {
        if (root == null) {
            return true;
        }
        ArrayDeque<TreeNode> deque = new ArrayDeque<>();
        deque.addFirst(root.left);
        deque.addLast(root.right);
        while (!deque.isEmpty()) {
            TreeNode left = deque.pollFirst();
            TreeNode right = deque.pollLast();
            if (left == null && right == null) {
                continue;
            }
            if (left == null || right == null) {
                return false;
            }
            if (left.val != right.val) {
                return false;
            }
            deque.addFirst(left.left);
            deque.addFirst(left.right);
            deque.addLast(right.right);
            deque.addLast(right.left);
        }
        return true;
    }

    public boolean isSymmetric2(TreeNode root) {
        if (root == null) {
            return true;
        }
        return help(root.left, root.right);
    }

    boolean help(TreeNode left, TreeNode right) {
        if (left == null || right == null) {
            return left == right;
        }
        if (left.val != right.val) {
            return false;
        }
        return help(left.left, right.right) && help(left.right, right.left);
    }
    
}
