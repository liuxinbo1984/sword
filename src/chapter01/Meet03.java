package chapter01;

import common.Utils;

//面试题3：前n个数字二进制形式中1的个数
public class Meet03 {

    public static void main(String[] args) {
        Utils.printArr(countBits(4));
        Utils.printArr(countBits2(4));
        Utils.printArr(countBits3(4));
    }

    // i & (i-1) 整数最右边二进制消去1
    // 5=010[1] 4=0[1]00  3=0011  5&4=0100 4&3=0000
    // 循环法: O(n*k)
    public static int[] countBits(int num) {
        int[] result = new int[num + 1];
        for (int i = 0; i <= num; i++) {
            int j = i;
            while (j != 0) {
                result[i]++;
                j = j & (j - 1);
            }
        }
        return result;
    }

    // O(n)
    public static int[] countBits2(int num) {
        int[] result = new int[num + 1];
        for (int i = 1; i <= num; i++) {
            result[i] = result[i & (i-1)] + 1;
        }
        return result;
    }

    // O(n)
    public static int[] countBits3(int num) {
        int[] result = new int[num + 1];
        for (int i = 1; i <= num; i++) {
            result[i] = result[i >> 1] + (i & 1);
        }
        return result;
    }


}
