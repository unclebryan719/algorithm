package arr;

import java.util.Arrays;
import java.util.PrimitiveIterator;

/**
 * 给定一个数组 nums，编写一个函数将所有 0 移动到数组的末尾，同时保持非零元素的相对顺序。
 * 输入: [0,1,0,3,12]
 * 输出: [1,3,12,0,0]
 */
public class MoveZeroes {
    public int[] moveZeroes(int[] nums){
        int slowIdx = 0;
        for(int fastIdx = 0; fastIdx < nums.length; fastIdx ++ ){
            if(nums[slowIdx] == 0 && nums[fastIdx] != nums[slowIdx]){
                nums[slowIdx] = nums[fastIdx];
                nums[fastIdx] = 0;
                slowIdx ++;
            }
        }
        return nums;
    }
}
