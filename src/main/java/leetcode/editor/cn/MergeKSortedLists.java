//给你一个链表数组，每个链表都已经按升序排列。 
//
// 请你将所有链表合并到一个升序链表中，返回合并后的链表。 
//
// 
//
// 示例 1： 
//
// 输入：lists = [[1,4,5],[1,3,4],[2,6]]
//输出：[1,1,2,3,4,4,5,6]
//解释：链表数组如下：
//[
//  1->4->5,
//  1->3->4,
//  2->6
//]
//将它们合并到一个有序链表中得到。
//1->1->2->3->4->4->5->6
// 
//
// 示例 2： 
//
// 输入：lists = []
//输出：[]
// 
//
// 示例 3： 
//
// 输入：lists = [[]]
//输出：[]
// 
//
// 
//
// 提示： 
//
// 
// k == lists.length 
// 0 <= k <= 10^4 
// 0 <= lists[i].length <= 500 
// -10^4 <= lists[i][j] <= 10^4 
// lists[i] 按 升序 排列 
// lists[i].length 的总和不超过 10^4 
// 
//
// Related Topics 链表 分治 堆（优先队列） 归并排序 👍 2146 👎 0

package leetcode.editor.cn;

import java.util.Comparator;
import java.util.PriorityQueue;

/**
 * title: 23 : 合并K个升序链表
 * create: 2022-09-01 13:47:46
 */
public class MergeKSortedLists {
    public static void main(String[] args) {
        Solution solution = new MergeKSortedLists().new Solution();
        ListNode l1 = new ListNode(1, new ListNode(4, new ListNode(5)));
        ListNode l2 = new ListNode(1, new ListNode(3, new ListNode(4)));
        ListNode l3 = new ListNode(2, new ListNode(6));

        ListNode listNode = solution.mergeKLists(new ListNode[]{l1, l2, l3});

        while (listNode != null) {
            System.out.print(listNode.val + ", ");
            listNode = listNode.next;
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
        public ListNode mergeKLists(ListNode[] lists) {
            // lists = [] 情况
            if (lists.length == 0) return null;

            PriorityQueue<ListNode> queue = new PriorityQueue<>(Comparator.comparingInt(o -> o.val));
            for (ListNode node : lists) {
                // lists = [[]] 情况
                if (node != null)
                    queue.offer(node);
            }
            ListNode dummy = new ListNode();
            ListNode cur = dummy;
            while (!queue.isEmpty()) {
                ListNode poll = queue.poll();
                cur.next = poll;
                cur = cur.next;

                if (poll.next != null) {
                    queue.offer(poll.next);
                }
            }
            return dummy.next;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}