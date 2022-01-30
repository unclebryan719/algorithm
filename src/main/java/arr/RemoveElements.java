package arr;

/**
 * LeetCode27
 * 给你一个数组 nums 和一个值 val，你需要 原地 移除所有数值等于 val 的元素，并返回移除后数组的新长度。
 *
 * 不要使用额外的数组空间，你必须仅使用 O(1) 额外空间并 原地 修改输入数组。
 *
 * 元素的顺序可以改变。你不需要考虑数组中超出新长度后面的元素。
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/remove-element
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class RemoveElements {
    public static void main(String[] args) {
        //test1
//        int[] nums = {3,2,2,3};
//        int val = 3;
        //test2
//        int[] nums = {0,1,2,2,3,0,4,2};
//        int val = 2;
        //test3
        int[] nums = null;
        int val = 2;
        int length = new RemoveElements().removeElements(nums, val);
        System.out.println(length);
    }

    public int removeElements(int[] nums, int val){
        if(nums==null || nums.length == 0){
            return 0;
        }
        int slowIdx = 0;
        /**
         * 用快指针作为循环遍历的主要条件
         * 慢指针作为返回结果
         * 只有当快指针所指向的值与给定值不相等的情况下慢指针才向后移动
         * 慢指针的索引值即为数组的长度，如果需要返回移除后的数组，则遍历前slowIdx个元素即可
         */
        for(int fastIdx=0; fastIdx < nums.length; fastIdx ++){
            if(nums[fastIdx] != val){
                nums[slowIdx] = nums[fastIdx];
                slowIdx ++;
            }
        }
        return slowIdx;
    }
}
