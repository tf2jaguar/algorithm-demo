//编写一个函数来查找字符串数组中的最长公共前缀。 
//
// 如果不存在公共前缀，返回空字符串 ""。 
//
// 
//
// 示例 1： 
//
// 
//输入：strs = ["flower","flow","flight"]
//输出："fl"
// 
//
// 示例 2： 
//
// 
//输入：strs = ["dog","racecar","car"]
//输出：""
//解释：输入不存在公共前缀。 
//
// 
//
// 提示： 
//
// 
// 1 <= strs.length <= 200 
// 0 <= strs[i].length <= 200 
// strs[i] 仅由小写英文字母组成 
// 
// Related Topics 字符串 👍 1842 👎 0

package leetcode.editor.cn;

/**
 * title: 14 : 最长公共前缀
 * since: 2021-11-02 08:16:05
 */
public class LongestCommonPrefix {
    public static void main(String[] args) {
        Solution solution = new LongestCommonPrefix().new Solution();
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        /**
         * 纵向寻找
         * strs[0] 和strs 其他的每个元素比较,遇到后序字符串长度 或 不想等的时候，截取0-i 返回
         * 否则，最长前缀就是 strs[0]
         */
        public String longestCommonPrefix(String[] strs) {
            int count = strs.length;
            int len = strs[0].length();
            for (int i = 0; i < len; i++) {
                for (int j = 1; j < count; j++) {
                    if (i == strs[j].length() || strs[0].charAt(i) != strs[j].charAt(i)) {
                        return strs[0].substring(0, i);
                    }
                }
            }
            return strs[0];
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}