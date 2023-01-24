//在数组中的两个数字，如果前面一个数字大于后面的数字，则这两个数字组成一个逆序对。输入一个数组，求出这个数组中的逆序对的总数。 
//
// 
//
// 示例 1: 
//
// 输入: [7,5,6,4]
//输出: 5 
//
// 
//
// 限制： 
//
// 0 <= 数组长度 <= 50000 
//
// Related Topics 树状数组 线段树 数组 二分查找 分治 有序集合 归并排序 👍 900 👎 0

package leetcode.editor.cn;

/**
 * title: 剑指 Offer 51 : 数组中的逆序对
 * create: 2022-12-04 19:29:14
 */
public class Q剑指Offer51_ShuZuZhongDeNiXuDuiLcof{
public static void main(String[]args){
        Solution solution=new Q剑指Offer51_ShuZuZhongDeNiXuDuiLcof().new Solution();
        }

//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    // 双循环会超时
//    public int reversePairs(int[] nums) {
//        int res = 0;
//        for (int i = 0; i < nums.length; i++) {
//            for (int j = i + 1; j < nums.length; j++) {
//                if (nums[i] > nums[j]) {
//                    res++;
//                }
//            }
//        }
//        return res;
//    }
    public int reversePairs(int[] nums) {
        int len = nums.length;
        if (len < 2) {
            return 0;
        }

        int[] copy = new int[len];
        int[] temp = new int[len];
        System.arraycopy(nums, 0, copy, 0, len);

        return reversePairs(copy, 0, len - 1, temp);
    }

    private int reversePairs(int[] nums, int left, int right, int[] temp) {
        if (left == right) {
            return 0;
        }

        int mid = left + (right - left) / 2;
        int leftPairs = reversePairs(nums, left, mid, temp);
        int rightPairs = reversePairs(nums, mid + 1, right, temp);

        // left  mid   right
        // 上边已经对 left、right做了处理，此处判断边界。左边最大值小于右边最小值
        if (nums[mid] <= nums[mid + 1]) {
            return leftPairs + rightPairs;
        }

        int crossPairs = mergeAndCount(nums, left, mid, right, temp);
        return leftPairs + rightPairs + crossPairs;
    }

    /**
     * 归并排序同时统计逆序对
     */
    private int mergeAndCount(int[] nums, int left, int mid, int right, int[] temp) {
        if (right + 1 - left >= 0) {
            System.arraycopy(nums, left, temp, left, right + 1 - left);
        }

        int p1 = left;
        int p2 = mid + 1;

        int count = 0;
        for (int i = left; i <= right; i++) {
            // 左边界处理
            if (p1 == mid + 1) {
                nums[i] = temp[p2++];
            } else if (p2 == right + 1) {
                // 右边界处理
                nums[i] = temp[p1++];
            } else if (temp[p1] <= temp[p2]) {
                nums[i] = temp[p1++];
            } else {
                // 左 大于 右
                nums[i] = temp[p2++];
                // 左边排序好的，右边排序好的，此时 `逆序对 = 中间位置 - 左边当前位置`
                count += (mid - p1 + 1);
            }
        }
        return count;
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}