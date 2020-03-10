package array;

import java.util.Arrays;

/**
 * Description: no.27
 * 给你一个数组 nums 和一个值 val，你需要 原地 移除所有数值等于 val 的元素，并返回移除后数组的新长度。
 *
 * 不要使用额外的数组空间，你必须仅使用 O(1) 额外空间并 原地 修改输入数组。
 *
 * 元素的顺序可以改变。你不需要考虑数组中超出新长度后面的元素。
 *
 *  
 *
 * 示例 1:
 *
 * 给定 nums = [3,2,2,3], val = 3,
 *
 * 函数应该返回新的长度 2, 并且 nums 中的前两个元素均为 2。
 *
 * 你不需要考虑数组中超出新长度后面的元素。
 * 示例 2:
 *
 * 给定 nums = [0,1,2,2,3,0,4,2], val = 2,
 *
 * 函数应该返回新的长度 5, 并且 nums 中的前五个元素为 0, 1, 3, 0, 4。
 *
 * 注意这五个元素可为任意顺序。
 *
 * 你不需要考虑数组中超出新长度后面的元素。
 *
 * @author 杨存秋
 * @version 1.0
 * date: 2020/3/10 10:10
 * @since JDK 1.8
 */
public class RemoveElement {

    public static void main(String[] args) {
        int[] nums = {3, 2, 2, 3};
        int val = 3;
        int count = getNewArrLeftAndRight(nums, val);
        System.out.println("新数组: " + Arrays.toString(nums));
        System.out.println("新数组长度: " + count);
    }

    // 自己写的
    private static int getNewArr(int[] nums, int val) {
        if (nums == null || nums.length == 0) return 0;
        int i = 0;
        for (int j = nums.length-1; j >= i; j--) {
            if (nums[i] != val) {
                i++;
                j++;
                continue;
            }
            if (nums[i] == val && nums[j] != val){
                int temp = nums[i];
                nums[i] = nums[j];
                nums[j] = temp;
                i++;
            }
        }

        return i;
    }


    // 快慢双指针(当要删除的元素很多时)
    private static int getNewArrSpeed(int[] nums, int val) {
        int i = 0;
        for (int j = 0; j < nums.length; j++) {
            if (nums[j] != val){
                nums[i] = nums[j];
                i++;
            }
        }
        return i;
    }

    // 左右双指针(当要删除的元素很少时)
    private static int getNewArrLeftAndRight(int[] nums, int val) {
        int i = 0;
        int n = nums.length;
        while (i < n) {
            if (nums[i] == val) {
                nums[i] = nums[n - 1];
                n--;
            } else {
                i++;
            }
        }
        return n;
    }

}
