package org.example.programmers.lv_1;

/**
 * 처음에는 p를 int형으로 파싱했는데, 런타임 에러가 나왔다.
 * 그 이유는 제한사항에 있었다. 바로 p의 길이가 최대 18까지 나오기 때문이다.
 * int형은 양수로 21억까지 표현이 가능하기 때문에(10자리), long 타입(19자리)으로 바꿔줘야 한다.
 *
 * 그리고 한 가지 고민했던 부분인데,
 * for문에서 종료 조건식에 idx <= t.length() - length 해도 된다는 거!
 */
public class Lv_1_MiniString {
    public static void main(String[] args) {
        solution("10000000000", "2");
    }

    /*
        테스트 1 〉	통과 (2.17ms, 81.9MB)
        테스트 2 〉	통과 (4.88ms, 75.4MB)
        테스트 3 〉	통과 (3.20ms, 78.5MB)
        테스트 4 〉	통과 (2.35ms, 77.2MB)
        테스트 5 〉	통과 (2.50ms, 80.6MB)
        테스트 6 〉	통과 (2.72ms, 77.9MB)
        테스트 7 〉	통과 (6.52ms, 74.5MB)
        테스트 8 〉	통과 (4.28ms, 75.2MB)
        테스트 9 〉	통과 (1.65ms, 77.4MB)
        테스트 10 〉	통과 (0.52ms, 73.7MB)
        테스트 11 〉	통과 (3.36ms, 75.1MB)
        테스트 12 〉	통과 (8.25ms, 79.7MB)
        테스트 13 〉	통과 (6.79ms, 74.1MB)
        테스트 14 〉	통과 (3.22ms, 73.2MB)
        테스트 15 〉	통과 (4.32ms, 80.2MB)
        테스트 16 〉	통과 (2.74ms, 72.3MB)
        테스트 17 〉	통과 (4.58ms, 77.5MB)
        테스트 18 〉	통과 (4.06ms, 85.2MB)
        테스트 19 〉	통과 (1.07ms, 78.2MB)
        테스트 20 〉	통과 (1.57ms, 73.4MB)
        테스트 21 〉	통과 (0.13ms, 76.4MB)
        테스트 22 〉	통과 (1.28ms, 76.9MB)
        테스트 23 〉	통과 (1.43ms, 73.8MB)
        테스트 24 〉	통과 (0.23ms, 64.4MB)
        테스트 25 〉	통과 (0.49ms, 75.6MB)
        테스트 26 〉	통과 (0.17ms, 74.4MB)
        테스트 27 〉	통과 (0.16ms, 78.2MB)
        테스트 28 〉	통과 (0.27ms, 73.8MB)
        테스트 29 〉	통과 (0.23ms, 77.5MB)
        테스트 30 〉	통과 (1.19ms, 75.4MB)
        테스트 31 〉	통과 (0.06ms, 76.1MB)
        테스트 32 〉	통과 (0.06ms, 70MB)
        테스트 33 〉	통과 (0.08ms, 75.9MB)
        테스트 34 〉	통과 (0.09ms, 75.7MB)
        테스트 35 〉	통과 (0.08ms, 72.8MB)
        테스트 36 〉	통과 (0.12ms, 75.9MB)
        테스트 37 〉	통과 (0.07ms, 77.2MB)
        테스트 38 〉	통과 (0.11ms, 75.4MB)
     */
    public static int solution(String t, String p) {
        int length = p.length();
        long target = Long.parseLong(p);
        int answer = 0;

        for (int idx = 0; idx + length <= t.length(); idx++) {
            long n = Long.parseLong(t.substring(idx, length + idx));
            if (n <= target) {
                answer++;
            }
        }

        return answer;
    }
}
