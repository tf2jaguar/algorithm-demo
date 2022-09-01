//给你一个链表，删除链表的倒数第 n 个结点，并且返回链表的头结点。 
//
// 
//
// 示例 1： 
// 
// 
//输入：head = [1,2,3,4,5], n = 2
//输出：[1,2,3,5]
// 
//
// 示例 2： 
//
// 
//输入：head = [1], n = 1
//输出：[]
// 
//
// 示例 3： 
//
// 
//输入：head = [1,2], n = 1
//输出：[1]
// 
//
// 
//
// 提示： 
//
// 
// 链表中结点的数目为 sz 
// 1 <= sz <= 30 
// 0 <= Node.val <= 100 
// 1 <= n <= sz 
// 
//
// 
//
// 进阶：你能尝试使用一趟扫描实现吗？ 
//
// Related Topics 链表 双指针 👍 2194 👎 0

package leetcode.editor.cn;

/**
 * title: 19 : 删除链表的倒数第 N 个结点
 * create: 2022-09-01 14:38:16
 */
public class RemoveNthNodeFromEndOfList {
    public static void main(String[] args) {
        Solution solution = new RemoveNthNodeFromEndOfList().new Solution();
//        ListNode listNode = new ListNode(1, new ListNode(2, new ListNode(3, new ListNode(4, new ListNode(5)))));
//        ListNode node = solution.removeNthFromEnd(listNode, 1);

        ListNode listNode = new ListNode(1, new ListNode(2));
        ListNode node = solution.removeNthFromEnd(listNode, 2);

        while (node != null) {
            System.out.print(node.val + ", ");
            node = node.next;
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
        public ListNode removeNthFromEnd(ListNode head, int n) {
            ListNode dummy = new ListNode(-1);
            // 防止删除第一个节点时，导致null
            dummy.next = head;

            ListNode f = dummy;
            int step = 0;
            while (step < n && f.next != null) {
                f = f.next;
                step++;
            }

            ListNode s = dummy;
            while (f.next != null) {
                f = f.next;
                s = s.next;
            }

            // 防止 n 大于链表节点数量
            if (step == n) {
                s.next = s.next.next;
            }
            return dummy.next;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}