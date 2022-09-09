//给你一个字符串 s ，请你去除字符串中重复的字母，使得每个字母只出现一次。需保证 返回结果的字典序最小（要求不能打乱其他字符的相对位置）。 
//
// 
//
// 示例 1： 
//
// 
//输入：s = "bcabc"
//输出："abc"
// 
//
// 示例 2： 
//
// 
//输入：s = "cbacdcbc"
//输出："acdb" 
//
// 
//
// 提示： 
//
// 
// 1 <= s.length <= 10⁴ 
// s 由小写英文字母组成 
// 
//
// 
//
// 注意：该题与 1081 https://leetcode-cn.com/problems/smallest-subsequence-of-
//distinct-characters 相同 
//
// Related Topics 栈 贪心 字符串 单调栈 👍 807 👎 0

package leetcode.editor.cn;

import java.util.Stack;

/**
 * title: 316 : 去除重复字母
 * create: 2022-09-08 10:51:30
 */
public class RemoveDuplicateLetters {
    public static void main(String[] args) {
        Solution solution = new RemoveDuplicateLetters().new Solution();
        String removeDuplicateLetters = solution.removeDuplicateLetters("bcabc");
        System.out.println("is acdb " + "abc".equals(removeDuplicateLetters));
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public String removeDuplicateLetters(String s) {
            // 存放去重的结果
            Stack<Character> stk = new Stack<>();
            // 找到最大值，做数组的长度
            int max = 0;
            for (char c : s.toCharArray()) {
                max = Math.max(max, c);
            }
            // 计数器
            // 输入字符均为 ASCII 字符，所以大小 256 够用了
            int[] count = new int[max + 1];
            for (char c : s.toCharArray()) {
                count[c]++;
            }
            // 布尔数组初始值为 false，记录栈中是否存在某个字符
            boolean[] inStack = new boolean[max + 1];
            for (char c : s.toCharArray()) {
                count[c]--;
                // 如果字符 c 存在栈中，直接跳过
                if (inStack[c]) continue;

                // 插入之前，和之前的元素比较一下大小，如果字典序比前面的小，pop 前面的元素
                while (!stk.isEmpty() && stk.peek() > c) {
                    if (count[stk.peek()] == 0) {
                        break;
                    }
                    // 弹出栈顶元素，并把该元素标记为不在栈中
                    inStack[stk.pop()] = false;
                }
                // 若不存在，则插入栈顶并标记为存在
                stk.push(c);
                inStack[c] = true;
            }

            StringBuilder sb = new StringBuilder();
            while (!stk.empty()) {
                sb.append(stk.pop());
            }
            // 栈中元素插入顺序是反的，需要 reverse 一下
            return sb.reverse().toString();
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}