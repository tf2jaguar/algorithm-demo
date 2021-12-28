//将两个升序链表合并为一个新的 升序 链表并返回。新链表是通过拼接给定的两个链表的所有节点组成的。 
//
// 
//
// 示例 1： 
//
// 
//输入：l1 = [1,2,4], l2 = [1,3,4]
//输出：[1,1,2,3,4,4]
// 
//
// 示例 2： 
//
// 
//输入：l1 = [], l2 = []
//输出：[]
// 
//
// 示例 3： 
//
// 
//输入：l1 = [], l2 = [0]
//输出：[0]
// 
//
// 
//
// 提示： 
//
// 
// 两个链表的节点数目范围是 [0, 50] 
// -100 <= Node.val <= 100 
// l1 和 l2 均按 非递减顺序 排列 
// 
// Related Topics 递归 链表 👍 2110 👎 0

package leetcode.editor.cn;

/**
 * title: 21 : 合并两个有序链表
 * create: 2021-12-28 15:36:22
 */
public class MergeTwoSortedLists {
    public static void main(String[] args) {
        Solution solution = new MergeTwoSortedLists().new Solution();
        ListNode l1 = new ListNode(1, new ListNode(2, new ListNode(4)));
        ListNode l2 = new ListNode(1, new ListNode(3, new ListNode(4)));
        ListNode listNode = solution.mergeTwoLists(l1, l2);
        System.out.println(listNode);
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
        public ListNode mergeTwoLists(ListNode list1, ListNode list2) {
            return method2(list1, list2);
        }

        /**
         * 迭代法
         * 时间复杂度：O(n + m)
         * 空间复杂度：O(1)
         */
        public ListNode method1(ListNode l1, ListNode l2) {
            ListNode dummy = new ListNode();
            ListNode cur = dummy;
            while (l1 != null && l2 != null) {
                if (l1.val < l2.val) {
                    cur.next = l1;
                    l1 = l1.next;
                } else {
                    cur.next = l2;
                    l2 = l2.next;
                }
                cur = cur.next;
            }
            // 走完上边的while后，l1、l2 有一个不为空，直接追加在后边即可
            cur.next = l1 == null ? l2 : l1;
            return dummy.next;
        }

        /**
         * 递归法
         * 时间复杂度：O(n + m)
         * 空间复杂度为 O(n+m)
         */
        public ListNode method2(ListNode l1, ListNode l2) {
            if (l1 == null) {
                return l2;
            } else if (l2 == null) {
                return l1;
            } else if (l1.val < l2.val) {
                l1.next = method2(l1.next, l2);
                return l1;
            } else {
                l2.next = method2(l1, l2.next);
                return l2;
            }
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}