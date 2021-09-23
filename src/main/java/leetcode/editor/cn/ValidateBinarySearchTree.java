//给你一个二叉树的根节点 root ，判断其是否是一个有效的二叉搜索树。 
//
// 有效 二叉搜索树定义如下： 
//
// 
// 节点的左子树只包含 小于 当前节点的数。 
// 节点的右子树只包含 大于 当前节点的数。 
// 所有左子树和右子树自身必须也是二叉搜索树。 
// 
//
// 
//
// 示例 1： 
//
// 
//输入：root = [2,1,3]
//输出：true
// 
//
// 示例 2： 
//
// 
//输入：root = [5,1,4,null,null,3,6]
//输出：false
//解释：根节点的值是 5 ，但是右子节点的值是 4 。
// 
//
// 
//
// 提示： 
//
// 
// 树中节点数目范围在[1, 10⁴] 内 
// -2³¹ <= Node.val <= 2³¹ - 1 
// 
// Related Topics 树 深度优先搜索 二叉搜索树 二叉树 👍 1217 👎 0

package leetcode.editor.cn;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 * title: 98 : 验证二叉搜索树
 * create: 2021-09-22 15:51:13
 */
public class ValidateBinarySearchTree {
    public static void main(String[] args) {
        Solution solution = new ValidateBinarySearchTree().new Solution();
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
        private boolean res = true;

        public boolean isValidBST(TreeNode root) {
            preOrder(root, Long.MIN_VALUE, Long.MAX_VALUE);
            return res;
        }

        /**
         * 前序，这里判定下根节点和左右子节点的大小
         */
        // 坑1： 这里要用 long
        private void preOrder(TreeNode root, Long minValue, Long maxValue) {
            if (root == null || !res) {
                return;
            }

            // 坑2： 这里不能相等
            if (minValue >= root.val || maxValue <= root.val) {
                res = false;
                return;
            }

            preOrder(root.left, minValue, (long) root.val);
            preOrder(root.right, (long) root.val, maxValue);
        }

        /**
         * 中序遍历后重新比较一次
         */
        private boolean isValidBst1(TreeNode root) {
            List<Integer> res = new ArrayList<>();
            middleOrder(root, res);
            for (int i = 1; i < res.size(); i++) {
                if (res.get(i - 1) >= res.get(i)) {
                    return false;
                }
            }
            return true;
        }

        public void middleOrder(TreeNode node, List<Integer> list) {
            if (node == null) {
                return;
            }
            middleOrder(node.left, list);
            list.add(node.val);
            middleOrder(node.right, list);
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}