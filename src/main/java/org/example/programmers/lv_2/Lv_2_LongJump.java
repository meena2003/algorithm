package org.example.programmers.lv_2;

/**
 * 오랜만에 푼 문제이다. 쉽게 풀줄 알았는데 이번에는 혼자서 원리를 파악하지 못했다.
 * 경우의 수를 A4용지에 그리며 노력했지만 결과적으로 찾지 못했다.
 * 이건 피보나치 수열 문제였다.
 * 일단 문제에서 1 또는 2 시도라는 키워드가 나오면 경우의 수 문제로 피보나치 수열이 이용되는 것 같다.
 * 피보나치 수열은 이전, 이전전 원소를 더하면 된다.
 *
 * 여기선 너무 값이 커지기 때문에 %1234567 의 나머지를 사용하는 것 같다.
 * 근데 왜 1234567이지??
 * 아무튼 좀 찝찝하다.
 */
public class Lv_2_LongJump {
    public static void main(String[] args) {

    }

    /*
        테스트 1 〉	통과 (0.06ms, 74.7MB)
        테스트 2 〉	통과 (0.08ms, 80.9MB)
        테스트 3 〉	통과 (0.07ms, 78.2MB)
        테스트 4 〉	통과 (0.04ms, 73.6MB)
        테스트 5 〉	통과 (0.06ms, 78.7MB)
        테스트 6 〉	통과 (0.05ms, 77.4MB)
        테스트 7 〉	통과 (0.07ms, 77.1MB)
        테스트 8 〉	통과 (0.06ms, 72MB)
        테스트 9 〉	통과 (0.09ms, 81.4MB)
        테스트 10 〉	통과 (0.08ms, 85.2MB)
        테스트 11 〉	통과 (0.11ms, 74.7MB)
        테스트 12 〉	통과 (0.16ms, 73.7MB)
        테스트 13 〉	통과 (0.11ms, 78.2MB)
        테스트 14 〉	통과 (0.12ms, 79.9MB)
        테스트 15 〉	통과 (0.11ms, 73.3MB)
        테스트 16 〉	통과 (0.11ms, 71.3MB)
     */
    public static long solution(int n) {

        long answer = 0L;
        long preNum = 1L;
        long nextNum = 1L;

        if (n == 1) {
            return 1;
        }

        for (int i = 2; i <= n; i++) {
            answer = (preNum % 1234567) + (nextNum % 1234567);
            preNum = nextNum;
            nextNum = answer;
        }

        return answer % 1234567;
    }
}
