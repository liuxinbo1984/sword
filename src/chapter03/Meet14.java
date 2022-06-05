package chapter03;

// 双指针法：字符串中的变位词
public class Meet14 {

    public static void main(String[] args) {
        System.out.println(checkInclusion("ac", "dgcaf"));
    }

    public static boolean checkInclusion(String s1, String s2) {
        if (s2.length() < s1.length()) {
            return false;
        }

        int[] counts = new int[26];
        for (int i = 0; i < s1.length(); i++) {
            counts[s1.charAt(i) - 'a']++;
            counts[s2.charAt(i) - 'a']--;
        }

        if (areAllZero(counts)) {
            return true;
        }

        for (int i = s1.length(); i < s2.length(); i++) {
            counts[s2.charAt(i) - 'a']--; //第二个指针
            counts[s2.charAt(i - s1.length()) - 'a']++; //第一个指针
            if (areAllZero(counts)) {
                return true;
            }
        }
        return false;
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
