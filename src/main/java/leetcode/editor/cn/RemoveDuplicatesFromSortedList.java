//存在一个按升序排列的链表，给你这个链表的头节点 head ，请你删除所有重复的元素，使每个元素 只出现一次 。 
//
// 返回同样按升序排列的结果链表。 
//
// 
//
// 示例 1： 
//
// 
//输入：head = [1,1,2]
//输出：[1,2]
// 
//
// 示例 2： 
//
// 
//输入：head = [1,1,2,3,3]
//输出：[1,2,3]
// 
//
// 
//
// 提示： 
//
// 
// 链表中节点数目在范围 [0, 300] 内 
// -100 <= Node.val <= 100 
// 题目数据保证链表已经按升序排列 
// 
// Related Topics 链表 
// 👍 627 👎 0

package leetcode.editor.cn;

/**
 * title: 83 : 删除排序链表中的重复元素
 * create: 2021-08-17 08:34:57
 */
public class RemoveDuplicatesFromSortedList {
    public static void main(String[] args) {
        Solution solution = new RemoveDuplicatesFromSortedList().new Solution();
        ListNode c1 = new ListNode();
        c1.val = 0;
        ListNode c2 = new ListNode();
        c2.val = 0;
        c2.next = c1;
        ListNode c3 = new ListNode();
        c3.val = 0;
        c3.next = c2;
        ListNode h = new ListNode();
        h.val = 0;
        h.next = c3;
        solution.deleteDuplicates(h);
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
        public ListNode deleteDuplicates(ListNode head) {
            ListNode newOne = new ListNode();

            ListNode tail = newOne;
            ListNode cur = head;
            while (cur != null) {
                ListNode tmp = cur.next;
                if (tail == newOne || tail.val != cur.val) {
                    tail.next = cur;
                    tail = cur;
                }
                cur = tmp;
            }
            tail.next = null;
            return newOne.next;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}