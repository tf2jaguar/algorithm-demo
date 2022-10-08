//给定两个大小相等的数组 nums1 和 nums2，nums1 相对于 nums 的优势可以用满足 nums1[i] > nums2[i] 的索引 i 的数
//目来描述。 
//
// 返回 nums1 的任意排列，使其相对于 nums2 的优势最大化。 
//
// 
//
// 示例 1： 
//
// 
//输入：nums1 = [2,7,11,15], nums2 = [1,10,4,11]
//输出：[2,11,7,15]
// 
//
// 示例 2： 
//
// 
//输入：nums1 = [12,24,8,32], nums2 = [13,25,32,11]
//输出：[24,32,8,12]
// 
//
// 
//
// 提示： 
//
// 
// 1 <= nums1.length <= 10⁵ 
// nums2.length == nums1.length 
// 0 <= nums1[i], nums2[i] <= 10⁹ 
// 
//
// Related Topics 贪心 数组 排序 👍 198 👎 0

package leetcode.editor.cn;

import java.util.Arrays;
import java.util.PriorityQueue;

/**
 * title: 870 : 优势洗牌
 * create: 2022-08-30 13:37:56
 */
public class Q870_AdvantageShuffle {
    public static void main(String[] args) {
        Solution solution = new Q870_AdvantageShuffle().new Solution();
        int[] ints = solution.advantageCount(new int[]{2, 7, 11, 15}, new int[]{1, 10, 4, 11});

        for (int i : ints) {
            System.out.print(i + ",");
        }
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int[] advantageCount(int[] nums1, int[] nums2) {
            int len = nums1.length;
            // 对两个数组排序
            // nums2 中元素的顺序不能改变，因为计算结果的顺序依赖 nums2 的顺序，利用其他数据结构来辅助。
            PriorityQueue<int[]> priorityQueue = new PriorityQueue<>((o1, o2) -> o2[1] - o1[1]);
            for (int i = 0; i < len; i++) {
                priorityQueue.offer(new int[]{i, nums2[i]});
            }
            Arrays.sort(nums1);

            int[] res = new int[len];
            int left = 0, right = len - 1;
            while (!priorityQueue.isEmpty()) {
                int[] poll = priorityQueue.poll();
                int i = poll[0], val = poll[1];
                // 如果 nums1 最大的大于 nums2 最大的，则使用nums1的大值；否则使用小的充数(塞翁失马)
                if (nums1[right] > val) {
                    res[i] = nums1[right--];
                } else {
                    res[i] = nums1[left++];
                }
            }
            return res;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}