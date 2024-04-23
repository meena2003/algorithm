package org.example.programmers.Lv_2;

import java.util.Arrays;

/**
 * 과거에 풀었던 문제..
 * 쉽게 풀줄 알았는데 그게 아니었다.
 * 과거와 다른 방식으로 풀려고 했는데 실패해서 과거 코드를 참고했다.
 *
 * 정렬을 이용하면 쉽게 풀 수 있다.
 * 해당 원리를 잘 이해해야 한다.
 * - 단 두 명만 탈 수 있다 --> 반드시 최적화 할 필요가 없다.
 * - 최소 몸무게와 합이 제한 몸무게를 넘는다면 최대 몸무게는 혼자 타야 한다.
 *
 * 배열을 이용할 때 그냥 for 문으로 하면 인덱스 예외가 발생할 가능성이 크다.
 * 내가 직접 인덱스를 만들어서 조정하는 게 훨씬 편리하다.
 *
 * Arrays.sort() 메소드로 쉽게 배열을 '오름차순' 정렬이 가능하다.
 * 만약 '내림차순'으로 하려면 Collection.reverseOrder()을 사용하면 되지만, 원시 타입은 예외가 발생한다.
 */
public class Lv_2_Lifeboat {
    public static void main(String[] args) {
        solution(new int[]{40, 50, 40, 200, 150, 100}, 200);
    }

    /*
            정확성  테스트
        테스트 1 〉	통과 (1.39ms, 72.3MB)
        테스트 2 〉	통과 (1.38ms, 77.4MB)
        테스트 3 〉	통과 (1.22ms, 76.6MB)
        테스트 4 〉	통과 (1.30ms, 78.8MB)
        테스트 5 〉	통과 (0.96ms, 88MB)
        테스트 6 〉	통과 (0.95ms, 74.1MB)
        테스트 7 〉	통과 (0.81ms, 71.1MB)
        테스트 8 〉	통과 (0.52ms, 72.9MB)
        테스트 9 〉	통과 (0.43ms, 73.8MB)
        테스트 10 〉	통과 (1.07ms, 77.3MB)
        테스트 11 〉	통과 (1.87ms, 87.1MB)
        테스트 12 〉	통과 (1.05ms, 79.2MB)
        테스트 13 〉	통과 (1.58ms, 57.4MB)
        테스트 14 〉	통과 (1.08ms, 82.9MB)
        테스트 15 〉	통과 (0.46ms, 72.6MB)
        테스트 16 〉	통과 (0.42ms, 74.8MB)
        테스트 17 〉	통과 (0.37ms, 73.1MB)
        테스트 18 〉	통과 (0.43ms, 70.6MB)
        테스트 19 〉	통과 (0.39ms, 83.7MB)
        테스트 20 〉	통과 (0.47ms, 79.9MB)
        테스트 21 〉	통과 (0.43ms, 76.5MB)
        테스트 22 〉	통과 (0.53ms, 73.9MB)

            효율성  테스트
        테스트 1 〉	통과 (10.46ms, 56.6MB)
        테스트 2 〉	통과 (9.98ms, 54.3MB)
        테스트 3 〉	통과 (11.21ms, 55.7MB)
        테스트 4 〉	통과 (7.17ms, 56.8MB)
        테스트 5 〉	통과 (9.24ms, 53.8MB)
     */
    public static int solution(int[] people, int limit) {

        Arrays.sort(people);
        int answer = 0;

        int left = 0;
        int right = people.length - 1;

        while (left <= right) {
            if (people[right--] + people[left] <= limit) {
                left++;
            }
            answer++;
        }

        return answer;
    }
}
