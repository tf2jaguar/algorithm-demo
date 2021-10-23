package com.example.algorithmdemo;

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

    public static int pow(int m, int n) {
        // m 的 0 次方等于1
        int res = 1, tmp = m;
        while (n != 0) {
            // 奇数
            if ((n & 1) == 1) {
                res *= tmp;
            }
            tmp *= tmp;
            n = n >> 1;
        }
        return res;
    }

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
            int mid = low + (high - low) >> 1;
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

    public static void main(String[] args) {
//        int pow = MathCal.pow(2, 5);
//        System.out.println(pow);
//        System.out.println(MathCal.sqrt(4));
        System.out.println(MathCal.divide(36, 6));
    }
}
