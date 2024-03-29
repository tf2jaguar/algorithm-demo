//给你两个单链表的头节点 headA 和 headB ，请你找出并返回两个单链表相交的起始节点。如果两个链表没有交点，返回 null 。 
//
// 图示两个链表在节点 c1 开始相交： 
//
// 
//
// 题目数据 保证 整个链式结构中不存在环。 
//
// 注意，函数返回结果后，链表必须 保持其原始结构 。 
//
// 
//
// 示例 1： 
//
// 
//
// 
//输入：intersectVal = 8, listA = [4,1,8,4,5], listB = [5,0,1,8,4,5], skipA = 2, 
//skipB = 3
//输出：Intersected at '8'
//解释：相交节点的值为 8 （注意，如果两个链表相交则不能为 0）。
//从各自的表头开始算起，链表 A 为 [4,1,8,4,5]，链表 B 为 [5,0,1,8,4,5]。
//在 A 中，相交节点前有 2 个节点；在 B 中，相交节点前有 3 个节点。
// 
//
// 示例 2： 
//
// 
//
// 
//输入：intersectVal = 2, listA = [0,9,1,2,4], listB = [3,2,4], skipA = 3, skipB = 
//1
//输出：Intersected at '2'
//解释：相交节点的值为 2 （注意，如果两个链表相交则不能为 0）。
//从各自的表头开始算起，链表 A 为 [0,9,1,2,4]，链表 B 为 [3,2,4]。
//在 A 中，相交节点前有 3 个节点；在 B 中，相交节点前有 1 个节点。
// 
//
// 示例 3： 
//
// 
//
// 
//输入：intersectVal = 0, listA = [2,6,4], listB = [1,5], skipA = 3, skipB = 2
//输出：null
//解释：从各自的表头开始算起，链表 A 为 [2,6,4]，链表 B 为 [1,5]。
//由于这两个链表不相交，所以 intersectVal 必须为 0，而 skipA 和 skipB 可以是任意值。
//这两个链表不相交，因此返回 null 。
// 
//
// 
//
// 提示： 
//
// 
// listA 中节点数目为 m 
// listB 中节点数目为 n 
// 0 <= m, n <= 3 * 10⁴ 
// 1 <= Node.val <= 10⁵ 
// 0 <= skipA <= m 
// 0 <= skipB <= n 
// 如果 listA 和 listB 没有交点，intersectVal 为 0 
// 如果 listA 和 listB 有交点，intersectVal == listA[skipA + 1] == listB[skipB + 1] 
// 
//
// 
//
// 进阶：你能否设计一个时间复杂度 O(n) 、仅用 O(1) 内存的解决方案？ 
// Related Topics 哈希表 链表 双指针 👍 124 👎 0

package leetcode.editor.cn;

import leetcode.editor.cn.warpper.ListNode;

import java.util.Stack;

/**
 * title: 面试题 02.07 : 链表相交
 * since: 2021-12-15 08:01:57
 */
public class Q面试题0207_IntersectionOfTwoLinkedListsLcci {
    public static void main(String[] args) {
        Solution solution = new Q面试题0207_IntersectionOfTwoLinkedListsLcci().new Solution();
        ListNode common = new ListNode(8, new ListNode(4, new ListNode(5)));
        ListNode heada = new ListNode(4, new ListNode(1, common));
        ListNode headb = new ListNode(5, new ListNode(0, new ListNode(1, common)));
        ListNode intersectionNode = solution.getIntersectionNode(heada, headb);
        System.out.println(intersectionNode);
    }
    //leetcode submit region begin(Prohibit modification and deletion)

    /**
     * Definition for singly-linked list.
     * public class ListNode {
     * int val;
     * ListNode next;
     * ListNode(int x) {
     * val = x;
     * next = null;
     * }
     * }
     */
    public class Solution {
        /**
         * 分别遍历两个链表，某一个遍历到空节点时，则将头指向另一个的头节点，直到找到相同的节点
         * （相当于遍历了一遍短链表 + 长链表到相同节点的长度）
         */
        public ListNode method2(ListNode headA, ListNode headB) {
            if (headA == null || headB == null) return null;
            ListNode hA = headA, hB = headB;
            while (hA != hB) {
                hA = hA == null ? headB : hA.next;
                hB = hB == null ? headA : hB.next;
            }
            return hA;
        }

        /**
         * 利用栈。 两个链表分别入栈，然后pop
         * 如果最后一个都不相同则不相交；
         * 一直pop直到出现不相同的节点时，返回上一个相同的节点
         */
        public ListNode method1(ListNode headA, ListNode headB) {
            Stack<ListNode> stacka = new Stack<>();
            Stack<ListNode> stackb = new Stack<>();
            ListNode tmp = headA;
            while (tmp != null) {
                stacka.push(tmp);
                tmp = tmp.next;
            }
            tmp = headB;
            while (tmp != null) {
                stackb.push(tmp);
                tmp = tmp.next;
            }

            // 空链表情况；尾节点不相同：不相交
            if (stacka.isEmpty() || stackb.isEmpty() || stacka.peek() != stackb.peek()) {
                return null;
            }
            ListNode res = headA;
            while (!stacka.isEmpty() && !stackb.isEmpty()) {
                if (stacka.peek() != stackb.peek()) {
                    return res;
                }
                res = stacka.pop();
                stackb.pop();
            }
            return res;
        }

        public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
            return method2(headA, headB);
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}