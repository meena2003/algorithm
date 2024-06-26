package org.example.programmers.lv_1;

/**
 * 굉장히 어려움을 많이 겪었던 문제다.
 * 처음에 배열로 접근했다가 고생을 많이 했다. 인덱스가 배열 길이를 넘어가는 경우를 처리하는 데 애로사항이 많았다.
 *
 * 결과적으로 배열로 푸는 것은 포기했다.
 *
 * 이 문제는 크게 두 가지 방법이 있다.
 * 1. 문자열 그 자체를 잘라내면서 진행 -> 반복문 2개
 *    : 비효율적이다. 일반적인 사고방식으로 for문을 2개 돌린다.
 * 2. 앞 글자를 특정 글자로 치환 후 진행 -> 반복문 1개
 *    : 훨씬 효율적인 알고리즘이다. 문자열에서 단어를 하나씩 빼서 비교하는 데, 관건은 첫 문자를 가상의 단어로 치환한 뒤 대입해서 하나씩 비교하는 것이다.
 *    : 즉 특정 문자로 초기화하는 것이 관건이다!!
 *
 * 마지막 남은 문자도 한 번의 카운트로 세야 하기 때문에, answer++를 전반부에 배치해야 한다.
 * 뒤에 answer++을 하면 특정 조건이 달성하지 못했을 때는 적용이 안되기 때문이다.
 *
 */
public class Lv_1_StringSplitter {
    public static void main(String[] args) {
        solution("banana");
    }

    /*
        테스트 1 〉	통과 (0.04ms, 73.1MB)
        테스트 2 〉	통과 (3.21ms, 79.6MB)
        테스트 3 〉	통과 (9.13ms, 87.4MB)
        테스트 4 〉	통과 (0.04ms, 73.8MB)
        테스트 5 〉	통과 (0.03ms, 74.7MB)
        테스트 6 〉	통과 (0.03ms, 69.8MB)
        테스트 7 〉	통과 (0.03ms, 74MB)
        테스트 8 〉	통과 (0.02ms, 64.7MB)
        테스트 9 〉	통과 (2.04ms, 78.2MB)
        테스트 10 〉	통과 (5.79ms, 82.9MB)
        테스트 11 〉	통과 (0.95ms, 78.6MB)
        테스트 12 〉	통과 (4.28ms, 90.4MB)
        테스트 13 〉	통과 (13.99ms, 92MB)
        테스트 14 〉	통과 (14.02ms, 96.3MB)
        테스트 15 〉	통과 (0.96ms, 71.4MB)
        테스트 16 〉	통과 (10.91ms, 95.5MB)
        테스트 17 〉	통과 (2.35ms, 75.4MB)
        테스트 18 〉	통과 (7.87ms, 86.4MB)
        테스트 19 〉	통과 (3.51ms, 78.9MB)
        테스트 20 〉	통과 (10.28ms, 98.8MB)
        테스트 21 〉	통과 (16.69ms, 89.4MB)
        테스트 22 〉	통과 (6.12ms, 79.5MB)
        테스트 23 〉	통과 (0.82ms, 67MB)
        테스트 24 〉	통과 (2.44ms, 82.5MB)
        테스트 25 〉	통과 (30.71ms, 86.9MB)
        테스트 26 〉	통과 (11.53ms, 97.9MB)
        테스트 27 〉	통과 (8.59ms, 87.3MB)
        테스트 28 〉	통과 (3.53ms, 77MB)
        테스트 29 〉	통과 (15.67ms, 94.4MB)
        테스트 30 〉	통과 (4.77ms, 81.1MB)
        테스트 31 〉	통과 (0.03ms, 78MB)
        테스트 32 〉	통과 (0.05ms, 67.2MB)
        테스트 33 〉	통과 (0.05ms, 74.2MB)
        테스트 34 〉	통과 (0.04ms, 91.7MB)
        테스트 35 〉	통과 (0.03ms, 69.6MB)
        테스트 36 〉	통과 (0.05ms, 74.8MB)
        테스트 37 〉	통과 (0.04ms, 77.9MB)
        테스트 38 〉	통과 (0.03ms, 80.5MB)
        테스트 39 〉	통과 (0.04ms, 70.9MB)
        테스트 40 〉	통과 (0.04ms, 78.6MB)
        테스트 41 〉	통과 (7.35ms, 86.8MB)
        테스트 42 〉	통과 (10.27ms, 85MB)
     */
    public static int solution(String s) {
        int answer = 0;

        while (s.length() != 0) {
            answer++;

            char startChar = s.charAt(0);
            int sameCount = 1;
            int wrongCount = 0;

            for (int i = 1; i < s.length(); i++) {
                if (startChar == s.charAt(i)) {
                    sameCount++;
                } else {
                    wrongCount++;
                }

                if (sameCount == wrongCount) {
                    break;
                }
            }

            s = s.substring(sameCount + wrongCount);
        }

        return answer;
    }

