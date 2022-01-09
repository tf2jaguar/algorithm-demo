//给你二叉树的根节点 root ，返回其节点值的 锯齿形层序遍历 。（即先从左往右，再从右往左进行下一层遍历，以此类推，层与层之间交替进行）。 
//
// 
//
// 示例 1： 
//
// 
//输入：root = [3,9,20,null,null,15,7]
//输出：[[3],[20,9],[15,7]]
// 
//
// 示例 2： 
//
// 
//输入：root = [1]
//输出：[[1]]
// 
//
// 示例 3： 
//
// 
//输入：root = []
//输出：[]
// 
//
// 
//
// 提示： 
//
// 
// 树中节点数目在范围 [0, 2000] 内 
// -100 <= Node.val <= 100 
// 
// Related Topics 树 广度优先搜索 二叉树 👍 570 👎 0

package leetcode.editor.cn;

import java.util.LinkedList;
import java.util.List;

/**
 * title: 103 : 二叉树的锯齿形层序遍历
 * since: 2022-01-09 15:52:34
 */
public class BinaryTreeZigzagLevelOrderTraversal {
    public static void main(String[] args) {
        Solution solution = new BinaryTreeZigzagLevelOrderTraversal().new Solution();
        TreeNode root = TreeNode.generate(new Integer[]{1, 2, 3, 4, null, null, 5});
        List<List<Integer>> lists = solution.zigzagLevelOrder(root);
        System.out.println(lists);
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
        public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
            List<List<Integer>> res = new LinkedList<>();
            help(res, root, 0);
            return res;
        }

        private void help(List<List<Integer>> res, TreeNode root, int level) {
            if (root == null) return;
            // 新的一层
            if (res.size() == level) res.add(new LinkedList<>());
            if ((level & 1) == 1) res.get(level).add(0, root.val);
            else res.get(level).add(root.val);

            help(res, root.left, level + 1);
            help(res, root.right, level + 1);
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}