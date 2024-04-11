package org.example.programmers;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * 처음 이 문제를 보고 각 파일의 상단, 왼쪽, 하단, 오른쪽의 최대값, 최소값을 구하면 되는 것을 깨달았다.
 * 그리 어렵지 않은 문제였다.
 * 하지만 각각의 좌표의 최대값과 최소값을 구하려고 하는데, 처음 초기화를 하는 데 어려움이 있었다.
 * 각 좌표의 초기값을 0으로 설정하니 아예 첫 조건부터 맞지 않게 된 것이다.
 *
 * 이를 해결하고자 List를 만들어 모든 좌표값을 넣고 마지막에 Collections.max(), min() 메소드를 사용했다.
 * 정답이었지만 마지막에 원소들을 한 번 더 정렬하기 때문에 성능이 좋지 못하다.
 *
 * 다른 사람 풀이를 보니 Integer.MAX_VALUE, Integer.MIN_VALUE 를 통해 초기화를 진행한다.
 * 그리고 Math.min(), Math.max() 메소드로 바로바로 최대값, 최소값을 비교하고 소거하기 때문에 성능에 있어 훨씬 유리하다.
 */
public class Lv_1_ComputerWallpaperClean {
    public static void main(String[] args) {
        solution(new String[]{".##...##.", "#..#.#..#", "#...#...#", ".#.....#.", "..#...#..", "...#.#...", "....#...."});
    }

    /*
        테스트 1 〉	통과 (1.39ms, 73.2MB)
        테스트 2 〉	통과 (0.57ms, 74.8MB)
        테스트 3 〉	통과 (0.08ms, 71.6MB)
        테스트 4 〉	통과 (1.59ms, 75.3MB)
        테스트 5 〉	통과 (2.50ms, 71.5MB)
        테스트 6 〉	통과 (1.02ms, 76.4MB)
        테스트 7 〉	통과 (4.25ms, 80.9MB)
        테스트 8 〉	통과 (22.41ms, 71.3MB)
        테스트 9 〉	통과 (25.89ms, 80.8MB)
        테스트 10 〉	통과 (13.24ms, 75.3MB)
        테스트 11 〉	통과 (2.66ms, 75.9MB)
        테스트 12 〉	통과 (4.86ms, 77.9MB)
        테스트 13 〉	통과 (1.69ms, 73.4MB)
        테스트 14 〉	통과 (1.09ms, 74.5MB)
        테스트 15 〉	통과 (1.27ms, 73.1MB)
        테스트 16 〉	통과 (1.46ms, 76.7MB)
        테스트 17 〉	통과 (1.48ms, 71.2MB)
        테스트 18 〉	통과 (5.20ms, 80MB)
        테스트 19 〉	통과 (4.52ms, 73.4MB)
        테스트 20 〉	통과 (19.50ms, 78.2MB)
        테스트 21 〉	통과 (0.16ms, 69MB)
        테스트 22 〉	통과 (0.16ms, 72.8MB)
        테스트 23 〉	통과 (0.38ms, 70.6MB)
        테스트 24 〉	통과 (0.19ms, 79.4MB)
        테스트 25 〉	통과 (4.21ms, 71.7MB)
        테스트 26 〉	통과 (13.18ms, 80.1MB)
        테스트 27 〉	통과 (1.32ms, 75.1MB)
        테스트 28 〉	통과 (3.84ms, 75.3MB)
        테스트 29 〉	통과 (3.35ms, 78MB)
        테스트 30 〉	통과 (27.92ms, 77.1MB)
        테스트 31 〉	통과 (0.23ms, 74.4MB)
     */
    public static int[] solution(String[] wallpaper) {
        int[] answer = new int[4];

        List<Integer> upIdxs = new ArrayList<>();
        List<Integer> leftIdxs = new ArrayList<>();
        List<Integer> downIdxs = new ArrayList<>();
        List<Integer> rightIdxs = new ArrayList<>();

        for (int i = 0; i < wallpaper.length; i++) {
            for (int j = 0; j < wallpaper[i].length(); j++) {

                // 해당 라인에 파일이 없을 경우 다음 줄로 패스
                if (!wallpaper[i].contains("#")) {
                    break;
                }

                char space = wallpaper[i].charAt(j);
                // 해당 공간에 파일이 없을 경우 다음 공간으로 패스
                if (space != '#') {
                    continue;
                }

                // 모든 파일의 좌표를 저장
                upIdxs.add(i);
                leftIdxs.add(j);
                downIdxs.add(i + 1);
                rightIdxs.add(j + 1);

                // 조건에 맞는 좌표만 추출
                answer[0] = Collections.min(upIdxs);
                answer[1] = Collections.min(leftIdxs);
                answer[2] = Collections.max(downIdxs);
                answer[3] = Collections.max(rightIdxs);
            }
        }

        return answer;
    }

