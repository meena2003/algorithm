package org.example.programmers.lv_1;

import java.util.*;

/**
 * 해시맵 정렬하는 법만 알고 있으면 그리 어렵지 않은 문제였다.
 * 하지만 생각보다 인텔리제이 기능을 많이 사용했는데, 그 이유는 사소한 부분에서 오타가 꽤 있었다.
 * 그리고 쉽게 생각할 수 있는 부분들도 간과했다.
 * 예를 들어서 단순히 작은지 확인만 하면 되는데, 굳이 마이너스를 한 뒤에 0보다 큰지 확인하려고 하는 것...
 * 또 이 문제의 관건은 바로 Map에 대한 정렬 부분이다. 정렬 부분에 대해 아직 취약한 게 보인다.
 *
 * 생각해보면 굳이 해시맵이 필요가 없다. 그냥 조건에 맞는 인덱스를 저장해 놓고, 해당 인덱스의 값들을 정렬하면 되는 거 아닌가..
 *
 * 스트림을 사용한 풀이 방법도 있던데, 굉장히 코드가 간편하지만, 성능에 있어서는 그리 좋아 보이진 않는다.
 */
public class Lv_1_DataAnalyze {
    public static void main(String[] args) {
        int[][] solution = solution(new int[][]{{1, 20300104, 100, 80}, {2, 20300804, 847, 37}, {3, 20300401, 10, 8}}, "date", 20300501, "remain");
        System.out.println("Arrays.toString(solution) = " + Arrays.toString(solution));
    }

    /*
        테스트 1 〉	통과 (3.24ms, 71.7MB)
        테스트 2 〉	통과 (7.20ms, 87.9MB)
        테스트 3 〉	통과 (1.44ms, 71.9MB)
        테스트 4 〉	통과 (1.22ms, 70.2MB)
        테스트 5 〉	통과 (1.38ms, 79.3MB)
        테스트 6 〉	통과 (1.79ms, 82.6MB)
        테스트 7 〉	통과 (1.45ms, 66.3MB)
        테스트 8 〉	통과 (1.39ms, 66.8MB)
        테스트 9 〉	통과 (1.75ms, 83.2MB)
        테스트 10 〉	통과 (0.75ms, 79.7MB)
        테스트 11 〉	통과 (4.73ms, 88.7MB)
        테스트 12 〉	통과 (2.10ms, 74.8MB)
        테스트 13 〉	통과 (1.23ms, 70.4MB)
        테스트 14 〉	통과 (1.66ms, 69.9MB)
        테스트 15 〉	통과 (0.92ms, 74.6MB)
        테스트 16 〉	통과 (0.99ms, 75.6MB)
        테스트 17 〉	통과 (4.17ms, 88.8MB)
        테스트 18 〉	통과 (2.57ms, 73.5MB)
        테스트 19 〉	통과 (0.61ms, 75.9MB)
        테스트 20 〉	통과 (1.39ms, 73.3MB)
        테스트 21 〉	통과 (1.77ms, 79.9MB)
        테스트 22 〉	통과 (2.32ms, 74.8MB)
        테스트 23 〉	통과 (2.11ms, 87.9MB)
        테스트 24 〉	통과 (1.03ms, 71.3MB)
        테스트 25 〉	통과 (1.10ms, 90.4MB)
        테스트 26 〉	통과 (1.45ms, 75.3MB)
        테스트 27 〉	통과 (1.14ms, 81.2MB)
        테스트 28 〉	통과 (1.78ms, 79.3MB)
        테스트 29 〉	통과 (0.98ms, 77.1MB)
        테스트 30 〉	통과 (0.98ms, 75.2MB)
        테스트 31 〉	통과 (1.04ms, 80.6MB)
        테스트 32 〉	통과 (1.41ms, 80.7MB)
        테스트 33 〉	통과 (1.93ms, 66.1MB)
        테스트 34 〉	통과 (1.07ms, 77.6MB)
        테스트 35 〉	통과 (2.07ms, 90.4MB)
        테스트 36 〉	통과 (0.99ms, 79.6MB)
        테스트 37 〉	통과 (1.74ms, 77.7MB)
        테스트 38 〉	통과 (1.27ms, 72.3MB)
        테스트 39 〉	통과 (1.41ms, 81.5MB)
        테스트 40 〉	통과 (1.59ms, 73.1MB)
        테스트 41 〉	통과 (1.23ms, 77.5MB)
        테스트 42 〉	통과 (1.63ms, 77.8MB)
        테스트 43 〉	통과 (1.14ms, 78.5MB)
        테스트 44 〉	통과 (1.63ms, 80.7MB)
        테스트 45 〉	통과 (2.51ms, 87.4MB)
        테스트 46 〉	통과 (1.85ms, 81.7MB)
        테스트 47 〉	통과 (1.49ms, 79.8MB)
        테스트 48 〉	통과 (1.13ms, 94MB)
        테스트 49 〉	통과 (1.14ms, 76.1MB)
        테스트 50 〉	통과 (1.90ms, 77.6MB)
     */
    public static int[][] solution(int[][] data, String ext, int val_ext, String sort_by) {
        String[] array = new String[]{"code", "date", "maximum", "remain"};

        int filter = 0;
        int sort = 0;
        for (int i = 0; i < array.length; i++) {
            if (ext.equals(array[i])) {
                filter = i;
            }
            if (sort_by.equals(array[i])) {
                sort = i;
            }
        }

        Map<Integer, Integer> filteredDatas = new HashMap<>();

        for (int i = 0; i < data.length; i++) {
            if (val_ext - data[i][filter] > 0) {
                filteredDatas.put(i, data[i][sort]);
            }
        }

        List<Integer> sortedDatas = new ArrayList<>(filteredDatas.keySet());
        sortedDatas.sort((o1, o2) -> filteredDatas.get(o1).compareTo(filteredDatas.get(o2)));

        int[][] answer = new int[sortedDatas.size()][4];
        for (int i = 0; i < answer.length; i++) {
            answer[i] = data[sortedDatas.get(i)];
        }

        return answer;
    }

    public int[][] solution2(int[][] data, String ext, int val_ext, String sort_by) {

        String[] arr = {"code","date","maximum","remain"};
        List<String> columnList = Arrays.asList(arr);
        int extIdx = columnList.indexOf(ext);
        int sortIdx = columnList.indexOf(sort_by);
        int[][] answer = Arrays.stream(data).filter(o1 -> o1[extIdx] < val_ext)
                .sorted((o1 ,o2) -> o1[sortIdx]-o2[sortIdx]).toArray(int[][]::new);

        return answer;
    }
}
