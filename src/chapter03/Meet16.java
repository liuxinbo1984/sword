package chapter03;

// 面试题16：不含重复字符的最长子字符串
public class Meet16 {
    public static void main(String[] args) {
        // 最长不含重复字符的子串为"abc",长度为 3
        String s = "babca";
        System.out.println(lengthOfLongest(s));
        System.out.println(lengthOfLongest2(s));
    }

    // arr[...j...i...]
    public static int lengthOfLongest(String s) {
        if (s.length() == 0) {
            return 0;
        }

        int[] counts = new int[256];
        int i = 0;
        int j = -1;
        int longest = 1;
        for (; i < s.length(); i++) {
            counts[s.charAt(i)]++;
            while (hasGreaterThan1(counts)) {
                ++j;
                counts[s.charAt(j)]--;
            }
            longest = Math.max(i - j, longest);
        }

        return longest;
    }

    // arr[...j...i...], 避免【多次遍历】的解法
    public static int lengthOfLongest2(String s) {
        if (s.length() == 0) {
            return 0;
        }

        int[] counts = new int[256];
        int i = 0;
        int j = -1;
        int longest = 1;
        int countDup = 0;
        for (; i < s.length(); i++) {
            counts[s.charAt(i)]++;
            if (counts[s.charAt(i)] == 2) {
                countDup++;
            }
            while (countDup > 0) {
                ++j;
                counts[s.charAt(j)]--;
                if (counts[s.charAt(j)] == 1) {
                    countDup--;
                }
            }
            longest = Math.max(i - j, longest);
        }

        return longest;
    }

    // 计数检查有重复
    private static boolean hasGreaterThan1(int[] counts) {
        for (int i = 0; i < counts.length; i++) {
            if (counts[i] > 1) {
                return true;
            }
        }
        return false;
    }
}
