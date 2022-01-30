package arr;

/**
 * 209. 长度最小的子数组
 * 给定一个含有 n 个正整数的数组和一个正整数 target 。
 *
 * 找出该数组中满足其和 ≥ target 的长度最小的 连续子数组 [numsl, numsl+1, ..., numsr-1, numsr] ，并返回其长度。如果不存在符合条件的子数组，返回 0 。
 *
 *  
 *
 * 示例 1：
 *
 * 输入：target = 7, nums = [2,3,1,2,4,3]
 * 输出：2
 * 解释：子数组 [4,3] 是该条件下的长度最小的子数组。
 * 示例 2：
 *
 * 输入：target = 4, nums = [1,4,4]
 * 输出：1
 * 示例 3：
 *
 * 输入：target = 11, nums = [1,1,1,1,1,1,1,1]
 * 输出：0
 *  
 *
 * 提示：
 *
 * 1 <= target <= 109
 * 1 <= nums.length <= 105
 * 1 <= nums[i] <= 105
 *  
 *
 * 进阶：
 *
 * 如果你已经实现 O(n) 时间复杂度的解法, 请尝试设计一个 O(n log(n)) 时间复杂度的解法。
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/minimum-size-subarray-sum
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class MinimumSizeSubarraySum {
    /**
     * 基于滑动窗口解题
     * 思路：
     * 1.遍历数组并累加求和
     * 2.当sum大于等target时
     * 3.计算此时的子数组长度（right-left+1）并与此前result比较，求出相对小的子数组长度作为此时长度最小的子数组长度
     * 4.同时与慢指针所在的值进行减法操作，并将慢指针向前移动（因为此时子数组的和有可能远大于target，所以需要慢指针向前移动依次减去慢指针所在位置的值，当sum>=target条件不满足时，才能得出最小的子数组长度）
     * 5.循环3与4步骤，直到不满足sum>=target为止
     * @param nums
     * @param target
     * @return
     */
    public int getSubarraySum(int[] nums, int target){
        int left = 0;
        int sum = 0;
        int result = Integer.MAX_VALUE;
        for(int right = 0; right < nums.length; right ++){
            sum += nums[right];
            while (sum >= target){
                result = Math.min(result, right - left + 1);
                sum -= nums[left ++];
            }
        }
        return result == Integer.MAX_VALUE ? 0 : result;
    }
}
