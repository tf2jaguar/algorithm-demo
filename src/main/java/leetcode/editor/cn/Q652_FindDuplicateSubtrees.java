//给你一棵二叉树的根节点 root ，返回所有 重复的子树 。 
//
// 对于同一类的重复子树，你只需要返回其中任意 一棵 的根结点即可。 
//
// 如果两棵树具有 相同的结构 和 相同的结点值 ，则认为二者是 重复 的。 
//
// 
//
// 示例 1： 
//
// 
//
// 
//输入：root = [1,2,3,4,null,2,4,null,null,4]
//输出：[[2,4],[4]] 
//
// 示例 2： 
//
// 
//
// 
//输入：root = [2,1,1]
//输出：[[1]] 
//
// 示例 3： 
//
// 
//
// 
//输入：root = [2,2,2,3,null,3,null]
//输出：[[2,3],[3]] 
//
// 
//
// 提示： 
//
// 
// 树中的结点数在 [1, 5000] 范围内。 
// -200 <= Node.val <= 200 
// 
//
// Related Topics 树 深度优先搜索 哈希表 二叉树 👍 646 👎 0

package leetcode.editor.cn;

import leetcode.editor.cn.warpper.TreeNode;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;

/**
 * title: 652 : 寻找重复的子树
 * create: 2022-11-10 13:50:25
 */
public class Q652_FindDuplicateSubtrees {
    public static void main(String[] args) {
        Solution solution = new Q652_FindDuplicateSubtrees().new Solution();
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
        HashMap<String, Integer> map = new HashMap<>();
        List<TreeNode> res = new LinkedList<>();

        /**
         * 递归整棵树(后序)，记录当前节点为跟节点的整棵树为一个 string 类型数据key，存入map 用来统计出现的次数
         * 出现次数大于等于 1 时，即为所求节点
         */
        public List<TreeNode> findDuplicateSubtrees(TreeNode root) {
            recursion(root);
            return res;
        }

        private String recursion(TreeNode root) {
            if (root == null) return "#";

            String left = recursion(root.left);
            String right = recursion(root.right);
            // 节点之间要增加分隔符，否则难以区分 1，12 和 11，2
            String curTree = left + "," + right + "," + root.val;

            int freq = map.getOrDefault(curTree, 0);
            if (freq == 1) {
                res.add(root);
            }
            map.put(curTree, freq + 1);
            return curTree;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}