//给你一个二维整数数组 envelopes ，其中 envelopes[i] = [wi, hi] ，表示第 i 个信封的宽度和高度。 
//
// 当另一个信封的宽度和高度都比这个信封大的时候，这个信封就可以放进另一个信封里，如同俄罗斯套娃一样。 
//
// 请计算 最多能有多少个 信封能组成一组“俄罗斯套娃”信封（即可以把一个信封放到另一个信封里面）。 
//
// 注意：不允许旋转信封。 
//
// 示例 1： 
//
// 
//输入：envelopes = [[5,4],[6,4],[6,7],[2,3]]
//输出：3
//解释：最多信封的个数为 3, 组合为: [2,3] => [5,4] => [6,7]。 
//
// 示例 2： 
//
// 
//输入：envelopes = [[1,1],[1,1],[1,1]]
//输出：1
// 
//
// 
//
// 提示： 
//
// 
// 1 <= envelopes.length <= 10⁵ 
// envelopes[i].length == 2 
// 1 <= wi, hi <= 10⁵ 
// 
//
// Related Topics 数组 二分查找 动态规划 排序 👍 795 👎 0

package leetcode.editor.cn;

import java.util.Arrays;

/**
 * title: 354 : 俄罗斯套娃信封问题
 * create: 2022-08-30 17:04:24
 */
public class RussianDollEnvelopes {
    public static void main(String[] args) {
        Solution solution = new RussianDollEnvelopes().new Solution();
        System.out.println(solution.maxEnvelopes(new int[][]{{5, 4}, {6, 4}, {6, 7}, {2, 3}}));
        System.out.println(solution.maxEnvelopes(new int[][]{{1, 1}, {1, 1}, {1, 1}}));
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int maxEnvelopes(int[][] envelopes) {
            // 宽度升序、高度降序
            Arrays.sort(envelopes, (o1, o2) -> o1[0] == o2[0] ? o2[1] - o1[1] : o1[0] - o2[0]);

            // 求宽度顺序情况下，高度的 LIS(最长递增子序列)
            int[] tail = new int[envelopes.length];
            int size = 0;
            for (int[] envelope : envelopes) {
                int num = envelope[1];

                int l = 0, r = size;
                while (l < r) {
                    int mid = l + (r - l) / 2;
                    if (tail[mid] < num) {
                        l = mid + 1;
                    } else {
                        r = mid;
                    }
                }
                tail[l] = num;
                if (size == r) {
                    size++;
                }
            }
            return size;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}