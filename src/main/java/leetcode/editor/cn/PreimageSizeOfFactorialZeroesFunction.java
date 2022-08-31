//f(x) 是 x! 末尾是 0 的数量。回想一下 x! = 1 * 2 * 3 * ... * x，且 0! = 1 。 
//
// 
// 例如， f(3) = 0 ，因为 3! = 6 的末尾没有 0 ；而 f(11) = 2 ，因为 11!= 39916800 末端有 2 个 0 。 
// 
//
// 给定 k，找出返回能满足 f(x) = k 的非负整数 x 的数量。 
//
// 
//
// 示例 1： 
//
// 
//输入：k = 0
//输出：5
//解释：0!, 1!, 2!, 3!, 和 4! 均符合 k = 0 的条件。
// 
//
// 示例 2： 
//
// 
//输入：k = 5
//输出：0
//解释：没有匹配到这样的 x!，符合 k = 5 的条件。 
//
// 示例 3: 
//
// 
//输入: k = 3
//输出: 5
// 
//
// 
//
// 提示: 
//
// 
// 0 <= k <= 10⁹ 
// 
//
// Related Topics 数学 二分查找 👍 187 👎 0

package leetcode.editor.cn;

/**
 * title: 793 : 阶乘函数后 K 个零
 * create: 2022-08-31 10:49:47
 */
public class PreimageSizeOfFactorialZeroesFunction {
    public static void main(String[] args) {
        Solution solution = new PreimageSizeOfFactorialZeroesFunction().new Solution();
        System.out.println(solution.preimageSizeFZF(1000000000));
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        /**
         * 对于一个 n!=1×2×...×(n−1)×n 而言，其最终结果尾部包含 0 的数量取决于其被累乘 10 的次数，
         * 而 10 可通过质因数 2 和 5 相乘而来，因此假设对 n! 进行阶乘分解，最终分解出 2^p 和 5^q 的话
         * 那么最终结果尾部包含 0 的个数为 q 个（可证明 p>=q 始终满足）。
         * <p>
         * 因此原问题转化为：在非负整数中，有多少个数进行阶乘分解后，所含质因数 5 的个数恰好为 k 个
         * 使用二分法找到左右边界，相减即可得到个数
         */
        public int preimageSizeFZF(int k) {
            if (k <= 1) return 5;
            return right(k) - left(k) + 1;
        }

        int right(int x) {
            long l = 0, r = (long) 1e10;
            while (l < r) {
                long mid = l + (r - l) / 2;
                long cnt = getCnt(mid);
                if (cnt < x) {
                    l = mid + 1;
                } else if (cnt > x) {
                    r = mid;
                } else if (cnt == x) {
                    l = mid + 1;
                }
            }
            return (int) l - 1;
        }

        int left(int x) {
            long l = 0, r = (long) 1e10;
            while (l < r) {
                long mid = l + (r - l) / 2;
                long cnt = getCnt(mid);
                if (cnt < x) {
                    l = mid + 1;
                } else if (cnt > x) {
                    r = mid;
                } else if (cnt == x) {
                    r = mid;
                }
            }
            return (int) l;
        }

        long getCnt(long x) {
            long ans = 0;
            while (x != 0) {
                ans += x / 5;
                x /= 5;
            }
            return ans;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}