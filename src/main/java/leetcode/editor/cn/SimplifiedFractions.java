//给你一个整数 n ，请你返回所有 0 到 1 之间（不包括 0 和 1）满足分母小于等于 n 的 最简 分数 。分数可以以 任意 顺序返回。 
//
// 
//
// 示例 1： 
//
// 输入：n = 2
//输出：["1/2"]
//解释："1/2" 是唯一一个分母小于等于 2 的最简分数。 
//
// 示例 2： 
//
// 输入：n = 3
//输出：["1/2","1/3","2/3"]
// 
//
// 示例 3： 
//
// 输入：n = 4
//输出：["1/2","1/3","1/4","2/3","3/4"]
//解释："2/4" 不是最简分数，因为它可以化简为 "1/2" 。 
//
// 示例 4： 
//
// 输入：n = 1
//输出：[]
// 
//
// 
//
// 提示： 
//
// 
// 1 <= n <= 100 
// 
// Related Topics 数组 数学 字符串 👍 15 👎 0

package leetcode.editor.cn;

import java.util.ArrayList;
import java.util.List;

/**
 * title: 1447 : 最简分数
 * create: 2022-02-08 20:29:20
 */
public class SimplifiedFractions {
    public static void main(String[] args) {
        Solution solution = new SimplifiedFractions().new Solution();
        List<String> strings = solution.simplifiedFractions(10);
        System.out.println(strings);
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public List<String> simplifiedFractions(int n) {
            List<String> res = new ArrayList<>();
            if (n == 1) return res;

            // 分母
            for (int i = 2; i <= n; i++) {
                // 分子
                for (int j = 1; j < i; j++) {
                    // 求公约数
                    if (!hasCommonDivisor(i, j)) res.add(j + "/" + i);
                }
            }
            return res;
        }

        private boolean hasCommonDivisor(int i, int j) {
            for (int k = 2; k <= j; k++) {
                if (i % k == 0 && j % k == 0) return true;
            }
            return false;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}