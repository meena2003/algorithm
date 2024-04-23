package org.example.programmers.lv_1;

/**
 * 공원 산책이란 문제와 너무 비슷하다.
 * 움직이는 좌표에 대한 배열을 만들어 놓고선 상하좌우 순서대로 해당 좌표의 값을 비교하면 된다.
 * 보안하자면, 가로, 세로 따로 배열을 만들지 말고, direction이란 이중 포문을 통해서 구현해도 좋을듯 하다.
 */
public class Lv_1_NeighborCell {
    public static void main(String[] args) {
    }

    /*
        테스트 1 〉	통과 (0.03ms, 80.3MB)
        테스트 2 〉	통과 (0.03ms, 76.6MB)
        테스트 3 〉	통과 (0.05ms, 78.4MB)
        테스트 4 〉	통과 (0.03ms, 70.9MB)
        테스트 5 〉	통과 (0.04ms, 78.6MB)
        테스트 6 〉	통과 (0.02ms, 72.4MB)
        테스트 7 〉	통과 (0.02ms, 74MB)
        테스트 8 〉	통과 (0.02ms, 78.7MB)
        테스트 9 〉	통과 (0.02ms, 73.4MB)
        테스트 10 〉	통과 (0.02ms, 85MB)
        테스트 11 〉	통과 (0.05ms, 69.8MB)
        테스트 12 〉	통과 (0.02ms, 77MB)
        테스트 13 〉	통과 (0.02ms, 73.2MB)
        테스트 14 〉	통과 (0.02ms, 73.1MB)
        테스트 15 〉	통과 (0.03ms, 70.9MB)
        테스트 16 〉	통과 (0.02ms, 72.4MB)
        테스트 17 〉	통과 (0.02ms, 76.5MB)
        테스트 18 〉	통과 (0.03ms, 74.3MB)
        테스트 19 〉	통과 (0.02ms, 88.6MB)
        테스트 20 〉	통과 (0.02ms, 81.4MB)
        테스트 21 〉	통과 (0.03ms, 73.8MB)
        테스트 22 〉	통과 (0.02ms, 73.8MB)
        테스트 23 〉	통과 (0.03ms, 79.3MB)
        테스트 24 〉	통과 (0.04ms, 73.5MB)
        테스트 25 〉	통과 (0.02ms, 78.9MB)
        테스트 26 〉	통과 (0.02ms, 75.2MB)
        테스트 27 〉	통과 (0.02ms, 74.9MB)
        테스트 28 〉	통과 (0.06ms, 80.1MB)
        테스트 29 〉	통과 (0.02ms, 75.6MB)
        테스트 30 〉	통과 (0.03ms, 80.3MB)
        테스트 31 〉	통과 (0.04ms, 80.5MB)
        테스트 32 〉	통과 (0.03ms, 73.9MB)
        테스트 33 〉	통과 (0.04ms, 66.7MB)
        테스트 34 〉	통과 (0.06ms, 73.6MB)
        테스트 35 〉	통과 (0.03ms, 74.4MB)
        테스트 36 〉	통과 (0.04ms, 89.2MB)
        테스트 37 〉	통과 (0.02ms, 79.7MB)
        테스트 38 〉	통과 (0.04ms, 78.6MB)
        테스트 39 〉	통과 (0.02ms, 75.3MB)
        테스트 40 〉	통과 (0.02ms, 77.4MB)
        테스트 41 〉	통과 (0.02ms, 73MB)
        테스트 42 〉	통과 (0.02ms, 80MB)
        테스트 43 〉	통과 (0.02ms, 77.5MB)
        테스트 44 〉	통과 (0.02ms, 73.6MB)
        테스트 45 〉	통과 (0.03ms, 69.6MB)
        테스트 46 〉	통과 (0.02ms, 76.4MB)
        테스트 47 〉	통과 (0.04ms, 77.7MB)
        테스트 48 〉	통과 (0.03ms, 74.3MB)
        테스트 49 〉	통과 (0.02ms, 75.4MB)
        테스트 50 〉	통과 (0.02ms, 79.7MB)
     */
    public static int solution(String[][] board, int h, int w) {

        int[] height = new int[]{-1, 0, 1, 0};
        int[] width = new int[]{0, -1, 0, 1};
        int count = 0;

        for (int i = 0; i < 4; i++) {
            int y = h + height[i];
            int x = w + width[i];

            if (x < 0 || y < 0 || x == board[0].length || y == board.length) {
                continue;
            } else if (board[y][x].equals(board[h][w])) {
                count++;
            }
        }

        return count;
    }
}