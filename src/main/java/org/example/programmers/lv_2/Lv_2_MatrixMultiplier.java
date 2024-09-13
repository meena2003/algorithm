package org.example.programmers.lv_2;

import java.util.Arrays;

public class Lv_2_MatrixMultiplier {
    public static void main(String[] args) {
        int[][] solution = solution(new int[][]{{1, 4}, {3, 2}, {4, 1}}, new int[][]{{3, 3}, {3, 3}});
        System.out.println("Arrays.toString(solution) = " + Arrays.toString(solution));
    }

    public static int[][] solution(int[][] arr1, int[][] arr2) {

        int[][] answer = new int[arr1.length][arr2.length];

        for (int i = 0; i < arr1.length; i++) {
            for (int j = 0; j < arr2[i].length; j++) {
                for (int z = 0; z < arr1[i].length; z++) {
                    answer[i][j] += arr1[i][z] * arr2[z][j];
                }
            }
        }

        return answer;
    }
}
