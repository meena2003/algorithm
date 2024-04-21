package org.example.programmers.lv_1;

import java.util.HashMap;
import java.util.Map;

/**
 * 어렵지 않았다. 해시맵을 이용하면 됨!
 */
public class Lv_1_MemoryScoring {
    public static void main(String[] args) {
        solution(new String[]{"may", "kein", "kain", "radi"}, new int[]{5, 10, 1, 3}, new String[][]{{"may", "kein", "kain", "radi"},{"may", "kein", "brin", "deny"}, {"kon", "kain", "may", "coni"}});
    }

    /*
        테스트 1 〉	통과 (0.03ms, 73.4MB)
        테스트 2 〉	통과 (0.04ms, 74.6MB)
        테스트 3 〉	통과 (0.16ms, 75.3MB)
        테스트 4 〉	통과 (0.10ms, 79.3MB)
        테스트 5 〉	통과 (0.42ms, 74.1MB)
        테스트 6 〉	통과 (0.90ms, 90.9MB)
        테스트 7 〉	통과 (0.84ms, 81.5MB)
        테스트 8 〉	통과 (1.09ms, 80.7MB)
        테스트 9 〉	통과 (0.77ms, 84.7MB)
        테스트 10 〉	통과 (1.32ms, 96.6MB)
        테스트 11 〉	통과 (2.46ms, 105MB)
        테스트 12 〉	통과 (1.04ms, 88.4MB)
        테스트 13 〉	통과 (0.10ms, 73.1MB)
        테스트 14 〉	통과 (0.03ms, 72.8MB)
     */
    public static int[] solution(String[] name, int[] yearning, String[][] photo) {
        int[] answer = new int[photo.length];
        Map<String, Integer> scores = new HashMap<>();

        // 점수표를 해시맵으로 완성
        for (int i = 0; i < name.length; i++) {
            scores.put(name[i], yearning[i]);
        }

        // 사진을 보면서 점수 매김
        for (int i = 0; i < photo.length; i++) {
            for (int j = 0; j < photo[i].length; j++) {
                if (scores.containsKey(photo[i][j])) {
                    answer[i] += scores.get(photo[i][j]);
                }
            }
        }

        return answer;
    }
}
