//给你一个链表，每 k 个节点一组进行翻转，请你返回翻转后的链表。 
//
// k 是一个正整数，它的值小于或等于链表的长度。 
//
// 如果节点总数不是 k 的整数倍，那么请将最后剩余的节点保持原有顺序。 
//
// 进阶： 
//
// 
// 你可以设计一个只使用常数额外空间的算法来解决此问题吗？ 
// 你不能只是单纯的改变节点内部的值，而是需要实际进行节点交换。 
// 
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
//输入：head = [1,2,3,4,5], k = 3
//输出：[3,2,1,4,5]
// 
//
// 示例 3： 
//
// 
//输入：head = [1,2,3,4,5], k = 1
//输出：[1,2,3,4,5]
// 
//
// 示例 4： 
//
// 
//输入：head = [1], k = 1
//输出：[1]
// 
//
// 
// 
//
// 提示： 
//
// 
// 列表中节点的数量在范围 sz 内 
// 1 <= sz <= 5000 
// 0 <= Node.val <= 1000 
// 1 <= k <= sz 
// 
// Related Topics 递归 链表 
// 👍 1267 👎 0

package leetcode.editor.cn;

/**
 * title: 25 : K 个一组翻转链表
 * create: 2021-08-31 16:38:22
 */
public class ReverseNodesInKGroup {
    public static void main(String[] args) {
        Solution solution = new ReverseNodesInKGroup().new Solution();
        ListNode head = new ListNode(1, new ListNode(2, new ListNode(3, new ListNode(4, new ListNode(5)))));
        solution.reverseKGroup(head, 2);
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
            // 记录最终的头节点
            ListNode dummy = new ListNode();
            // 记录临时结果列表，每次翻转后需要更新这个位置
            ListNode dTmp = dummy;

            // 记录当前是第 k 组中的头节点 和 第k组中的当前位置。
            ListNode curHead = head;
            ListNode curTmp = curHead;

            int i = 1;
            for (; i <= k && curTmp != null; i++) {
                // i==k 每k个一组，这一组需要翻转。
                // 记录其下一个位置，然后将翻转后的链表追加到临时结果链表 dTmp 中
                // 更新下一组的各起始节点位置
                if (i == k) {
                    ListNode tmpNext = curTmp.next;
                    curTmp.next = null;

                    dTmp.next = reverse(curHead);
                    dTmp = curHead;

                    curHead = tmpNext;
                    curTmp = curHead;
                    i = 0;
                } else {
                    curTmp = curTmp.next;
                }
            }

            // 如果 上述的 i 不为0，则存在尾节点个数不够 k 个，直接将最后一组追加到 临时结果链表即可
            if (i != 0) {
                dTmp.next = curHead;
            }
            return dummy.next;
        }

        /**
         * 头插法，翻转链表
         */
        public ListNode reverse(ListNode node) {
            ListNode dummy = new ListNode();
            while (node != null) {
                ListNode tmp = node.next;
                node.next = dummy.next;
                dummy.next = node;
                node = tmp;
            }
            return dummy.next;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}