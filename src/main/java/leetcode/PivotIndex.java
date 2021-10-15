package leetcode;

import java.util.Arrays;

/**
 * @Description: 寻找中心下标
 * @Author: UncleBryan
 * @Date: 2021/8/30 20:48
 */
public class PivotIndex {
    public static int pivotIndex(int[] nums){
        int sum = Arrays.stream(nums).sum();
        int total = 0;
        for(int i=0;i<nums.length;i++){
            total +=nums[i];
            if(total == sum){
                return i;
            }
            sum -=nums[i];
        }
        return -1;
    }

    public static void main(String[] args) {
        int[] nums = {1,7,3,6,5,6};
        int index = pivotIndex(nums);
        System.out.println(index);
    }
}