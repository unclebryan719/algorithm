package leetcode;

/**
 * @Description: TODO
 * @Author: UncleBryan
 * @Date: 2021/9/13 18:44
 */
public class Fib {
    public static void main(String[] args) {
        System.out.println(calculate(10));
        System.out.println(calculate2(10));
        System.out.println(iterate(10));

    }

    /**
     * 暴力递归 类似二叉树
     * 时间复杂度 2的N次方
     * @param num
     * @return
     */
    public static int calculate(int num){
        if(num == 0){
            return 0;
        }
        if(num == 1){
            return 1;
        }
        return calculate(num - 2) + calculate(num - 1);
    }
    /**
     * 去重递归 遍历二叉树左侧
     * 时间复杂度O(N) 空间复杂度O(N)
     * @param num
     * @return
     */
    public static int calculate2(int num){
        //斐波那契数列下标从0开始，初始化数组长度为n+1
        int[] arr = new int[num+1];
        return recurse(arr, num);
    }

    private static int recurse(int[] arr, int num){
        if(num == 0){
            return 0;
        }
        if(num == 1){
            return 1;
        }
        //去重操作
        if(arr[num] != 0){
            return arr[num];
        }
        return arr[num] = recurse(arr,num-1) + recurse(arr, num-2);
    }

    /**
     * 双指针算法
     * 时间复杂度O(N)
     * 空间复杂度O(1)
     * @param num
     * @return
     */
    public static int iterate(int num){
        if(num == 0){
            return 0;
        }
        if(num == 1){
            return 1;
        }
        int low = 0,high=1;
        for(int i=2;i<=num;i++){
            int sum = low+high;
            low = high;
            high = sum;
        }
        return high;
    }
}