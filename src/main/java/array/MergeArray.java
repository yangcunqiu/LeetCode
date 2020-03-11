package array;

import java.util.Arrays;

/**
 * Description: no.88
 * 给你两个有序整数数组 nums1 和 nums2，请你将 nums2 合并到 nums1 中，使 num1 成为一个有序数组。
 *
 *  
 *
 * 说明:
 *
 * 初始化 nums1 和 nums2 的元素数量分别为 m 和 n 。
 * 你可以假设 nums1 有足够的空间（空间大小大于或等于 m + n）来保存 nums2 中的元素。
 *  
 *
 * 示例:
 *
 * 输入:
 * nums1 = [1,2,3,0,0,0], m = 3
 * nums2 = [2,5,6],       n = 3
 *
 * 输出: [1,2,2,3,5,6]
 *
 * @author 杨存秋
 * @version 1.0
 * date: 2020/3/11 15:04
 * @since JDK 1.8
 */
public class MergeArray {

    public static void main(String[] args){
        int[] numsMerge = {1, 2, 3, 0, 0, 0};
        int[] numsDoublePointerStartToEnd = {1, 2, 3, 0, 0, 0};
        int[] numsDoublePointerEndToStart = {1, 2, 3, 0, 0, 0};
        int m = 3;
        int[] nums2 = {2, 5, 6};
        int n = 3;
        int[] mergeArr = merge(numsMerge, m, nums2, n);
        System.out.println("mergeArr: " + Arrays.toString(mergeArr));
        int[] doublePointerStartToEndArr = doublePointerStartToEnd(numsDoublePointerStartToEnd, m, nums2, n);
        System.out.println("doublePointerStartToEndArr: " + Arrays.toString(doublePointerStartToEndArr));
        int[] doublePointerEndToStartArr = doublePointerEndToStart(numsDoublePointerEndToStart, m, nums2, n);
        System.out.println("doublePointerEndToStartArr: " + Arrays.toString(doublePointerEndToStartArr));
    }

    private static int[] merge(int[] nums1, int m, int[] nums2, int n){
        System.arraycopy(nums2, 0, nums1, m, n);
        Arrays.sort(nums1);
        return nums1;
    }

    // 双指针 从前往后
    private static int[] doublePointerStartToEnd(int[] nums1, int m, int[] nums2, int n){
        // 复制nums1
        int[] nums1Copy = new int[m];
        System.arraycopy(nums1, 0, nums1Copy, 0, m);

        // 创建指向nums1Copy和nums2两个指针
        int p1 = 0;
        int p2 = 0;

        // 创建要输出的nums1的指针
        int p = 0;

        while ((p1 < m) && (p2 < n)){
            nums1[p++] = nums1Copy[p1] < nums2[p2] ? nums1Copy[p1++] : nums2[p2++];
        }

        if (p1 < m)
            System.arraycopy(nums1Copy, p1, nums1, p1 + p2, m + n - p1 - p2);
        if (p2 < n)
            System.arraycopy(nums2, p2, nums1, p1 + p2, m + n - p1 - p2);

        return nums1;
    }


    // 双指针 从后往前
    private static int[] doublePointerEndToStart(int[] nums1, int m, int[] nums2, int n){
        // 创建指针
        int p1 = m - 1;
        int p2 = n - 1;
        int p = m + n - 1;

        while ((p1 >= 0) && (p2 >= 0)){
            nums1[p--] = nums1[p1] > nums2[p2] ? nums1[p1--] : nums2[p2--];
        }

        System.arraycopy(nums2, 0, nums1, 0, p2 + 1);

        return nums1;
    }

}
