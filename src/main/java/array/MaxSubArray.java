package array;

/**
 * Description: no.53
 * 给定一个整数数组 nums ，找到一个具有最大和的连续子数组（子数组最少包含一个元素），返回其最大和。
 *
 * 示例:
 *
 * 输入: [-2,1,-3,4,-1,2,1,-5,4],
 * 输出: 6
 * 解释: 连续子数组 [4,-1,2,1] 的和最大，为 6。
 * 进阶:
 *
 * 如果你已经实现复杂度为 O(n) 的解法，尝试使用更为精妙的分治法求解。
 *
 * @author 杨存秋
 * @version 1.0
 * date: 2020/3/11 10:10
 * @since JDK 1.8
 */
public class MaxSubArray {

    public static void main(String[] args) {
        int[] nums = {-2, 1, -3, 4, -1, 2, 1, -5, 4};

        int maxSumDivide = getMaxSumDivide(nums);
        System.out.println("分治法: " + maxSumDivide);

        int maxSumGreed = getMaxSumGreed(nums);
        System.out.println("贪心算法: " + maxSumGreed);

        int maxSumDP = getMaxSumDP(nums);
        System.out.println("动态规划: " + maxSumDP);

    }


    // 分治法
    /*将整个数组分成三部分 以下三个部分会构成整个数组的全集, 且没有互相重复
    * mid左边且包含mid的序列为一组
    * mid右边不包含mid的序列为一组
    * 任何包含mid以及mid右边元素的序列为一组*/
    private static int getMaxSumDivide(int[] nums) {
        return maxSubArray(nums, 0, nums.length-1);
    }

    private static int maxSubArray(int[] nums, int start, int end) {
        // 递归出口
        if (start == end) return nums[start];

        // 计算mid
        int mid = (start + end) / 2;
        // 计算左侧子序列的最大值
        int leftSubMax = maxSubArray(nums, start, mid);
        // 计算右侧子序列的最大值
        int rightSubMax = maxSubArray(nums, mid+1, end);
        // 计算横跨左右两序列的最大值

        // 计算包含左侧子序列最后一个元素的子序列最大值
        int leftMax = Integer.MIN_VALUE;
        int leftSum = 0;
        for (int i = mid; i >= start; i--) {
            leftSum += nums[i];
            leftMax = Math.max(leftSum, leftMax);
        }
        // 计算包含右侧子序列最后一个元素的子序列最大值
        int rightMax = nums[mid+1];
        int rightSum = 0;
        for (int i = mid+1; i <= end; i++) {
            rightSum += nums[i];
            rightMax = Math.max(rightSum, rightMax);
        }
        // 计算跨中心的子序列的最大值
        int crossMax = leftMax + rightMax;
        return Math.max(crossMax, Math.max(leftSubMax, rightSubMax));
    }

    // 贪心
    private static int getMaxSumGreed(int[] nums) {
        int currentSum = nums[0];
        int maxSum = nums[0];

        for (int i = 1; i < nums.length; i++) {
            currentSum = Math.max(nums[i], currentSum + nums[i]);
            maxSum = Math.max(maxSum, currentSum);
        }

        return maxSum;
    }

    // 动态规划
    private static int getMaxSumDP(int[] nums) {
        int maxSum = nums[0];

        for (int i = 1; i < nums.length; i++) {
            if (nums[i-1] > 0){
                nums[i] += nums[i-1];
            }
            maxSum = Math.max(maxSum, nums[i]);
        }

        return maxSum;
    }

}
