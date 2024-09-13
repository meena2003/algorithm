package org.example.programmers.lv_2;

/**
 * 진짜 너무 스트레스 받는다...
 * 처음에 규칙을 찾으려고 애쓰다가 실패해서 배열로 만들어서 풀려고 진짜 머리를 쮜어 뜯으며 풀었는데
 * 결과적으론 배열로 만들어 풀면 런타임 에러...
 * <p>
 * 결과적으로 찾아보니 규칙을 찾는 거였다.
 * left 시작점이 2차원 배열의 어떤 x, y 좌표가 되는지 파악한 뒤,
 * 둘 중에 높은 숫자 + 1이 값이 된다.
 * <p>
 * 열받는 건 i로 하면 또 런타임 에러가 터지는 것.
 * long 타입으로 해야 한다... 이런 저런 지저분하고 짜증나는 문제... 아 열받는다.
 */
public class Lv_2_ArraySquareCutter {
    public static void main(String[] args) {
        solution(3, 2, 5);
    }

    /*
        테스트 1 〉	통과 (5.05ms, 92.6MB)
        테스트 2 〉	통과 (5.35ms, 103MB)
        테스트 3 〉	통과 (7.75ms, 94.5MB)
        테스트 4 〉	통과 (0.03ms, 72.6MB)
        테스트 5 〉	통과 (0.03ms, 78.1MB)
        테스트 6 〉	통과 (4.82ms, 98.1MB)
        테스트 7 〉	통과 (5.29ms, 108MB)
        테스트 8 〉	통과 (5.07ms, 104MB)
        테스트 9 〉	통과 (5.00ms, 106MB)
        테스트 10 〉	통과 (5.30ms, 94.9MB)
        테스트 11 〉	통과 (7.63ms, 90.3MB)
        테스트 12 〉	통과 (4.43ms, 94.7MB)
        테스트 13 〉	통과 (7.40ms, 105MB)
        테스트 14 〉	통과 (4.64ms, 101MB)
        테스트 15 〉	통과 (7.15ms, 90.9MB)
        테스트 16 〉	통과 (4.91ms, 92.4MB)
        테스트 17 〉	통과 (6.53ms, 109MB)
        테스트 18 〉	통과 (5.21ms, 107MB)
        테스트 19 〉	통과 (4.96ms, 105MB)
        테스트 20 〉	통과 (4.77ms, 108MB)
     */
    public static int[] solution(int n, long left, long right) {
        int[] answer = new int[(int) (right - left) + 1];

        for (long i = 0; left <= right; left++, i++) {
            int x = (int) (left / (long) n);
            int y = (int) (left / (long) n);

            int value = Math.max(x, y) + 1;
            answer[(int) i] = value;
        }

        return answer;
    }

    /*
        배열로 풀기 실패...
     */
    public int[] solutionByArray(int n, long left, long right) {

        int intLeft = (int) left;
        int intRight = (int) right;

        int[] answer = new int[intRight - intLeft + 1];
        int[] array = new int[(int) Math.pow(n, 2)];

        for (int i = 0, j = 1; i < (int) Math.pow(n, 2); i++, j = i / n + 1) {

            int a = i % n + 1;

            if (a <= j) {
                array[i] = j;
            } else {
                array[i] = a;
            }
        }

        int gap = intRight - intLeft;
        for (int i = 0; i <= gap; i++) {
            answer[i] = array[intLeft++];
        }

        return answer;
    }
}

