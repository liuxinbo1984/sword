package chapter01;

// 只出现一次的数字
public class Meet04 {

    public static void main(String[] args) {
        System.out.println(singleNumber(new int[]{0, 1, 0, 1, 0, 1, 100}));
        System.out.println(binary(4));
//        System.out.println(b2i("00000000000000000000000000000100"));
        System.out.println(b2i("100"));
//        int num = 4;
//        for (int i = 0; i < 32; i++) {
//            System.out.print((num & (i << 1)) + " ");
//        }
//        System.out.println();
//        for (int i = 0; i < 32; i++) {
//            System.out.print(((num >> (31-i)) & 1) + " ");
//        }
    }

    public static int singleNumber(int[] nums) {
        int[] bitSums = new int[32];
        for (int i = 0; i < nums.length; i++) {
            for (int j = 0; j < 32; j++) {
                bitSums[j] += (nums[i] >> (31 - j)) & 1;
            }
        }

        int result = 0;
        for (int i = 0; i < 32; i++) {
            System.out.println(String.format("before %d: %s", i, binary(result)));
            result = (result << 1) + bitSums[i] % 3;
            System.out.println(String.format("after %d: %s", i, binary(result)));
        }

        return result;
    }

    public static String binary(int num) {
        StringBuilder sb = new StringBuilder();
        while (num > 0) {
            sb.append(num % 2);
            num /= 2;
        }
        return sb.reverse().toString();
    }

    public static int b2i(String binary) {
        int size = binary.length();
        int result = 0;
        for (int i = 0; i < size; i++) {
            int value = Integer.valueOf(binary.charAt(i) - '0');
//            System.out.println("index:" + i + " " + value);
            result += value * (Math.pow(2, (size - 1 - i)));
        }
        return result;
    }
}
