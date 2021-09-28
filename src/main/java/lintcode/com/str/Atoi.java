/*
 * 描述 实现atoi这个函数，将一个字符串转换为整数。如果没有合法的整数，返回0。若求出的数越界则返回最大值（2147483647）或最小值（-2147483647）
 *
 * 样例 样例 1：
 *
 * 输入：
 *
 * 字符串 = "10" 输出：
 *
 * 10 解释：
 *
 * 将字符串转换为整数。
 *
 * 样例 2：
 *
 * 输入：
 *
 * 字符串 = "1" 输出：
 *
 * 1 解释：
 *
 * 将字符串转换为整数。
 *
 * 样例 3：
 *
 * 输入：
 *
 * 字符串 = "123123123123123" 输出：
 *
 * 2147483647 解释：
 *
 * 因为123123123123123 > INT_MAX，所以返回INT_MAX。
 *
 * 样例 4：
 *
 * 输入：
 *
 * 字符串 = "1.0" 输出：
 *
 * 1 解释：
 *
 * 我们只需要转换第一个有效数字。
 */
package lintcode.com.str;

/**
 * 54 · 转换字符串到整数
 *
 * @author zhangguodong
 * @date 2021/9/28 20:35
 */
public class Atoi {
    public static void main(String[] args) {
        Atoi a = new Atoi();
        int atoi = a.atoi("123123123123123");
        System.out.println(atoi);
    }

    public int atoi(String str) {
        if (str == null) {
            return 0;
        }
        str = str.trim();
        if (str.length() == 0) {
            return 0;
        }

        // 标记正负
        int sign = 1, idx = 0;
        if (str.startsWith("-")) {
            sign = -1;
            idx++;
        } else if (str.startsWith("+")) {
            idx++;
        }

        // 计算
        long res = 0;
        for (; idx < str.length(); idx++) {
            char c = str.charAt(idx);
            if (c < '0' || c > '9') {
                break;
            }
            res = res * 10 + (str.charAt(idx) - '0');
            if (res > Integer.MAX_VALUE) {
                break;
            }
        }

        // 添加正负标记
        res *= sign;
        if (res > Integer.MAX_VALUE) {
            return Integer.MAX_VALUE;
        }
        if (res < Integer.MIN_VALUE) {
            return Integer.MIN_VALUE;
        }
        return (int) res;
    }
}
