//给你二叉树的根节点 root 和一个整数目标和 targetSum ，找出所有 从根节点到叶子节点 路径总和等于给定目标和的路径。 
//
// 叶子节点 是指没有子节点的节点。 
//
// 
// 
// 
//
// 示例 1： 
//
// 
//输入：root = [5,4,8,11,null,13,4,7,2,null,null,5,1], targetSum = 22
//输出：[[5,4,11,2],[5,8,4,5]]
// 
//
// 示例 2： 
//
// 
//输入：root = [1,2,3], targetSum = 5
//输出：[]
// 
//
// 示例 3： 
//
// 
//输入：root = [1,2], targetSum = 0
//输出：[]
// 
//
// 
//
// 提示： 
//
// 
// 树中节点总数在范围 [0, 5000] 内 
// -1000 <= Node.val <= 1000 
// -1000 <= targetSum <= 1000 
// 
// 
// 
// Related Topics 树 深度优先搜索 回溯 二叉树 👍 592 👎 0

package leetcode.editor.cn;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 * title: 113 : 路径总和 II
 * create: 2021-10-05 07:42:46
 */
public class PathSumIi {
    public static void main(String[] args) {
        Solution solution = new PathSumIi().new Solution();
        TreeNode treeNode = TreeNode.generate(new Integer[]{5, 4, 8, 11, null, 13, 4, 7, 2, null, null, 5, 1});
        System.out.println(solution.pathSum(treeNode, 22));
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
        int allSum;
        List<List<Integer>> res;

        public List<List<Integer>> pathSum(TreeNode root, int targetSum) {
            this.allSum = targetSum;
            this.res = new LinkedList<>();

            List<Integer> path = new LinkedList<>();
            this.process(root, path, 0);
            return res;
        }

        public void process(TreeNode node, List<Integer> path, int sum) {
            if (node == null) {
                return;
            }

            sum += node.val;
            path.add(node.val);

            if (node.left == null && node.right == null) {
                // 已经形成一个有效路径，添加到res
                if (sum == this.allSum) {
                    // 这里要做深拷贝
                    this.res.add(new ArrayList<>(path));
                }
            } else {
                // 回朔
                process(node.left, path, sum);
                process(node.right, path, sum);
            }

            // 移除最后一次的路径
            path.remove(path.size() - 1);
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}