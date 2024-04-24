package org.example.programmers.Lv_2;

import java.util.HashSet;
import java.util.Set;

/**
 * 수열이라고 해서 좀 불안했다. 나는 수학에 약하다는 생각이 있었기 때문이다.
 * 처음에는 링크드 리스트를 이용해서 풀어야 하나 싶었다.
 * 하지만 링크드 리스트의 사용법에 대해서 잘 모르고, 현재 내가 할 수 있는 상황에서 최선을 다해보고 싶었다.
 * 곰곰이 생각해보면 배열로도 풀 수 있을것 같았다.
 * 관건은 배열이 끝났을 때 인덱스를 어떻게 처리하느냐에 있었다.
 * 시행착오는 있었지만, 그래도 내 힘으로 스스로 풀었다!
 * 한가지 잘못 아는 게 있었다면, 나머지를 이용해서 풀 때 10, 100, 1000 이 아니라, 배열의 길이로 접근하면 됐다.
 */
public class Lv_2_SubsequenceSumCount {
    public static void main(String[] args) {
        solution(new int[]{7, 9, 1, 1, 4});
    }

    /*
        테스트 1 〉	통과 (0.06ms, 72.7MB)
        테스트 2 〉	통과 (44.22ms, 90.8MB)
        테스트 3 〉	통과 (66.38ms, 95.3MB)
        테스트 4 〉	통과 (145.70ms, 82.7MB)
        테스트 5 〉	통과 (245.00ms, 90.1MB)
        테스트 6 〉	통과 (324.05ms, 97.8MB)
        테스트 7 〉	통과 (625.20ms, 115MB)
        테스트 8 〉	통과 (763.59ms, 127MB)
        테스트 9 〉	통과 (1244.32ms, 114MB)
        테스트 10 〉	통과 (1544.92ms, 132MB)
        테스트 11 〉	통과 (286.66ms, 105MB)
        테스트 12 〉	통과 (353.75ms, 97.1MB)
        테스트 13 〉	통과 (449.78ms, 100MB)
        테스트 14 〉	통과 (559.06ms, 119MB)
        테스트 15 〉	통과 (699.09ms, 127MB)
        테스트 16 〉	통과 (994.63ms, 128MB)
        테스트 17 〉	통과 (889.63ms, 120MB)
        테스트 18 〉	통과 (1080.20ms, 116MB)
        테스트 19 〉	통과 (1226.07ms, 136MB)
        테스트 20 〉	통과 (1512.35ms, 134MB)
     */
    public static int solution(int[] elements) {

        // 자리수 확인
        int length = elements.length;
        Set<Integer> answers = new HashSet<>();

        // 총 elements의 개수만큼 반복 (n-1번까지)
        for (int n = 1; n < elements.length; n++) {

            // 단계별 elements 합산 구하기
            for (int i = 0; i < elements.length; i++) {
                int sum = 0;
                for (int j = 0; j < n; j++) {
                    sum += elements[(j + i) % length];
                }
                answers.add(sum);
            }
        }

        int sum = 0;
        // 마지막 모든 원소를 더하는 거 추가
        for (int n : elements) {
            sum += n;
        }
        answers.add(sum);

        return answers.size();
    }
}
