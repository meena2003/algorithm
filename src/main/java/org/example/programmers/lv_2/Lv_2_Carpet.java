package org.example.programmers.lv_2;

/**
 * 과거에 풀었던 문제인데 복습 차원으로 다시 풀었다.
 * 일단 원리를 파악하는 것이 중요하다.
 * 가로 * 세로 = 총 사이즈다.
 * 그리고 정답은 사이즈의 약수들 중 하나가 된다.
 *
 * 반복문으로 해당 약수들을 구할 때, 사이즈의 제곱근까지만 구하면 된다. 왜냐하면 나머지는 순서만 다를 뿐 동일하기 때문이다.
 * 중요한 건, yellow 개수의 조건이다.
 * 약수들 중, (a - 2) * (b - 2)가 yellow의 개수가 된다.
 * 그 이유는, 사각형일 때 가로에서 2개, 세로에서 2개, 즉 '모서리'를 제외하고 가로 * 세로가 yellow의 영역이 되기 때문이다.
 */
public class Lv_2_Carpet {
    public static void main(String[] args) {

    }

    /*
    테스트 1 〉	통과 (0.05ms, 82.5MB)
    테스트 2 〉	통과 (0.03ms, 80.1MB)
    테스트 3 〉	통과 (0.06ms, 72.1MB)
    테스트 4 〉	통과 (0.03ms, 76.4MB)
    테스트 5 〉	통과 (0.04ms, 74.4MB)
    테스트 6 〉	통과 (0.04ms, 79.5MB)
    테스트 7 〉	통과 (0.05ms, 74MB)
    테스트 8 〉	통과 (0.09ms, 73.7MB)
    테스트 9 〉	통과 (0.09ms, 74.3MB)
    테스트 10 〉	통과 (0.05ms, 75.7MB)
    테스트 11 〉	통과 (0.09ms, 77.2MB)
    테스트 12 〉	통과 (0.02ms, 91.6MB)
    테스트 13 〉	통과 (0.03ms, 77.5MB)
     */
    public int[] solution(int brown, int yellow) {
        int size = brown + yellow;
        int[] answer = new int[2];

        for (int height = 3, width = 0; height <= Math.sqrt(size); height++) {

            if (size % height != 0) {
                continue;
            }

            width = size / height;

            // 모서리를 제외한 영역이 노란색인 경우가 정답이다.
            if ((width - 2) * (height - 2) == yellow) {
                answer[0] = width;
                answer[1] = height;
            }
        }

        return answer;
    }
}
