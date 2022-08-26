//给你一个字符串 s 、一个字符串 t 。返回 s 中涵盖 t 所有字符的最小子串。如果 s 中不存在涵盖 t 所有字符的子串，则返回空字符串 "" 。 
//
// 
//
// 注意： 
//
// 
// 对于 t 中重复字符，我们寻找的子字符串中该字符数量必须不少于 t 中该字符数量。 
// 如果 s 中存在这样的子串，我们保证它是唯一的答案。 
// 
//
// 
//
// 示例 1： 
//
// 
//输入：s = "ADOBECODEBANC", t = "ABC"
//输出："BANC"
// 
//
// 示例 2： 
//
// 
//输入：s = "a", t = "a"
//输出："a"
// 
//
// 示例 3: 
//
// 
//输入: s = "a", t = "aa"
//输出: ""
//解释: t 中两个字符 'a' 均应包含在 s 的子串中，
//因此没有符合条件的子字符串，返回空字符串。 
//
// 
//
// 提示： 
//
// 
// 1 <= s.length, t.length <= 10⁵ 
// s 和 t 由英文字母组成 
// 
//
// 
//进阶：你能设计一个在 
//o(n) 时间内解决此问题的算法吗？
//
// Related Topics 哈希表 字符串 滑动窗口 👍 2087 👎 0

package leetcode.editor.cn;

import java.util.HashMap;

/**
 * title: 76 : 最小覆盖子串
 * create: 2022-08-25 17:02:35
 */
public class MinimumWindowSubstring {
    public static void main(String[] args) {
        Solution solution = new MinimumWindowSubstring().new Solution();
        System.out.println(solution.minWindow("a", "b"));
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public String minWindow(String s, String t) {
            if (t.length() > s.length()) return "";

            HashMap<Character, Integer> needMap = new HashMap<>();
            HashMap<Character, Integer> windowMap = new HashMap<>();
            // 记录待匹配字符串中各字符出现的次数
            for (char c : t.toCharArray()) {
                needMap.put(c, needMap.getOrDefault(c, 0) + 1);
            }

            int left = 0, right = 0, valid = 0;
            int start = 0, len = Integer.MAX_VALUE;

            while (right < s.length()) {
                char c = s.charAt(right++);
                if (needMap.containsKey(c)) {
                    // 待匹配字符串中包含此字符，当出现次数相同时增加有效字符个数
                    windowMap.put(c, windowMap.getOrDefault(c, 0) + 1);
                    if (windowMap.get(c).equals(needMap.get(c))) {
                        valid++;
                    }
                }

                // 有效字符个数和待匹配的字符个数相等时
                while (valid == needMap.size()) {
                    // 记录最短的长度
                    if (right - left < len) {
                        start = left;
                        len = right - left;
                    }

                    // 尝试缩减左边界
                    char c1 = s.charAt(left++);
                    if (needMap.containsKey(c1)) {
                        if (windowMap.get(c1).equals(needMap.get(c1))) {
                            valid--;
                        }
                        windowMap.put(c1, windowMap.get(c1) - 1);
                    }
                }
            }
            return len == Integer.MAX_VALUE ? "" : s.substring(start, start + len);
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}