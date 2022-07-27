//路径 被定义为一条从树中任意节点出发，沿父节点-子节点连接，达到任意节点的序列。同一个节点在一条路径序列中 至多出现一次 。该路径 至少包含一个 节点，且不
//一定经过根节点。 
//
// 路径和 是路径中各节点值的总和。 
//
// 给你一个二叉树的根节点 root ，返回其 最大路径和 。 
//
// 
//
// 示例 1： 
// 
// 
//输入：root = [1,2,3]
//输出：6
//解释：最优路径是 2 -> 1 -> 3 ，路径和为 2 + 1 + 3 = 6 
//
// 示例 2： 
// 
// 
//输入：root = [-10,9,20,null,null,15,7]
//输出：42
//解释：最优路径是 15 -> 20 -> 7 ，路径和为 15 + 20 + 7 = 42
// 
//
// 
//
// 提示： 
//
// 
// 树中节点数目范围是 [1, 3 * 10⁴] 
// -1000 <= Node.val <= 1000 
// 
//
// Related Topics 树 深度优先搜索 动态规划 二叉树 👍 1667 👎 0

package leetcode.editor.cn;

/**
 * title: 124 : 二叉树中的最大路径和
 * create: 2022-07-27 14:17:39
 */
public class BinaryTreeMaximumPathSum {
    public static void main(String[] args) {
        Solution solution = new BinaryTreeMaximumPathSum().new Solution();
        TreeNode generate = TreeNode.generate(new Integer[]{-10, 9, 20, null, null, 15, 7});
        int i = solution.maxPathSum(generate);
        System.out.println(i);
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
        int max = Integer.MIN_VALUE;

        public int maxPathSum(TreeNode root) {
            recursion(root);
            return max;
        }

        private int recursion(TreeNode root) {
            if (root == null) return 0;
            // 因为取最大的，则如果子节点路径和是小于0的，就设为0
            int left = Math.max(0, recursion(root.left));
            int right = Math.max(0, recursion(root.right));
            // 比较出最大的路径
            max = Math.max(max, left + right + root.val);

            return Math.max(left, right) + root.val;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}