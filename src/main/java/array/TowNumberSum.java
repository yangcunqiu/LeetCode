package array;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/**
 * Description: no.01
 * 给定一个整数数组 nums 和一个目标值 target，请你在该数组中找出和为目标值的那 两个 整数，并返回他们的数组下标。
 *
 * 你可以假设每种输入只会对应一个答案。但是，你不能重复利用这个数组中同样的元素。
 *
 * 示例: n
 *
 * 给定 nums = [2, 7, 11, 15], target = 9
 *
 * 因为 nums[0] + nums[1] = 2 + 7 = 9
 * 所以返回 [0, 1]
 * @author 杨存秋
 * @version 1.0
 * date: 2020/3/9 14:49
 * @since JDK 1.8
 */
@SuppressWarnings("all")
public class TowNumberSum {

    public static void main(String[] args) {
        int[] nums = {2, 7, 11, 15};
        int target = 9;

        int[] indexArrViolent = getIndexArrViolent(nums, target);
        System.out.println("暴力破解法: " + Arrays.toString(indexArrViolent));
        int[] indexArrOneHash = getIndexArrOneHash(nums, target);
        System.out.println("两遍hash: " + Arrays.toString(indexArrOneHash));
        int[] indexArrTwoHash = getIndexArrTwoHash(nums, target);
        System.out.println("一遍hash: " + Arrays.toString(indexArrTwoHash));
    }

    // 暴力破解
    private static int[] getIndexArrViolent(int[] nums, int target) {
        int[] indexArr = new int[2];

        for (int i = 0; i < nums.length; i++) {
            for (int j = i+1; j < nums.length; j++) {
                int sum = nums[i] + nums[j];
                if (sum == target){
                    indexArr[0] = i;
                    indexArr[1] = j;
                    return indexArr;
                }
            }
        }
        return null;
    }

    // 两遍哈希表
    private static int[] getIndexArrOneHash(int[] nums, int target) {
        // 创建一个map存放索引和值
        Map<Integer, Integer> indexValueMapping = new HashMap<>();

        // 遍历数组将索引和对应值填进map(第一遍hash)
        for (int i = 0; i < nums.length; i++) {
            indexValueMapping.put(nums[i], i);
        }

        // 再次遍历数组, 查找是否有符合条件的key
        for (int i = 0; i < nums.length; i++) {
            int key = target - nums[i];
            if (indexValueMapping.containsKey(key) && indexValueMapping.get(key) != i){
                return new int[] {i, indexValueMapping.get(key)};
            }
        }

        return null;
    }

    // 一遍hash
    private static int[] getIndexArrTwoHash(int[] nums, int target) {
        Map<Integer, Integer> indexValueMapping = new HashMap<>();

        for (int i = 0; i < nums.length; i++) {
            indexValueMapping.put(nums[i], i);

            int key = target - nums[i];
            if (indexValueMapping.containsKey(key) && indexValueMapping.get(key) != i){
                return new int[] {indexValueMapping.get(key), i};
    }

        }

        return null;
    }

}
