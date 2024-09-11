package org.example.programmers.lv_1;

public class Lv_1_VideoPlayer {
    public static void main(String[] args) {
        solution(	"34:33", "13:00", "00:55", "02:55", new String[]{"next", "prev"});
    }

    public static String solution(String video_len, String pos, String op_start, String op_end, String[] commands) {

        int totalVideoLength = convertStringToIntForTime(video_len);
        int position = convertStringToIntForTime(pos);
        int oping_start = convertStringToIntForTime(op_start);
        int oping_end = convertStringToIntForTime(op_end);

        //for문으로 명령어를 돌리면서 계산하기
        for (String command : commands) {

            //오프닝 시간 사이인지 확인
            if (oping_start <= position && position < oping_end) {
                position = oping_end;
            }

            if (command.equals("next")) {
                position += 10;
            } else {
                position -= 10;
            }

            //끝, 시작 위치를 벗어나는지 확인
            if (position < 0) {
                position = 0;
            } else if (position > totalVideoLength) {
                position = totalVideoLength;
            }

            //오프닝 시간 사이인지 확인
            if (oping_start <= position && position < oping_end) {
                position = oping_end;
            }
        }

        return convertIntToStringForTime(position);
    }

    private static int convertStringToIntForTime(String time) {
        String[] times = time.split(":");
        int hour = Integer.parseInt(times[0]);
        int minute = Integer.parseInt(times[1]);
        return (hour * 60) + minute;
    }

    private static String convertIntToStringForTime(int time) {
        int h = time / 60;
        int m = time % 60;
        String hour = h <= 9 ? "0" + h : h + "";
        String minute = m <= 9 ? "0" + m : m + "";
        return hour + ":" + minute;
    }
}
