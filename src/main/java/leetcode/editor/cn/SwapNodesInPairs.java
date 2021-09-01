//给定一个链表，两两交换其中相邻的节点，并返回交换后的链表。 
//
// 你不能只是单纯的改变节点内部的值，而是需要实际的进行节点交换。 
//
// 
//
// 示例 1： 
//
// 
//输入：head = [1,2,3,4]
//输出：[2,1,4,3]
// 
//
// 示例 2： 
//
// 
//输入：head = []
//输出：[]
// 
//
// 示例 3： 
//
// 
//输入：head = [1]
//输出：[1]
// 
//
// 
//
// 提示： 
//
// 
// 链表中节点的数目在范围 [0, 100] 内 
// 0 <= Node.val <= 100 
// 
//
// 
//
// 进阶：你能在不修改链表节点值的情况下解决这个问题吗?（也就是说，仅修改节点本身。） 
// Related Topics 递归 链表 
// 👍 1026 👎 0

package leetcode.editor.cn;

/**
 * title: 24 : 两两交换链表中的节点
 * create: 2021-08-31 15:41:36
 */
public class SwapNodesInPairs {
    public static void main(String[] args) {
        Solution solution = new SwapNodesInPairs().new Solution();
        ListNode head = new ListNode(1, new ListNode(2, new ListNode(3, new ListNode(4))));
        ListNode node = solution.swapPairs(head);
        System.out.println();
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
        public ListNode swapPairs(ListNode head) {
            ListNode oddDummy = new ListNode();
            ListNode oddTail = oddDummy;
            ListNode evenDummy = new ListNode();
            ListNode evenTail = evenDummy;
            ListNode cur = head;
            int idx = 1;
            while (cur != null) {
                if (idx % 2 == 0) {
                    evenTail.next = cur;
                    evenTail = cur;
                } else {
                    oddTail.next = cur;
                    oddTail = cur;
                }
                idx++;
                cur = cur.next;
            }
            evenTail.next = null;
            oddTail.next = null;
            return mergeTwoList(evenDummy.next, oddDummy.next);
        }

        private ListNode mergeTwoList(ListNode evenDummy, ListNode oddTail) {
            ListNode dummy = new ListNode();
            ListNode tail = dummy;
            while (evenDummy != null || oddTail != null) {
                if (evenDummy != null) {
                    tail.next = evenDummy;
                    tail = evenDummy;
                    evenDummy = evenDummy.next;
                }
                if (oddTail != null) {
                    tail.next = oddTail;
                    tail = oddTail;
                    oddTail = oddTail.next;
                }
            }
            tail.next = null;
            return dummy.next;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}