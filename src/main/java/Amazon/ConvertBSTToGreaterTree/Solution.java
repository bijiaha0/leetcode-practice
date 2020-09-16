package Amazon.ConvertBSTToGreaterTree;
class TreeNode{
    TreeNode left;
    TreeNode right;
    int val;
    TreeNode(int val){
        this.val = val;
    }
}


/**
 * 反中根遍历
 * https://www.jiuzhang.com/solutions/convert-bst-to-greater-tree/
 */
public class Solution {

    int sum = 0;

    public TreeNode convertBST(TreeNode root) {
        dfs(root);
        return root;
    }

    void dfs(TreeNode root){
        if(root==null){
            return;
        }
        convertBST(root.right);
        sum += root.val;
        root.val=sum;
        convertBST(root.left);
    }

}
