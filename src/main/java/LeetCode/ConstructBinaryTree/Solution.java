package LeetCode.ConstructBinaryTree;

class TreeNode {
      int val;
      TreeNode left;
      TreeNode right;
      TreeNode(int x) { val = x; }
}
public class Solution {
    public TreeNode buildTree(int[] in,int[] pre){
        int[] curIn = {0};
        int[] curPre = {0};
        return construct(in,pre,curIn,curPre,Integer.MAX_VALUE);
    }

    public TreeNode construct(int[] in,int[] pre,int[] curIn,int[] curPre,int check){
        if(curPre[0]==pre.length){
            return null;
        }
        if(check==in[curIn[0]]){
            curIn[0]++;
            return null;
        }
        TreeNode root = new TreeNode(pre[curPre[0]++]);
        root.left = construct(in,pre,curIn,curPre,root.val);
        root.right = construct(in,pre,curIn,curPre,check);
        return root;
    }

    public static void main(String[] args) {
        int[] preorder = new int[]{3,9,20,15,7};
        int[] inorder = new int[]{9,3,15,20,7};
        TreeNode treeNode = new Solution().buildTree(inorder, preorder);
        System.out.println(treeNode);
    }
}
