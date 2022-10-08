//
// 
// 给你两棵二叉树 root 和 subRoot 。检验 root 中是否包含和 subRoot 具有相同结构和节点值的子树。如果存在，返回 true ；否则
//，返回 false 。 
//
// 二叉树 tree 的一棵子树包括 tree 的某个节点和这个节点的所有后代节点。tree 也可以看做它自身的一棵子树。 
//
// 
//
// 示例 1： 
//
// 
//输入：root = [3,4,5,1,2], subRoot = [4,1,2]
//输出：true
// 
//
// 示例 2： 
//
// 
//输入：root = [3,4,5,1,2,null,null,null,null,0], subRoot = [4,1,2]
//输出：false
// 
//
// 
//
// 提示： 
//
// 
// root 树上的节点数量范围是 [1, 2000] 
// subRoot 树上的节点数量范围是 [1, 1000] 
// -10⁴ <= root.val <= 10⁴ 
// -10⁴ <= subRoot.val <= 10⁴ 
// 
// 
// 
// Related Topics 树 深度优先搜索 二叉树 字符串匹配 哈希函数 👍 556 👎 0

package leetcode.editor.cn;

import leetcode.editor.cn.warpper.TreeNode;

/**
 * title: 572 : 另一棵树的子树
 * create: 2021-09-29 20:16:54
 */
public class Q572_SubtreeOfAnotherTree {
    public static void main(String[] args) {
        Solution solution = new Q572_SubtreeOfAnotherTree().new Solution();
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
        public boolean isSubtree(TreeNode root, TreeNode subRoot) {
//            return zip(root, subRoot);
            return recursion(root, subRoot);
        }

        /**
         * 2. 递归解法
         */
        public boolean recursion(TreeNode a, TreeNode b) {
            return isSubTree(a, b);
        }

        private boolean isSubTree(TreeNode a, TreeNode b) {
            if (a == b) {
                return true;
            }
            if (a == null || b == null) {
                return false;
            }
            return a.val == b.val && isSameTree(a, b) || isSubTree(a.left, b) || isSubTree(a.right, b);
        }

        private boolean isSameTree(TreeNode a, TreeNode b) {
            if (a == b) {
                return true;
            }
            if (a == null || b == null) {
                return false;
            }
            return a.val == b.val && isSameTree(a.left, b.left) && isSameTree(a.right, b.right);
        }

        /**
         * 1. 压缩算法。将树按照策略压缩成字符串，树的问题变成了字符串问题
         */
        public boolean zip(TreeNode root, TreeNode subRoot) {
            StringBuilder rB = new StringBuilder("#");
            StringBuilder sB = new StringBuilder("#");
            zipTreeNode(root, rB);
            zipTreeNode(subRoot, sB);
            return rB.toString().contains(sB.toString());
        }

        private void zipTreeNode(TreeNode node, StringBuilder builder) {
            if (node == null) {
                builder.append("@").append("#");
            } else {
                builder.append(node.val).append("#");
                zipTreeNode(node.left, builder);
                zipTreeNode(node.right, builder);
            }
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}