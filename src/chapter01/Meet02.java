package chapter01;

// 二进制加法：类似十进制【进位】加法，可以处理【超长二进制】加法
public class Meet02 {

    public static void main(String[] args) {
        // 0011（3） + 0010（2） = 0101（5）
        System.out.println("0011 + 0010 = " + addBinary("0011", "0010"));
        System.out
            .println("0011110000110101011 + 0010 = " + addBinary("0011110000110101011", "0010"));
    }

    public static String addBinary(String a, String b) {
        StringBuilder result = new StringBuilder();
        int i = a.length() - 1;
        int j = b.length() - 1;
        int curry = 0;
        while (i >= 0 || j >= 0) {
            int digitA = i >= 0 ? a.charAt(i--) - '0' : 0;
            int digitB = j >= 0 ? b.charAt(j--) - '0' : 0;
            int sum = digitA + digitB + curry;

            // 记录进位
            curry = sum >= 2 ? 1 : 0;
            sum = sum >= 2 ? sum - 2 : sum;
            result.append(sum);
        }

        // 处理最后是否进位
        if (curry == 1) {
            result.append(1);
        }

        // 转为以【高位】显示
        return result.reverse().toString();
    }
}
