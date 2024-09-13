package org.example.programmers.lv_2;

/**
 * 과거에 풀었던 문제.
 * 덕분에 최소 공약수와 최소 공배수의 성질과 구하는 방법을 복습할 수 있었다.
 */
public class Lv_2_LeastCommonMultiple {
    public static void main(String[] args) {
        solution(new int[]{2, 6, 8, 14});
    }

    /*
        테스트 1 〉	통과 (0.02ms, 79MB)
        테스트 2 〉	통과 (0.02ms, 73.5MB)
        테스트 3 〉	통과 (0.02ms, 81MB)
        테스트 4 〉	통과 (0.02ms, 77.1MB)
        테스트 5 〉	통과 (0.02ms, 75.8MB)
        테스트 6 〉	통과 (0.03ms, 79.5MB)
        테스트 7 〉	통과 (0.03ms, 70.3MB)
        테스트 8 〉	통과 (0.02ms, 75.9MB)
        테스트 9 〉	통과 (0.03ms, 72.6MB)
        테스트 10 〉	통과 (0.04ms, 82.1MB)
     */
    public static int solution(int[] arr) {
        int answer = arr[0];
        int gcd = 0;

        for (int i = 1; i < arr.length; i++) {
            gcd = gcd(answer, arr[i]);
            answer = answer * arr[i] / gcd;
        }

        return answer;
    }

    public static int gcd(int a, int b) {

        if (a > b) {
            return (a % b == 0) ? b : gcd(b, a % b);
        } else {
            return (b % a == 0) ? a : gcd(a, b % a);
        }
    }
}
