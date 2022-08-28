//给定两个字符串 s 和 p，找到 s 中所有 p 的 异位词 的子串，返回这些子串的起始索引。不考虑答案输出的顺序。 
//
// 异位词 指由相同字母重排列形成的字符串（包括相同的字符串）。 
//
// 
//
// 示例 1: 
//
// 
//输入: s = "cbaebabacd", p = "abc"
//输出: [0,6]
//解释:
//起始索引等于 0 的子串是 "cba", 它是 "abc" 的异位词。
//起始索引等于 6 的子串是 "bac", 它是 "abc" 的异位词。
// 
//
// 示例 2: 
//
// 
//输入: s = "abab", p = "ab"
//输出: [0,1,2]
//解释:
//起始索引等于 0 的子串是 "ab", 它是 "ab" 的异位词。
//起始索引等于 1 的子串是 "ba", 它是 "ab" 的异位词。
//起始索引等于 2 的子串是 "ab", 它是 "ab" 的异位词。
// 
//
// 
//
// 提示: 
//
// 
// 1 <= s.length, p.length <= 3 * 10⁴ 
// s 和 p 仅包含小写字母 
// 
//
// Related Topics 哈希表 字符串 滑动窗口 👍 986 👎 0

package leetcode.editor.cn;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;

/**
 * title: 438 : 找到字符串中所有字母异位词
 * create: 2022-08-28 14:34:19
 */
public class FindAllAnagramsInAString {
    public static void main(String[] args) {
        Solution solution = new FindAllAnagramsInAString().new Solution();
        System.out.println(solution.findAnagrams("", ""));

    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public List<Integer> findAnagrams(String s, String p) {
            List<Integer> res = new LinkedList<>();
            if (s.length() < p.length()) return res;

            HashMap<Character, Integer> needMap = new HashMap<>();
            HashMap<Character, Integer> windowMap = new HashMap<>();

            for (char c : p.toCharArray()) {
                needMap.put(c, needMap.getOrDefault(c, 0) + 1);
            }

            int left = 0, right = 0, valid = 0;
            while (right < s.length()) {
                char c = s.charAt(right++);
                if (needMap.containsKey(c)) {
                    windowMap.put(c, windowMap.getOrDefault(c, 0) + 1);
                    if (windowMap.get(c).equals(needMap.get(c))) {
                        valid++;
                    }
                }

                // 窗口大小要维持 p.length()
                while (right - left >= p.length()) {
                    if (valid == needMap.size()) {
                        res.add(left);
                    }
                    char c1 = s.charAt(left++);
                    if (needMap.containsKey(c1)) {
                        if (windowMap.get(c1).equals(needMap.get(c1))) {
                            valid--;
                        }
                        windowMap.put(c1, windowMap.get(c1) - 1);
                    }
                }
            }
            return res;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}