package org.example.programmers.lv_0;

import java.util.Arrays;

public class Lv_0_DiceGame2 {
    public static void main(String[] args) {
        solution(1, 2, 3);
    }

    public static int solution(int a, int b, int c) {

        int[] dice = {a, b, c};
        Arrays.sort(dice);

        if (dice[0] == dice[2]) {
            return (int) ((a + b + c) * (Math.pow(a, 2) + Math.pow(b, 2) + Math.pow(c, 2)) * (Math.pow(a, 3) + Math.pow(b, 3) + Math.pow(c, 3)));
        }

        if (dice[0] == dice[1] || dice[1] == dice[2]) {
            return (int) ((a + b + c) * (Math.pow(a, 2) + Math.pow(b, 2) + Math.pow(c, 2)));
        }

        return a + b + c;
    }
}
