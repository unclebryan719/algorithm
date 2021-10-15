package binarysearch;

/**
 * @Description: Koko 每小时最多吃一堆香蕉，如果吃不下的话留到下一小时再吃；
 * 如果吃完了这一堆还有胃口，也只会等到下一小时才会吃下一堆。
 * 在这个条件下，让我们确定 Koko 吃香蕉的**最小速度**（根/小时）。
 * @Author: UncleBryan
 * @Date: 2021/8/9 20:53
 */
public class EatingBanana {
    public static void main(String[] args) {
        EatingBanana eatingBanana = new EatingBanana();
        int[] piles = {3, 6 , 7 ,11};
        int speed = eatingBanana.minEatingSpeed(piles, 8);
        System.out.println(speed);
    }
    int minEatingSpeed(int[] piles, int H){
        int left = 1, right = getMax(piles) + 1;
        while (left < right){
            int mid = left + (right - left)/2 ;
            if(canFinish(piles, mid, H)){
                right = mid;
            }else{
                left = mid + 1;
            }
        }
        return left;
    }

    boolean canFinish(int[] piles, int speed, int H){
        int time = 0;
        for(int n : piles){
            time += timeOf(n, speed);
        }
        return time <= H;
    }

    int timeOf(int n, int speed){
        return (n/speed) + ((n % speed) > 0? 1 : 0);
    }

    int getMax(int[] piles){
        int max = 0;
        for(int n : piles){
            max = Math.max(n, max);
        }
        return max;
    }
}