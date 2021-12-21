//给定两个大小分别为 m 和 n 的正序（从小到大）数组 nums1 和 nums2。请你找出并返回这两个正序数组的 中位数 。 
//
// 算法的时间复杂度应该为 O(log (m+n)) 。 
//
// 
//
// 示例 1： 
//
// 
//输入：nums1 = [1,3], nums2 = [2]
//输出：2.00000
//解释：合并数组 = [1,2,3] ，中位数 2
// 
//
// 示例 2： 
//
// 
//输入：nums1 = [1,2], nums2 = [3,4]
//输出：2.50000
//解释：合并数组 = [1,2,3,4] ，中位数 (2 + 3) / 2 = 2.5
// 
//
// 示例 3： 
//
// 
//输入：nums1 = [0,0], nums2 = [0,0]
//输出：0.00000
// 
//
// 示例 4： 
//
// 
//输入：nums1 = [], nums2 = [1]
//输出：1.00000
// 
//
// 示例 5： 
//
// 
//输入：nums1 = [2], nums2 = []
//输出：2.00000
// 
//
// 
//
// 提示： 
//
// 
// nums1.length == m 
// nums2.length == n 
// 0 <= m <= 1000 
// 0 <= n <= 1000 
// 1 <= m + n <= 2000 
// -10⁶ <= nums1[i], nums2[i] <= 10⁶ 
// 
// Related Topics 数组 二分查找 分治 👍 4794 👎 0

package leetcode.editor.cn;

/**
 * title: 4 : 寻找两个正序数组的中位数
 * since: 2021-12-21 07:43:45
 */
public class MedianOfTwoSortedArrays {
    public static void main(String[] args) {
        Solution solution = new MedianOfTwoSortedArrays().new Solution();
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public double findMedianSortedArrays(int[] nums1, int[] nums2) {
            return method1(nums1, nums2);
        }

        /**
         * 时间复杂度：遍历 len/2+1 次，len=m+n，所以时间复杂度依旧是 O(m+n)O(m+n)。
         * <p>
         * 空间复杂度：我们申请了常数个变量，也就是 m，n，len，left，right，aStart，bStart 以及 i。
         * 总共 8 个变量，所以空间复杂度是 O(1）O(1）。
         */
        private double method1(int[] nums1, int[] nums2) {
            int len1 = nums1.length;
            int len2 = nums2.length;
            int len = len1 + len2;
            int l = 0, r = 0, idx1 = 0, idx2 = 0;
            for (int i = 0; i <= len / 2; i++) {
                l = r;
                if (idx1 < len1 && (idx2 >= len2 || nums1[idx1] < nums2[idx2])) {
                    r = nums1[idx1++];
                } else {
                    r = nums2[idx2++];
                }
            }
            if ((len & 1) == 0) {
                return (l + r) / 2.0;
            } else {
                return r;
            }
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}