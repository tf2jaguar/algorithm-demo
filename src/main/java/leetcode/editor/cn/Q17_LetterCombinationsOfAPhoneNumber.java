//给定一个仅包含数字 2-9 的字符串，返回所有它能表示的字母组合。答案可以按 任意顺序 返回。 
//
// 给出数字到字母的映射如下（与电话按键相同）。注意 1 不对应任何字母。 
//
// 
//
// 
//
// 示例 1： 
//
// 
//输入：digits = "23"
//输出：["ad","ae","af","bd","be","bf","cd","ce","cf"]
// 
//
// 示例 2： 
//
// 
//输入：digits = ""
//输出：[]
// 
//
// 示例 3： 
//
// 
//输入：digits = "2"
//输出：["a","b","c"]
// 
//
// 
//
// 提示： 
//
// 
// 0 <= digits.length <= 4 
// digits[i] 是范围 ['2', '9'] 的一个数字。 
// 
// Related Topics 哈希表 字符串 回溯 👍 1543 👎 0

package leetcode.editor.cn;

import java.util.ArrayList;
import java.util.List;

/**
 * title: 17 : 电话号码的字母组合
 * since: 2021-10-11 22:33:47
 */
public class Q17_LetterCombinationsOfAPhoneNumber {
    public static void main(String[] args) {
        Solution solution = new Q17_LetterCombinationsOfAPhoneNumber().new Solution();
        System.out.println(solution.letterCombinations("23"));
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        final String[] ds = new String[]{ //
                "", // 0
                "", // 1
                "abc", // 2
                "def", // 3
                "ghi", // 4
                "jkl", // 5
                "mno", // 6
                "pqrs", // 7
                "tuv", // 8
                "wxyz" // 9
        };

        public List<String> letterCombinations(String str) {
            if (str == null || str.length() == 0) {
                return new ArrayList<>();
            }
            StringBuffer box = new StringBuffer();
            List<String> ans = new ArrayList<>();
            process(str, box, 0, ans);
            return ans;
        }

        private void process(String str, StringBuffer box, int strIdx, List<String> ans) {
            final int len = str == null ? 0 : str.length();
            if (len == box.length()) {
                ans.add(box.toString());
            }
            if (strIdx >= len) {
                return;
            }
            // 第几个数字
            int idx = str.charAt(strIdx) - '0';
            for (int i = 0; i < ds[idx].length(); i++) {
                // 找到 a、b、c……
                char c = ds[idx].charAt(i);
                // 添加到box
                box.append(c);
                // 找下一个人
                process(str, box, strIdx + 1, ans);
                // 清除最后一次放进box的
                box.deleteCharAt(box.length() - 1);
            }
        }
    }

//leetcode submit region end(Prohibit modification and deletion)

}