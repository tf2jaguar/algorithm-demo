//珂珂喜欢吃香蕉。这里有 n 堆香蕉，第 i 堆中有 piles[i] 根香蕉。警卫已经离开了，将在 h 小时后回来。 
//
// 珂珂可以决定她吃香蕉的速度 k （单位：根/小时）。每个小时，她将会选择一堆香蕉，从中吃掉 k 根。如果这堆香蕉少于 k 根，她将吃掉这堆的所有香蕉，然后
//这一小时内不会再吃更多的香蕉。 
//
// 珂珂喜欢慢慢吃，但仍然想在警卫回来前吃掉所有的香蕉。 
//
// 返回她可以在 h 小时内吃掉所有香蕉的最小速度 k（k 为整数）。 
//
// 
//
// 
// 
//
// 示例 1： 
//
// 
//输入：piles = [3,6,7,11], h = 8
//输出：4
// 
//
// 示例 2： 
//
// 
//输入：piles = [30,11,23,4,20], h = 5
//输出：30
// 
//
// 示例 3： 
//
// 
//输入：piles = [30,11,23,4,20], h = 6
//输出：23
// 
//
// 
//
// 提示： 
//
// 
// 1 <= piles.length <= 10⁴ 
// piles.length <= h <= 10⁹ 
// 1 <= piles[i] <= 10⁹ 
// 
//
// Related Topics 数组 二分查找 👍 420 👎 0

package leetcode.editor.cn;

/**
 * title: 875 : 爱吃香蕉的珂珂
 * create: 2022-08-29 13:59:16
 */
public class KokoEatingBananas {
    public static void main(String[] args) {
        Solution solution = new KokoEatingBananas().new Solution();
        System.out.println(solution.minEatingSpeed(new int[]{30, 11, 23, 4, 20}, 6));
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int minEatingSpeed(int[] piles, int h) {
            // 因为可以吃一部分，留一部分下一次吃，则:
            // 可以根据用例的数据范围设定边界
            int left = 0, right = (int) 1e9;
            while (left < right) {
                int mid = left + (right - left) / 2;
                if (f(piles, mid) <= h) {
                    right = mid;
                } else {
                    left = mid + 1;
                }
            }
            return right;
        }

        /**
         * 定义：速度为x时，需要f（x）小时吃完所有香蕉
         * f(x）随着 x 的增加单调递减
         */
        private int f(int[] piles, int mid) {
            int ans = 0;
            for (int p : piles) {
                ans += Math.ceil(p * 1.0 / mid);
            }
            return ans;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}