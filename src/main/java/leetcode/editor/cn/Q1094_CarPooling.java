//车上最初有 capacity 个空座位。车 只能 向一个方向行驶（也就是说，不允许掉头或改变方向） 
//
// 给定整数 capacity 和一个数组 trips , trip[i] = [numPassengersi, fromi, toi] 表示第 i 次旅行有
// numPassengersi 乘客，接他们和放他们的位置分别是 fromi 和 toi 。这些位置是从汽车的初始位置向东的公里数。 
//
// 当且仅当你可以在所有给定的行程中接送所有乘客时，返回 true，否则请返回 false。 
//
// 
//
// 示例 1： 
//
// 
//输入：trips = [[2,1,5],[3,3,7]], capacity = 4
//输出：false
// 
//
// 示例 2： 
//
// 
//输入：trips = [[2,1,5],[3,3,7]], capacity = 5
//输出：true
// 
//
// 
//
// 提示： 
//
// 
// 1 <= trips.length <= 1000 
// trips[i].length == 3 
// 1 <= numPassengersi <= 100 
// 0 <= fromi < toi <= 1000 
// 1 <= capacity <= 10⁵ 
// 
//
// Related Topics 数组 前缀和 排序 模拟 堆（优先队列） 👍 195 👎 0

package leetcode.editor.cn;

/**
 * title: 1094 : 拼车
 * create: 2022-08-01 21:09:14
 */
public class Q1094_CarPooling {
    public static void main(String[] args) {
        Solution solution = new Q1094_CarPooling().new Solution();
        boolean b = solution.carPooling(new int[][]{{9, 0, 1}, {3, 3, 7}}, 3);
        System.out.println(b);
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public boolean carPooling(int[][] trips, int capacity) {
            // 差分数组
            int[] diff = new int[1001];
            for (int[] trip : trips) {
                int v = trip[0];
                // 第 trip[1] 上车，车上有乘客
                int i = trip[1];
                // 第 trip[2] - 1 乘客下车
                int j = trip[2] - 1;

                diff[i] += v;
                if (j + 1 < 1001) {
                    diff[j + 1] -= v;
                }
            }

            if (diff[0] > capacity) {
                return false;
            }
            for (int i = 1; i < diff.length; i++) {
                if (diff[i] > capacity) {
                    return false;
                }
                diff[i] = diff[i - 1] + diff[i];
                if (diff[i] > capacity) {
                    return false;
                }
            }
            return true;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}