package com.example.algorithmdemo;

/**
 * @author ：guodongzhang
 * @date ：Created in 2021/8/24 17:19
 */
public class KMP {

    /**
     * 获取KMP算法中pattern字符串对应的next数组
     *
     * @param chars 模式字符串对应的字符数组
     */
    public int[] getNext(char[] chars) {
        final int len = chars.length;
        int[] next = new int[len];

        int l = -1;
        // 当前待求next的位置
        int i = 0;
        next[0] = -1;
        while (i < len - 1) {
            if (l == -1 || chars[i] == chars[l]) {
                l++;
                i++;
                next[i] = l;
            } else {
                l = next[l];
            }
        }
        return next;
    }

    public int[] getNext2(char[] chars) {
        if (chars.length == 1) {
            return new int[]{-1};
        }
        int[] next = new int[chars.length];
        next[0] = -1;
        next[1] = 0;
        // 当前待求next的位置
        int i = 2;
        // 上一个位置的next数组的值
        int lastNextVal = 0;
        while (i < chars.length) {
            if (chars[i - 1] == chars[lastNextVal]) {
                next[i++] = ++lastNextVal;
            } else if (lastNextVal > 0) {
                lastNextVal = next[lastNextVal];
            } else {
                next[i++] = 0;
            }
        }
        return next;
    }

    public int indexOf(String source, String pattern) {
        char[] sChar = source.toCharArray();
        char[] pChar = pattern.toCharArray();
        int sLen = sChar.length;
        int pLen = pChar.length;
        int[] next = getNext(pChar);
        int[] next1 = getNext2(pChar);

        int i = 0, j = 0;
        while (i < sLen && j < pLen) {
            // 如果j = -1,或者当前字符匹配成功(src[i] = ptn[j]),都让i++,j++
            if (j == -1 || sChar[i] == pChar[j]) {
                i++;
                j++;
            } else {
                // 如果j!=-1且当前字符匹配失败,则令i不变,j=next[j],即让pattern模式串右移j-next[j]个单位
                j = next[j];
            }
        }
        if (j == pLen) {
            return i - j;
        }

        return -1;
    }


    public static void main(String[] args) {
        KMP k = new KMP();
        int i = k.indexOf("aabbaa", "bbaa");
        System.out.println(i);
    }
}
