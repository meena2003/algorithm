package org.example.programmers.lv_2;

import java.util.HashMap;

/**
 * 문자열은 함정이다.
 * 결국 경우의 수를 구하는 문제다.
 * 각 카테고리별로 몇 종류의 옷이 있는지 확인하고,
 * 각 옷마다 몇 개의 경우의 수가 있는지 확인한다. 카테고리마다 +1하는 건 해당 카테고리에서 한 종류도 고르지 않았을 때를 의미한다.
 * 그리고 각 카테고리 별 경우의 수를 곱한다.
 * 마지막에 -1은 모든 카테고리에서 하나도 고르지 않는 경우를 제외하는 것이다.
 */
public class Lv_2_Clothes {
    public static void main(String[] args) {
        solution(new String[][]{{"yellow_hat", "headgear"}, {"blue_sunglasses", "eyewear"}, {"green_turban", "headgear"}});
    }

    public static int solution(String[][] clothes) {
        HashMap<String, Integer> clothMap = new HashMap<>();

        for (String[] cloth : clothes) {
            clothMap.put(cloth[1], clothMap.getOrDefault(cloth[1], 0) + 1);
        }

        int combination = 1;
        for (int count : clothMap.values()) {
            combination *= count + 1;
        }

        return combination - 1;
    }
}
