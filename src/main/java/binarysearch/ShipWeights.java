package binarysearch;

/**
 * @Description: 传送带上的第i个包裹的重量为weights[i]。
 * 每一天都会按给出重量的顺序往传送带上装载包裹。
 * 我们装载的重量不会超过船的最大运载重量。
 * 返回能在D天内将传送带上的所有包裹送达的船的最低运载能力。
 * 输入：weights = [1,2,3,4,5,6,7,8,9,10], D = 5
 * 输出：15
 * @Author: UncleBryan
 * @Date: 2021/8/10 14:04
 */
public class ShipWeights {
    public static void main(String[] args) {
        int[] weights = {1,2,3,4,5,6,7,8,9,10};
        int D = 5;
        int i = new ShipWeights().shipWithinDays(weights, D);
        System.out.println(i);
    }
    // 寻找左侧边界的二分查找
    int shipWithinDays(int[] weights, int D) {
        // 载重可能的最小值
        int left = getMax(weights);
        // 载重可能的最大值 + 1
        int right = getSum(weights) + 1;
        while (left < right) {
            int mid = left + (right - left) / 2;
            if (canFinish(weights, D, mid)) {
                right = mid;
            } else {
                left = mid + 1;
            }
        }
        return left;
    }

    // 如果载重为 cap，是否能在 D 天内运完货物？
    boolean canFinish(int[] w, int D, int cap) {
        int i = 0;
        for (int day = 0; day < D; day++) {
            int maxCap = cap;
            while ((maxCap -= w[i]) >= 0) {
                i++;
                if (i == w.length) {
                    return true;
                }
            }
        }
        return false;
    }

    int getMax(int[] weights) {
        int max = 0;
        for (int n : weights) {
            max = Math.max(n, max);
        }
        return max;
    }

    int getSum(int[] weights) {
        int sum = 0;
        for (int n : weights) {
            sum += n;
        }
        return sum;
    }
}