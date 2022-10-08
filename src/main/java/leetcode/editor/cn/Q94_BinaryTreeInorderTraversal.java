//给定一个二叉树的根节点 root ，返回它的 中序 遍历。 
//
// 
//
// 示例 1： 
//
// 
//输入：root = [1,null,2,3]
//输出：[1,3,2]
// 
//
// 示例 2： 
//
// 
//输入：root = []
//输出：[]
// 
//
// 示例 3： 
//
// 
//输入：root = [1]
//输出：[1]
// 
//
// 示例 4： 
//
// 
//输入：root = [1,2]
//输出：[2,1]
// 
//
// 示例 5： 
//
// 
//输入：root = [1,null,2]
//输出：[1,2]
// 
//
// 
//
// 提示： 
//
// 
// 树中节点数目在范围 [0, 100] 内 
// -100 <= Node.val <= 100 
// 
//
// 
//
// 进阶: 递归算法很简单，你可以通过迭代算法完成吗？ 
// Related Topics 栈 树 深度优先搜索 二叉树 👍 1118 👎 0

package leetcode.editor.cn;

import leetcode.editor.cn.warpper.TreeNode;

import java.util.LinkedList;
import java.util.List;

/**
 * title: 94 : 二叉树的中序遍历
 * create: 2021-10-06 09:13:26
 */
public class Q94_BinaryTreeInorderTraversal {
    public static void main(String[] args) {
        Solution solution = new Q94_BinaryTreeInorderTraversal().new Solution();
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
        /**
         * 左、根、右
         */
        public List<Integer> inorderTraversal(TreeNode root) {
            TreeNode cur = root;
            List<Integer> ans = new LinkedList<>();
            while (cur != null) {
                if (cur.left != null) {
                    TreeNode pre = cur.left;
                    while (pre.right != null && pre.right != cur) {
                        pre = pre.right;
                    }
                    if (pre.right == null) {
                        pre.right = cur;
                        cur = cur.left;
                    } else {
                        ans.add(cur.val);
                        pre.right = null;
                        cur = cur.right;
                    }
                } else {
                    ans.add(cur.val);
                    cur = cur.right;
                }
            }

            return ans;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}