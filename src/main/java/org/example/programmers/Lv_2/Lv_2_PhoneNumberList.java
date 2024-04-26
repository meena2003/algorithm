package org.example.programmers.Lv_2;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/**
 * 처음에는 indexOf() 메소드로 풀었다.
 * 배열의 순서대로 모든 원소들을 찾으며 indexOf()의 값이 0이면 false를 반환하도록 한 것이다.
 * 정확성에서는 합격. 그러나 효율성에서 탈락했다.
 * 아마 최대 길이인 백만개의 원소가 있으면 이중 포문이기 때문에 최악의 경우엔 1,000,000 x 1,000,000 경우가 발생할 수 있다.
 * 그래서 이중 포문이 아니라, 일단 정렬을 한 번 시행한 다음에, for문을 한 번만 돌리면 성공한다.
 *
 * 대안으로 해시를 사용할 수 있다.
 * 먼저 모든 번호를 다 해시맵에 저장해둔다.
 * 그리고 각각의 원소를 탐색하면서 한 글자씩 검색하여 해당 경우가 해시맵에 저장되어 있는지 확인하는 것이다.
 */
public class Lv_2_PhoneNumberList {
    public static void main(String[] args) {
        solution(new String[]{"119", "97674223", "1195524421"});
    }

    /*
            <정확성  테스트>
        테스트 1 〉	통과 (0.03ms, 73.6MB)
        테스트 2 〉	통과 (0.04ms, 73.1MB)
        테스트 3 〉	통과 (0.04ms, 77.5MB)
        테스트 4 〉	통과 (0.02ms, 73.1MB)
        테스트 5 〉	통과 (0.04ms, 73.4MB)
        테스트 6 〉	통과 (0.02ms, 75.9MB)
        테스트 7 〉	통과 (0.05ms, 73.3MB)
        테스트 8 〉	통과 (0.03ms, 76.7MB)
        테스트 9 〉	통과 (0.04ms, 67.5MB)
        테스트 10 〉	통과 (0.03ms, 77.4MB)
        테스트 11 〉	통과 (0.04ms, 73.6MB)
        테스트 12 〉	통과 (0.02ms, 74MB)
        테스트 13 〉	통과 (0.03ms, 77.1MB)
        테스트 14 〉	통과 (1.49ms, 75.2MB)
        테스트 15 〉	통과 (3.11ms, 73.5MB)
        테스트 16 〉	통과 (4.70ms, 90.2MB)
        테스트 17 〉	통과 (5.45ms, 92.1MB)
        테스트 18 〉	통과 (12.44ms, 90.1MB)
        테스트 19 〉	통과 (4.75ms, 85.8MB)
        테스트 20 〉	통과 (6.39ms, 81MB)
            <효율성  테스트>
        테스트 1 〉	통과 (3.93ms, 59.6MB)
        테스트 2 〉	통과 (3.15ms, 57.1MB)
        테스트 3 〉	통과 (289.51ms, 245MB)
        테스트 4 〉	통과 (204.81ms, 135MB)
     */
    public static boolean solution(String[] phone_book) {
        // 모든 값을 해시맵에 저장
        Map<String, Integer> map = new HashMap<>();
        for (String phoneNum : phone_book) {
            map.put(phoneNum, 0);
        }

        // 비교
        for (int i = 0; i < phone_book.length; i++) {
            for (int j = 1; j < phone_book[i].length(); j++) {
                if (map.containsKey(phone_book[i].substring(0, j))) {
                    return false;
                }
            }
        }

        return true;
    }

    /*
            <정확성  테스트>
        테스트 1 〉	통과 (0.20ms, 73.2MB)
        테스트 2 〉	통과 (0.19ms, 73.3MB)
        테스트 3 〉	통과 (0.21ms, 79.7MB)
        테스트 4 〉	통과 (0.26ms, 67.7MB)
        테스트 5 〉	통과 (0.27ms, 73.2MB)
        테스트 6 〉	통과 (0.19ms, 71.8MB)
        테스트 7 〉	통과 (0.27ms, 75.5MB)
        테스트 8 〉	통과 (0.19ms, 77.4MB)
        테스트 9 〉	통과 (0.24ms, 73.3MB)
        테스트 10 〉	통과 (0.29ms, 81.3MB)
        테스트 11 〉	통과 (0.28ms, 73.2MB)
        테스트 12 〉	통과 (0.17ms, 72.3MB)
        테스트 13 〉	통과 (0.23ms, 74.3MB)
        테스트 14 〉	통과 (2.21ms, 75.9MB)
        테스트 15 〉	통과 (3.18ms, 79.2MB)
        테스트 16 〉	통과 (3.58ms, 75.2MB)
        테스트 17 〉	통과 (4.28ms, 82.5MB)
        테스트 18 〉	통과 (5.54ms, 80.3MB)
        테스트 19 〉	통과 (4.02ms, 77MB)
        테스트 20 〉	통과 (4.95ms, 86.7MB)
            <효율성  테스트>
        테스트 1 〉	통과 (24.57ms, 55.9MB)
        테스트 2 〉	통과 (21.18ms, 56.9MB)
        테스트 3 〉	통과 (338.06ms, 98.3MB)
        테스트 4 〉	통과 (259.43ms, 96.4MB)
     */
    public boolean solution2(String[] phone_book) {

        Arrays.sort(phone_book);

        for (int i = 0; i < phone_book.length - 1; i++) {
            if (phone_book[i + 1].indexOf(phone_book[i]) == 0) {
                return false;

            }
        }

        return true;
    }
}
