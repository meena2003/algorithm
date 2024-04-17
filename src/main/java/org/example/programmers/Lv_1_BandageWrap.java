package org.example.programmers;

/**
 * 예상보다 쉬웠다. 인텔리제이 도움을 받지 않고 풀 수 있었다.
 *
 */
public class Lv_1_BandageWrap {
    public static void main(String[] args) {

    }

    /*
        테스트 1 〉	통과 (0.01ms, 70.6MB)
        테스트 2 〉	통과 (0.04ms, 83MB)
        테스트 3 〉	통과 (0.02ms, 77MB)
        테스트 4 〉	통과 (0.01ms, 77.3MB)
        테스트 5 〉	통과 (0.03ms, 84.2MB)
        테스트 6 〉	통과 (0.03ms, 74.1MB)
        테스트 7 〉	통과 (0.06ms, 75.4MB)
        테스트 8 〉	통과 (0.02ms, 78.9MB)
        테스트 9 〉	통과 (0.03ms, 74.9MB)
        테스트 10 〉	통과 (0.02ms, 75.3MB)
        테스트 11 〉	통과 (0.05ms, 75.7MB)
        테스트 12 〉	통과 (0.04ms, 74.3MB)
        테스트 13 〉	통과 (0.07ms, 76MB)
        테스트 14 〉	통과 (0.07ms, 85.3MB)
        테스트 15 〉	통과 (0.07ms, 81MB)
        테스트 16 〉	통과 (0.04ms, 77.4MB)
        테스트 17 〉	통과 (0.04ms, 72.5MB)
        테스트 18 〉	통과 (0.06ms, 73.8MB)
        테스트 19 〉	통과 (0.08ms, 75.7MB)
        테스트 20 〉	통과 (0.06ms, 74.4MB)
     */
    public int solution(int[] bandage, int health, int[][] attacks) {

        int time = attacks[attacks.length - 1][0];
        int bonusHealCount = 0;
        int attackIdx = 0;
        int maxHealth = health;

        //마지막 공격까지 1초씩 for문 반복
        for (int second = 1; second <= time; second++) {

            // 해당 턴에서 공격이 없고, 체력 회복이 필요하면 증가
            if (second != attacks[attackIdx][0] && health < maxHealth) {
                // 추가 회복 조건이라면,
                if (++bonusHealCount == bandage[0]) {
                    health += bandage[1] + bandage[2];
                    bonusHealCount = 0;
                } else {
                    health += bandage[1];
                }

                if (health > maxHealth) {
                    health = maxHealth;
                }

            // 해당 턴에서 공격이 있으면 체력 감소
            } else if (second == attacks[attackIdx][0]) {
                health -= attacks[attackIdx][1];
                bonusHealCount = 0;
                attackIdx++;
            }

            if (health <= 0) {
                return -1;
            }
        }

        return health;
    }
}
