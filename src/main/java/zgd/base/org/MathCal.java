package zgd.base.org;

import java.text.DecimalFormat;

/**
 * @author zhangguodong
 * @date 2021/9/28 19:43
 */
public class MathCal {
    public static int divide(int dividend, int divisor) {
        long a = dividend, b = divisor, ans = 0;
        boolean isNeg = a < 0 && b > 0 || a > 0 && b < 0;
        // 试除
        a = Math.abs(a);
        b = Math.abs(b);
        while (a >= b) {
            long base = b, cnt = 1;
            // 除数不断翻倍，直至大于被除数
            while ((base << 1) <= a) {
                base <<= 1;
                cnt <<= 1;
            }
            // 将倍数累加
            ans += cnt;
            // 被除数在减去这个不超过被除数的除数的最大倍数
            a -= base;
        }

        if (isNeg) ans = -ans;
        if (ans < Integer.MIN_VALUE || ans > Integer.MAX_VALUE) return Integer.MAX_VALUE;
        return (int) ans;
    }

    public static double myPow(double x, int n) {
        return (long) n >= 0 ? quickMul(x, n) : 1.0 / quickMul(x, -(long) n);
    }

    public static double quickMul(double x, long n) {
        double ans = 1.0, tmp = x;
        // 在对 N 进行二进制拆分的同时计算答案
        while (n > 0) {
            if (n % 2 == 1) {
                // 如果 N 二进制表示的最低位为 1，那么需要计入贡献
                ans *= tmp;
            }
            // 将贡献不断地平方
            tmp *= tmp;
            // 舍弃 N 二进制表示的最低位，这样我们每次只要判断最低位即可
            n /= 2;
        }
        return ans;
    }

    /**
     * 开平方
     * 二分法
     */
    public static double sqrt(int n) {
        if (n < 0) {
            return Double.NaN;
        }
        if (n == 0) {
            return 0;
        }
        // 二分法逐步逼近
        int low = 0, high = n;
        while (low <= high) {
            int mid = (low + high) / 2;
            int tmp = n / mid;
            if (tmp == mid) {
                return mid;
            } else if (tmp > mid) {
                low = mid + 1;
            } else {
                high = mid - 1;
            }
        }
        return high;
    }

    /**
     * 开立方
     * 牛顿迭代法
     */
    public static double cube(double n) {
        double n1 = n;
        double n2 = niuDunDieDai(n1, n);
        while (Math.abs(n1 - n2) > 0.000001) {
            n1 = n2;
            n2 = niuDunDieDai(n1, n);
        }
        DecimalFormat df = new DecimalFormat("#0.0");
        return Double.parseDouble(df.format(n2));
    }

    /**
     * 牛顿迭代法
     */
    private static double niuDunDieDai(double n1, double n2) {
        return (2 * n1 / 3) + (n2 / (n1 * n1 * 3));
    }

    public static void main(String[] args) {
//        System.out.println(MathCal.myPow(2, 10));
//
        System.out.println(MathCal.cube(8));
        System.out.println(MathCal.cube(27.00));
//        System.out.println(MathCal.sqrt(49));
//        System.out.println(MathCal.divide(36, 6));
        // 值传递，引用传递
//        String a = "1122";
//        System.out.println(a);
//        test(a);
//        System.out.println(a);

    }

}
