package org.example.etc;

import java.util.Arrays;

public class WotecamNumberAdder {
    public static void main(String[] args) {
        int[] answer = solution(12000);
        System.out.println("answer = " + Arrays.toString(answer));
    }

    public static int[] solution(int n) {
        int idx = 0;

        while (n / 10 != 0) {
            String strN = n + "";
            int half = strN.length() / 2;
            boolean isZero = false;

            while (half < strN.length() && strN.charAt(half) == '0') {
                half++;
                isZero = true;
            }

            int front = Integer.parseInt(strN.substring(0, half + 1));
            int back = Integer.parseInt(strN.substring(half));

            if (!isZero && front < back) {
                front = Integer.parseInt(strN.substring(0, half + 1));
                back = Integer.parseInt(strN.substring(half + 1));
            } else {
                front = Integer.parseInt(strN.substring(0, half));
                back = Integer.parseInt(strN.substring(half));
            }

            n = front + back;
            idx++;
        }

        return new int[]{idx, n};
    }
}
