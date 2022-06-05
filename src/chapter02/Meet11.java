package chapter02;

import java.util.HashMap;
import java.util.Map;

// 0和1个数相同的子数组
// 数组元素不全为正，不能应用双指针
public class Meet11 {

    public static void main(String[] args) {
        int[] nums = new int[]{0,1,0};
        System.out.println(findMaxLength(nums));
    }

    private static int findMaxLength(int[] nums) {
        Map<Integer, Integer> sumToIndex = new HashMap<>();
        sumToIndex.put(0, -1);
        int sum = 0;
        int maxLength = 0;
        for (int i = 0; i < nums.length; i++) {
            sum += nums[i] == 1 ? -1 : 1;
            if (sumToIndex.containsKey(sum)){
                maxLength=Math.max(maxLength,i-sumToIndex.get(sum));
            } else{
                sumToIndex.put(sum,i);
            }
        }
        return maxLength;
    }

}
