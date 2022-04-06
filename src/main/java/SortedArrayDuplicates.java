package leetcode;

/**
 * @Description: 删除排序数组中的重复项 快慢指针
 * @Author: UncleBryan
 * @Date: 2021/8/30 20:13
 */
public class SortedArrayDuplicates {
    public static int getNoDuplicatesCount(int[] nums){
        if(nums==null || nums.length == 0){
            return 0;
        }
        int i = 0;
        for(int j=1; j<nums.length; j++){
            if(nums[j] != nums[i]){
                i++;
                nums[i] = nums[j];
            }
        }
        return i+1;
    }

    public static void main(String[] args) {
        int nums[] = {0,1,2,2,3,3,4};
        int count = getNoDuplicatesCount(nums);
        System.out.println(count);
    }
}