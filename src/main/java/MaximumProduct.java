package leetcode;

import java.util.Arrays;

/**
 * @Description: 三数成绩最大值
 *
 * @Author: UncleBryan
 * @Date: 2021/8/31 17:15
 */
public class MaximumProduct {
    public static void main(String[] args) {
        int[] nums = {1,-1,3,4,8,9,5,-3};
        System.out.println(maximum(nums));
        System.out.println(maximunProduct(nums));

    }

    /**
     * 首先将数组排序。
     * 如果数组中全是非负数，则排序后最大的三个数相乘即为最大乘积；如果全是非正数，则最大的三个数相乘同样也为最大乘积。
     * 如果数组中有正数有负数，则最大乘积既可能是三个最大正数的乘积，也可能是两个最小负数（即绝对值最大）与最大正数的乘积。
     * 综上，我们在给数组排序后，分别求出三个最大正数的乘积，以及两个最小负数与最大正数的乘积，二者之间的最大值即为所求答案。
     * 时间复杂度：O(NlogN)，其中 NN 为数组长度。排序需要 O(N\log N)O(NlogN) 的时间。
     * 空间复杂度：O(logN)，主要为排序的空间开销。
     *
     * @param nums
     * @return
     */
    public static int maximum(int[] nums){
        Arrays.sort(nums);
        int n = nums.length;
        return Math.max(nums[0]*nums[1]*nums[n-1],nums[n-3]*nums[n-2]*nums[n-1]);
    }

    /**
     * 线性扫描
     * 在方法一中，我们实际上只要求出数组中最大的三个数以及最小的两个数，因此我们可以不用排序，用线性扫描直接得出这五个数。
     * @param nums
     * @return
     */
    public static int maximunProduct(int[] nums){
        int min1=Integer.MAX_VALUE,min2=Integer.MAX_VALUE;
        int max1 = Integer.MIN_VALUE,max2 = Integer.MIN_VALUE,max3 = Integer.MIN_VALUE;
        for(int num : nums){
            //如果num比最小值还小，则num为最小值，min为第二小值
            if(num < min1){
                min2 = min1;
                min1 = num;
            }
            //如果num比第二小的值还小，则num为第二小的值
            else if(num < min2){
                min2 = num;
            }
            //如果num比最大值大，则num为最大值,max1为第二大，max2为第三大
            if(num > max1){
                max3 = max2;
                max2 = max1;
                max1 = num;
            }else if(num > max2){
                max3 = max2;
                max2 = num;
            }else if(num > max3){
                max3 = num;
            }
        }
        return Math.max(min1 * min2 * max1, max1 * max2 * max3);
    }
}