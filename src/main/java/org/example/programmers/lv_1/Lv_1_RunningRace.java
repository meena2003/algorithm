package org.example.programmers.lv_1;

import java.util.HashMap;
import java.util.Map;

/**
 * 아.. 처음에 너무 어렵게 생각해서 꼬아서 생각한게 패착이었다.
 * 추월을 하는 순간은 한 사람이지, 여러명을 동시에 추월해도 된다고 생각했던 게 오판이었다.
 * 그래서 어떻게 정렬 알고리즘을 사용해야 하는지 고민을 하느라 막막했었다.
 * 그런데 실제론 딱 앞 사람과의 추월만 신경쓰면 됐기 때문에 그 이전의 사람들의 순위는 변동이 되지 않는다.
 * 사실 쉬운 문제다...
 *
 * 그냥 플레이어 배열 위치만 바꾸면 되는 거 아닌가 싶지만,
 * players 배열의 크기가 최대 50,000까지이기 떄문에 해댱 플레이어의 위치를 매번 파악하려면 for문으로 전체 탐색을 해야 한다.
 * 그건 너무 비효율적이기 때문에 현재 플레이어의 위치를 HashMap에 저장한 뒤, 해당 선수 위치를 한 번에 파악하기 위해서 Map을 사용한다.
 */
public class Lv_1_RunningRace {
    public static void main(String[] args) {
        solution(new String[]{"mumu", "soe", "poe", "kai", "mine"}, new String[]{"kai", "kai", "mine", "mine"});
    }

    /*
        테스트 1 〉	통과 (0.03ms, 63.7MB)
        테스트 2 〉	통과 (0.05ms, 69.8MB)
        테스트 3 〉	통과 (0.12ms, 76.3MB)
        테스트 4 〉	통과 (1.48ms, 87.1MB)
        테스트 5 〉	통과 (5.80ms, 89.8MB)
        테스트 6 〉	통과 (7.68ms, 105MB)
        테스트 7 〉	통과 (37.84ms, 122MB)
        테스트 8 〉	통과 (48.23ms, 130MB)
        테스트 9 〉	통과 (64.48ms, 157MB)
        테스트 10 〉	통과 (159.16ms, 231MB)
        테스트 11 〉	통과 (420.96ms, 381MB)
        테스트 12 〉	통과 (379.17ms, 385MB)
        테스트 13 〉	통과 (306.86ms, 353MB)
        테스트 14 〉	통과 (0.05ms, 78.2MB)
        테스트 15 〉	통과 (0.03ms, 71.2MB)
        테스트 16 〉	통과 (0.03ms, 77MB)
     */
    public static String[] solution(String[] players, String[] callings) {

        Map<String, Integer> playersRanking = new HashMap<>();

        // 초기 등수를 확인
        for (int i = 0; i < players.length; i++) {
            playersRanking.put(players[i], i);
        }

        for (int i = 0; i < callings.length; i++) {
            // 추월한 플레이어의 현재 등수 확인
            int rank = playersRanking.get(callings[i]);

            // 이전 플레이어의 현재 등수 확인
            int forwardRank = playersRanking.get(players[rank - 1]);

            // 두 플레이어 순위 교체
            playersRanking.put(callings[i], forwardRank);
            playersRanking.put(players[rank - 1], rank);

            // 배열에서 교체
            String tmp = players[rank - 1];
            players[rank - 1] = players[rank];
            players[rank] = tmp;
        }

        return players;
    }
}
