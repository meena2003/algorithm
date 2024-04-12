package org.example.programmers;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

/**
 * 하루종일 고민하다가 겨우 풀었다...
 * 일단 처음 고민의 방향성은 두 가지였다.
 * 먼저, 고전적으로 2차원 배열을 만든 다음 하나씩 이동하면서 경로를 검증하는 것.
 * 단순하지만, 런타임 아웃이 생기지 않을까 걱정이 됐다.
 *
 * 두 번째로 생각한 방법은, 일단 장애물의 좌표만 알고 있으면 특정 법칙으로 검증할 수 있지 않을까 생각했다.
 * 그렇게 시작했는데... 3~16번 테스트 케이스가 통과가 안되서 너무 괴로웠다.
 * 여러 반례들을 다 통과하는데 말이다.
 *
 * 그러다 장애물 검증 로직에 이상이 있음을 깨달았다.
 * 장애물이 이동 경로상 내부에 있는지 확인이 필요했는데, 그 부분이 부족했다.
 *
 * 생각해보면, 내가 너무 복잡하게 생각한것 같다 ㅠㅠ
 */
public class Lv_1_ParkWalk {
    public static void main(String[] args) {
        System.out.println(Arrays.toString(solution(new String[]{"OOO", "OSO", "OXO", "OOO"}, new String[]{"W 2", "N 1"})));
    }

    /*
        테스트 1 〉	통과 (0.08ms, 72.9MB)
        테스트 2 〉	통과 (0.11ms, 78.2MB)
        테스트 3 〉	통과 (0.19ms, 74.5MB)
        테스트 4 〉	통과 (0.33ms, 75MB)
        테스트 5 〉	통과 (0.58ms, 85.6MB)
        테스트 6 〉	통과 (0.90ms, 71.6MB)
        테스트 7 〉	통과 (0.74ms, 84.1MB)
        테스트 8 〉	통과 (0.78ms, 67.7MB)
        테스트 9 〉	통과 (1.00ms, 71.3MB)
        테스트 10 〉	통과 (1.11ms, 70.6MB)
        테스트 11 〉	통과 (1.02ms, 74.1MB)
        테스트 12 〉	통과 (1.17ms, 72.6MB)
        테스트 13 〉	통과 (0.96ms, 74.6MB)
        테스트 14 〉	통과 (0.92ms, 76.9MB)
        테스트 15 〉	통과 (0.89ms, 82.8MB)
        테스트 16 〉	통과 (0.32ms, 78.6MB)
        테스트 17 〉	통과 (0.28ms, 72.9MB)
        테스트 18 〉	통과 (0.27ms, 74.7MB)
        테스트 19 〉	통과 (0.39ms, 79.6MB)
        테스트 20 〉	통과 (0.30ms, 78.2MB)
     */
    public static int[] solution(String[] park, String[] routes) {

        // 초기화
        int height = park.length;
        int width = park[0].length();
        int[] position = new int[2];
        List<int[]> obstacles = new ArrayList<>();

        // 장애물 위치를 배열로 정리해둔다.
        for (int i = 0; i < height; i++) {
            for (int j = 0; j < width; j++) {
                if ('X' == park[i].charAt(j)) {
                    obstacles.add(new int[]{i, j});
                    continue;
                }

                if ('S' == park[i].charAt(j)) {
                    position[0] = i;
                    position[1] = j;
                }
            }
        }

        // routes 반복문을 돌면서 이동한다.
        int[] tmp = new int[]{position[0], position[1]};
        for (String order : routes) {
            char direction = order.charAt(0);
            int distance = Integer.parseInt(order.split(" ")[1]);

            if (direction == 'E') {
                tmp[1] = tmp[1] + distance;
            }
            if (direction == 'W') {
                tmp[1] = tmp[1] - distance;
            }
            if (direction == 'S') {
                tmp[0] = tmp[0] + distance;
            }
            if (direction == 'N') {
                tmp[0] = tmp[0] - distance;
            }

            if (tmp[1] < width && tmp[1] >= 0 && tmp[0] < height && tmp[0] >= 0 && isNotObstacle(obstacles, position, direction, distance)) {
                position[0] = tmp[0];
                position[1] = tmp[1];
                continue;
            }

            tmp[0] = position[0];
            tmp[1] = position[1];
        }

        return position;
    }

    // 해당 경로에 장애물이 있는지 확인한다.
    private static boolean isNotObstacle(List<int[]> obstacles, int[] position, char direction, int distance) {

        switch (direction) {
            case 'E':
                for (int[] obstacle : obstacles) {
                    if (position[0] == obstacle[0] && position[1] + distance >= obstacle[1] && position[1] < obstacle[1]) {
                        return false;
                    }
                }
                return true;

            case 'W':
                for (int[] obstacle : obstacles) {
                    if (position[0] == obstacle[0] && position[1] - distance <= obstacle[1] && position[1] > obstacle[1]) {
                        return false;
                    }
                }
                return true;

            case 'S':
                for (int[] obstacle : obstacles) {
                    if (position[1] == obstacle[1] && position[0] + distance >= obstacle[0] && position[0] < obstacle[0]) {
                        return false;
                    }
                }
                return true;

            case 'N':
                for (int[] obstacle : obstacles) {
                    if (position[1] == obstacle[1] && position[0] - distance <= obstacle[0] && position[0] > obstacle[0]) {
                        return false;
                    }
                }
                return true;

            default :
                return false;
        }
    }

    /**
     * 와... 한 칸씩 X가 있는지 확인하는 데, 다음 좌표값을 구하는데 switch 문이 아니라 HashMap을 이용한 것이 굉장히 좋아 보인다.
     */
    public int[] solution2(String[] park, String[] routes) {
        int m = park.length;
        int n = park[0].length();
        int curX = 0;
        int curY = 0;
        char[][] grid = new char[m][n];

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                grid[i][j] = park[i].charAt(j);
                if (grid[i][j] == 'S') {
                    curX = i;
                    curY = j;
                }
            }
        }

        int[] dx = { -1, 1, 0, 0 };
        int[] dy = { 0, 0, -1, 1 };
        HashMap<Character, Integer> map = new HashMap<>();
        map.put('N', 0);
        map.put('S', 1);
        map.put('W', 2);
        map.put('E', 3);

        for (String command : routes) {

            char op = command.charAt(0);
            int move = command.charAt(2) - '0';

            int nextX = curX;
            int nextY = curY;
            boolean isOK = true;
            for (int i = 0; i < move; i++) {
                nextX += dx[map.get(op)];
                nextY += dy[map.get(op)];

                if (nextX < 0 || nextY < 0 || nextX >= m || nextY >= n || grid[nextX][nextY] == 'X') {
                    isOK = false;
                    break;
                }
            }

            if (isOK) {
                curX = nextX;
                curY = nextY;
            }
        }

        return new int[] { curX, curY };
    }
}
