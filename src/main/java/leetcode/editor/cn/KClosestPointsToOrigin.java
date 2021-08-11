//我们有一个由平面上的点组成的列表 points。需要从中找出 K 个距离原点 (0, 0) 最近的点。 
//
// （这里，平面上两点之间的距离是欧几里德距离。） 
//
// 你可以按任何顺序返回答案。除了点坐标的顺序之外，答案确保是唯一的。 
//
// 
//
// 示例 1： 
//
// 输入：points = [[1,3],[-2,2]], K = 1
//输出：[[-2,2]]
//解释： 
//(1, 3) 和原点之间的距离为 sqrt(10)，
//(-2, 2) 和原点之间的距离为 sqrt(8)，
//由于 sqrt(8) < sqrt(10)，(-2, 2) 离原点更近。
//我们只需要距离原点最近的 K = 1 个点，所以答案就是 [[-2,2]]。
// 
//
// 示例 2： 
//
// 输入：points = [[3,3],[5,-1],[-2,4]], K = 2
//输出：[[3,3],[-2,4]]
//（答案 [[-2,4],[3,3]] 也会被接受。）
// 
//
// 
//
// 提示： 
//
// 
// 1 <= K <= points.length <= 10000 
// -10000 < points[i][0] < 10000 
// -10000 < points[i][1] < 10000 
// 
// Related Topics 几何 数组 数学 分治 快速选择 排序 堆（优先队列） 
// 👍 268 👎 0

package leetcode.editor.cn;

import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.Queue;

/**
 * title: 973 : 最接近原点的 K 个点
 * create: 2021-08-11 14:06:37
 */
public class KClosestPointsToOrigin {
    public static void main(String[] args) {
        Solution solution = new KClosestPointsToOrigin().new Solution();
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        class Counter {
            private int count;
            private int idx;

            public Counter(int count, int idx) {
                this.count = count;
                this.idx = idx;
            }

            public int getCount() {
                return count;
            }
        }

        public int[][] kClosest(int[][] points, int k) {
            Queue<Counter> queue = new PriorityQueue<>(Comparator.comparingInt(Counter::getCount));
            for (int i = 0; i < points.length; i++) {
                int a1 = points[i][0] * points[i][0];
                int a2 = points[i][1] * points[i][1];
                queue.offer(new Counter(a1 + a2, i));
            }
            int[][] res = new int[k][2];
            for (int i = 0; i < k && !queue.isEmpty(); i++) {
                Counter poll = queue.poll();
                res[i][0] = points[poll.idx][0];
                res[i][1] = points[poll.idx][1];
            }
            return res;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}