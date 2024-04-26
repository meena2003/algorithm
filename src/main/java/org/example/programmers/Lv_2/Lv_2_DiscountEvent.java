package org.example.programmers.Lv_2;

import java.util.HashMap;
import java.util.Map;

/**
 * 문제 자체는 크게 어렵지 않다.
 * 문제를 푸는 방식도 스스로 생각했다.
 * 하지만 인텔리제이의 디버그 도움을 받아야했다..
 * 그 원인은 반복문의 조건때문이다. 몇 번 반복해야 하는지 그 조건을 맞추기가 헷갈렸다.
 *
 * 또 깊은 복사와 얕은 복사에 대해서 익힐 수 있었다.
 * 해시맵을 계속 초기화 시켜야 했는데, 원본을 복사해서 사용하는 방식을 채택했다.
 * 초기에는 그냥 변수에 원본 해시맵의 주소값을 할당하는 얕은 복사를 사용했는데,
 * 그건 원본 값에 영향을 주기 때문에 깊은 복사를 해야만 했다.
 * HashMap의 복사 방식에 대해 몰라서 이 방법은 인터넷을 보고 찾았다.
 * 즉 생성자를 통해서 만들 수 있는 것이다.
 *
 * 문제를 푸는 방식은 일단 원하는 물품과 수량을 HashMap으로 만든 다음, 일자별로 해당 해시맵을 돌면서 수량을 체크하는 것이다.
 */
public class Lv_2_DiscountEvent {
    public static void main(String[] args) {
        solution(new String[]{"banana", "apple", "rice", "pork", "pot"}, new int[]{3, 2, 2, 2, 1}, new String[]{"chicken", "apple", "apple", "banana", "rice", "apple", "pork", "banana", "pork", "rice", "pot", "banana", "apple", "banana"});
    }

    /*
        테스트 1 〉	통과 (21.31ms, 109MB)
        테스트 2 〉	통과 (68.15ms, 123MB)
        테스트 3 〉	통과 (26.31ms, 97MB)
        테스트 4 〉	통과 (47.55ms, 113MB)
        테스트 5 〉	통과 (76.55ms, 102MB)
        테스트 6 〉	통과 (13.24ms, 93.8MB)
        테스트 7 〉	통과 (30.41ms, 116MB)
        테스트 8 〉	통과 (64.67ms, 131MB)
        테스트 9 〉	통과 (47.99ms, 94.6MB)
        테스트 10 〉	통과 (58.23ms, 118MB)
        테스트 11 〉	통과 (34.64ms, 87.6MB)
        테스트 12 〉	통과 (0.06ms, 78.5MB)
     */
    public static int solution(String[] want, int[] number, String[] discount) {

        int answer = 0;
        int wishQuantity = 0;

        // 원하는 리스트에 대한 해시맵 만들기
        Map<String, Integer> wishList = new HashMap<>();
        for (int i = 0; i < want.length; i++) {
            wishList.put(want[i], number[i]);
            wishQuantity += number[i];
        }

        for (int day = 0; day <= discount.length - wishQuantity; day++) {

            Map<String, Integer> tmpWishList = new HashMap<>(wishList);
            int tmpQuantity = wishQuantity;

            for (int checkIdx = day; checkIdx < wishQuantity + day; checkIdx++) {
                // 해당 날짜의 할인 품목이 위시리스트에 있다면,
                if (tmpWishList.containsKey(discount[checkIdx]) && tmpWishList.get(discount[checkIdx]) != 0) {
                    tmpWishList.put(discount[checkIdx], tmpWishList.get(discount[checkIdx]) - 1);
                    tmpQuantity--;
                } else {
                    break;
                }
            }

            if (tmpQuantity == 0) {
                answer++;
            }
        }

        return answer;
    }
}
