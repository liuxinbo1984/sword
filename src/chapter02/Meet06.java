package chapter02;

import common.Utils;

// 排序数组中两个数字之和 TwoSum
public class Meet06 {

    public static void main(String[] args) {
        Utils.printArr(twoSum(new int[]{1, 2, 4, 6, 10}, 8));
    }

    // 双指针法： 切分区间
    public static int[] twoSum(int[] numbers, int target) {
        int i = 0;
        int j = numbers.length - 1;
        while (i < j && numbers[i] + numbers[j] != target) {
            if (numbers[i] + numbers[j] < target) {
                i++;
            } else {
                j--;
            }
        }
        return new int[]{i, j};
    }
}
