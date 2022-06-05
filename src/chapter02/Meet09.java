package chapter02;

// 乘积小于K的子数组(连续子数组)
public class Meet09 {

    public static void main(String[] args) {
        int[] nums = new int[]{10, 5, 2, 6};
        System.out.println(minSubArrayLen(nums, 100));
    }

    private static int minSubArrayLen(int[] nums, int k) {
        int left = 0;
        long product = 1;
        int count = 0;
        for (int right = 0; right < nums.length; right++) {
            product *= nums[right];
            while (left <= right && product >= k) {
                product /= nums[left++];
            }
            System.out.println(String.format("left: %d, right: %d", left, right));
            count += right >= left ? right - left + 1 : 0;
        }
        return count;
    }

}
