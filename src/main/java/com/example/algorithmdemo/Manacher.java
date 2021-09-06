package com.example.algorithmdemo;

/**
 * 1. 回文右边界R不包含位置i，此时暴力扩展，直到R包含i。
 * 2. i位置在回文有边界内时，知道了回文右边界可以知道回文左边界，对称中心为c，此时关于c做i的对称点i‘，若i‘的回文彻底在c为中心的回文里面，此时i的回文半径和i’的回文半径相同。
 * 3. i位置的对称位置i’的回文半径越过了以c为中心的左边范围。（i‘扩出的范围以c为中心的回文没包住，存在一部分在回文直径外面）此时i的回文半径是R-i。
 * 4. 正好i‘的回文半径正好跟左边L相等，此时可以直到i的回文半径大于等于i-R，然后需要判断R后面的位置，重新返回第一步。
 * 5. 整个算法的复杂度O(n)，虽然第一步和第四步花费时间长，但是1，4都会扩展R，依次变化的过程中，R最多也就是变化到n，所以时间复杂度为O(n)。
 *
 * @author zhangguodong
 */
public class Manacher {
    /**
     * 首位、中间、末位 加上#
     */
    public static char[] manacherString(String str) {
        char[] charArr = str.toCharArray();
        char[] res = new char[str.length() * 2 + 1];
        int index = 0;
        for (int i = 0; i != res.length; i++) {
            res[i] = (i & 1) == 0 ? '#' : charArr[index++];
        }
        return res;
    }

    public static void main(String[] args) {
        System.out.println(manacherString("zhang"));
    }


}
