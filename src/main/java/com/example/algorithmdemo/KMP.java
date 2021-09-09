package com.example.algorithmdemo;

/**
 * 解决原始问题：str1和str2为两个字符串，其中str1中的某个子串是否等于str2.
 *
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
            // 当前待求next值位置的前一个位置的值，和该位置对应的next数组的值的位置是否相等
            // 相等则直接将该位置对应的next数组的值 加一，即为当前位置的next数组的值
            if (chars[i - 1] == chars[lastNextVal]) {
                next[i++] = ++lastNextVal;
            } else if (lastNextVal > 0) {
                // 两个值不想等，如果上一个位置的next数组的值不为-1，则向前跳到next值的位置
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

        int i = 0, j = 0;
        while (i < sLen && j < pLen) {
            // 如果当前字符匹配成功(src[i] = ptn[j]),都让i++,j++
            if (sChar[i] == pChar[j]) {
                i++;
                j++;
            } else if (next[j] == -1) {
                // 如果pattern模式串的 next 数组的值为 -1 那么，pattern模式串已经到了最开头，无法再往前跳了。将源串位置加一
                i++;
            } else {
                // j=next[j],即让pattern模式串右移j-next[j]个单位
                j = next[j];
            }
        }

        return j == pLen ? i - j : -1;
    }


    public static void main(String[] args) {
        KMP k = new KMP();
        int i = k.indexOf("aabbaa", "bbaa");
        System.out.println(i);
    }
}
