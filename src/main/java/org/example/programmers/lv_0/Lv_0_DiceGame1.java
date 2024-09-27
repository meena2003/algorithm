package org.example.programmers.lv_0;

public class Lv_0_DiceGame1 {
    public static void main(String[] args) {
        solution(1, 2);
    }

    public static int solution(int a, int b) {

        int oddCount = 0;
        int[] nums = {a, b};

        for (int n : nums) {
            if (isOdd(n)) {
                oddCount++;
            }
        }

        if (oddCount == 2) {
            return (a * a) + (b * b);
        }

        if (oddCount == 1) {
            return 2 * (a + b);
        }

        return Math.abs(a - b);
    }

    private static boolean isOdd(int n) {
        return n % 2 != 0;
    }
}
