package org.example.programmers;

import java.util.HashMap;
import java.util.Map;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 * 처음 풀었던 방식과 두 번째 코드를 비교하면 풀이 방식은 비슷하다.
 * 하지만 빠른 성능과 방식에 있어선 두 번째 코드가 더 깔끔하고 정교해 보인다.
 * 성격 지표와 점수표를 배열로 관리한 것이 내가 생각하지 못한 방향이다.
 */
public class Lv_1_PersonalityTypeTest {

    /*
    테스트 1 〉	통과 (1.73ms, 71.6MB)
    테스트 2 〉	통과 (1.89ms, 79MB)
    테스트 3 〉	통과 (2.44ms, 83.6MB)
    테스트 4 〉	통과 (2.69ms, 76.5MB)
    테스트 5 〉	통과 (1.65ms, 73.8MB)
    테스트 6 〉	통과 (2.43ms, 80.1MB)
    테스트 7 〉	통과 (2.09ms, 76.2MB)
    테스트 8 〉	통과 (3.75ms, 79.8MB)
    테스트 9 〉	통과 (3.44ms, 79.9MB)
    테스트 10 〉	통과 (3.29ms, 74.9MB)
    테스트 11 〉	통과 (3.90ms, 76.3MB)
    테스트 12 〉	통과 (6.70ms, 78MB)
    테스트 13 〉	통과 (9.32ms, 82MB)
    테스트 14 〉	통과 (9.39ms, 88.5MB)
    테스트 15 〉	통과 (8.39ms, 87.8MB)
    테스트 16 〉	통과 (8.77ms, 79.6MB)
    테스트 17 〉	통과 (11.80ms, 85.9MB)
    테스트 18 〉	통과 (7.82ms, 79.4MB)
    테스트 19 〉	통과 (10.45ms, 84MB)
    테스트 20 〉	통과 (9.05ms, 78.8MB)
    */
    public String mySolution(String[] survey, int[] choices) {

        Map<String, Integer> scores = Stream.of(new Object[][]{
                {"R", 0}, {"T", 0}, {"C", 0}, {"F", 0},
                {"J", 0}, {"M", 0}, {"A", 0}, {"N", 0},
        }).collect(Collectors.toMap(
                data -> (String) data[0],
                data -> (Integer) data[1]
        ));

        for (int i = 0; i < survey.length; i++) {
            String[] questions = survey[i].split("");
            int answer = choices[i];

            if (answer == 4) { // 4번이라면,
                continue;
            } else if (answer < 4) { // 1,2,3번이라면 왼쪽 알파벳을
                int score = 0;
                switch (answer) {
                    case 3:
                        answer = 1;
                        break;
                    case 2:
                        answer = 2;
                        break;
                    case 1:
                        answer = 3;
                        break;
                }
                scores.put(questions[0], scores.get(questions[0]) + answer);
            } else { // 5,6,7번 이라면 오른쪽 알파벳을
                scores.put(questions[1], scores.get(questions[1]) + answer - 4);
            }
        }

        StringBuilder sb = new StringBuilder();

        if (scores.get("R") == scores.get("T")) {
            sb.append("R");
        } else if (scores.get("R").compareTo(scores.get("T")) >= 0) {
            sb.append("R");
        } else {
            sb.append("T");
        }

        if (scores.get("C") == scores.get("F")) {
            sb.append("C");
        } else if (scores.get("C").compareTo(scores.get("F")) >= 0) {
            sb.append("C");
        } else {
            sb.append("F");
        }

        if (scores.get("J") == scores.get("M")) {
            sb.append("J");
        } else if (scores.get("J").compareTo(scores.get("M")) >= 0) {
            sb.append("J");
        } else {
            sb.append("M");
        }

        if (scores.get("A") == scores.get("N")) {
            sb.append("A");
        } else if (scores.get("A").compareTo(scores.get("N")) >= 0) {
            sb.append("A");
        } else {
            sb.append("N");
        }

        return sb.toString();
    }

    /*
    테스트 1 〉	통과 (0.13ms, 72.7MB)
    테스트 2 〉	통과 (0.20ms, 76.3MB)
    테스트 3 〉	통과 (0.12ms, 77.5MB)
    테스트 4 〉	통과 (0.14ms, 79.3MB)
    테스트 5 〉	통과 (0.17ms, 84.2MB)
    테스트 6 〉	통과 (0.23ms, 76.7MB)
    테스트 7 〉	통과 (0.23ms, 77.4MB)
    테스트 8 〉	통과 (0.14ms, 72.1MB)
    테스트 9 〉	통과 (0.27ms, 78.3MB)
    테스트 10 〉	통과 (0.24ms, 77.4MB)
    테스트 11 〉	통과 (0.23ms, 70.2MB)
    테스트 12 〉	통과 (1.09ms, 66.6MB)
    테스트 13 〉	통과 (0.61ms, 78.9MB)
    테스트 14 〉	통과 (0.65ms, 82.5MB)
    테스트 15 〉	통과 (0.69ms, 88.9MB)
    테스트 16 〉	통과 (0.63ms, 80.5MB)
    테스트 17 〉	통과 (0.77ms, 75.2MB)
    테스트 18 〉	통과 (0.50ms, 81.5MB)
    테스트 19 〉	통과 (0.51ms, 74MB)
    테스트 20 〉	통과 (0.53ms, 89.5MB)
     */
    public String anotherSolution(String[] survey, int[] choices) {
        String answer = "";
        char [][] type = {{'R', 'T'}, {'C', 'F'}, {'J', 'M'}, {'A', 'N'}};
        int [] score = {0, 3, 2, 1, 0, 1, 2, 3};
        HashMap<Character, Integer> point = new HashMap<Character, Integer>();

        // 점수 기록할 배열 초기화
        for (char[] t : type) {
            point.put(t[0], 0);
            point.put(t[1], 0);
        }

        // 점수 기록
        for (int idx = 0; idx < choices.length; idx++){
            if(choices[idx] > 4){
                point.put(survey[idx].charAt(1), point.get(survey[idx].charAt(1)) + score[choices[idx]]);
            } else {
                point.put(survey[idx].charAt(0), point.get(survey[idx].charAt(0)) + score[choices[idx]]);
            }
        }

        StringBuilder sb = new StringBuilder();

        // 지표 별 점수 비교 후 유형 기입
        for (char[] t : type) {
            sb.append((point.get(t[1]) <= point.get(t[0])) ? t[0] : t[1]);
        }

        return sb.toString();
    }
}
