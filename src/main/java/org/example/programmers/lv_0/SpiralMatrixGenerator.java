package org.example.programmers.lv_0;

public class SpiralMatrixGenerator {
    public static void main(String[] args) {
        solution(4);
    }

    public static int[][] solution(int n) {
        int[] dx = {1, 0, -1, 0}; //x축 방향
        int[] dy = {0, -1, 0, 1}; //y축 방향

        int[][] answer = new int[n][n];
        int count = 1;
        int direction = 0; //0, 1, 2, 3순서 (오른쪽, 아래, 왼쪽, 위)

        int x = 0;
        int y = 0;

        while (count <= n * n) {
            if (x >= 0 && y >= 0 && x < n && y < n && answer[y][x] == 0) {
                answer[y][x] = count++;
            } else {
                x -= dx[direction];
                y -= dy[direction];
                direction = (direction + 1) % 4;
            }

            x += dx[direction];
            y += dy[direction];
        }

        return answer;
    }
}
