package arr;

/**
 * 给你一个按 非递减顺序 排序的整数数组 nums，返回 每个数字的平方 组成的新数组，要求也按 非递减顺序 排序。
 *
 *  
 *
 * 示例 1：
 *
 * 输入：nums = [-4,-1,0,3,10]
 * 输出：[0,1,9,16,100]
 * 解释：平方后，数组变为 [16,1,0,9,100]
 * 排序后，数组变为 [0,1,9,16,100]
 * 示例 2：
 *
 * 输入：nums = [-7,-3,2,3,11]
 * 输出：[4,9,9,49,121]
 *  
 *
 * 提示：
 *
 * 1 <= nums.length <= 104
 * -104 <= nums[i] <= 104
 * nums 已按 非递减顺序 排序
 *  
 *
 * 进阶：
 *
 * 请你设计时间复杂度为 O(n) 的算法解决本问题
 *
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/squares-of-a-sorted-array
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class SortedSquares {

    /**
     * 题目中已说明是按递增顺序排序的有序数组
     * @param nums
     * @return
     */
    public int[] sortedSquares(int[] nums) {
        // 将数组中第一个元素的平方赋值给第一个元素
        nums[0] = nums[0] * nums[0];
        int pos = nums.length - 1;
        while (pos > 0){
            // 计算当前位置的平方并与第一个元素的平方进行比较
            int squares = nums[pos] * nums[pos];
            // 如果第一个元素的平方大于当前位置的平方，彼此交换
            if(nums[0] > squares){
                nums[pos] = nums[0];
                nums[0] = squares;
            }else{
                // 无需交换，直接计算当前位置的平方并将平方赋值数组当前位置
                nums[pos] = squares;
            }
            // 向前移动指针
            pos --;
        }
        return nums;
    }
}
