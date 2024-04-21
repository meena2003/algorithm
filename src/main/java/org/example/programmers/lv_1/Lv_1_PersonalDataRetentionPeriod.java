package org.example.programmers.lv_1;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 크게 어려운 문제는 아니었다. 대신 꼬아서 냈기 때문에 사소하게 신경써야 하는 부분들이 많았다.
 * - "."는 "\\."로 해야 정규식에 해당됐다.
 * - 매개변수로 받는 개월수는 1~100으로 12개월 이상일 수 있다.
 * <p>
 * 나머지는 일부터 차근차근 풀어가면 된다.
 * <p>
 * 1. 정답 배열은 크기를 알지 못하기 때문에 일단 리스트로 만들고 나중에 배열로 변환한다.
 * 2. 정답에 인덱스가 들어가야 하기 때문에 for문으로 privacies를 탐색한다.
 * 3. 이중 포문으로 만들지 않기 위해서 terms는 해시맵으로 만든다.
 * 4. privacies를 탐색하면서 로직을 수행한다.
 */
public class Lv_1_PersonalDataRetentionPeriod {
    public static void main(String[] args) {
        solution("2022.05.19", new String[]{"A 6", "B 12", "C 3"}, new String[]{"2021.05.02 A", "2021.07.01 B", "2022.02.19 C", "2022.02.20 C"});
    }

    /*
        테스트 1 〉	통과 (0.10ms, 72.9MB)
        테스트 2 〉	통과 (0.22ms, 77.9MB)
        테스트 3 〉	통과 (0.18ms, 81MB)
        테스트 4 〉	통과 (0.15ms, 76.9MB)
        테스트 5 〉	통과 (0.23ms, 75MB)
        테스트 6 〉	통과 (0.39ms, 71.2MB)
        테스트 7 〉	통과 (0.28ms, 73.4MB)
        테스트 8 〉	통과 (0.39ms, 77.7MB)
        테스트 9 〉	통과 (1.29ms, 73.4MB)
        테스트 10 〉	통과 (0.89ms, 78.1MB)
        테스트 11 〉	통과 (0.79ms, 73.8MB)
        테스트 12 〉	통과 (1.28ms, 78.6MB)
        테스트 13 〉	통과 (1.66ms, 73.5MB)
        테스트 14 〉	통과 (1.12ms, 75.6MB)
        테스트 15 〉	통과 (1.13ms, 75.4MB)
        테스트 16 〉	통과 (1.43ms, 84.2MB)
        테스트 17 〉	통과 (1.58ms, 76.8MB)
        테스트 18 〉	통과 (1.87ms, 76.6MB)
        테스트 19 〉	통과 (1.77ms, 77.8MB)
        테스트 20 〉	통과 (1.23ms, 84.7MB)
     */
    public static int[] solution(String today, String[] terms, String[] privacies) {
        List<Integer> list = new ArrayList<>();

        // terms를 해시맵으로 변환
        Map<String, Integer> termMap = new HashMap<>();
        for (String term : terms) {
            String[] array = term.split(" ");
            termMap.put(array[0], Integer.parseInt(array[1]));
        }

        // privacies를 탐색
        for (int i = 0; i < privacies.length; i++) {

            String[] info = privacies[i].split(" ");
            String term = info[1];
            String period = info[0];

            String[] date = period.split("\\.");
            int[] intDate = new int[3];
            for (int idx = 0; idx < intDate.length; idx++) {
                intDate[idx] = Integer.parseInt(date[idx]);
            }

            // 일 계산
            if (intDate[2] - 1 == 0) {
                intDate[2] = 28;
                intDate[1] = intDate[1] - 1;
            } else {
                intDate[2] = intDate[2] - 1;
            }

            // 월 계산
            int plusMonth = termMap.get(term) % 12;
            if (intDate[1] + plusMonth > 12) {
                intDate[0] = intDate[0] + 1;
                intDate[1] = intDate[1] + plusMonth - 12;
            } else {
                intDate[1] = intDate[1] + plusMonth;
            }

            // 연 계산
            int plusYear = termMap.get(term) / 12;
            intDate[0] = intDate[0] + plusYear;

            // 비교하기
            String[] todayDate = today.split("\\.");
            int[] intToday = new int[3];
            for (int idx = 0; idx < intToday.length; idx++) {
                intToday[idx] = Integer.parseInt(todayDate[idx]);
            }

            if (intToday[0] > intDate[0]) {
                list.add(i + 1);
            } else if (intToday[0] == intDate[0]) {
                if (intToday[1] > intDate[1]) {
                    list.add(i + 1);
                } else if (intToday[1] == intDate[1]) {
                    if (intToday[2] > intDate[2]) {
                        list.add(i + 1);
                    }
                }
            }
        }

        int[] answer = new int[list.size()];
        for (int i = 0; i < answer.length; i++) {
            answer[i] = list.get(i);
        }

        return answer;
    }

