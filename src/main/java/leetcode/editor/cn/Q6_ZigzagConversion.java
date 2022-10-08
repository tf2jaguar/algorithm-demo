//将一个给定字符串 s 根据给定的行数 numRows ，以从上往下、从左到右进行 Z 字形排列。 
//
// 比如输入字符串为 "PAYPALISHIRING" 行数为 3 时，排列如下： 
//
// 
//P   A   H   N
//A P L S I I G
//Y   I   R 
//
// 之后，你的输出需要从左往右逐行读取，产生出一个新的字符串，比如："PAHNAPLSIIGYIR"。 
//
// 请你实现这个将字符串进行指定行数变换的函数： 
//
// 
//string convert(string s, int numRows); 
//
// 
//
// 示例 1： 
//
// 
//输入：s = "PAYPALISHIRING", numRows = 3
//输出："PAHNAPLSIIGYIR"
// 
//示例 2：
//
// 
//输入：s = "PAYPALISHIRING", numRows = 4
//输出："PINALSIGYAHRPI"
//解释：
//P     I    N
//A   L S  I G
//Y A   H R
//P     I
// 
//
// 示例 3： 
//
// 
//输入：s = "A", numRows = 1
//输出："A"
// 
//
// 
//
// 提示： 
//
// 
// 1 <= s.length <= 1000 
// s 由英文字母（小写和大写）、',' 和 '.' 组成 
// 1 <= numRows <= 1000 
// 
// Related Topics 字符串 👍 1502 👎 0

package leetcode.editor.cn;

/**
 * title: 6 : Z 字形变换
 * create: 2022-03-01 08:16:18
 */
public class Q6_ZigzagConversion {
    public static void main(String[] args) {
        Solution solution = new Q6_ZigzagConversion().new Solution();
        System.out.println(solution.convert("PAYPALISHIRING", 3).equals("PAHNAPLSIIGYIR"));
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        // P A Y P A L I S H I R I N G   3

        // P       A       H       N
        //   A   P  L    S   I   I   G
        //     Y      I        R
        // PAHNAPLSIIGYIR
        public String convert(String s, int numRows) {
            if (numRows == 1) return s;
            // 周期 numRows + numRows - 2
            int sum = 2 * numRows - 2;
            char[] res = new char[s.length()];
            // 对每一行查找一次 s
            for (int r = 0, i = 0; r < numRows; r++) {
                for (int j = 0; j < s.length(); j++) {
                    // 下标对周期取余，如果等于行数，或者等于周期减去行数，说明在z字结构上
                    if (j % sum == r || j % sum == (sum - r)) res[i++] = s.charAt(j);
                }
            }
            return new String(res);
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}