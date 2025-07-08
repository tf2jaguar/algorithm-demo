package main

import (
	"sort"
	"testing"
)

// 题目标题: 三数之和
//给你一个整数数组 nums ，判断是否存在三元组 [nums[i], nums[j], nums[k]] 满足 i != j、i != k 且 j !=
//k ，同时还满足 nums[i] + nums[j] + nums[k] == 0 。请你返回所有和为 0 且不重复的三元组。
//
// 注意：答案中不可以包含重复的三元组。
//
//
//
//
//
// 示例 1：
//
//
//输入：nums = [-1,0,1,2,-1,-4]
//输出：[[-1,-1,2],[-1,0,1]]
//解释：
//nums[0] + nums[1] + nums[2] = (-1) + 0 + 1 = 0 。
//nums[1] + nums[2] + nums[4] = 0 + 1 + (-1) = 0 。
//nums[0] + nums[3] + nums[4] = (-1) + 2 + (-1) = 0 。
//不同的三元组是 [-1,0,1] 和 [-1,-1,2] 。
//注意，输出的顺序和三元组的顺序并不重要。
//
//
// 示例 2：
//
//
//输入：nums = [0,1,1]
//输出：[]
//解释：唯一可能的三元组和不为 0 。
//
//
// 示例 3：
//
//
//输入：nums = [0,0,0]
//输出：[[0,0,0]]
//解释：唯一可能的三元组和为 0 。
//
//
//
//
// 提示：
//
//
// 3 <= nums.length <= 3000
// -10⁵ <= nums[i] <= 10⁵
//
//
// Related Topics 数组 双指针 排序 👍 7532 👎 0

func TestThreeSum(t *testing.T) {
	t.Log(threeSum([]int{-1, 0, 1, 2, -1, -4}))
}

// leetcode submit region begin(Prohibit modification and deletion)
func threeSum(nums []int) [][]int {
	sort.Ints(nums)
	res := make([][]int, 0)
	// 因为第2、第3下标是从开始下标右边寻找，所以 开始下标范围是 0 ~ len-2
	for cur := 0; cur < len(nums)-2; cur++ {
		// 排序后，窗口第一个值大于 0，则不会再有和为 0 的组合
		if nums[cur] > 0 {
			break
		}
		// 当前值不是第一个，对当前下标去重
		if cur > 0 && nums[cur] == nums[cur-1] {
			continue
		}
		start, end := cur+1, len(nums)-1
		for start < end {
			// 这里的隐含条件：和为0的组合在全部组合中较少，所以去重逻辑放在和为0里比放在外边效率更高
			addNum := nums[cur] + nums[start] + nums[end]
			if addNum == 0 {
				res = append(res, []int{nums[cur], nums[start], nums[end]})
				// start 去重
				startNum := nums[start]
				for start < end && nums[start] == startNum {
					start++
				}
				// end 去重
				endNum := nums[end]
				for start < end && nums[end] == endNum {
					end--
				}
			} else if addNum > 0 {
				end--
			} else {
				start++
			}
		}
	}

	return res
}

//leetcode submit region end(Prohibit modification and deletion)
