package chapter02;

import common.Utils;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

// 排序数组中三数之和为0 ThreeSum
// 三数【不能重复】
public class Meet07 {

    public static void main(String[] args) {
        Utils.printList(ThreeSum(new int[]{-1, 0, 1, 2, -1, -4}));
    }

    // 双指针法： 切分区间
    public static List<List<Integer>> ThreeSum(int[] numbers) {
        List<List<Integer>> result = new LinkedList<>();
        if (numbers.length >= 3) {
            Arrays.sort(numbers);

            // 当前正在处理的数据索引，先固定一个数字，问题转化为两数之和
            int i = 0;
            while (i < numbers.length - 2) {
                twoSum(numbers, i, result);
                int temp = numbers[i];
                // 去重
                while (i < numbers.length && numbers[i] == temp) {
                    ++i;
                }
            }
        }
        return result;
    }

    // 双指针法： 切分区间
    public static void twoSum(int[] nums, int i, List<List<Integer>> result) {
        int j = i + 1;
        int k = nums.length - 1;
        while (j < k) {
            System.out.println(String.format("i:%d, j:%d, k:%d", i, j, k));
            if (nums[i] + nums[j] + nums[k] == 0) {
                result.add(Arrays.asList(nums[i], nums[j], nums[k]));
                int temp = nums[j];
                // 去重
                while (nums[j] == temp && j < k) {
                    ++j;
                }
            } else if (nums[i] + nums[j] + nums[k] < 0) {
                ++j;
            } else {
                --k;
            }
        }
    }
}
