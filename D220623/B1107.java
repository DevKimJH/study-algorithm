package studyAlgorithm.D220623;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;


/**
 * 리모컨
 * 버튼 0-9 숫자 +, 숫자 -
 * 채널 0에서 - 누르면 채널이 변하지 않음
 * 이동하려고하는 채널 N
 * 채널 N으로 이동하기 위해 버튼을 최소 몇 번 눌어햐 하는가
 * 현재채널 100
 * <p>
 * <p>
 * 5457
 * 3
 * 6 7 8
 * <p>
 * 5457
 * 3
 * 1 2 3
 * <p>
 * 5457
 * <p>
 * <p>
 * <p>
 * <p>
 * 5
 * 54
 * 545
 * 5455
 * 5456
 * 5457
 * 6
 * <p>
 * 1
 * 9
 * 1 2 3 4 5 6 7 8 9
 * --
 * 2
 * <p>
 * <p>
 * <p>
 * 1. 숫자로만
 * 2. 숫자 + +- 버튼
 * 3. +- 버튼
 */

public class B1107 {

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;

        int answer = 0;

        // 이동 채널
        int N = Integer.parseInt(br.readLine());

        // 고장 버튼 개수
        int M = Integer.parseInt(br.readLine());
        boolean[] brokenButton = new boolean[10];

        // 고장 버튼 설정 시작
        if (M != 0) {
            st = new StringTokenizer(br.readLine(), " ");

            for (int i = 0; i < M; i++) {
                int brokenButtonNumber = Integer.parseInt(st.nextToken());
                brokenButton[brokenButtonNumber] = true;
            }
        }

        // 고장 버튼 설정 종료

        //////////////////////////////////////////////////////////////////
        //////////////////////////////////////////////////////////////////

        // 초기값 설정
        int result = Math.abs(N - 100);
        for (int i = 0; i <= 999999; i++) {
            String str = String.valueOf(i);
            int len = str.length();

            boolean isBreak = false;
            for (int j = 0; j < len; j++) {
                // 고장난 버튼을 눌러야 하면
                if (M != 0 && brokenButton[str.charAt(j) - '0']) {
                    isBreak = true;
                    // 탐색 중지하고 빠져나온다
                    break;
                }
            }

            // 고장난 버튼을 누르지 않으면
            if (!isBreak) {
                int min = Math.abs(N - i) + len;
                result = Math.min(min, result);
            }
        }
        System.out.print(result);
    }
}






























