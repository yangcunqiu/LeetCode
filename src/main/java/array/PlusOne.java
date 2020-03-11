package array;

import java.util.Arrays;


/**
 * Description: no.66
 * 给定一个由整数组成的非空数组所表示的非负整数，在该数的基础上加一。
 *
 * 最高位数字存放在数组的首位， 数组中每个元素只存储单个数字。
 *
 * 你可以假设除了整数 0 之外，这个整数不会以零开头。
 *
 * 示例 1:
 *
 * 输入: [1,2,3]
 * 输出: [1,2,4]
 * 解释: 输入数组表示数字 123。
 * 示例 2:
 *
 * 输入: [4,3,2,1]
 * 输出: [4,3,2,2]
 * 解释: 输入数组表示数字 4321。
 *
 * @author 杨存秋
 * @version 1.0
 * date: 2020/3/11 13:41
 * @since JDK 1.8
 */
public class PlusOne {

    public static void main(String[] args) {

        int[] nums = {1, 2, 3};
        int[] plusOne = getPlusOne(nums);
        System.out.println(Arrays.toString(plusOne));
    }

    private static int[] getPlusOne(int[] nums) {
        for (int i = nums.length - 1; i >= 0; i--) {
            nums[i] += 1;
            nums[i] = nums[i] % 10;
            if (nums[i] != 0) return nums;
        }
        int[] ints = new int[nums.length + 1];
        ints[0] = 1;
        return ints;
    }

}
