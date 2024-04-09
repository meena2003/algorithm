package org.example.programmers;

/**
 * 과거에 풀다가 힘들어서 포기 했었던 문제.
 * 그러나. 최근 소수를 판별하는 원리를 파악하고 대입만 하니깐 쉽게 풀렸다.
 * -> 2부터 x의 제곱근까지의 숫자로 0으로 나눠 떨어지지 않으면 소수로 판단한다.
 */
public class Lv_1_PrimeFinder {

    /*
        <정확성  테스트>
        테스트 1 〉	통과 (0.02ms, 76MB)
        테스트 2 〉	통과 (0.07ms, 78.3MB)
        테스트 3 〉	통과 (0.23ms, 74.3MB)
        테스트 4 〉	통과 (0.31ms, 75.2MB)
        테스트 5 〉	통과 (0.15ms, 76.1MB)
        테스트 6 〉	통과 (1.14ms, 80.6MB)
        테스트 7 〉	통과 (0.43ms, 74.8MB)
        테스트 8 〉	통과 (1.28ms, 78MB)
        테스트 9 〉	통과 (1.18ms, 75.6MB)
        테스트 10 〉	통과 (50.43ms, 86MB)
        테스트 11 〉	통과 (201.82ms, 98.2MB)
        테스트 12 〉	통과 (51.83ms, 87MB)

        <효율성  테스트>
        테스트 1 〉	통과 (208.47ms, 52.4MB)
        테스트 2 〉	통과 (197.84ms, 51.8MB)
        테스트 3 〉	통과 (225.15ms, 52.1MB)
        테스트 4 〉	통과 (196.46ms, 51.9MB)
     */
    public static void main(String[] args) {
        solution(10);
    }

    public static int solution(int n) {
        int answer = 0;

        for (int i = 2; i <= n; i++) {
            if (isPrim(i)) {
                answer++;
            }
        }

        return answer;
    }

    private static boolean isPrim(int x) {
        for (int i = 2; i <= Math.sqrt(x); i++) {
            if (x % i == 0) {
                return false;
            }
        }
        return true;
    }
}
