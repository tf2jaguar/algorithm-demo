package leetcode.editor.cn.warpper;

import java.util.LinkedList;
import java.util.Queue;

/**
 * @author zhangguodong
 * @date 2021/9/22 15:51
 */
public class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;

    TreeNode() {
    }

    TreeNode(int val) {
        this.val = val;
    }

    TreeNode(int val, TreeNode left, TreeNode right) {
        this.val = val;
        this.left = left;
        this.right = right;
    }

    /**
     * 恢复层序遍历的树
     */
    public static TreeNode generate(Integer[] list) {
        Queue<TreeNode> queue = new LinkedList<>();
        TreeNode head = null;
        int flag = 0;
        for (Integer s : list) {

            if (flag == 0) {
                flag = 1;
                if (s == null) {
                    break;
                }
                head = new TreeNode(s);
                queue.offer(head);
            } else if (flag == 1) {
                if (!queue.isEmpty()) {
                    TreeNode peek = queue.peek();
                    if (s == null) {
                        flag = 2;
                        continue;
                    }
                    TreeNode newLeft = new TreeNode(s);

                    peek.left = newLeft;
                    queue.offer(newLeft);
                    flag = 2;
                }
            } else if (flag == 2) {
                if (!queue.isEmpty()) {
                    TreeNode peek = queue.poll();
                    if (s == null) {
                        flag = 1;
                        continue;
                    }
                    TreeNode newRight = new TreeNode(s);
                    peek.right = newRight;
                    queue.offer(newRight);
                    flag = 1;
                }
            }
        }
        return head;
    }

    public static int maxDept(TreeNode node, int dep) {
        if (node == null) return dep;
        return Math.max(maxDept(node.left, dep + 1), maxDept(node.right, dep + 1));
    }

    public static void main(String[] args) {
        Integer[] list = new Integer[]{5, 4, 8, 11, null, 13, 4, 7, 2, null, null, 5, 1};
        TreeNode generate = TreeNode.generate(list);
        System.out.println(generate);

        System.out.println(maxDept(generate,0));
    }
}
