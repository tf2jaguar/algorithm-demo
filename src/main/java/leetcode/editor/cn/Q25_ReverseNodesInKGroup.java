//给你链表的头节点 head ，每 k 个节点一组进行翻转，请你返回修改后的链表。 
//
// k 是一个正整数，它的值小于或等于链表的长度。如果节点总数不是 k 的整数倍，那么请将最后剩余的节点保持原有顺序。 
//
// 你不能只是单纯的改变节点内部的值，而是需要实际进行节点交换。 
//
// 
//
// 示例 1： 
// 
// 
//输入：head = [1,2,3,4,5], k = 2
//输出：[2,1,4,3,5]
// 
//
// 示例 2： 
//
// 
//
// 
//输入：head = [1,2,3,4,5], k = 3
//输出：[3,2,1,4,5]
// 
//
// 
//提示：
//
// 
// 链表中的节点数目为 n 
// 1 <= k <= n <= 5000 
// 0 <= Node.val <= 1000 
// 
//
// 
//
// 进阶：你可以设计一个只用 O(1) 额外内存空间的算法解决此问题吗？ 
//
// 
// 
//
// Related Topics 递归 链表 👍 1782 👎 0

package leetcode.editor.cn;

import leetcode.editor.cn.warpper.ListNode;

/**
 * title: 25 : K 个一组翻转链表
 * create: 2022-09-03 10:58:20
 */
public class Q25_ReverseNodesInKGroup {
    public static void main(String[] args) {
        Solution solution = new Q25_ReverseNodesInKGroup().new Solution();
        ListNode listNode = new ListNode(1, new ListNode(2, new ListNode(3, new ListNode(4, new ListNode(5)))));
        ListNode afterReverse = solution.reverseKGroup(listNode, 2);

        while (afterReverse != null) {
            System.out.print(afterReverse.val + ", ");
            afterReverse = afterReverse.next;
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
        public ListNode reverseKGroup(ListNode head, int k) {
            if (head == null || head.next == null) return head;
            ListNode dummy = new ListNode(-1);
            dummy.next = head;

            ListNode rPre = dummy, rHead = head, cur = head;
            int curIdx = 1;
            while (cur != null) {
                if (curIdx == k) {
                    ListNode next = cur.next;
                    cur.next = null;

                    rPre.next = reverse(rHead);
                    // rHead 指向翻转前的下一个节点，翻转完成
                    rHead.next = next;

                    // 重置各指针
                    rPre = rHead;
                    rHead = next;
                    cur = next;
                    curIdx = 1;
                } else {
                    cur = cur.next;
                    curIdx++;
                }
            }
            return dummy.next;
        }

        private ListNode reverse(ListNode head) {
            ListNode dummy = new ListNode(-1);
            while (head != null) {
                ListNode next = head.next;
                head.next = dummy.next;
                dummy.next = head;
                head = next;
            }
            return dummy.next;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}