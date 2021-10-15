package leetcode;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/**
 * @Description: 两数之和-有序数组
 * @Author: UncleBryan
 * @Date: 2021/9/6 20:39
 */
public class TwoSumSorted {
    public static void main(String[] args) {
        int[] nums = {1,2,3,4,5,6,7};
        int target = 11;
        int[] result = solution1(nums, target);
        int[] result2 = solution2(nums, target);
        System.out.println(Arrays.toString(result));
        System.out.println(Arrays.toString(result2));
    }
    public static int[] solution1(int[] nums, int target){

        for(int i=0; i<nums.length; i++){
            int low = i, high = nums.length-1;
            while (low<=high){
                int mid = (high - low)/2 + low;
                if(nums[mid] == target - nums[i]){
                    return new int[]{i, mid};
                }else if(nums[mid] < target - nums[i]){
                    low = mid + 1;
                }else{
                    high = mid - 1;
                }
            }
        }
        return new int[0];
    }
    public static int[] solution2(int[] nums, int target){

            int low = 0, high = nums.length-1;
            while (low<high){
                int sum = nums[low] + nums[high];
                if(sum == target){
                    return new int[]{low, high};
                }else if(sum < target){
                    low ++;
                }else{
                    high --;
                }
            }
        return new int[0];
    }
}