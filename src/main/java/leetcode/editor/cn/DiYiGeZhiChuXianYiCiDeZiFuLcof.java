//在字符串 s 中找出第一个只出现一次的字符。如果没有，返回一个单空格。 s 只包含小写字母。 
//
// 示例 1: 
//
// 
//输入：s = "abaccdeff"
//输出：'b'
// 
//
// 示例 2: 
//
// 
//输入：s = "" 
//输出：' '
// 
//
// 
//
// 限制： 
//
// 0 <= s 的长度 <= 50000 
// Related Topics 队列 哈希表 字符串 计数 👍 140 👎 0

package leetcode.editor.cn;

import java.util.HashMap;
import java.util.Map;

/**
 * title: 剑指 Offer 50 : 第一个只出现一次的字符
 * create: 2021-09-29 11:34:51
 */
public class DiYiGeZhiChuXianYiCiDeZiFuLcof{
    public static void main(String[] args){
        Solution solution = new DiYiGeZhiChuXianYiCiDeZiFuLcof().new Solution();
    }
    //leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public char firstUniqChar(String s) {
        Map<Character, Integer> frequency = new HashMap<>(s.length());
        for (int i = 0; i < s.length(); ++i) {
            char ch = s.charAt(i);
            frequency.put(ch, frequency.getOrDefault(ch, 0) + 1);
        }
        for (int i = 0; i < s.length(); ++i) {
            if (frequency.get(s.charAt(i)) == 1) {
                return s.charAt(i);
            }
        }
        return ' ';
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}