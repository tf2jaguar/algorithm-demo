//给定一个链表的 头节点 head ，请判断其是否为回文链表。 
//
// 如果一个链表是回文，那么链表节点序列从前往后看和从后往前看是相同的。 
//
// 
//
// 示例 1： 
//
// 
//
// 
//输入: head = [1,2,3,3,2,1]
//输出: true 
//
// 示例 2： 
//
// 
//
// 
//输入: head = [1,2]
//输出: fasle
// 
//
// 
//
// 提示： 
//
// 
// 链表 L 的长度范围为 [1, 10⁵] 
// 0 <= node.val <= 9 
// 
//
// 
//
// 进阶：能否用 O(n) 时间复杂度和 O(1) 空间复杂度解决此题？ 
//
// 
//
// 注意：本题与主站 234 题相同：https://leetcode-cn.com/problems/palindrome-linked-list/ 
// Related Topics 栈 递归 链表 双指针 👍 2 👎 0

package leetcode.editor.cn;

/**
 * title: 剑指 Offer II 027 : 回文链表
 * create: 2021-09-05 16:29:11
 */
public class AMhZSa {
    public static void main(String[] args) {
        Solution solution = new AMhZSa().new Solution();
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
        public boolean isPalindrome(ListNode head) {
            ListNode fast = head;
            ListNode slow = head;

            // 快慢指针，fast结束时，slow将会指向后半段的开始节点处
            while (fast != null && fast.next != null) {
                fast = fast.next.next;
                slow = slow.next;
            }
            // 1 2 3 4 5 6
            //       s     f

            // 1 2 3 4 5
            //     s   f
            // 翻转后半部分，重置fast为原始头节点，然后一个一个比较
            ListNode rNode = reverse(slow);
            fast = head;
            boolean res = true;
            while (fast != null && rNode != null) {
                if (fast.val != rNode.val) {
                    res = false;
                    break;
                }
                fast = fast.next;
                rNode = rNode.next;
            }
            return res;
        }

        private ListNode reverse(ListNode node) {
            ListNode dummy = new ListNode();
            while (node!=null){
                ListNode tmp = node.next;
                node.next=dummy.next;
                dummy.next=node;
                node = tmp;
            }
            return dummy.next;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}