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
 * 题解：https://leetcode-cn.com/problems/median-of-two-sorted-arrays/solution/xiang-xi-tong-su-de-si-lu-fen-xi-duo-jie-fa-by-w-2/
 * since: 2021-12-21 07:43:45
 */
public class MedianOfTwoSortedArrays {
    public static void main(String[] args) {
        Solution solution = new MedianOfTwoSortedArrays().new Solution();
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public double findMedianSortedArrays(int[] nums1, int[] nums2) {
            return method2(nums1, nums2);
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
                // 记录上一次的结果
                l = r;
                if (idx1 < len1 && (idx2 >= len2 || nums1[idx1] < nums2[idx2])) {
                    r = nums1[idx1++];
                } else {
                    r = nums2[idx2++];
                }
            }
            // 两个数组加起来数量是偶数
            if ((len & 1) == 0) {
                return (l + r) / 2.0;
            }
            return r;
        }

        /**
         * 时间复杂度：每进行一次循环，我们就减少 k/2 个元素，
         * 所以时间复杂度是 O(log(k)，而 k=(m+n)/2，所以最终的复杂也就是 O(log(m+n）)
         * <p>
         * 空间复杂度：虽然我们用到了递归，但是可以看到这个递归属于尾递归，所以编译器不需要不停地堆栈，
         * 所以空间复杂度为 O(1)
         */
        private double method2(int[] nums1, int[] nums2) {
            int n = nums1.length;
            int m = nums2.length;
            int left = (n + m + 1) / 2;
            int right = (n + m + 2) / 2;
            //将偶数和奇数的情况合并，如果是奇数，会求两次同样的 k 。
            return (getKth(nums1, 0, n - 1, nums2, 0, m - 1, left) +
                    getKth(nums1, 0, n - 1, nums2, 0, m - 1, right)) * 0.5;
        }

        private int getKth(int[] nums1, int start1, int end1, int[] nums2, int start2, int end2, int k) {
            int len1 = end1 - start1 + 1;
            int len2 = end2 - start2 + 1;
            //让 len1 的长度小于 len2，这样就能保证如果有数组空了，一定是 len1
            if (len1 > len2) return getKth(nums2, start2, end2, nums1, start1, end1, k);
            if (len1 == 0) return nums2[start2 + k - 1];

            if (k == 1) return Math.min(nums1[start1], nums2[start2]);

            int i = start1 + Math.min(len1, k / 2) - 1;
            int j = start2 + Math.min(len2, k / 2) - 1;

            if (nums1[i] > nums2[j]) {
                return getKth(nums1, start1, end1, nums2, j + 1, end2, k - (j - start2 + 1));
            } else {
                return getKth(nums1, i + 1, end1, nums2, start2, end2, k - (i - start1 + 1));
            }
        }

        /**
         * 时间复杂度：我们对较短的数组进行了二分查找，所以时间复杂度是 O(log（min（m，n））
         * <p>
         * 空间复杂度：只有一些固定的变量，和数组长度无关，所以空间复杂度是 O ( 1 )
         */
        private double method3(int[] A, int[] B) {
            int m = A.length;
            int n = B.length;
            if (m > n) {
                return findMedianSortedArrays(B, A); // 保证 m <= n
            }
            int iMin = 0, iMax = m;
            while (iMin <= iMax) {
                int i = (iMin + iMax) / 2;
                int j = (m + n + 1) / 2 - i;
                if (j != 0 && i != m && B[j - 1] > A[i]) { // i 需要增大
                    iMin = i + 1;
                } else if (i != 0 && j != n && A[i - 1] > B[j]) { // i 需要减小
                    iMax = i - 1;
                } else { // 达到要求，并且将边界条件列出来单独考虑
                    int maxLeft = 0;
                    if (i == 0) {
                        maxLeft = B[j - 1];
                    } else if (j == 0) {
                        maxLeft = A[i - 1];
                    } else {
                        maxLeft = Math.max(A[i - 1], B[j - 1]);
                    }
                    if ((m + n) % 2 == 1) {
                        return maxLeft;
                    } // 奇数的话不需要考虑右半部分

                    int minRight = 0;
                    if (i == m) {
                        minRight = B[j];
                    } else if (j == n) {
                        minRight = A[i];
                    } else {
                        minRight = Math.min(B[j], A[i]);
                    }

                    return (maxLeft + minRight) / 2.0; //如果是偶数的话返回结果
                }
            }
            return 0.0;
        }
    }

//leetcode submit region end(Prohibit modification and deletion)

}