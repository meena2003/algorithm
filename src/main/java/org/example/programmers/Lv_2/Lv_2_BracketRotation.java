package org.example.programmers.Lv_2;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/**
 * 결국은 스택을 사용하는 거였다.
 * 오랜만에 사용하는 거라 스택의 메소드에 대해서 좀 헷갈렸다.
 * push(), pop(), empty(), peek() 메소드를 알아야 풀 수 있다.
 *
 * 괄호가 회전한다는 것은 두 가지 방법을 고안했다. (배열로 하면 모든 원소들을 움직여야 하기 때문에 비효율적이라 생각했다)
 * 1. 문자열을 새롭게 만드는 것
 * 2. 리스트의 원소를 추가, 삭제하는 것
 *
 * 테스트를 해보니깐, 리스트로 푸는 게 훨씬 성능이 좋았다.
 * 그 이유는 String은 매번 객체를 생성해야 하기 때문이다. 반면 list는 인덱스만 교체하면 된다.
 */
public class Lv_2_BracketRotation {
    public static void main(String[] args) {
        solutionByString("[](){}");
    }

    private static Stack<String> stack = new Stack();

    /**
     * 문자열로 풀기!
     */
    /*
        테스트 1 〉	통과 (230.61ms, 146MB)
        테스트 2 〉	통과 (213.53ms, 143MB)
        테스트 3 〉	통과 (251.54ms, 146MB)
        테스트 4 〉	통과 (245.49ms, 132MB)
        테스트 5 〉	통과 (384.84ms, 150MB)
        테스트 6 〉	통과 (330.48ms, 132MB)
        테스트 7 〉	통과 (367.30ms, 126MB)
        테스트 8 〉	통과 (449.67ms, 148MB)
        테스트 9 〉	통과 (463.81ms, 128MB)
        테스트 10 〉	통과 (271.00ms, 155MB)
        테스트 11 〉	통과 (286.43ms, 152MB)
        테스트 12 〉	통과 (0.02ms, 75.6MB)
        테스트 13 〉	통과 (8.37ms, 79MB)
        테스트 14 〉	통과 (7.72ms, 73.5MB)
     */
    public static int solutionByString(String s) {

        int answer = 0;

        for (int i = 0; i < s.length() - 1; i++) {
            if (isCorrectBracketsByString(s)) {
                answer++;
            }
            s = s.concat(s.charAt(0) + "").substring(1);
        }

        return answer;
    }

    private static boolean isCorrectBracketsByString(String s) {
        stack.clear();

        for (String nextBracket : s.split("")) {
            if (stack.empty()) {
                stack.push(nextBracket);
            } else {
                String preBracket = stack.peek();

                if (preBracket.equals("(") && nextBracket.equals(")")) {
                    stack.pop();
                } else if (preBracket.equals("[") && nextBracket.equals("]")) {
                    stack.pop();
                } else if (preBracket.equals("{") && nextBracket.equals("}")) {
                    stack.pop();
                } else {
                    stack.push(nextBracket);
                }
            }
        }

        if (stack.empty()) {
            return true;
        }
        return false;
    }


    /**
     * 리스트로 풀기!
     */
    /*
        테스트 1 〉	통과 (128.56ms, 91.4MB)
        테스트 2 〉	통과 (110.37ms, 80.6MB)
        테스트 3 〉	통과 (88.41ms, 88.7MB)
        테스트 4 〉	통과 (98.64ms, 85.5MB)
        테스트 5 〉	통과 (138.43ms, 84.9MB)
        테스트 6 〉	통과 (88.90ms, 79.9MB)
        테스트 7 〉	통과 (103.26ms, 78MB)
        테스트 8 〉	통과 (108.95ms, 91.2MB)
        테스트 9 〉	통과 (91.33ms, 84MB)
        테스트 10 〉	통과 (90.10ms, 72.7MB)
        테스트 11 〉	통과 (77.55ms, 80.6MB)
        테스트 12 〉	통과 (0.11ms, 83MB)
        테스트 13 〉	통과 (0.21ms, 78.3MB)
        테스트 14 〉	통과 (0.16ms, 74.2MB)
     */
    public int solutionByList(String s) {

        int answer = 0;
        List<String> list = new ArrayList<>();

        for (String str : s.split("")) {
            list.add(str);
        }

        for (int i = 0; i < s.length() - 1; i++) {
            if (isCorrectBracketsByList(list)) {
                answer++;
            }
            list.add(list.get(0));
            list.remove(0);
        }

        return answer;
    }

    private boolean isCorrectBracketsByList(List<String> list) {
        stack.clear();

        for (String nextBracket : list) {
            if (stack.empty()) {
                stack.push(nextBracket);
            } else {
                String preBracket = stack.peek();

                if (preBracket.equals("(") && nextBracket.equals(")")) {
                    stack.pop();
                } else if (preBracket.equals("[") && nextBracket.equals("]")) {
                    stack.pop();
                } else if (preBracket.equals("{") && nextBracket.equals("}")) {
                    stack.pop();
                } else {
                    stack.push(nextBracket);
                }
            }
        }

        if (stack.empty()) {
            return true;
        }
        return false;
    }
}
