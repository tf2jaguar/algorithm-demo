//给你一个二叉搜索树的根节点 root ，返回 树中任意两不同节点值之间的最小差值 。 
//
// 注意：本题与 530：https://leetcode-cn.com/problems/minimum-absolute-difference-in-bst/ 相同
//
// 
//
// 
// 
// 示例 1： 
//
// 
//输入：root = [4,2,6,1,3]
//输出：1
// 
//
// 示例 2： 
//
// 
//输入：root = [1,0,48,null,null,12,49]
//输出：1
// 
//
// 
//
// 提示： 
//
// 
// 树中节点数目在范围 [2, 100] 内 
// 0 <= Node.val <= 10⁵ 
// 差值是一个正数，其数值等于两值之差的绝对值 
// 
// 
// 
// Related Topics 树 深度优先搜索 广度优先搜索 二叉搜索树 二叉树 👍 201 👎 0

package leetcode.editor.cn;

/**
 * title: 783 : 二叉搜索树节点最小距离
 * create: 2021-10-06 14:29:09
 */
public class MinimumDistanceBetweenBstNodes {
    public static void main(String[] args) {
        Solution solution = new MinimumDistanceBetweenBstNodes().new Solution();
        TreeNode treeNode = TreeNode.generate(new Integer[]{1, 0, 48, null, null, 12, 49});
        System.out.println(solution.minDiffInBST(treeNode));
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
        int res = Integer.MAX_VALUE;
        TreeNode pre = null;

        public int minDiffInBST(TreeNode root) {
            preorder(root);
            return res;
        }

        private void preorder(TreeNode root) {
            if (root == null) {
                return;
            }
            preorder(root.left);
            if (pre != null) {
                res = Math.min(res, Math.abs(root.val - pre.val));
            }
            pre = root;
            preorder(root.right);
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}