    /*
        테스트 1 〉	통과 (0.04ms, 79.2MB)
        테스트 2 〉	통과 (0.04ms, 66.4MB)
        테스트 3 〉	통과 (0.02ms, 74MB)
        테스트 4 〉	통과 (0.03ms, 66.7MB)
        테스트 5 〉	통과 (0.04ms, 71.2MB)
        테스트 6 〉	통과 (0.05ms, 75.8MB)
        테스트 7 〉	통과 (0.08ms, 71MB)
        테스트 8 〉	통과 (0.09ms, 76.4MB)
        테스트 9 〉	통과 (0.32ms, 71.8MB)
        테스트 10 〉	통과 (0.10ms, 79.5MB)
        테스트 11 〉	통과 (0.09ms, 74.2MB)
        테스트 12 〉	통과 (0.09ms, 74.9MB)
        테스트 13 〉	통과 (0.08ms, 80.6MB)
        테스트 14 〉	통과 (0.11ms, 71.2MB)
        테스트 15 〉	통과 (0.10ms, 76.6MB)
        테스트 16 〉	통과 (0.10ms, 75.6MB)
        테스트 17 〉	통과 (0.06ms, 70.6MB)
        테스트 18 〉	통과 (0.21ms, 81.2MB)
        테스트 19 〉	통과 (0.17ms, 76.7MB)
        테스트 20 〉	통과 (0.23ms, 74.8MB)
        테스트 21 〉	통과 (0.04ms, 77.9MB)
        테스트 22 〉	통과 (0.04ms, 73MB)
        테스트 23 〉	통과 (0.05ms, 78.6MB)
        테스트 24 〉	통과 (0.04ms, 84.8MB)
        테스트 25 〉	통과 (0.20ms, 76.9MB)
        테스트 26 〉	통과 (0.16ms, 77.2MB)
        테스트 27 〉	통과 (0.08ms, 76.3MB)
        테스트 28 〉	통과 (0.06ms, 73.5MB)
        테스트 29 〉	통과 (0.12ms, 76.8MB)
        테스트 30 〉	통과 (0.28ms, 73.1MB)
        테스트 31 〉	통과 (0.21ms, 72.6MB)
     */
    public static int[] solution2(String[] wallpaper) {
        int minX = Integer.MAX_VALUE;
        int minY = Integer.MAX_VALUE;
        int maxX = Integer.MIN_VALUE;
        int maxY = Integer.MIN_VALUE;

        for (int i = 0; i < wallpaper.length; i++) {
            for (int j = 0; j < wallpaper[i].length(); j++) {
                if (wallpaper[i].charAt(j) == '#') {
                    minX = Math.min(minX, i);
                    minY = Math.min(minY, j);
                    maxX = Math.max(maxX, i + 1);
                    maxY = Math.max(maxY, j + 1);
                }
            }
        }

        return new int[]{minX, minY, maxX, maxY};
    }
}
