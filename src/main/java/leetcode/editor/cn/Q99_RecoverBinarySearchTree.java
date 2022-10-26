//给你二叉搜索树的根节点 root ，该树中的两个节点被错误地交换。请在不改变其结构的情况下，恢复这棵树。 
//
// 进阶：使用 O(n) 空间复杂度的解法很容易实现。你能想出一个只使用常数空间的解决方案吗？ 
//
// 
//
// 示例 1： 
//
// 
//输入：root = [1,3,null,null,2]
//输出：[3,1,null,null,2]
//解释：3 不能是 1 左孩子，因为 3 > 1 。交换 1 和 3 使二叉搜索树有效。
// 
//
// 示例 2： 
//
// 
//输入：root = [3,1,4,null,null,2]
//输出：[2,1,4,null,null,3]
//解释：2 不能在 3 的右子树中，因为 2 < 3 。交换 2 和 3 使二叉搜索树有效。 
//
// 
//
// 提示： 
//
// 
// 树上节点的数目在范围 [2, 1000] 内 
// -2³¹ <= Node.val <= 2³¹ - 1 
// 
// Related Topics 树 深度优先搜索 二叉搜索树 二叉树 👍 568 👎 0
package leetcode.editor.cn;

import leetcode.editor.cn.warpper.TreeNode;

import java.util.Stack;

/**
 * title: 99 : 恢复二叉搜索树
 * create: 2021-10-06 15:03:29
 */
public class Q99_RecoverBinarySearchTree {
    public static void main(String[] args) {
        Solution solution = new Q99_RecoverBinarySearchTree().new Solution();
        TreeNode generate = TreeNode.generate(new Integer[]{3, 1, 4, null, null, 2});
        solution.recoverTree(generate);
        System.out.println(generate);
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

        TreeNode first = null;
        TreeNode second = null;
        TreeNode pre = null;

        public void recoverTree(TreeNode root) {
            // 方法一：迭代
            // midorder(root);

            // 方法二：递归
            recursion(root);

            if (first != null && second != null) {
                int t = first.val;
                first.val = second.val;
                second.val = t;
            }
        }

        // 递归
        private void recursion(TreeNode node) {
            if (node == null) return;

            recursion(node.left);
            process(node);
            recursion(node.right);
        }

        // 迭代
        private void midorder(TreeNode root) {
            Stack<TreeNode> stack = new Stack<>();
            while (root != null || !stack.isEmpty()) {
                while (root != null) {
                    stack.push(root);
                    root = root.left;
                }
                root = stack.pop();
                process(root);
                root = root.right;
            }
        }

        private void process(TreeNode root) {
            if (pre != null && pre.val > root.val) {
                if (first == null) {
                    first = pre;
                }
                second = root;
            }
            pre = root;
        }

    }
//leetcode submit region end(Prohibit modification and deletion)

}