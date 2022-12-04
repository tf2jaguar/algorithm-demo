package zgd.base.org;

import leetcode.editor.cn.warpper.TreeNode;

public class DIDI2 {
    public static void main(String[] args) {

    }

    /**
     * 判断一棵树是否平衡
     */
    public boolean isB(TreeNode node) {
        if (node == null) return false;

        int left = maxDeep(node.left);
        int right = maxDeep(node.right);

        if (Math.abs(left - right) > 1) {
            return false;
        }

        return isB(node.left) && isB(node.right);
    }

    public int maxDeep(TreeNode node) {
        if (node == null) {
            return 0;
        }

        int left = maxDeep(node.left);
        int right = maxDeep(node.right);

        return Math.max(left, right) + 1;
    }
}