    /*
        테스트 1 〉	통과 (0.03ms, 66.8MB)
        테스트 2 〉	통과 (0.21ms, 78.3MB)
        테스트 3 〉	통과 (0.34ms, 75.6MB)
        테스트 4 〉	통과 (0.03ms, 70.5MB)
        테스트 5 〉	통과 (0.02ms, 82.3MB)
        테스트 6 〉	통과 (0.04ms, 77.8MB)
        테스트 7 〉	통과 (0.03ms, 81.4MB)
        테스트 8 〉	통과 (0.03ms, 75.4MB)
        테스트 9 〉	통과 (0.30ms, 71.6MB)
        테스트 10 〉	통과 (0.49ms, 85.4MB)
        테스트 11 〉	통과 (0.13ms, 69.5MB)
        테스트 12 〉	통과 (0.25ms, 73.9MB)
        테스트 13 〉	통과 (0.50ms, 78.4MB)
        테스트 14 〉	통과 (0.71ms, 77.1MB)
        테스트 15 〉	통과 (0.19ms, 74.7MB)
        테스트 16 〉	통과 (0.39ms, 80MB)
        테스트 17 〉	통과 (0.35ms, 78.6MB)
        테스트 18 〉	통과 (0.60ms, 75.3MB)
        테스트 19 〉	통과 (0.40ms, 70.3MB)
        테스트 20 〉	통과 (0.68ms, 69.6MB)
        테스트 21 〉	통과 (0.42ms, 74.7MB)
        테스트 22 〉	통과 (0.26ms, 70.6MB)
        테스트 23 〉	통과 (0.15ms, 78.5MB)
        테스트 24 〉	통과 (0.18ms, 72.8MB)
        테스트 25 〉	통과 (0.79ms, 77.3MB)
        테스트 26 〉	통과 (0.65ms, 78.2MB)
        테스트 27 〉	통과 (0.59ms, 74.3MB)
        테스트 28 〉	통과 (0.41ms, 73.3MB)
        테스트 29 〉	통과 (0.82ms, 71.4MB)
        테스트 30 〉	통과 (0.33ms, 68.2MB)
        테스트 31 〉	통과 (0.02ms, 73.9MB)
        테스트 32 〉	통과 (0.02ms, 72.9MB)
        테스트 33 〉	통과 (0.03ms, 78.1MB)
        테스트 34 〉	통과 (0.03ms, 73.5MB)
        테스트 35 〉	통과 (0.03ms, 75.1MB)
        테스트 36 〉	통과 (0.04ms, 75.7MB)
        테스트 37 〉	통과 (0.03ms, 72.6MB)
        테스트 38 〉	통과 (0.04ms, 74MB)
        테스트 39 〉	통과 (0.03ms, 85.1MB)
        테스트 40 〉	통과 (0.03ms, 74.8MB)
        테스트 41 〉	통과 (0.76ms, 68.7MB)
        테스트 42 〉	통과 (0.49ms, 75.7MB)
     */
    public int solution2(String s) {
        int answer = 0;

        int same = 0;
        int diffrent = 0;
        char prev = ' ';

        for (char c : s.toCharArray()) {
            if (prev == ' ') {
                prev = c;
                same++;
                answer++;
                continue;
            }

            if (prev == c) {
                same++;
            } else {
                diffrent++;
            }

            if (same == diffrent) {
                prev = ' ';
                same = 0;
                diffrent = 0;
            }
        }

        return answer;
    }
}
