package zgd.base.org;

/**
 * 解决原始问题：str1和str2为两个字符串，其中str1中的某个子串是否等于str2.
 * 参考：https://leetcode-cn.com/problems/implement-strstr/solution/dai-ma-sui-xiang-lu-kmpsuan-fa-xiang-jie-mfbs/
 *
 * @author ：guodongzhang
 * @since  ：Created in 2021/8/24 17:19
 */
public class KMP {

    /**
     * 获取KMP算法中pattern字符串对应的next数组
     *
     * @param s 模式字符串对应的字符数组
     */
    public int[] getNext(String s) {
        int[] next = new int[s.length()];
        int j = 0;
        for (int i = 1; i < s.length(); i++) { // 注意i就从1开始
            while (j > 0 && s.charAt(i) != s.charAt(j)) {  // 前后缀不相同了，回朔
                j = next[j - 1];
            }

            if (s.charAt(i) == s.charAt(j)) { // 找到相同的前后缀
                j++;
            }
            next[i] = j; // 将j（前缀的长度）赋给next[i]
        }
        return next;
    }

    public int indexOf(String source, String pattern) {
        if (pattern == null || pattern.length() == 0) {
            return 0;
        }
        int[] next = getNext(pattern);

        int j = 0;
        for (int i = 0; i < source.length(); i++) { // 注意i就从0开始
            while (j > 0 && source.charAt(i) != pattern.charAt(j)) { // 匹配，j和i同时向后移动，i的增加在for循环里
                j = next[j - 1]; // j 寻找之前匹配的位置
            }
            if (source.charAt(i) == pattern.charAt(j)) { // 匹配，j和i同时向后移动，i的增加在for循环里
                j++;
            }
            if (j == pattern.length()) { // 文本串s里出现了模式串t
                return (i - pattern.length() + 1);
            }
        }
        return -1;
    }

    public static void main(String[] args) {
        KMP k = new KMP();
        int i = k.indexOf("aabbaa", "bbaa");
        System.out.println(i);
        int[] ledales = k.getNext("ledale");
        System.out.println();
    }
}
