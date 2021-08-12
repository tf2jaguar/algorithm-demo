//给定两个以升序排列的整数数组 nums1 和 nums2 , 以及一个整数 k 。 
//
// 定义一对值 (u,v)，其中第一个元素来自 nums1，第二个元素来自 nums2 。 
//
// 请找到和最小的 k 个数对 (u1,v1), (u2,v2) ... (uk,vk) 。 
//
// 
//
// 示例 1: 
//
// 
//输入: nums1 = [1,7,11], nums2 = [2,4,6], k = 3
//输出: [1,2],[1,4],[1,6]
//解释: 返回序列中的前 3 对数：
//     [1,2],[1,4],[1,6],[7,2],[7,4],[11,2],[7,6],[11,4],[11,6]
// 
//
// 示例 2: 
//
// 
//输入: nums1 = [1,1,2], nums2 = [1,2,3], k = 2
//输出: [1,1],[1,1]
//解释: 返回序列中的前 2 对数：
//     [1,1],[1,1],[1,2],[2,1],[1,2],[2,2],[1,3],[1,3],[2,3]
// 
//
// 示例 3: 
//
// 
//输入: nums1 = [1,2], nums2 = [3], k = 3 
//输出: [1,3],[2,3]
//解释: 也可能序列中所有的数对都被返回:[1,3],[2,3]
// 
//
// 
//
// 提示: 
//
// 
// 1 <= nums1.length, nums2.length <= 104 
// -109 <= nums1[i], nums2[i] <= 109 
// nums1, nums2 均为升序排列 
// 1 <= k <= 1000 
// 
// Related Topics 数组 堆（优先队列） 
// 👍 199 👎 0

package leetcode.editor.cn;

import java.util.*;
import java.util.stream.Collectors;

/**
 * title: 373 : 查找和最小的K对数字
 * create: 2021-08-11 19:39:25
 */
public class FindKPairsWithSmallestSums {
    public static void main(String[] args) {
        Solution solution = new FindKPairsWithSmallestSums().new Solution();
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        class Counter {
            private int a;
            private int b;

            public Counter(int a, int b) {
                this.a = a;
                this.b = b;
            }

            public int getCount() {
                return a + b;
            }
        }

        public List<List<Integer>> kSmallestPairs(int[] nums1, int[] nums2, int k) {
            Queue<Counter> queue = new PriorityQueue<>((o1, o2) -> o2.getCount() - o1.getCount());
            int counter = 0;
            int aLen = nums1.length;
            int bLen = nums2.length;
            for (int i = 0; i < Math.min(aLen, k); i++) {
                for (int j = 0; j < Math.min(bLen, k); j++) {
                    if (counter > k) {
                        queue.poll();
                    }
                    queue.offer(new Counter(nums1[i], nums2[j]));
                    counter++;
                }

            }

            List<List<Integer>> res = new LinkedList<>();
            List<Counter> counters = queue.stream().sorted(Comparator.comparingInt(Counter::getCount)).collect(Collectors.toList());
            for (int i = 0; k > 0 && i < counters.size(); i++) {
                res.add(Arrays.asList(counters.get(i).a, counters.get(i).b));
                k--;
            }
            return res;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}