//给你二叉树的根节点 root ，返回它节点值的 前序 遍历。 
//
// 
//
// 示例 1： 
//
// 
//输入：root = [1,null,2,3]
//输出：[1,2,3]
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
//输出：[1,2]
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
// 进阶：递归算法很简单，你可以通过迭代算法完成吗？ 
// Related Topics 栈 树 深度优先搜索 二叉树 👍 650 👎 0

package leetcode.editor.cn;

import java.util.ArrayList;
import java.util.List;

/**
 * title: 144 : 二叉树的前序遍历
 * create: 2021-09-23 20:46:19
 */
public class BinaryTreePreorderTraversal {
    public static void main(String[] args) {
        Solution solution = new BinaryTreePreorderTraversal().new Solution();
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
        public List<Integer> preorderTraversal(TreeNode root) {
//            List<Integer> res = new ArrayList<>();
//            preorder(root, res);
            return morris(root);
        }

        private void preorder(TreeNode root, List<Integer> res) {
            if (root == null) {
                return;
            }
            res.add(root.val);
            preorder(root.left, res);
            preorder(root.right, res);
        }

        public List<Integer> morris(TreeNode root) {
            List<Integer> res = new ArrayList<Integer>();
            if (root == null) {
                return res;
            }

            TreeNode p1 = root, p2 = null;

            while (p1 != null) {
                p2 = p1.left;
                if (p2 != null) {
                    while (p2.right != null && p2.right != p1) {
                        p2 = p2.right;
                    }
                    if (p2.right == null) {
                        res.add(p1.val);
                        p2.right = p1;
                        p1 = p1.left;
                        continue;
                    } else {
                        p2.right = null;
                    }
                } else {
                    res.add(p1.val);
                }
                p1 = p1.right;
            }
            return res;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}