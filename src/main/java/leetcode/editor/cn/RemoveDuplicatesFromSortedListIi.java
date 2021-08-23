//存在一个按升序排列的链表，给你这个链表的头节点 head ，请你删除链表中所有存在数字重复情况的节点，只保留原始链表中 没有重复出现 的数字。 
//
// 返回同样按升序排列的结果链表。 
//
// 
//
// 示例 1： 
//
// 
//输入：head = [1,2,3,3,4,4,5]
//输出：[1,2,5]
// 
//
// 示例 2： 
//
// 
//输入：head = [1,1,1,2,3]
//输出：[2,3]
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
// Related Topics 链表 双指针 
// 👍 682 👎 0

package leetcode.editor.cn;

/**
 * title: 82 : 删除排序链表中的重复元素 II
 * create: 2021-08-17 08:50:23
 */
public class RemoveDuplicatesFromSortedListIi {
    public static void main(String[] args) {
        Solution solution = new RemoveDuplicatesFromSortedListIi().new Solution();
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

            while (cur != null && cur.next != null) {
                if (cur.val == cur.next.val) {
                    cur = cur.next;
                }else {
                    tail.next = cur;
                    tail = cur;
                }
            }

            if (cur != null && cur.val !=tail.val){
                tail.next = cur;
            }
            return newOne.next;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}