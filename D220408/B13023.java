package studyAlgorithm.D220408;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/**
 친구 관계 파악하기
 BOJ 알고리즘 캠프에는 총 N명이 참가하고 있다. 사람들은 0번부터 N-1번으로 번호가 매겨져 있고, 일부 사람들은 친구다.
 오늘은 다음과 같은 친구 관계를 가진 사람 A,B,C,D,E가 존재하는지 구해 보려고 한다.
 - A와 B는 친구다.
 - B는 C와 친구다.
 - C는 D와 친구다.
 - D는 E와 친구다.

 위와 같은 친구 관계가 존재하는지 여부를 구하는 프로그램을 작성하시오

8 8
1 7
3 7
4 7
3 4
4 6
3 5
0 4
2 7
--
1

5 5
0 1
1 2
2 3
3 0
1 4
--
1
 */

public class B13023 {

    static boolean[] visitArr;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st;

        st = new StringTokenizer(br.readLine(), " ");
        // 사람의 수
        int N = Integer.parseInt(st.nextToken());

        // 친구 관계의 수
        int M = Integer.parseInt(st.nextToken());

        int[][] peopleArr = new int[N][N];
        visitArr = new boolean[N];

        for(int i = 0 ; i < M ; i++){
            st = new StringTokenizer(br.readLine(), " ");
            int inputFirstIdx = Integer.parseInt(st.nextToken());
            int inputSecondIdx = Integer.parseInt(st.nextToken());

            peopleArr[inputFirstIdx][inputSecondIdx] = 1;
            peopleArr[inputSecondIdx][inputFirstIdx] = 1;
        }
    }
}
