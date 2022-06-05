package chapter01;

import java.util.HashMap;
import java.util.Map;

// 单词长度最大乘积
public class Meet05 {

    public static void main(String[] args) {
        System.out.println(maxProduct(new String[]{"abcw", "foo", "bar", "fxyz", "abcdef"}));
        System.out.println(maxProduct2(new String[]{"abcw", "foo", "bar", "fxyz", "abcdef"}));
        System.out.println(maxProduct3(new String[]{"abcw", "foo", "bar", "fxyz", "abcdef"}));
    }

    // 哈希表(数组hash)记录字符串中出现的字符
    public static int maxProduct(String[] words) {
        boolean[][] flags = new boolean[words.length][26];
        for (int i = 0; i < words.length; i++) {
            for (char c : words[i].toCharArray()) {
                flags[i][c - 'a'] = true;
            }
        }

        int result = 0;
        for (int i = 0; i < words.length; i++) {
            for (int j = i + 1; j < words.length; j++) {
                int k = 0;
                for (; k < 26; k++) {
                    if (flags[i][k] && flags[j][k]) {
                        break;
                    }
                }

                // 没有字符相同，计算乘积
                if (k == 26) {
                    int prod = words[i].length() * words[j].length();
                    result = Math.max(result, prod);
                }
            }
        }
        return result;
    }

    // 用【整数二进制位】代替hash记录出现的字符
    public static int maxProduct2(String[] words) {
        int[] flags = new int[words.length];
        for (int i = 0; i < words.length; i++) {
            for (char c : words[i].toCharArray()) {
                flags[i] |= 1 << (c - 'a');
            }
        }

        int result = 0;
        for (int i = 0; i < words.length; i++) {
            for (int j = i + 1; j < words.length; j++) {
                // 每一位都不相同
                if ((flags[i] & flags[j]) == 0) {
                    int prod = words[i].length() * words[j].length();
                    result = Math.max(result, prod);
                }
            }
        }
        return result;
    }

    // 用标准hash记录出现的字符
    public static int maxProduct3(String[] words) {
        Map<Integer, Boolean>[] flags = new HashMap[words.length];
        for (int i = 0; i < words.length; i++) {
            flags[i] = new HashMap<>();
        }

        for (int i = 0; i < words.length; i++) {
            for (char c : words[i].toCharArray()) {
                flags[i].put(c - 'a', true);
            }
        }

        int result = 0;
        for (int i = 0; i < words.length; i++) {
            for (int j = i + 1; j < words.length; j++) {

                int k = 0;
                for (; k < 26; k++) {
                    if (flags[i].get(k) !=null && flags[j].get(k) !=null && flags[i].get(k) && flags[j].get(k)) {
                        break;
                    }
                }

                // 每一位都不相同
                if (k == 26) {
                    int prod = words[i].length() * words[j].length();
                    result = Math.max(result, prod);
                }
            }
        }
        return result;
    }
}
