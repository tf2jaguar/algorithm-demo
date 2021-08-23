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
        solution.getLeastNumbers(new int[]{3,2,1},2);
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int[] getLeastNumbers(int[] arr, int k) {
            data = new int[k + 1];
            for (int i = 0; i < arr.length; i++) {
                push(arr[i]);
                if (size() > k) {
                    pop();
                }
            }
            int[] res = new int[k];
            int i = 0;
            while (size() > 0) {
                res[i++] = pop();
            }
            return res;
        }

        private int[] data = null;
        private int size = 0;

        /**
         * 下沉
         * <p>
         * 传入待处理的下标。通过寻找左右两个子节点中最大值，逐步下沉至 data[idx]
         */
        public void sink(int idx) {
            int tmp = data[idx];
            int j;
            // 找到左右两个子节点中较大的
            while ((j = (idx << 1) + 1) < size) {
                if (j + 1 < size && data[j] < data[j + 1]) {
                    j++;
                }

                // 如果子节点比当前节点大，将子节点替换到idx的位置
                // 否则，找到了tmp值该沉降到的位置
                if (data[j] > tmp) {
                    data[idx] = data[j];
                    idx = j;
                } else {
                    break;
                }
            }
            // 将tmp值，放到已更新好的idx位置
            data[idx] = tmp;
        }

        /**
         * 上浮
         * <p>
         * 传入待处理的下标。通过判断父节点和当前值的大小，逐步上浮至 data[idx]
         */
        public void swim(int idx) {
            int tmp = data[idx];
            int j;
            // 父节点最小为0
            while ((j = (idx - 1) >> 1) >= 0) {
                // 父节点比待上浮的值小，调整父节点值到idx位置
                // 否则，找到了上浮的最终位置
                if (data[j] < tmp) {
                    data[idx] = data[j];
                    idx = j;
                } else {
                    break;
                }
            }
            // 将tmp值，放到已更新好的idx位置
            data[idx] = tmp;
        }

        /**
         * 压入。主要是上浮操作，所以时间复杂度为 O(lgN)
         * <p>
         * （1）往堆的尾巴 data[n] 上添加新来的元素
         * （2）新来元素 data[n] 进行上浮的操作
         */
        public void push(int val) {
            data[size++] = val;
            swim(size - 1);
        }

        /**
         * 弹出。主要是下沉操作，所以时间复杂度为 O(lgN)
         * <p>
         * （1）取出 data[0] 的值作为返回值
         * （2）然后将 data[n-1] 存放至 data[0]
         * （3）将 data[0] 进行下沉操作
         */
        public int pop() {
            int tmp = data[0];
            data[0] = data[--size];
            sink(0);
            return tmp;
        }

        /**
         * 当前堆大小
         */
        public int size() {
            return size;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}