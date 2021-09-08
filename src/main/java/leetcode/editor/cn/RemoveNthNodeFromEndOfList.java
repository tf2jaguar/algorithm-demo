//给你一个链表，删除链表的倒数第 n 个结点，并且返回链表的头结点。 
//
// 进阶：你能尝试使用一趟扫描实现吗？ 
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
// Related Topics 链表 双指针 👍 1548 👎 0

package leetcode.editor.cn;

/**
 * title: 19 : 删除链表的倒数第 N 个结点
 * create: 2021-09-07 19:42:28
 */
public class RemoveNthNodeFromEndOfList {
    public static void main(String[] args) {
        Solution solution = new RemoveNthNodeFromEndOfList().new Solution();
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
        public ListNode removeNthFromEnd(ListNode head, int k) {
            ListNode dummy = new ListNode();
            dummy.next = head;

            // 倒数第k个，双指针 快指针先走k步
            ListNode fast = dummy;
            int preWalkedSteps = 0;
            while (preWalkedSteps < k && fast.next != null) {
                fast = fast.next;
                preWalkedSteps++;
            }

            // slow指针指向头，然后fast与slow指针一起走
            // 注意fast不能为空，需要指向链表的最后一个结点
            ListNode slow = dummy;
            while (fast.next != null) {
                fast = fast.next;
                slow = slow.next;
            }

            // 如果preWalkedSteps == k 需要删除倒数第k个结点
            if (preWalkedSteps == k) {
                slow.next = slow.next.next;
            }
            // 返回新的链表头
            return dummy.next;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}