//输入整数数组 arr ，找出其中最小的 k 个数。例如，输入4、5、1、6、2、7、3、8这8个数字，则最小的4个数字是1、2、3、4。 
//
// 
//
// 示例 1： 
//
// 输入：arr = [3,2,1], k = 2
//输出：[1,2] 或者 [2,1]
// 
//
// 示例 2： 
//
// 输入：arr = [0,1,2,1], k = 1
//输出：[0] 
//
// 
//
// 限制： 
//
// 
// 0 <= k <= arr.length <= 10000 
// 0 <= arr[i] <= 10000 
// 
// Related Topics 数组 分治 快速选择 排序 堆（优先队列） 
// 👍 281 👎 0

package leetcode.editor.cn;

import com.example.algorithmdemo.Heap;

/**
 * title: 剑指 Offer 40 : 最小的k个数
 * create: 2021-08-10 17:54:54
 */
public class ZuiXiaoDeKgeShuLcof {
    public static void main(String[] args) {
        Solution solution = new ZuiXiaoDeKgeShuLcof().new Solution();
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int[] getLeastNumbers(int[] arr, int k) {
            Heap heap = new Heap(new int[k]);
            for (int i = 0; i < arr.length; i++) {
                heap.push(arr[i]);
                if (i > k) {
                    heap.pop();
                }
            }
            int[] res = new int[k];
            int i = 0;
            while (heap.size() > 0) {
                res[i++] = heap.pop();
            }
            return res;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}