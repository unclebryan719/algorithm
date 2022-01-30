package binarysearch;

public class BinarySearchArr {
    public int getTargetIdx(int[] nums, int target){
        if(nums.length == 0){
            return -1;
        }
        int left = 0;
        int right = nums.length;
        while(left < right){ //左闭右开，right为最后一个元素的下一个元素
            int middle = left + ((right-left)>>1);
            if(nums[middle] == target){
                return middle;
            }else if(nums[middle] > target){
                right = middle;
            }else{
                left = middle + 1;
            }
        }
        return -1;
    }

    public int getTargetIdx2(int[] nums, int target){
        if(nums.length == 0){
            return -1;
        }
        int left = 0;
        int right = nums.length-1;
        while(left <= right){ //左闭右闭，right为最后一个元素
            int middle = left + ((right-left)>>1);
            if(nums[middle] == target){
                return middle;
            }else if(nums[middle] > target){
                right = middle-1;
            }else{
                left = middle + 1;
            }
        }
        return -1;
    }

    public static void main(String[] args) {
//        int[] nums = {-1,0,3,5,9,12};
//        int target = 9;
        int[] nums = {-1,0,3,5,9,12};
        int target = 2;
        int targetIdx = new BinarySearchArr().getTargetIdx(nums, target);
        System.out.println(targetIdx);
    }
}
