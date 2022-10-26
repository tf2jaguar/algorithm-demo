//给你单链表的头指针 head 和两个整数 left 和 right ，其中 left <= right 。请你反转从位置 left 到位置 right 的链
//表节点，返回 反转后的链表 。
//
// 
//
// 示例 1： 
// 
// 
//输入：head = [1,2,3,4,5], left = 2, right = 4
//输出：[1,4,3,2,5]
// 
//
// 示例 2： 
//
// 
//输入：head = [5], left = 1, right = 1
//输出：[5]
// 
//
// 
//
// 提示： 
//
// 
// 链表中节点数目为 n 
// 1 <= n <= 500 
// -500 <= Node.val <= 500 
// 1 <= left <= right <= n 
// 
//
// 
//
// 进阶： 你可以使用一趟扫描完成反转吗？ 
//
// Related Topics 链表 👍 1382 👎 0

package leetcode.editor.cn;

import leetcode.editor.cn.warpper.ListNode;

/**
 * title: 92 : 反转链表 II
 * create: 2022-09-01 16:14:00
 */
public class Q92_ReverseLinkedListIi {
    public static void main(String[] args) {
        Solution solution = new Q92_ReverseLinkedListIi().new Solution();
        ListNode node = new ListNode(1, new ListNode(2, new ListNode(3, new ListNode(4, new ListNode(5, new ListNode(6))))));
        ListNode listNode = solution.reverseNNode(node, 3);

        while (listNode != null) {
            System.out.print(listNode.val + ", ");
            listNode = listNode.next;
        }

    }
    //leetcode submit region begin(Prohibit modification and deletion)

    /**
     * Definition for singly-linked list.
     * public class ListNode {
     * int val;
     * ListNode next;
     * ListNode() {}
     * ListNode(int val) { this.val = val; }
     * ListNode(int val, ListNode next) { this.val = val; this.next = next; }
     * }
     */
    class Solution {
        public ListNode reverseBetween(ListNode head, int left, int right) {
            // left == 1 为 反转链表开头 right 个节点
            if (left == 1) {
                return reverseNNode(head, right);
            }
            // 把 head.next 节点视为 1，则反转区间从 left -1 到 right -1
            head.next = reverseBetween(head.next, left - 1, right - 1);
            return head;
        }

        //   1 <- 2 <- 3        4 -> 5 -> 6  -> NULL
        //   ⬇️-----------------⬆️
        // head       last   breakpoint
        ListNode breakpoint = null;

        public ListNode reverseNNode(ListNode head, int n) {
            if (n == 1) {
                breakpoint = head.next;
                return head;
            }
            ListNode nNode = reverseNNode(head.next, n - 1);
            head.next.next = head;
            head.next = breakpoint;
            return nNode;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}