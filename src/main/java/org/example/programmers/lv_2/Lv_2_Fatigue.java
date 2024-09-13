package org.example.programmers.lv_2;

public class Lv_2_Fatigue {
    public static void main(String[] args) {
        int k = 80;
        int[][] dungeons = {{80, 20}, {50, 40}, {30, 10}};
        System.out.println(solution(k, dungeons)); // 3
    }

    private static int maxCount = 0;

    public static int solution(int k, int[][] dungeons) {
        boolean[] visited = new boolean[dungeons.length];
        exploreDungeons(k, dungeons, visited, 0);
        return maxCount;
    }

    private static void exploreDungeons(int k, int[][] dungeons, boolean[] visited, int count) {
        // 모든 던전을 탐험했거나 피로도가 부족해 더 이상 탐험할 수 없는 경우
        maxCount = Math.max(maxCount, count);

        // 각 던전을 탐험할 수 있는지 확인
        for (int i = 0; i < dungeons.length; i++) {
            if (!visited[i] && k >= dungeons[i][0]) { // 방문하지 않았고, 최소 피로도 조건을 만족하는 경우
                visited[i] = true;
                exploreDungeons(k - dungeons[i][1], dungeons, visited, count + 1); // 소모 피로도만큼 감소
                visited[i] = false; // 백트래킹을 위해 방문 기록 초기화
            }
        }
    }
}
