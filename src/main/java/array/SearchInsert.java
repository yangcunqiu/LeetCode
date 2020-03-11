package array;

/**
 * Description: no.35
 * 给定一个排序数组和一个目标值，在数组中找到目标值，并返回其索引。如果目标值不存在于数组中，返回它将会被按顺序插入的位置。
 *
 * 你可以假设数组中无重复元素。
 *
 * 示例 1:
 *
 * 输入: [1,3,5,6], 5
 * 输出: 2
 * 示例 2:
 *
 * 输入: [1,3,5,6], 2
 * 输出: 1
 * 示例 3:
 *
 * 输入: [1,3,5,6], 7
 * 输出: 4
 * 示例 4:
 *
 * 输入: [1,3,5,6], 0
 * 输出: 0
 *
 * @author 杨存秋
 * @version 1.0
 * date: 2020/3/10 18:40
 * @since JDK 1.8
 */
public class SearchInsert {

    public static void main(String[] args) {
        int[] nums = {1, 3, 5, 6};
        int target = 5;
        int index = getIndexDichotomy(nums, target);
        System.out.println(index);
    }

    // 暴力法
    private static int getIndex(int[] nums, int target) {
        if (nums == null || nums.length == 0) return 0;

        for (int i = 0; i < nums.length; i++) {
            if (nums[i] >= target){
                return i;
            }
        }

        return nums.length;
    }

    // 二分法
    private static int getIndexDichotomy(int[] nums, int target) {
        if (nums == null || nums.length == 0) return 0;

        int left = 0;
        int right = nums.length-1;

        while (left <= right){
            int mid = (right + left) / 2;
            if (target < nums[mid]) {
                right = mid - 1;
            } else if (target > nums[mid]) {
                left = mid + 1;
            } else {
                return mid;
            }
        }

        return left;

    }

}
