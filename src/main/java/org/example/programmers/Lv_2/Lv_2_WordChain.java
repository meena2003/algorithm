package org.example.programmers.Lv_2;

import java.util.HashSet;
import java.util.Set;

/**
 * 아.. 다시 풀었을 때 쉽다고 생각했는데, 이런 망신도 없다.
 * 스스로에게 너무 아쉽다.
 * 어떻게 풀어야 하는지 감이 오는데도, 디테일한 면에서 풀지 못해서 결국 과거의 코드를 보고야 말았다.
 * 그래도 앞으로 이런 문제를 만났을 때 어떻게 해결하면 좋을지 학습했다고 생각하자.
 *
 * 관건은 % 와 / 연산자이다. 해당 연산자가 가지는 의미를 잘 이해해야 한다.
 * 누가 틀렸냐는 것은 반복한 횟수에 사람 인원을 % 하는 것이다. 어차피 인원은 계속 반복하기 때문이다. 나머지는 나누는 수보다 작을 수밖에 없다.
 * 언제 틀렸냐는 것은 몇 번 반복했냐는 것이니 / 를 하면 된다. 여기서 또 나의 실수는, 몇 번째에 틀렸냐를 구했다는 것이다.
 * 정답은 몇 번째 사이클 때를 구해야 하는데 말이다...
 * + 1을 하는 이유는 결국 게임이 진행된 횟수는 인덱스 0부터 시작하기 때문에 +1을 해줘야 한다.
 *
 * 그리고 첫 인덱스르 1로 시작하고, 이전 단어를 -1로 표시하는 것도 잘 기억하자.
 * 그래야 마지막 인덱스 바운더리 예외가 발생하지 않는다.
 *
 * 너무 아쉬운 문제다.
 */
public class Lv_2_WordChain {
    public static void main(String[] args) {
        solution(5, new String[]{"hello", "observe", "effect", "take", "either", "recognize", "encourage", "ensure", "establish", "hang", "gather", "refer", "reference", "estimate", "executive"});
    }

    /*
        테스트 1 〉	통과 (0.04ms, 74.5MB)
        테스트 2 〉	통과 (0.05ms, 76.9MB)
        테스트 3 〉	통과 (0.03ms, 72.2MB)
        테스트 4 〉	통과 (0.09ms, 76MB)
        테스트 5 〉	통과 (0.07ms, 73.8MB)
        테스트 6 〉	통과 (0.04ms, 72.9MB)
        테스트 7 〉	통과 (0.06ms, 72MB)
        테스트 8 〉	통과 (0.05ms, 72.6MB)
        테스트 9 〉	통과 (0.05ms, 72.9MB)
        테스트 10 〉	통과 (0.06ms, 75MB)
        테스트 11 〉	통과 (0.05ms, 72.1MB)
        테스트 12 〉	통과 (0.05ms, 75.5MB)
        테스트 13 〉	통과 (0.04ms, 77.2MB)
        테스트 14 〉	통과 (0.05ms, 73MB)
        테스트 15 〉	통과 (0.06ms, 76.5MB)
        테스트 16 〉	통과 (0.03ms, 74.4MB)
        테스트 17 〉	통과 (0.04ms, 76.3MB)
        테스트 18 〉	통과 (0.04ms, 70.7MB)
        테스트 19 〉	통과 (0.06ms, 76.7MB)
        테스트 20 〉	통과 (0.09ms, 81.8MB)
     */
    public static int[] solution(int n, String[] words) {

        Set<String> set = new HashSet<>();
        int count = 1;

        for (; count < words.length; count++) {
            String preWord = words[count - 1];
            String nextWord = words[count];

            set.add(preWord);
            if (set.contains(nextWord)) {
                break;
            } else if (preWord.charAt(preWord.length() - 1) != nextWord.charAt(0)) {
                break;
            }
        }

        int[] answer = new int[2];
        if (count != words.length) {
            answer[0] = count % n + 1;
            answer[1] = count / n + 1;
        }

        return answer;
    }
}