    /**
     * 다른 사람의 풀이 방법...!!
     * 반드시 연,월,일 형식을 맞출 필요 없이 단순히 일괄 일로 계산해서 비교하는 방법이다.
     * 확실히 성능도 더 좋고, 또 필요없는 형변환도 필요 없어서 개발 속도도 빠르다.
     * 틀에 박힌 사고를 없애도록 하자!
     */
    /*
        테스트 1 〉	통과 (0.10ms, 77.5MB)
        테스트 2 〉	통과 (0.17ms, 77.1MB)
        테스트 3 〉	통과 (0.14ms, 74.8MB)
        테스트 4 〉	통과 (0.21ms, 82.4MB)
        테스트 5 〉	통과 (0.18ms, 75.8MB)
        테스트 6 〉	통과 (0.34ms, 89.4MB)
        테스트 7 〉	통과 (0.21ms, 78.8MB)
        테스트 8 〉	통과 (0.39ms, 73.5MB)
        테스트 9 〉	통과 (0.54ms, 75.6MB)
        테스트 10 〉	통과 (0.79ms, 71.8MB)
        테스트 11 〉	통과 (0.72ms, 74.5MB)
        테스트 12 〉	통과 (0.85ms, 74.3MB)
        테스트 13 〉	통과 (1.41ms, 79.9MB)
        테스트 14 〉	통과 (0.63ms, 79.7MB)
        테스트 15 〉	통과 (0.78ms, 73.3MB)
        테스트 16 〉	통과 (1.05ms, 78MB)
        테스트 17 〉	통과 (0.90ms, 76.3MB)
        테스트 18 〉	통과 (1.31ms, 77.1MB)
        테스트 19 〉	통과 (1.08ms, 75.7MB)
        테스트 20 〉	통과 (0.92ms, 77.3MB)
     */
    public static int[] solution2(String today, String[] terms, String[] privacies) {
        List<Integer> list = new ArrayList<>();
        Map<String, Integer> termMap = new HashMap<>();
        int date = getDate(today);

        for (String s : terms) {
            String[] term = s.split(" ");

            termMap.put(term[0], Integer.parseInt(term[1]));
        }
        for (int i = 0; i < privacies.length; i++) {
            String[] privacy = privacies[i].split(" ");

            if (getDate(privacy[0]) + (termMap.get(privacy[1]) * 28) <= date) {
                list.add(i + 1);
            }
        }

        int[] answer = new int[list.size()];
        for (int i = 0; i < answer.length; i++) {
            answer[i] = list.get(i);
        }
        return answer;
    }

    private static int getDate(String today) {
        String[] date = today.split("\\.");
        int year = Integer.parseInt(date[0]);
        int month = Integer.parseInt(date[1]);
        int day = Integer.parseInt(date[2]);
        return (year * 12 * 28) + (month * 28) + day;
    }
}
