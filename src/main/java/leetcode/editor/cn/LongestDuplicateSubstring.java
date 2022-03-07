//给你一个字符串 s ，考虑其所有 重复子串 ：即 s 的（连续）子串，在 s 中出现 2 次或更多次。这些出现之间可能存在重叠。 
//
// 返回 任意一个 可能具有最长长度的重复子串。如果 s 不含重复子串，那么答案为 "" 。 
//
// 
//
// 示例 1： 
//
// 
//输入：s = "banana"
//输出："ana"
// 
//
// 示例 2： 
//
// 
//输入：s = "abcd"
//输出：""
// 
//
// 
//
// 提示： 
//
// 
// 2 <= s.length <= 3 * 10⁴ 
// s 由小写英文字母组成 
// 
// Related Topics 字符串 二分查找 后缀数组 滑动窗口 哈希函数 滚动哈希 👍 300 👎 0

package leetcode.editor.cn;

import java.util.HashSet;
import java.util.Set;

/**
 * title: 1044 : 最长重复子串
 * https://leetcode-cn.com/problems/longest-duplicate-substring/solution/tong-ge-lai-shua-ti-la-er-fen-cha-zhao-z-gc3d/
 * create: 2022-03-07 23:13:48
 */
public class LongestDuplicateSubstring {
    public static void main(String[] args) {
        Solution solution = new LongestDuplicateSubstring().new Solution();
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public String longestDupSubstring(String s) {
            String res = "";
            int l = 0, r = s.length() - 1;
            while (l <= r) {
                // mid 是要找的长度
                int mid = (l + r + 1) / 2;
                // 看是否能找到这么长的重复子串
                String tmp = find(s, mid);
                if (!"".equals(tmp)) {
                    // 找到了再看更长的子串，更短的不用看了
                    l = mid + 1;
                    res = tmp;
                } else {
                    // 没找到再看更短的子串
                    r = mid - 1;
                }
            }
            return res;
        }

        private String find(String s, int len) {
            String res = "";
            Set<Long> set = new HashSet<>();
            long hash = 0;
            long power = 1;
            // 先计算前len个字符组成的子串的hash
            // 与java的String的hashCode()方法一样
            for (int i = 0; i < len; i++) {
                hash = hash * 31 + s.charAt(i);
                power *= 31;
            }
            set.add(hash);

            // 滑动窗口向后移，每次移动要把移出窗口的减去，再加上新的
            for (int i = len; i < s.length(); i++) {
                hash = hash * 31 + s.charAt(i) - power * s.charAt(i - len);
                // 如果包含相同的hash说明之前可能出现过相同的子串
                // 再检测一下从头查找相同的子串，它的位置不是当前 i 的位置，说明确实是相同的子串
                // 否则，可能是因为hash冲突导致的误判
                // 针对本题，不加indexOf这个判断也可以过，是因为没有出现这样的用例
                // 但是，为了逻辑更严谨，还是应该加上这个判断
                if (set.contains(hash) && s.indexOf(res = s.substring(i - len + 1, i + 1)) != i) {
                    return res;
                }
                set.add(hash);
            }

            return res;

        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}