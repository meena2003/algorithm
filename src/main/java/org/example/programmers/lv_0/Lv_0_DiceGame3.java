package org.example.programmers.lv_0;

import java.util.Arrays;

public class Lv_0_DiceGame3 {
    public static void main(String[] args) {
        solution(4,1,4,4);
    }

    public static int solution(int a, int b, int c, int d) {

            int[] dics = new int[]{a, b, c, d};
            Arrays.sort(dics);

            // 모든 주사위가 동일한 숫자가 나온 경우
            if (dics[0] == dics[3]) {
                return dics[0] * 1111;
            }

            // 세 주사위에서 나온 숫자와 하나의 다른 숫자가 나온 경우
            if (dics[0] == dics[2] || dics[1] == dics[3]) {
                int p = dics[1]; // 세 개가 모두 같은 값
                int q = dics[3]; // 하나가 다른 값

                if (dics[0] == dics[2]) {
                    q = dics[3];
                } else {
                    q = dics[0];
                }

                return (int) Math.pow((10 * p + q), 2);
            }

            // 주사위 두 개씩 동일한 경우
            if (dics[0] == dics[1] && dics[2] == dics[3]) {
                return (dics[0] + dics[2]) * Math.abs(dics[0] - dics[2]);
            }

            // 주사위 두 개가 동일하고, 나머지가 다른 경우 (q + r)
            if (dics[0] == dics[1] && dics[2] != dics[3]) {
                return dics[2] * dics[3];
            } else if (dics[2] == dics[3] && dics[0] != dics[1]) {
                return dics[0] * dics[1];
            } else if (dics[0] == dics[3] && dics[1] != dics[2]) {
                return dics[1] * dics[2];
            }

            return dics[0];
    }
}
