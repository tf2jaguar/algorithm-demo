//设计一个类似堆栈的数据结构，将元素推入堆栈，并从堆栈中弹出出现频率最高的元素。 
//
// 实现 FreqStack 类: 
//
// 
// 
// FreqStack() 构造一个空的堆栈。 
// 
// void push(int val) 将一个整数 val 压入栈顶。 
// 
// int pop() 删除并返回堆栈中出现频率最高的元素。 
// 
// 如果出现频率最高的元素不只一个，则移除并返回最接近栈顶的元素。 
// 
// 
//
// 
//
// 示例 1： 
//
// 
//输入：
//["FreqStack","push","push","push","push","push","push","pop","pop","pop",
//"pop"],
//[[],[5],[7],[5],[7],[4],[5],[],[],[],[]]
//输出：[null,null,null,null,null,null,null,5,7,5,4]
//解释：
//FreqStack = new FreqStack();
//freqStack.push (5);//堆栈为 [5]
//freqStack.push (7);//堆栈是 [5,7]
//freqStack.push (5);//堆栈是 [5,7,5]
//freqStack.push (7);//堆栈是 [5,7,5,7]
//freqStack.push (4);//堆栈是 [5,7,5,7,4]
//freqStack.push (5);//堆栈是 [5,7,5,7,4,5]
//freqStack.pop ();//返回 5 ，因为 5 出现频率最高。堆栈变成 [5,7,5,7,4]。
//freqStack.pop ();//返回 7 ，因为 5 和 7 出现频率最高，但7最接近顶部。堆栈变成 [5,7,5,4]。
//freqStack.pop ();//返回 5 ，因为 5 出现频率最高。堆栈变成 [5,7,4]。
//freqStack.pop ();//返回 4 ，因为 4, 5 和 7 出现频率最高，但 4 是最接近顶部的。堆栈变成 [5,7]。 
//
// 
//
// 提示： 
//
// 
// 0 <= val <= 10⁹ 
// push 和 pop 的操作数不大于 2 * 10⁴。 
// 输入保证在调用 pop 之前堆栈中至少有一个元素。 
// 
//
// Related Topics 栈 设计 哈希表 有序集合 👍 251 👎 0

package leetcode.editor.cn;

import java.util.HashMap;
import java.util.Stack;

/**
 * title: 895 : 最大频率栈
 * create: 2022-10-04 15:26:08
 */
public class MaximumFrequencyStack {
    public static void main(String[] args) {
        FreqStack solution = new MaximumFrequencyStack().new FreqStack();

    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class FreqStack {
        int maxFreq;
        HashMap<Integer, Integer> valToFreq;
        HashMap<Integer, Stack<Integer>> freqToVal;

        public FreqStack() {
            valToFreq = new HashMap<>();
            freqToVal = new HashMap<>();
            maxFreq = 0;
        }

        public void push(int val) {
            // 获取该 val 应该具有的频率数值，并放入对应的记录
            int valFreq = valToFreq.getOrDefault(val, 0) + 1;
            valToFreq.put(val, valFreq);

            // 将该 val 放入相应频率的栈中
            freqToVal.putIfAbsent(valFreq, new Stack<>());
            freqToVal.get(valFreq).push(val);

            // 更新当前所有数据中的 最大频率
            maxFreq = Math.max(maxFreq, valFreq);
        }

        public int pop() {
            // 取出当前最大频率的栈
            Stack<Integer> maxFreqVal = freqToVal.get(maxFreq);
            // 弹出最新进入的
            int popVal = maxFreqVal.pop();

            // 更新 val 的频率数值
            int newValFreq = valToFreq.get(popVal) - 1;
            valToFreq.put(popVal, newValFreq);

            // 如果当前栈已经空了，则最大频率 要递减
            if (maxFreqVal.isEmpty()) {
                maxFreq--;
            }
            return popVal;
        }
    }

/**
 * Your FreqStack object will be instantiated and called as such:
 * FreqStack obj = new FreqStack();
 * obj.push(val);
 * int param_2 = obj.pop();
 */
//leetcode submit region end(Prohibit modification and deletion)

}