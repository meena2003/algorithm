package org.example.programmers;

import java.util.HashMap;
import java.util.Map;

/**
 * 아.. 내가 잘못 알고 있던 게 하나 있었다.
 * 바로 for 조건문의 실행 여부이다.
 * 나는 초기값이 할당되고 무조건 한 번은 실행되는 줄 알았는데, 그게 아니다. 조건에 해당되지 않으면 첫 번째부터 수행이 안된다.
 *
 * 발상의 전환만 했다면 그리 어려운 문제는 아닌데, 나는 어렵게 느껴졌다.
 * 일단, 문제의 본질을 잘 살펴야 한다.
 * 선물을 주고 받는다는 건 대칭성을 가진다. 즉 2차원 배열로 그들의 선물 내역을 정리할 수 있다.
 * 그러면 2차원 배열의 위치는 어떻게 판단하는가? HashMap으로 인덱스를 저장한 뒤에 사용할 수 있다.
 * 두 번째로 선물 지수도 하나의 배열로 정리가 가능하다. 어차피 두 사람끼리 비교할 것이기 때문에 배열의 인덱스로 값을 관리할 수 있다.
 *
 * 문제를 도식화해서 특징을 찾아내는 것이 매우 중요한 문제였다.
 */
public class Lv_1_MostReceivedGift {
    public static void main(String[] args) {
        int solution = solution(new String[]{"muzi", "ryan", "frodo", "neo"}, new String[]{"muzi frodo", "muzi frodo", "ryan muzi", "ryan muzi", "ryan muzi", "frodo muzi", "frodo ryan", "neo muzi"});
        System.out.println("solution = " + solution);

    }

    /*
        테스트 1 〉	통과 (0.15ms, 67.4MB)
        테스트 2 〉	통과 (0.34ms, 75.9MB)
        테스트 3 〉	통과 (0.46ms, 71.1MB)
        테스트 4 〉	통과 (0.32ms, 73.3MB)
        테스트 5 〉	통과 (4.41ms, 80.1MB)
        테스트 6 〉	통과 (0.66ms, 79.4MB)
        테스트 7 〉	통과 (2.92ms, 77.7MB)
        테스트 8 〉	통과 (2.54ms, 83.7MB)
        테스트 9 〉	통과 (6.76ms, 83MB)
        테스트 10 〉	통과 (8.34ms, 82MB)
        테스트 11 〉	통과 (5.44ms, 77.4MB)
        테스트 12 〉	통과 (4.34ms, 91.1MB)
        테스트 13 〉	통과 (10.62ms, 103MB)
        테스트 14 〉	통과 (17.78ms, 98.1MB)
        테스트 15 〉	통과 (13.68ms, 87.9MB)
        테스트 16 〉	통과 (10.23ms, 101MB)
        테스트 17 〉	통과 (0.27ms, 74.8MB)
        테스트 18 〉	통과 (7.04ms, 91.3MB)
        테스트 19 〉	통과 (9.02ms, 106MB)
        테스트 20 〉	통과 (3.99ms, 74.5MB)
     */
    public static int solution(String[] friends, String[] gifts) {
        int len = friends.length;
        int[] total = new int[len];

        Map<String, Integer> indexs = new HashMap<>();
        for (int i = 0; i < len; i++) {
            indexs.put(friends[i], i);
        }

        int[] giftScore = new int[len];
        int[][] history = new int[len][len];

        // gift를 순회하며 2차원 배열 생성하기 - 생성할 때 선물지수까지 계산해서 1차원 배열에 생성
        for (int i = 0; i < gifts.length; i++) {
            String[] tmp = gifts[i].split(" ");
            int giverIdx = indexs.get(tmp[0]);
            int takeIdx = indexs.get(tmp[1]);

            // 선물을 주고 받은 내역 기록
            history[giverIdx][takeIdx]++;

            // 선물지수 계산
            giftScore[giverIdx]++;
            giftScore[takeIdx]--;
        }

        // 선물 이력을 탐색하면서 다음달에 받을 선물 양 계산
        for (int giver = 0; giver < len; giver++) {
            for (int taker = giver + 1; taker < len; taker++) {
                int give = history[giver][taker];
                int take = history[taker][giver];

                if (give > take) {
                    total[giver]++;
                } else if (take > give) {
                    total[taker]++;
                } else {
                    if (giftScore[giver] > giftScore[taker]) {
                        total[giver]++;
                    } else if (giftScore[giver] < giftScore[taker]) {
                        total[taker]++;
                    }
                }
            }
        }

        int maxPoint = 0;
        for (int point : total) {
            maxPoint = Math.max(maxPoint, point);
        }

        return maxPoint;
    }
}
