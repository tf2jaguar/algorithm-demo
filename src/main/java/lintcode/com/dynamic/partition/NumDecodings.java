/*
 * 描述
 * 有一个消息包含A-Z通过以下规则编码
 *
 * 'A' -> 1
 * 'B' -> 2
 * ...
 * 'Z' -> 26
 * 现在给你一个加密过后的消息，问有几种解码的方式
 *
 * 我们不能解码空串，因此若消息为空，你应该返回0。
 * 消息的长度 n≤100
 *
 * 样例
 * 样例 1:
 *
 * 输入: "12"
 * 输出: 2
 * 解释: 它可以被解码为 AB (1 2) 或 L (12).
 * 样例 2:
 *
 * 输入: "10"
 * 输出: 1
 */
package lintcode.com.dynamic.partition;

/**
 * 512 · 解码方法
 *
 * @author zhangguodong
 * @date 2021/9/24 07:32
 */
public class NumDecodings {
    /**
     * @param s: a string,  encoded message
     * @return an integer, the number of ways decoding
     */
    public int numDecodings(String s) {
        // 确定状态: 字符串前 i 个数字解密方式有 dp[i] 种。
        // 转移方程: 数字可能由1个或2个 组成一组解密方式， dp[i] = dp[i-1] + dp[i-2]
        // 初始条件、边界条件: dp[0] = 0, dp[1] = 1
        // 计算顺序: 从左到右， 0 -> i
        if (s == null || s.length() < 1) {
            return 0;
        }

        char[] chars = s.toCharArray();
        int[] dp = new int[chars.length + 1];
        // 初始条件
        dp[0] = 1;
        for (int i = 1; i <= chars.length; i++) {
            dp[i] = 0;
            // 字符串至少有一个数字
            int tmp = chars[i - 1] - '0';
            if (tmp > 0) {
                dp[i] += dp[i - 1];
            }

            // 有两个数字以上时
            if (i > 1) {
                tmp = (chars[i - 2] - '0') * 10 + (chars[i - 1] - '0');
                if (tmp >= 10 && tmp <= 26) {
                    dp[i] += dp[i - 2];
                }
            }

        }
        return dp[chars.length];
    }
}
