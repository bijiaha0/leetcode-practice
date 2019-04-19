package Amazon.ConvertBinarySearchTreeToDoublyLinkedList;
/**
 * Email: clickgwas@gmail.com
 * https://www.jiuzhang.com/solutions/convert-binary-search-tree-to-doubly-linked-list/
 */
class TreeNode {
      public int val;
      public TreeNode left, right;
      public TreeNode(int val) {
          this.val = val;
          this.left = this.right = null;
      }
  }
class DoublyListNode {
      int val;
      DoublyListNode next, prev;
      DoublyListNode(int val) {
          this.val = val;
          this.next = this.prev = null;
      }
  }
class ResultType {
    DoublyListNode first, last;

    public ResultType(DoublyListNode first, DoublyListNode last) {
        this.first = first;
        this.last = last;
    }
}
public class Solution {
    public DoublyListNode bstToDoublyList(TreeNode root) {
        if (root == null) {
            return null;
        }

        ResultType result = helper(root);
        return result.first;
    }

    //中序遍历函数
    public ResultType helper(TreeNode root) {
        if (root == null) {
            return null;
        }

        ResultType left = helper(root.left);
        ResultType right = helper(root.right);
        DoublyListNode node = new DoublyListNode(root.val);

        ResultType result = new ResultType(null, null);

        //构造单链表
        if (left == null) {
            result.first = node;
        } else {
            result.first = left.first;
            left.last.next = node;
            node.prev = left.last;
        }

        if (right == null) {
            result.last = node;
        } else {
            result.last = right.last;
            right.first.prev = node;
            node.next = right.first;
        }

        return result;
    }
}
