package org.example.programmers.Lv_2;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 크게 어렵지 않은 문제였다. 접근 방법은 아래와 같다.
 * 1. targerine 배열을 탐색하며 사이즈 별 수량을 해시맵에 저장
 * 2. 해시 맵의 값을 가준으로 내림차순 정렬 (사이즈를 리스트로 정렬)
 * 3. 리스트 첫 원소부터 반환해야 하는 개수를 빼면서 정답 카운팅
 *
 * 하지만 교훈은 있다.
 * 1. map.getOrDefault(key, 0) + 1의 사용법에 대해서 제대로 모르고 있었구나.
 *    만약 실제 코딩테스트였으면 나는 여기서 막혔을 것이다.
 * 2. 정렬할 때 오름차순, 내림차순하는 법에 대해서 잘 몰랐다.
 *    메소드로 하는 방법도 있겠지만, map.get(o2).compareTo(map.get(o1)) 으로 원소의 순서만 바꾸면 정렬 기준이 변한다.
 *    그나저나 정렬에 대해선 진짜 모르는 것 같다.
 *
 * 성능이 그리 좋지는 않는다. 아마 정렬할 때 성능을 많이 잡아 먹는 것 같다.
 */
public class Lv_2_TangerineChoosing {
    public static void main(String[] args) {
        solution(6, new int[] {1, 3, 2, 5, 4, 5, 2, 3});
    }

    /*
        테스트 1 〉	통과 (27.33ms, 96.1MB)
        테스트 2 〉	통과 (18.93ms, 101MB)
        테스트 3 〉	통과 (28.43ms, 89MB)
        테스트 4 〉	통과 (25.78ms, 97.1MB)
        테스트 5 〉	통과 (19.90ms, 80.9MB)
        테스트 6 〉	통과 (20.26ms, 98.7MB)
        테스트 7 〉	통과 (28.55ms, 99MB)
        테스트 8 〉	통과 (23.14ms, 92.3MB)
        테스트 9 〉	통과 (15.97ms, 86.8MB)
        테스트 10 〉	통과 (23.07ms, 86.5MB)
        테스트 11 〉	통과 (1.02ms, 66.3MB)
        테스트 12 〉	통과 (0.69ms, 75.9MB)
        테스트 13 〉	통과 (0.65ms, 78.7MB)
        테스트 14 〉	통과 (0.94ms, 73.3MB)
        테스트 15 〉	통과 (0.74ms, 72.4MB)
        테스트 16 〉	통과 (0.75ms, 73.4MB)
        테스트 17 〉	통과 (1.04ms, 73.4MB)
        테스트 18 〉	통과 (0.77ms, 73.6MB)
        테스트 19 〉	통과 (1.04ms, 76.6MB)
        테스트 20 〉	통과 (1.03ms, 72.6MB)
        테스트 21 〉	통과 (1.83ms, 77.6MB)
        테스트 22 〉	통과 (2.23ms, 75.1MB)
        테스트 23 〉	통과 (2.62ms, 85.2MB)
        테스트 24 〉	통과 (3.48ms, 67.8MB)
        테스트 25 〉	통과 (17.89ms, 85.6MB)
        테스트 26 〉	통과 (17.72ms, 82.1MB)
        테스트 27 〉	통과 (58.59ms, 96.3MB)
        테스트 28 〉	통과 (50.32ms, 92.7MB)
        테스트 29 〉	통과 (78.86ms, 113MB)
        테스트 30 〉	통과 (96.73ms, 95.4MB)
        테스트 31 〉	통과 (20.53ms, 86.3MB)
        테스트 32 〉	통과 (23.12ms, 102MB)
        테스트 33 〉	통과 (68.92ms, 99.5MB)
        테스트 34 〉	통과 (55.64ms, 97.4MB)
     */
    public static int solution(int k, int[] tangerine) {

        Map<Integer, Integer> map = new HashMap<Integer, Integer>();
        for (int size : tangerine) {
            map.put(size, map.getOrDefault(size, 0) + 1);
        }

        List<Integer> sizeList = new ArrayList<>(map.keySet());
        sizeList.sort((o1, o2) -> map.get(o2).compareTo(map.get(o1)));

        int answer = 0;
        int i = 0;
        while (k > 0) {
            k -= map.get(sizeList.get(i++));
            answer++;
        }

        return answer;
    }
}
