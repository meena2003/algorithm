package org.example.programmers;

/**
 * 풀고나면 별거 아닌데 굉장히 오래 걸린 문제..
 * 그리 복잡하게 생각할 필요가 없다.
 * 관건은,
 * 1) 언제까지 반복할 수 있는가?
 * 2) 새로운 빈병의 개수 계산 -> 나눈 개수 * 받는 개수 + 남는 개수
 */
public class Lv_1_ColaProblem {

    /*
        테스트 1 〉	통과 (0.01ms, 71.9MB)
        테스트 2 〉	통과 (0.02ms, 85.6MB)
        테스트 3 〉	통과 (0.03ms, 76.9MB)
        테스트 4 〉	통과 (0.02ms, 73.4MB)
        테스트 5 〉	통과 (0.02ms, 71.6MB)
        테스트 6 〉	통과 (0.02ms, 74.9MB)
        테스트 7 〉	통과 (0.02ms, 74.8MB)
        테스트 8 〉	통과 (0.02ms, 78.1MB)
        테스트 9 〉	통과 (0.02ms, 77.1MB)
        테스트 10 〉	통과 (0.02ms, 72.2MB)
        테스트 11 〉	통과 (0.01ms, 77.3MB)
        테스트 12 〉	통과 (0.15ms, 72.2MB)
        테스트 13 〉	통과 (0.02ms, 73.5MB)
        테스트 14 〉	통과 (0.02ms, 79.2MB)
     */
    public static void main(String[] args) {
        solution(3, 2, 20);
    }

    public static int solution(int a, int b, int n) {
        int answer = 0;

        while (n >= a) {
            answer += n / a * b;
            n = (n / a * b) + n % a;
        }

        return answer;
    }
}
