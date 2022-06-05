package chapter02;

import java.util.HashMap;
import java.util.Map;

// 和为K的子数组
// 数组元素不全为正，不能应用双指针
public class Meet10 {

    public static void main(String[] args) {
        int[] nums = new int[]{10, 5, 9, 6};
        System.out.println(subarraySum(nums, 15));
    }

    private static int subarraySum(int[] nums, int k) {
        Map<Integer, Integer> sumToCount = new HashMap<>();
        sumToCount.put(0, 1);
        int sum = 0;
        int count = 0;
        for (int num : nums) {
            sum += num;
            count += sumToCount.getOrDefault(sum - k, 0);
            sumToCount.put(sum, count);
        }
        return count;
    }

}
