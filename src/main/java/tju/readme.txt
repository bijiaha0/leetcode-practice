空间复杂度指的是额外空间，不包括输入和输出所需要的空间。
时间复杂度：
最优解：先满足时间复杂度最优的情况下，使用最小空间。
----------------------
1、Arrays.Sort(arr)是一个综合排序，如果数组的size小于60的时候，会进行insertion sort。
2、如果数组的size大于60的时候，会进行merge排序或者quick排序(他们会进行划分，
如果拆分的结果小于60，然后继续用insertion排序直接排好)。
3、在数组的size大于60的情况下，如果数组的元素是int char double等基础类型的话会用quick排序，如果数组的元素是自定义的class类型，会默认用merge sort。
基础类型排序用quick sort的原因是：它不要求稳定性，它只要求快。
自定义的class类型排序用merge sort的原因是：考虑到稳定性。
-----------------------
完全二叉树：每次都是从左往右长起，你要么就是变满，要么就是从左往右依次变满。
平衡二叉树：任何一个节点，左子树的高度与右子树的高度差不超过1。
搜索二叉树：如何一个节点，左树所有值比它小，右树所有值比它大。

判断一棵树是否是搜索二叉树，用中序遍历，值递增，则说明是搜索二叉树。值不是递增，则说明不是搜索二叉树。
判断一棵树是否是完全二叉树，用宽度优先遍历。在遍历x的时候，出现x有右无左，则不是完全二叉树。当第一次遇到左右两个孩子不双全的时候，那么接下来，我遇到的所有节点都必须是叶节点。

后继节点：在中序遍历的节点中的下一个节点；
先驱节点：在中序遍历的节点中的上一个节点。


