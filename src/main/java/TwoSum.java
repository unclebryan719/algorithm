package leetcode;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/**
 * @Description: 两数之和-无序数组
 * @Author: UncleBryan
 * @Date: 2021/9/6 20:39
 */
public class TwoSum {
    public static void main(String[] args) {
        int[] nums = {1,6,3,3,5,6,7};
        int target = 11;
        int[] result = twoSum(nums, target);
        System.out.println(Arrays.toString(result));
    }
    public static int[] twoSum(int[] nums, int target){
        Map<Integer,Integer> map = new HashMap<>();
        for(int i=0; i<nums.length; i++){
            if(map.containsKey(target-nums[i])){
                return new int[]{map.get(target-nums[i]),i};
            }
            map.put(nums[i], i);
        }
        return new int[0];
    }
}