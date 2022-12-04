//给你一棵以 root 为根的 二叉树 ，请你返回 任意 二叉搜索子树的最大键值和。 
//
// 二叉搜索树的定义如下： 
//
// 
// 任意节点的左子树中的键值都 小于 此节点的键值。 
// 任意节点的右子树中的键值都 大于 此节点的键值。 
// 任意节点的左子树和右子树都是二叉搜索树。 
// 
//
// 
//
// 示例 1： 
//
// 
//
// 
//输入：root = [1,4,3,2,4,2,5,null,null,null,null,null,null,4,6]
//输出：20
//解释：键值为 3 的子树是和最大的二叉搜索树。
// 
//
// 示例 2： 
//
// 
//
// 
//输入：root = [4,3,null,1,2]
//输出：2
//解释：键值为 2 的单节点子树是和最大的二叉搜索树。
// 
//
// 示例 3： 
//
// 
//输入：root = [-4,-2,-5]
//输出：0
//解释：所有节点键值都为负数，和最大的二叉搜索树为空。
// 
//
// 示例 4： 
//
// 
//输入：root = [2,1,3]
//输出：6
// 
//
// 示例 5： 
//
// 
//输入：root = [5,4,8,3,null,6,3]
//输出：7
// 
//
// 
//
// 提示： 
//
// 
// 每棵树有 1 到 40000 个节点。 
// 每个节点的键值在 [-4 * 10^4 , 4 * 10^4] 之间。 
// 
//
// Related Topics 树 深度优先搜索 二叉搜索树 动态规划 二叉树 👍 115 👎 0

package leetcode.editor.cn;

import leetcode.editor.cn.warpper.TreeNode;

/**
 * title: 1373 : 二叉搜索子树的最大键值和
 * create: 2022-11-10 15:33:03
 */
public class Q1373_MaximumSumBstInBinaryTree {
    public static void main(String[] args) {
        Solution solution = new Q1373_MaximumSumBstInBinaryTree().new Solution();
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
        int maxSum = 0;

        public int maxSumBST(TreeNode root) {
            recursion(root);
            return maxSum;
        }

        /**
         * 返回: 是否是BST、以 root 为根的⼆叉树所有节点中的最⼩值、以 root 为根的⼆叉树所有节点中的最大值、以root 为根的⼆叉树所有节点值之和
         */
        private int[] recursion(TreeNode root) {
            if (root == null) {
                return new int[]{1, Integer.MAX_VALUE, Integer.MIN_VALUE, 0};
            }

            int[] left = recursion(root.left);
            int[] right = recursion(root.right);

            int[] res = new int[4];
            // 左右子树为BST、当前节点比左子树最大值大，比右子树最小值小
            if (left[0] == 1 && right[0] == 1 && root.val > left[2] && root.val < right[1]) {
                // 当前节点为BST
                res[0] = 1;
                // 以 root 为根的 BST 所有节点中的最⼩值
                res[1] = Math.min(left[1], root.val);
                // 以 root 为根的 BST 所有节点中的最大值
                res[2] = Math.max(right[2], root.val);
                // 以 root 为根的 BST 所有节点中的 值之和
                res[3] = left[3] + right[3] + root.val;
                // 更新全局 最大和
                maxSum = Math.max(res[3], maxSum);
            } else {
                res[0] = 0;
            }
            return res;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}