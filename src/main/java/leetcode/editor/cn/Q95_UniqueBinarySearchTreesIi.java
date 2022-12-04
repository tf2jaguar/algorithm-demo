//给你一个整数 n ，请你生成并返回所有由 n 个节点组成且节点值从 1 到 n 互不相同的不同 二叉搜索树 。可以按 任意顺序 返回答案。 
//
// 
//
// 
// 
// 示例 1： 
// 
// 
//输入：n = 3
//输出：[[1,null,2,null,3],[1,null,3,2],[2,1,3],[3,1,null,null,2],[3,2,null,1]]
// 
// 
// 
//
// 示例 2： 
//
// 
//输入：n = 1
//输出：[[1]]
// 
//
// 
//
// 提示： 
//
// 
// 1 <= n <= 8 
// 
//
// Related Topics 树 二叉搜索树 动态规划 回溯 二叉树 👍 1342 👎 0

package leetcode.editor.cn;

import leetcode.editor.cn.warpper.TreeNode;

import java.util.LinkedList;
import java.util.List;

/**
 * title: 95 : 不同的二叉搜索树 II
 * create: 2022-11-14 16:27:36
 */
public class Q95_UniqueBinarySearchTreesIi {
    public static void main(String[] args) {
        Solution solution = new Q95_UniqueBinarySearchTreesIi().new Solution();
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
        public List<TreeNode> generateTrees(int n) {
            if (n == 0) {
                return new LinkedList<>();
            }
            return generateTrees(1, n);
        }

        /**
         * 遍历每个节点作为跟节点，左边为左子树，右边为右子树
         * 左子树有多种构建方式、右子树有多种构建方式，二者的笛卡尔积 为当前节点作为跟节点的总二叉树搜索树的种类数量
         */
        private List<TreeNode> generateTrees(int start, int end) {
            List<TreeNode> res = new LinkedList<>();
            if (start > end) {
                res.add(null);
                return res;
            }
            for (int i = start; i <= end; i++) {
                List<TreeNode> left = generateTrees(start, i - 1);
                List<TreeNode> right = generateTrees(i + 1, end);

                // 左右 做笛卡尔积
                for (TreeNode le : left) {
                    for (TreeNode ri : right) {
                        TreeNode node = new TreeNode(i);
                        node.left = le;
                        node.right = ri;
                        res.add(node);
                    }
                }
            }
            return res;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}