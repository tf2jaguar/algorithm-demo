//给你一个链表的头节点 head 和一个整数 val ，请你删除链表中所有满足 Node.val == val 的节点，并返回 新的头节点 。
// 
//
// 示例 1： 
//
// 
//输入：head = [1,2,6,3,4,5,6], val = 6
//输出：[1,2,3,4,5]
// 
//
// 示例 2： 
//
// 
//输入：head = [], val = 1
//输出：[]
// 
//
// 示例 3： 
//
// 
//输入：head = [7,7,7,7], val = 7
//输出：[]
// 
//
// 
//
// 提示： 
//
// 
// 列表中的节点数目在范围 [0, 104] 内 
// 1 <= Node.val <= 50 
// 0 <= val <= 50 
// 
// Related Topics 递归 链表 
// 👍 674 👎 0

package leetcode.editor.cn;

/**
 * title: 203 : 移除链表元素
 * create: 2021-08-16 20:48:43
 */
public class RemoveLinkedListElements {
    public static void main(String[] args) {
        Solution solution = new RemoveLinkedListElements().new Solution();
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
        public ListNode removeElements(ListNode head, int val) {
            // 假头链表
            ListNode newOne = new ListNode();

            // 用于移动的尾巴指针、当前指针
            ListNode tail = newOne;
            ListNode cur = head;
            while (cur != null) {
                ListNode tmp = cur.next;
                // 值不想等，则加入新链表
                if (cur.val != val) {
                    tail.next = cur;
                    tail = cur;
                }
                cur = tmp;
            }
            // 循环完成后，尾巴节点要置空
            tail.next = null;
            return newOne.next;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}