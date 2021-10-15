package leetcode;

/**
 * @Description: 求最接近指定值的平方根
 * @Author: UncleBryan
 * @Date: 2021/8/30 21:39
 */
public class SqrtX {
    /**
     * 二分法 时间复杂度O(Log(n))
     * @param x
     * @return
     */
    public static int binarySearch(int x){
        int index=-1,l=0,r=x;
        while (l<=r){
            int mid = l+(r-l)/2;
            if(mid * mid<=x){
                index = mid;
                //重置左指针
                l = mid + 1;
            }else {
                //重置右指针
                r = mid-1;
            }
        }
        return index;
    }

    /**
     * 牛顿迭代对x求平方根
     * @param i 解，即预估的平方根结果
     * @param x
     * @return
     */
    public static double newton(double i, int x){
        if(x == 0){
            return 0;
        }
        double res = (i+x/i)/2;
        if(res == i){
            return res;
        }else{
            return newton(res,x);
        }
    }
    public static void main(String[] args) {
//        System.out.println(binarySearch(24));
        System.out.println((int)newton(6,6));
    }
}