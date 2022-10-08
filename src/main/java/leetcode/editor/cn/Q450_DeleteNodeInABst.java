//给定一个二叉搜索树的根节点 root 和一个值 key，删除二叉搜索树中的 key 对应的节点，并保证二叉搜索树的性质不变。返回二叉搜索树（有可能被更新）的
//根节点的引用。 
//
// 一般来说，删除节点可分为两个步骤： 
//
// 
// 首先找到需要删除的节点； 
// 如果找到了，删除它。 
// 
//
// 说明： 要求算法时间复杂度为 O(h)，h 为树的高度。 
//
// 示例: 
//
// 
//root = [5,3,6,2,4,null,7]
//key = 3
//
//    5
//   / \
//  3   6
// / \   \
//2   4   7
//
//给定需要删除的节点值是 3，所以我们首先找到 3 这个节点，然后删除它。
//
//一个正确的答案是 [5,4,6,2,null,null,7], 如下图所示。
//
//    5
//   / \
//  4   6
// /     \
//2       7
//
//另一个正确答案是 [5,2,6,null,4,null,7]。
//
//    5
//   / \
//  2   6
//   \   \
//    4   7
// 
// Related Topics 树 二叉搜索树 二叉树 👍 537 👎 0

package leetcode.editor.cn;

import leetcode.editor.cn.warpper.TreeNode;

/**
 * title: 450 : 删除二叉搜索树中的节点
 * create: 2021-10-07 09:55:12
 */
public class Q450_DeleteNodeInABst {
    public static void main(String[] args) {
        Solution solution = new Q450_DeleteNodeInABst().new Solution();
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
        public TreeNode deleteNode(TreeNode root, int key) {
            if (root == null) {
                return null;
            }
            if (key < root.val) {
                root.left = deleteNode(root.left, key);
            } else if (key > root.val) {
                root.right = deleteNode(root.right, key);
            } else {
                // 当前树只有一个节点，直接返回null
                if (root.left == null && root.right == null) {
                    return null;
                } else if (root.left != null) {
                    // 当前节点还有左子树，找到左子树中的较大值
                    TreeNode lLarge = root.left;
                    while (lLarge.right != null) {
                        lLarge = lLarge.right;
                    }
                    // 交换后再删除
                    swapVal(root, lLarge);
                    root.left = deleteNode(root.left, key);
                } else if (root.right != null) {
                    // 当前节点还有右子树，找到右子树中的较小值
                    TreeNode rSmall = root.right;
                    while (rSmall.left != null) {
                        rSmall = rSmall.left;
                    }
                    // 交换后再删除
                    swapVal(root, rSmall);
                    root.right = deleteNode(root.right, key);
                }
            }
            return root;
        }

        private void swapVal(TreeNode n1, TreeNode n2) {
            n1.val = n1.val ^ n2.val;
            n2.val = n1.val ^ n2.val;
            n1.val = n1.val ^ n2.val;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}