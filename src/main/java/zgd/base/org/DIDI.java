package zgd.base.org;

public class DIDI {
    //    在排序数组中查找元素的第一个和最后一个位置
////给定一个按照升序排列的整数数组 nums，和一个目标值 target。找出给定目标值在数组中的开始位置和结束位置。
////你的算法时间复杂度必须是 O(log n) 级别。
////如果数组中不存在目标值，返回 [-1, -1]。
////
////示例 1:
////输入: nums = [5,7,7,8,8,10], target = 8
////输出: [3,4]
    public static void main(String[] args) {
        DIDI didi = new DIDI();
        int[] test = didi.test(new int[]{5, 7, 7, 8, 8, 10}, 8);
//        int[] test = didi.test(new int[]{ 7, 7, 8, 8, 10}, 7);
//        int[] test = didi.test(new int[]{ 7, 7, 8, 8, 10}, 10);

        for (int i : test) {
            System.out.print(i + " ");
        }
    }

    public int[] test(int[] nums, int target) {
        int l = 0;
        int r = nums.length - 1;
        int t = -1;
        while (l >= 0 && r < nums.length) {
            int mid = (r + l) / 2;
            if (nums[mid] == target) {
                t = mid;
                // 这里应该继续二分，以确保  O(log n) 复杂度
                break;
            } else if (nums[mid] < target) {
                l = mid + 1;
            } else if (nums[mid] > target) {
                r = mid;
            }
        }
        l = r = t;
        while (l >= 0 && nums[l] == target) {
            l--;
        }
        while (r < nums.length && nums[r] == target) {
            r++;
        }
        return new int[]{l + 1, r - 1};
    }
}
