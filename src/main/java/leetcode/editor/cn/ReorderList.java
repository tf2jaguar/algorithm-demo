//给定一个单链表 L 的头节点 head ，单链表 L 表示为： 
//
// L0 → L1 → … → Ln-1 → Ln 
//请将其重新排列后变为： 
//
// L0 → Ln → L1 → Ln-1 → L2 → Ln-2 → … 
//
// 不能只是单纯的改变节点内部的值，而是需要实际的进行节点交换。 
//
// 
//
// 示例 1: 
//
// 
//
// 
//输入: head = [1,2,3,4]
//输出: [1,4,2,3] 
//
// 示例 2: 
//
// 
//
// 
//输入: head = [1,2,3,4,5]
//输出: [1,5,2,4,3] 
//
// 
//
// 提示： 
//
// 
// 链表的长度范围为 [1, 5 * 10⁴] 
// 1 <= node.val <= 1000 
// 
// Related Topics 栈 递归 链表 双指针 👍 663 👎 0

package leetcode.editor.cn;

/**
 * title: 143 : 重排链表
 * create: 2021-09-09 08:49:16
 */
public class ReorderList {
    public static void main(String[] args) {
        Solution solution = new ReorderList().new Solution();
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
        public void reorderList(ListNode head) {
            // 找到中间节点
            ListNode middleNode = findMiddleNode(head);
            ListNode f = head;
            ListNode s = middleNode.next;
            middleNode.next = null;

            // 逆转后边
            ListNode reverseListNode = reverseNode(s);

            // 合并两段
           head = mergeNode(f, reverseListNode);
        }

        public ListNode findMiddleNode(ListNode head) {
            ListNode fast = head, slow = head;
            while (fast != null && fast.next != null) {
                fast = fast.next.next;
                slow = slow.next;
            }
            return slow;
        }

        public ListNode reverseNode(ListNode head) {
            ListNode dummy = new ListNode();
            while (head != null) {
                ListNode tmp = head.next;
                head.next = dummy.next;
                dummy.next = head;
                head = tmp;
            }
            return dummy.next;
        }

        public ListNode mergeNode(ListNode a, ListNode b){
            ListNode dummy = new ListNode();
            ListNode cur = dummy;
            while (a!=null&& b!=null){
                cur.next = a;
                cur.next.next = b;

                a = a.next;
                b = b.next;
                cur = cur.next.next;
            }

            if (a!=null){
                cur.next = a;
            }
            if (b!=null){
                dummy.next = b;
            }

            return dummy.next;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}