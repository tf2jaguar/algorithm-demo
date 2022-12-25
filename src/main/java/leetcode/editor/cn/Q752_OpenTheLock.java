//你有一个带有四个圆形拨轮的转盘锁。每个拨轮都有10个数字： '0', '1', '2', '3', '4', '5', '6', '7', '8', '9
//' 。每个拨轮可以自由旋转：例如把 '9' 变为 '0'，'0' 变为 '9' 。每次旋转都只能旋转一个拨轮的一位数字。 
//
// 锁的初始数字为 '0000' ，一个代表四个拨轮的数字的字符串。 
//
// 列表 deadends 包含了一组死亡数字，一旦拨轮的数字和列表里的任何一个元素相同，这个锁将会被永久锁定，无法再被旋转。 
//
// 字符串 target 代表可以解锁的数字，你需要给出解锁需要的最小旋转次数，如果无论如何不能解锁，返回 -1 。 
//
// 
//
// 示例 1: 
//
// 
//输入：deadends = ["0201","0101","0102","1212","2002"], target = "0202"
//输出：6
//解释：
//可能的移动序列为 "0000" -> "1000" -> "1100" -> "1200" -> "1201" -> "1202" -> "0202"。
//注意 "0000" -> "0001" -> "0002" -> "0102" -> "0202" 这样的序列是不能解锁的，
//因为当拨动到 "0102" 时这个锁就会被锁定。
// 
//
// 示例 2: 
//
// 
//输入: deadends = ["8888"], target = "0009"
//输出：1
//解释：把最后一位反向旋转一次即可 "0000" -> "0009"。
// 
//
// 示例 3: 
//
// 
//输入: deadends = ["8887","8889","8878","8898","8788","8988","7888","9888"], 
//target = "8888"
//输出：-1
//解释：无法旋转到目标数字且不被锁定。
// 
//
// 
//
// 提示： 
//
// 
// 1 <= deadends.length <= 500 
// deadends[i].length == 4 
// target.length == 4 
// target 不在 deadends 之中 
// target 和 deadends[i] 仅由若干位数字组成 
// 
//
// Related Topics 广度优先搜索 数组 哈希表 字符串 👍 577 👎 0

package leetcode.editor.cn;

import java.util.*;

/**
 * title: 752 : 打开转盘锁
 * create: 2022-12-25 18:07:26
 */
public class Q752_OpenTheLock {
    public static void main(String[] args) {
        Solution solution = new Q752_OpenTheLock().new Solution();
        System.out.println(solution.openLock(new String[]{"0201", "0101", "0102", "1212", "2002"}, "0202"));
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int openLock(String[] deadends, String target) {
            // 记录需要跳过的 死亡密码 和 已经穷举过的密码
            Set<String> dead = new HashSet<>(Arrays.asList(deadends));
            Set<String> visited = new HashSet<>();
            Queue<String> queue = new LinkedList<>();

            // 从起点开始广度搜索
            int step = 0;
            queue.offer("0000");
            visited.add("0000");

            while (!queue.isEmpty()) {
                // 将当前队列(循环中会新加入，所以这里用当前size())中的每个密码的 每个位数向上下扩散
                int size = queue.size();
                for (int i = 0; i < size; i++) {
                    String poll = queue.poll();

                    // 判断是否为 deadends 或者 是已经处理
                    if (dead.contains(poll)) {
                        continue;
                    }
                    if (poll.equals(target)) {
                        return step;
                    }

                    // 当前密码（四位数）向上、下扩散
                    for (int j = 0; j < 4; j++) {
                        String up = plusOne(poll, j);
                        if (!visited.contains(up)) {
                            queue.offer(up);
                            visited.add(up);
                        }
                        String down = minusOne(poll, j);
                        if (!visited.contains(down)) {
                            queue.offer(down);
                            visited.add(down);
                        }
                    }
                }
                step++;
            }
            return -1;
        }

        // 将 s[i] 向下拨动一次
        private String minusOne(String s, int i) {
            char[] chars = s.toCharArray();
            if (chars[i] == '0') {
                chars[i] = '9';
            } else {
                chars[i] -= 1;
            }
            return new String(chars);
        }

        // 将 s[i] 向上拨动一次
        private String plusOne(String s, int i) {
            char[] chars = s.toCharArray();
            if (chars[i] == '9') {
                chars[i] = '0';
            } else {
                chars[i] += 1;
            }
            return new String(chars);
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}