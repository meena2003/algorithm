package org.example.programmers;

/**
 * 크게 두 가지 로직으로 나눴다.
 * 1. 주어진 배열로 만들 수 있는 모든 경우의 수를 3중 for문으로 구함
 * 2. 각 숫자가 소수인지 판별
 *
 * 3중 for문의 마지막 초기값 때문에 고민을 많이 했다.
 * 복잡하게 생각할 필요가 없다. i말고 j와의 관계만 생각하면 간단히 풀 수 있다.
 *
 * 소수인지 판단하는 공식은,
 * 2부터 해당 숫자의 제곱근까지의 숫자들로 나누어 떨어지지 않으면 소수로 판단한다.
 */
public class Lv_1_PrimeNumberGenerator {
    public static void main(String[] args) {
        solution(new int[]{1, 2, 7, 6, 4});
    }

    /*
        테스트 1 〉	통과 (0.67ms, 78MB)
        테스트 2 〉	통과 (0.93ms, 72.5MB)
        테스트 3 〉	통과 (0.21ms, 72.1MB)
        테스트 4 〉	통과 (0.16ms, 73.6MB)
        테스트 5 〉	통과 (1.03ms, 72.8MB)
        테스트 6 〉	통과 (2.65ms, 77.4MB)
        테스트 7 〉	통과 (0.13ms, 76MB)
        테스트 8 〉	통과 (4.65ms, 70MB)
        테스트 9 〉	통과 (0.60ms, 83.8MB)
        테스트 10 〉	통과 (4.53ms, 78.6MB)
        테스트 11 〉	통과 (0.05ms, 71.7MB)
        테스트 12 〉	통과 (0.03ms, 72MB)
        테스트 13 〉	통과 (0.06ms, 72.2MB)
        테스트 14 〉	통과 (0.05ms, 73.2MB)
        테스트 15 〉	통과 (0.03ms, 77.7MB)
        테스트 16 〉	통과 (6.52ms, 78.2MB)
        테스트 17 〉	통과 (9.07ms, 78.7MB)
        테스트 18 〉	통과 (0.11ms, 72.6MB)
        테스트 19 〉	통과 (0.02ms, 76.6MB)
        테스트 20 〉	통과 (8.69ms, 75.2MB)
        테스트 21 〉	통과 (8.21ms, 77.5MB)
        테스트 22 〉	통과 (2.64ms, 73.6MB)
        테스트 23 〉	통과 (0.02ms, 76.9MB)
        테스트 24 〉	통과 (6.42ms, 78MB)
        테스트 25 〉	통과 (6.68ms, 77.9MB)
        테스트 26 〉	통과 (0.02ms, 73.9MB)
     */
    public static int solution(int[] nums) {
        int answer = 0;

        for (int i = 0; i < nums.length - 2; i++) {
            for (int j = i + 1; j < nums.length - 1; j++) {
                for (int z = j + 1; z < nums.length; z++) {

                    int number = nums[i] + nums[j] + nums[z];
                    boolean isPrime = true;

                    // 소수인지 판단
                    for (int b = 2; b <= Math.sqrt(number); b++) {
                        if (number % b == 0) {
                            isPrime = false;
                        }
                    }
                    if (isPrime) {
                        answer++;
                    }
                }
            }
        }

        return answer;
    }
}
