package leetcode;

import com.google.common.base.Stopwatch;

import java.util.concurrent.TimeUnit;

/**
 * @Description: 计算100以内的素数个数
 * @Author: UncleBryan
 * @Date: 2021/8/30 19:06
 */
public class SuShu {
    //
    public static long eratosthenes(int n){
        //false代表素数，默认初始值为false
        boolean[] isPrime = new boolean[n];
        int count = 0;
        for(int i=2; i<n; i++){
            if(!isPrime[i]){
                count ++;
                //标记所有合数
                for(int j=i * i; j<n; j+=i){
                    isPrime[j] = true;
                }
            }
        }
        return count;
    }

    /**
     * 暴力算法
     * @param n
     * @return
     */
    public static long bf(int n){
        long count =0;
        for(int i=2; i<=n; i++){
            count += isPrime(i) ? 1:0;
        }
        return count;
    }
    private static boolean isPrime(int x){
        for(int i=2; i<x; i++){
            if(x%i==0){
                return false;
            }
        }
        return true;
    }
    public static void main(String[] args) {
        // 创建并启动计时器
        Stopwatch stopwatch = Stopwatch.createStarted();
        System.out.println(eratosthenes(10000));
//        System.out.println(bf(10000));
        stopwatch.stop();
        // 执行时间（单位：秒）
        System.out.printf("执行时长：%d 秒. %n", stopwatch.elapsed().getSeconds()); // %n 为换行
        // 执行时间（单位：毫秒）
        System.out.printf("执行时长：%d 豪秒.", stopwatch.elapsed(TimeUnit.MILLISECONDS));

    }
}