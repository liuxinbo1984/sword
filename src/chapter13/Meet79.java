package chapter13;

import common.Utils;
import java.util.LinkedList;
import java.util.List;

// 所有子集
public class Meet79 {

    public static void main(String[] args) {
        int[] nums = new int[]{1, 2};
        Utils.printList(subsets(nums));
    }

    public static List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> result = new LinkedList<>();
        if (nums.length == 0) {
            return result;
        }
        helper(nums, 0, new LinkedList<Integer>(), result);
        return result;
    }

    /**
     * 求当前遍历元素【加入】或【不加入】新集合时，得到的新子集
     */
    private static void helper(int[] nums, int index, List<Integer> subset,
        List<List<Integer>> result) {
        // 所有元素都已遍历完毕，保存新的子集
        if (index == nums.length) {
            result.add(new LinkedList<>(subset));
        } else if (index < nums.length) {
            // 当前元素【不加入】新子集，直接进入下一步
            helper(nums, index + 1, subset, result);

            // 当前元素【加入】新子集，直接进入下一步
            subset.add(nums[index]);
            helper(nums, index + 1, subset, result);
            // 返回父元素时清除已加入的元素，处理父元素下的其它情况（目前只应对【不加入】的情况）
            subset.remove(subset.size() - 1);
        } else {
            throw new RuntimeException("index should in nums range!");
        }
    }
}
