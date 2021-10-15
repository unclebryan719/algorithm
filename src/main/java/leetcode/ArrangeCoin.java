package leetcode;

/**
 * @Description: TODO
 * @Author: UncleBryan
 * @Date: 2021/9/13 19:48
 */
public class ArrangeCoin {
    public static void main(String[] args) {
        System.out.println(arrangeCoin(10));
        System.out.println(arrangeCoin2(10));
        System.out.println(arrangeCoin3(10));
    }

    /**
     * 暴力穷举，迭代思维
     * 时间复杂度 O(N)
     * @param n 硬币数量
     * @return
     */
    public static int arrangeCoin(int n){
        for(int i=1; i<=n; i++){
            n -= i;
            if(n <= i){
                return i;
            }
        }
        return 0;
    }

    /**
     * 假设n枚硬币放了n行，利用二分查找找到中间值；实际肯定是放不了n行的
     * 时间复杂度O(logN)
     * @param n
     * @return
     */
    public static int arrangeCoin2(int n){
        int low = 0, high = n;
        while(low <= high){
            int mid = (high-low)/2 + low;
            int cost = ((mid+1)*mid)/2;
            if(cost ==n){
                return mid;
            }else if(cost>n){
                high = mid - 1;
            }else {
                low = mid +1;
            }
        }
        return high;
    }

    /**
     * 假设n枚硬币放了n行，利用二分查找找到中间值；实际肯定是放不了n行的
     * 时间复杂度O(logN)
     * 牛顿迭代：根据二分查找算法推导：int cost = ((mid+1)*mid)/2;-->mid平方=2*cost-mid;实际结果就是求mid的平方根，利用牛顿迭代
     * @param n
     * @return
     */
    public static int arrangeCoin3(int n){
       if(n == 0){
           return 0;
       }
        return (int)sqrt(n, n);
    }

    /**
     * 牛顿迭代
     * @param x 为解
     * @param n
     * @return
     */
    private static double sqrt(double x, int n) {
        double res = (x + (2*n-x)/x)/2;
        if(res == x){
            return x;
        }
        return sqrt(res, n);
    }
}