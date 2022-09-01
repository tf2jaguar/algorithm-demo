package zgd.base.org;


/**
 * @author ：zhangguodong
 * @since ：2021/10/24 09:50
 */
public class ListNodeTool {
    static class ListNode {
        int val;
        ListNode next;

        ListNode() {
        }

        ListNode(int val) {
            this.val = val;
        }

        ListNode(int val, ListNode next) {
            this.val = val;
            this.next = next;
        }
    }

    /**
     * 翻转链表
     */
    public ListNode reverse(ListNode node) {
        ListNode dummy = new ListNode(0);
        while (node != null) {
            ListNode next = node.next;
            node.next = dummy.next;
            dummy.next = node;
            node = next;
        }
        return dummy.next;
    }

    public ListNode reverse2(ListNode head) {
        if (head.next == null) return head;
        ListNode last = reverse2(head.next);
        head.next.next = head;
        head.next = null;
        return last;
    }

    /**
     * 打印链表
     */
    public void printListNode(ListNode node) {
        while (node != null) {
            System.out.print(node.val + " ");
            node = node.next;
        }
    }

    /**
     * 找到中间节点,结束时:
     * 偶数个节点：fast为null，slow为后段链表的开始位置）
     * 奇数个节点：fast为最后一个节点，slow为中间节点
     * <p>
     * 1 2 3 4 | 5 6 7 8
     * f       |
     * s       |
     * --      |
     * --      |         f
     * --      | s
     */
    public ListNode twoPart(ListNode head) {
        ListNode fast = head, slow = head;
        while (fast != null && fast.next != null) {
            fast = fast.next.next;
            slow = slow.next;
        }
        return slow;
    }

    public void threePart(ListNode node) {
        ListNode l1 = node, l2 = node, l3 = node;
        while (l3 != null && l3.next != null && l3.next.next != null) {
            l3 = l3.next.next.next;
            l2 = l2.next.next;
            l1 = l1.next;
        }
        System.out.println("part1:" + l1.val + " part2:" + l2.val + " part3:" + (l3 == null ? "null" : l3.val));
    }

    public static void main(String[] args) {
        ListNodeTool tool = new ListNodeTool();
        System.out.println("倒转链表");
        ListNode head = new ListNode(1, new ListNode(2, new ListNode(3, new ListNode(4, new ListNode(5)))));
        ListNode reverse = tool.reverse(head);
        tool.printListNode(reverse);
        System.out.println("\n=====");

        System.out.println("二等份链表");
        ListNode part2_1 = new ListNode(1, new ListNode(2, new ListNode(3, new ListNode(4, new ListNode(5)))));
        ListNode part2_2 = new ListNode(1, new ListNode(2, new ListNode(3, new ListNode(4, new ListNode(5, new ListNode(6))))));
        // 奇数链表为 mid指向后半段的头节点，后半段更长一点
        ListNode mid1 = tool.twoPart(part2_1);
        System.out.print("奇数：mid:" + mid1.val);
        // 偶数链表为，mid指向后半段的头节点，两端一样长
        ListNode mid2 = tool.twoPart(part2_2);
        System.out.println("偶数：mid:" + mid2.val);
        System.out.println("\n=====");

        System.out.println("三等份链表");
        // 三等分，分别指向第2段和第三段的开始节点位置
        ListNode part3 = new ListNode(1, new ListNode(2, new ListNode(3, new ListNode(4, new ListNode(5, new ListNode(6))))));
        tool.threePart(part3);
    }
}
