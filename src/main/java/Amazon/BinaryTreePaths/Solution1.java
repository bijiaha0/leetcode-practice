package Amazon.BinaryTreePaths;
import java.util.ArrayList;
import java.util.List;
/**
 * 给一棵二叉树，找出从根节点到叶子节点的所有路径。
 * https://www.jiuzhang.com/solutions/binary-tree-paths/
 */

public class Solution1 {

    public List<String> binaryTreePaths(TreeNode root) {

        List<String> paths = new ArrayList<>();
        if (root == null) {
            return paths;
        }

        List<String> leftPaths = binaryTreePaths(root.left);
        List<String> rightPaths = binaryTreePaths(root.right);

        for (String path : leftPaths) {
            paths.add(root.val + "->" + path);
        }

        for (String path : rightPaths) {
            paths.add(root.val + "->" + path);
        }

        // root is a leaf
        if (paths.size() == 0) {
            paths.add("" + root.val);
        }

        return paths;

    }
}
