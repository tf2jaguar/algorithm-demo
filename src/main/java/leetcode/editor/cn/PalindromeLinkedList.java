//给你一个单链表的头节点 head ，请你判断该链表是否为回文链表。如果是，返回 true ；否则，返回 false 。 
//
// 
//
// 示例 1： 
// 
// 
//输入：head = [1,2,2,1]
//输出：true
// 
//
// 示例 2： 
// 
// 
//输入：head = [1,2]
//输出：false
// 
//
// 
//
// 提示： 
//
// 
// 链表中节点数目在范围[1, 10⁵] 内 
// 0 <= Node.val <= 9 
// 
//
// 
//
// 进阶：你能否用 O(n) 时间复杂度和 O(1) 空间复杂度解决此题？ 
//
// Related Topics 栈 递归 链表 双指针 👍 1495 👎 0

package leetcode.editor.cn;

import org.springframework.util.Assert;

import java.util.Stack;

/**
 * title: 234 : 回文链表
 * create: 2022-09-03 11:46:36
 */
public class PalindromeLinkedList {
    public static void main(String[] args) {
        Solution solution = new PalindromeLinkedList().new Solution();

        ListNode case1 = new ListNode(1);
        Assert.isTrue(solution.isPalindrome(case1), "case1");

        ListNode case2 = new ListNode(1, new ListNode(1));
        Assert.isTrue(solution.isPalindrome(case2), "case2");

        ListNode case3 = new ListNode(1, new ListNode(2));
        Assert.isTrue(!solution.isPalindrome(case3), "case3");

        ListNode case4 = new ListNode(1, new ListNode(2, new ListNode(1)));
        Assert.isTrue(solution.isPalindrome(case4), "case4");


        ListNode case5 = new ListNode(1, new ListNode(2, new ListNode(3)));
        Assert.isTrue(!solution.isPalindrome(case5), "case5");

        ListNode case6 = new ListNode(1, new ListNode(2, new ListNode(2, new ListNode(1))));
        Assert.isTrue(solution.isPalindrome(case6), "case6");

        ListNode case7 = new ListNode(1, new ListNode(2, new ListNode(3, new ListNode(3, new ListNode(2, new ListNode(1))))));
        Assert.isTrue(solution.isPalindrome(case7), "case7");

        ListNode case8 = new ListNode(1, new ListNode(2, new ListNode(3, new ListNode(2, new ListNode(1)))));
        Assert.isTrue(solution.isPalindrome(case8), "case8");

        ListNode case9 = new ListNode(1, new ListNode(2, new ListNode(3, new ListNode(1, new ListNode(1)))));
        Assert.isTrue(!solution.isPalindrome(case9), "case9");

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
        /**
         * 方法一：快慢指针，找到中点，慢指针走的同时压栈，快指针到null后，同时弹栈 和 慢指针相比较
         * 时间: O(N), 空间: O(N)
         * <p>
         * 方法二：快慢指针，找到中点，翻转后半部分，重置两个指针，依次比较
         * 时间: O(N), 空间: O(1)
         */
        public boolean isPalindrome(ListNode head) {
            return method2(head);
        }

        private boolean method2(ListNode head) {
            ListNode s = head, f = head;
            while (f != null && f.next != null) {
                s = s.next;
                f = f.next.next;
            }

            // reverse node
            ListNode dummy = new ListNode(-1);
            while (s != null) {
                ListNode next = s.next;
                s.next = dummy.next;
                dummy.next = s;
                s = next;
            }

            // reset pointer
            s = dummy.next;
            f = head;
            while (s != null) {
                if (s.val != f.val) return false;

                s = s.next;
                f = f.next;
            }
            return true;
        }

        private boolean method1(ListNode head) {
            ListNode s = head, f = head;
            Stack<ListNode> stack = new Stack<>();
            while (f != null && f.next != null) {
                stack.push(s);

                s = s.next;
                f = f.next.next;
            }

            // After the fast and slow pointer is completed, when the fast pointer is not NULL,
            // the current linked list node is a strange number
            if (f != null) {
                s = s.next;
            }

            while (!stack.isEmpty() && s != null) {
                if (s.val != stack.pop().val) {
                    return false;
                }
                s = s.next;
            }
            return stack.isEmpty() && s == null;
        }


    }
//leetcode submit region end(Prohibit modification and deletion)

}