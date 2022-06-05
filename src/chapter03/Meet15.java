package chapter03;

import common.Utils;
import java.util.LinkedList;
import java.util.List;

// 双指针法：字符串中所有的变位词
public class Meet15 {

    public static void main(String[] args) {
        Utils.printSingleList(findAngrams("cbadabacg", "abc"));
    }

    private static List<Integer> findAngrams(String s1, String s2) {
        List<Integer> indices = new LinkedList<>();
        if (s1.length() < s2.length()) {
            return indices;
        }

        int[] counts = new int[26];
        int i = 0;
        for (; i < s2.length(); i++) {
            counts[s2.charAt(i) - 'a']++;
            counts[s1.charAt(i) - 'a']--;
        }

        if (areAllZero(counts)) {
            indices.add(0);
        }

        for (; i < s1.length(); i++) {
            counts[s1.charAt(i) - 'a']--; //第二个指针
            counts[s1.charAt(i - s2.length()) - 'a']++; //第一个指针
            if (areAllZero(counts)) {
                indices.add(i - s2.length() + 1);
            }
        }
        return indices;
    }

    private static boolean areAllZero(int[] counts) {
        for (int count : counts) {
            if (count != 0) {
                return false;
            }
        }
        return true;
    }
}
