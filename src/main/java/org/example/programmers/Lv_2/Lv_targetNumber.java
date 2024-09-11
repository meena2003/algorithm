package org.example.programmers.Lv_2;

public class Lv_targetNumber {
    public static void main(String[] args) {
        solution(new int[]{1, 1, 1, 1, 1}, 3);
    }

    public static int solution(int[] numbers, int target) {
        return dfs(numbers, target, 0, 0);
    }

    private static int dfs(int[] numbers, int target, int index, int sum) {
        // 모든 숫자를 다 사용했을 때
        if (index == numbers.length) {
            // 합계가 타겟 넘버와 같은지 확인
            if (sum == target) {
                return 1;  // 타겟과 같으면 1을 반환 (카운트 1 증가)
            } else {
                return 0;  // 같지 않으면 0을 반환
            }
        }

        // 현재 숫자를 더하거나 빼는 두 가지 경우를 재귀적으로 호출
        return dfs(numbers, target, index + 1, sum + numbers[index])
                + dfs(numbers, target, index + 1, sum - numbers[index]);
    }
}
