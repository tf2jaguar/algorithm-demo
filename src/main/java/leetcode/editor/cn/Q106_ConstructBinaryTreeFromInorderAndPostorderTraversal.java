//给定两个整数数组 inorder 和 postorder ，其中 inorder 是二叉树的中序遍历， postorder 是同一棵树的后序遍历，请你构造并
//返回这颗 二叉树 。 
//
// 
//
// 示例 1: 
// 
// 
//输入：inorder = [9,3,15,20,7], postorder = [9,15,7,20,3]
//输出：[3,9,20,null,null,15,7]
// 
//
// 示例 2: 
//
// 
//输入：inorder = [-1], postorder = [-1]
//输出：[-1]
// 
//
// 
//
// 提示: 
//
// 
// 1 <= inorder.length <= 3000 
// postorder.length == inorder.length 
// -3000 <= inorder[i], postorder[i] <= 3000 
// inorder 和 postorder 都由 不同 的值组成 
// postorder 中每一个值都在 inorder 中 
// inorder 保证是树的中序遍历 
// postorder 保证是树的后序遍历 
// 
//
// Related Topics 树 数组 哈希表 分治 二叉树 👍 862 👎 0

package leetcode.editor.cn;

import leetcode.editor.cn.warpper.TreeNode;

import java.util.*;

/**
 * title: 106 : 从中序与后序遍历序列构造二叉树
 * create: 2022-10-20 16:47:02
 */
public class Q106_ConstructBinaryTreeFromInorderAndPostorderTraversal {
    public static void main(String[] args) {
        Solution solution = new Q106_ConstructBinaryTreeFromInorderAndPostorderTraversal().new Solution();
        int[] inorder = new int[]{9, 3, 15, 20, 7};
        int[] postorder = new int[]{9, 15, 7, 20, 3};
        TreeNode treeNode = solution.buildTree(inorder, postorder);

        System.out.println();
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
        public TreeNode buildTree(int[] inorder, int[] postorder) {
            // 递归
            //return recursion(inorder, postorder);

            // 迭代
            return iteration(inorder, postorder);
        }

        /**
         * #           3
         * #       9        20
         * #    x    x   15    7
         * 中序遍历：[ [左子树的中序遍历结果], 根节点, [右子树的中序遍历结果] ]
         * 后序遍历：[ [左子树的前序遍历结果], [右子树的前序遍历结果], 根节点 ]
         * {9, 3, 15, 20, 7};
         * {9, 15, 7, 20, 3};
         */
        private TreeNode iteration(int[] inorder, int[] postorder) {
            TreeNode root = new TreeNode(postorder[postorder.length - 1]);
            Stack<TreeNode> stack = new Stack<>();
            stack.push(root);

            // 逆序中序、后序
            int inorderIdx = inorder.length - 1;
            for (int i = postorder.length - 2; i >= 0; i--) {
                int postorderVal = postorder[i];
                TreeNode peek = stack.peek();

                // 逆序情况下，后序往前推，当栈顶节点和 中序逆序情况下的第一个节点相同时 停下，不再入栈
                if (peek.val != inorder[inorderIdx]) {
                    peek.right = new TreeNode(postorderVal);
                    stack.push(peek.right);
                } else {
                    // 退栈，直到右边节点全部退出
                    while (!stack.isEmpty() && stack.peek().val == inorder[inorderIdx]) {
                        peek = stack.pop();
                        inorderIdx--;
                    }
                    peek.left = new TreeNode(postorderVal);
                    stack.push(peek.left);
                }
            }
            return root;
        }

        Map<Integer, Integer> inMap;

        /**
         * 中序遍历：[ [左子树的中序遍历结果], 根节点, [右子树的中序遍历结果] ]
         * 后序遍历：[ [左子树的前序遍历结果], [右子树的前序遍历结果], 根节点 ]
         * {9, 3, 15, 20, 7};
         * {9, 15, 7, 20, 3};
         */
        private TreeNode recursion(int[] inorder, int[] postorder) {
            int inorderLen = inorder.length;
            inMap = new HashMap<>(inorderLen);
            for (int i = 0; i < inorder.length; i++) {
                inMap.put(inorder[i], i);
            }

            return build(postorder, 0, postorder.length - 1, 0);
        }

        private TreeNode build(int[] postorder, int postStart, int postEnd, int inStart) {
            if (postStart > postEnd) return null;
            TreeNode root = new TreeNode(postorder[postEnd]);

            // 通过中序遍历获取当前节点的下标位置，与开始位置相减，得到左子树节点数量
            Integer inIdx = inMap.get(root.val);
            int leftNodeNum = inIdx - inStart;

            // 利用上边计算出来的左子树的数量在 中序遍历列表 中计算。
            // 左子树开始位置依然是 postStart，结束位置为 开始位置加上左子树节点数量 再减去下标偏移(从0计算的)即 postStart + leftNodeNum - 1
            root.left = build(postorder, postStart, postStart + leftNodeNum - 1, inStart);

            // 右子树开始位置是 左子树开始位置加上左子树节点数量（从0计算）postStart + leftNodeNum，结束位置为 后序遍历的倒数第2个数即 postEnd - 1
            root.right = build(postorder, postStart + leftNodeNum, postEnd - 1, inIdx + 1);
            return root;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}