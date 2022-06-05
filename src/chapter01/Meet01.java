package chapter01;

// 【不使用除法】运算实现【除法】
public class Meet01 {

    public static void main(String[] args) {
        int dividend = 37;
        int divisor = 5;
        System.out.println(dividend/divisor + " " + divide(dividend, divisor));
    }

    public static int divide(int dividend, int divisor) {
        // 如果被除数为【最小】的32位整数：2^31,除数为-1，返回最大整数
        if (dividend == 0x8000_0000 && divisor == -1) {
            return Integer.MAX_VALUE;
        }

        // 判断正负号
        int negative = 2;
        if (dividend > 0) {
            negative--;
            dividend = -dividend;
        }

        if (divisor > 0) {
            negative--;
            divisor = -divisor;
        }

        int result = divideCore(dividend, divisor);
        // 如果为负数，改变符号
        return negative == 1 ? -result : result;
    }

    private static int divideCore(int dividend, int divisor) {
        int result = 0;
        while (dividend <= divisor) {
            int value = divisor;
            int quotient = 1;

//            0xc000_0000为最小整数的一半, dividend < divisor的2倍，4倍...
            while (value >= 0xc000_0000 && dividend <= value + value) {
                // 2+4+...
                quotient += quotient;
                value += value;
            }

            result += quotient;
            dividend -= value;
        }
        return result;
    }
}
