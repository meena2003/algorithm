package org.example.programmers.lv_1;

/**
 * 생각보다 어렵지 않았다.
 * 배열을 순서대로 탐색하면 되는 문제.
 * 대신 카드1, 카드2 배열의 크기가 다르기 때문에 배열 크기를 고려하지 않으면 예외가 발생할 수 있다.
 */
public class Lv_1_CardBundle {

    /*
    테스트 1 〉	통과 (0.02ms, 82.3MB)
    테스트 2 〉	통과 (0.03ms, 73.9MB)
    테스트 3 〉	통과 (0.02ms, 75.9MB)
    테스트 4 〉	통과 (0.01ms, 74.2MB)
    테스트 5 〉	통과 (0.02ms, 74.7MB)
    테스트 6 〉	통과 (0.03ms, 77.2MB)
    테스트 7 〉	통과 (0.02ms, 77.3MB)
    테스트 8 〉	통과 (0.01ms, 73.1MB)
    테스트 9 〉	통과 (0.02ms, 74.9MB)
    테스트 10 〉	통과 (0.03ms, 73.4MB)
    테스트 11 〉	통과 (0.02ms, 72.6MB)
    테스트 12 〉	통과 (0.03ms, 70.7MB)
    테스트 13 〉	통과 (0.02ms, 75.5MB)
    테스트 14 〉	통과 (0.03ms, 82.1MB)
    테스트 15 〉	통과 (0.02ms, 73.9MB)
    테스트 16 〉	통과 (0.03ms, 68.3MB)
    테스트 17 〉	통과 (0.02ms, 71.3MB)
    테스트 18 〉	통과 (0.03ms, 73.1MB)
    테스트 19 〉	통과 (0.02ms, 71.3MB)
    테스트 20 〉	통과 (0.03ms, 77.4MB)
    테스트 21 〉	통과 (0.02ms, 77.6MB)
    테스트 22 〉	통과 (0.02ms, 76.3MB)
    테스트 23 〉	통과 (0.02ms, 75MB)
    테스트 24 〉	통과 (0.03ms, 82.8MB)
    테스트 25 〉	통과 (0.02ms, 71.6MB)
 */
    public static void main(String[] args) {
        solution(new String[]{"i", "water", "drink"}, new String[]{"want", "to"}, new String[]{"i", "want", "to", "drink", "water"});
    }

    public static String solution(String[] cards1, String[] cards2, String[] goal) {

        int c1Idx = 0;
        int c2Idx = 0;
        String answer = "Yes";

        for (String word : goal) {

            if (cards1.length > c1Idx && cards1[c1Idx].equals(word)) {
                c1Idx++;
                continue;
            }
            if (cards2.length > c2Idx && cards2[c2Idx].equals(word)) {
                c2Idx++;
                continue;
            }
            answer = "No";
        }

        return answer;
    }
}
