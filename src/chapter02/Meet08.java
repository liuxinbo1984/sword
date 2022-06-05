package chapter02;

import common.Utils;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

// 和大于或等于K的最短子数组(连续子数组)
public class Meet08 {

    public static void main(String[] args) {
        int[] nums = new int[]{5,1,4,3};
        System.out.println(minSubArrayLen(7, nums));
    }

    public static int minSubArrayLen(int k, int[] nums) {
        int left = 0;
        int sum = 0;
        int minLength = Integer.MAX_VALUE; // (Ox7fff_ffff)
        for (int right = 0; right < nums.length; right++) {
            sum += nums[right];
            while (left <= right && sum >= k) {
                minLength = Math.min(minLength, right - left + 1);
                sum -=nums[left++];
            }
        }
        return minLength == Integer.MAX_VALUE ? 0 : minLength;
    }

}
