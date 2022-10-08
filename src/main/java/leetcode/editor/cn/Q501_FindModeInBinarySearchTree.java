//给定一个有相同值的二叉搜索树（BST），找出 BST 中的所有众数（出现频率最高的元素）。 
//
// 假定 BST 有如下定义： 
//
// 
// 结点左子树中所含结点的值小于等于当前结点的值 
// 结点右子树中所含结点的值大于等于当前结点的值 
// 左子树和右子树都是二叉搜索树 
// 
//
// 例如： 
//给定 BST [1,null,2,2], 
//
//    1
//    \
//     2
//    /
//   2
// 
//
// 返回[2]. 
//
// 提示：如果众数超过1个，不需考虑输出顺序 
//
// 进阶：你可以不使用额外的空间吗？（假设由递归产生的隐式调用栈的开销不被计算在内） 
// Related Topics 树 深度优先搜索 二叉搜索树 二叉树 👍 354 👎 0

package leetcode.editor.cn;

import leetcode.editor.cn.warpper.TreeNode;

import java.util.LinkedList;
import java.util.List;

/**
 * title: 501 : 二叉搜索树中的众数
 * create: 2021-10-06 11:10:08
 */
public class Q501_FindModeInBinarySearchTree {
    public static void main(String[] args) {
        Solution solution = new Q501_FindModeInBinarySearchTree().new Solution();
        TreeNode treeNode = TreeNode.generate(new Integer[]{1});
        for (int i : solution.findMode(treeNode)) {
            System.out.println(i);
        }
    }
    //leetcode submit region begin(Prohibit modification and deletion)

    /**
     * Definition for a binary tree node.
     * public class TreeNode {
     * int val;
     * TreeNode left;
     * TreeNode right;
     * TreeNode() {}
     * TreeNode(int val) { this.val = val; }
     * TreeNode(int val, TreeNode left, TreeNode right) {
     * this.val = val;
     * this.left = left;
     * this.right = right;
     * }
     * }
     */
    class Solution {
        private int lastVal;
        private int curCount = 0;
        private int maxCount = Integer.MIN_VALUE;

        public int[] findMode(TreeNode root) {
            if (root == null) {
                return new int[0];
            }
            // 找到搜索树中出现最大的个数
            midOrder(root, null);
            // 统计出现最大次数的val值，重置当前数出现次数的统计
            List<Integer> res = new LinkedList<>();
            curCount = 0;
            midOrder(root, res);
            return res.stream().mapToInt(r -> r).toArray();
        }

        public void midOrder(TreeNode node, List<Integer> res) {
            if (node == null) {
                return;
            }
            midOrder(node.left, res);
            if (lastVal == node.val) {
                curCount++;
            } else {
                lastVal = node.val;
                curCount = 1;
            }
            if (res != null && maxCount == curCount) {
                res.add(lastVal);
            }
            maxCount = Math.max(maxCount, curCount);
            midOrder(node.right, res);
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}