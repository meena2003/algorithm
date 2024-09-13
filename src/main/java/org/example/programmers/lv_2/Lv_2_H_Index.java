package org.example.programmers.lv_2;

import java.util.Arrays;

public class Lv_2_H_Index {
    public static void main(String[] args) {
        int solution = solution(new int[]{1, 11, 111, 1111});
        System.out.println("solution = " + solution);
    }

    public static int solution(int[] citations) {
        Arrays.sort(citations);

        int answer = 0;
        int idx = 0;

        for (int i = citations.length - 1, n = 1; i >= 0; i--, n++) {
            idx = citations[i];

            if (idx == n) {
                answer = idx;
                break;
            } else if (idx > n) {
                answer = Math.max(idx, n);
            } else {
                answer = n;
            }

        }

        return answer;
    }
}
