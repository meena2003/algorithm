package org.example.programmers;

import java.util.HashMap;
import java.util.Map;

/**
 * 혼자 힘으로 한 번에 풀었다!!
 * 기분이 좋다 :)
 * 일단 단순하게 생각하면 중첩 for문이 너무 많아진다.
 * 따라서 keymap의 특성을 잘 분석해야 한다.
 * 어차피 최소한의 클릭 수만 해당되기 때문에 HashMap을 통해서 해당 글자가 몇 번 눌러야 되는지 계산해둔다.
 * 그리고 targets의 글자을 하나씩 map에 비교하면서 최소 값을 더하면 된다.
 */
public class Lv_1_RoughKeyboard {
    public static void main(String[] args) {
        solution(new String[]{"ABACD", "BCEFD"}, new String[]{"ABCD","AABB"});
    }

    /*
        테스트 1 〉	통과 (0.54ms, 75.7MB)
        테스트 2 〉	통과 (0.48ms, 74.3MB)
        테스트 3 〉	통과 (0.60ms, 77.4MB)
        테스트 4 〉	통과 (0.63ms, 75.3MB)
        테스트 5 〉	통과 (0.60ms, 74.6MB)
        테스트 6 〉	통과 (0.71ms, 76.5MB)
        테스트 7 〉	통과 (0.52ms, 77.1MB)
        테스트 8 〉	통과 (0.52ms, 72.6MB)
        테스트 9 〉	통과 (0.54ms, 77.1MB)
        테스트 10 〉	통과 (0.51ms, 80.2MB)
        테스트 11 〉	통과 (0.17ms, 75.5MB)
        테스트 12 〉	통과 (0.11ms, 75.8MB)
        테스트 13 〉	통과 (0.13ms, 73.2MB)
        테스트 14 〉	통과 (1.46ms, 77.7MB)
        테스트 15 〉	통과 (1.83ms, 78.6MB)
        테스트 16 〉	통과 (2.70ms, 73.9MB)
        테스트 17 〉	통과 (2.19ms, 73.1MB)
        테스트 18 〉	통과 (1.34ms, 77MB)
        테스트 19 〉	통과 (2.22ms, 80.5MB)
        테스트 20 〉	통과 (1.36ms, 75.6MB)
        테스트 21 〉	통과 (1.56ms, 77.8MB)
        테스트 22 〉	통과 (1.89ms, 70MB)
        테스트 23 〉	통과 (1.66ms, 72.6MB)
     */
    public static int[] solution(String[] keymap, String[] targets) {

        int[] answer = new int[targets.length];

        // keymap에 있는 알파벳들의 가장 최소값을 map에 저장해 둔다.
        Map<Character, Integer> map = new HashMap<>();
        for (String keypad : keymap) {
            for (int i = 0; i < keypad.length(); i++) {
                char c = keypad.charAt(i);
                if (!map.containsKey(c) || map.get(c) > i + 1) {
                    map.put(c, i + 1);
                }
            }
        }

        // targets를 구분 및 비교
        for (int i = 0; i < targets.length; i++) {
            String target = targets[i];
            char[] charArray = target.toCharArray();
            for (char c : charArray) {
                if (map.containsKey(c)) {
                    answer[i] = answer[i] + map.get(c);
                } else {
                    answer[i] = -1;
                    break;
                }
            }
        }

        return answer;
    }
}
