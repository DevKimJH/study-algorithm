package studyAlgorithm.M2207.D7;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;


/*
N * N 크기의 맵
어떤 지역에서 먹기 시작
그 곳을 다 먹으면 상, 하, 좌, 우 중 한 곳으로 이동
그리고 그 곳에서 또 먹는다.

대나무를 먹고 자리를 옮기면 옮기 지역에 그 전지역보다
대나무가 많이 있어야 한다
최대한 많은 칸을 이동하려면 어떤 경로를 통하여 움직여야 하는지

4
14 9 12 10
1 11 5 4
7 15 2 13
6 3 16 8
--
4


 */
public class B1937 {
    static int[] dr = {-1, 0, 1, 0};
    static int[] dc = {0, 1, 0, -1};
    static int answer = 1;

    static class Node {
        int r;
        int c;

        Node(int r, int c) {
            this.r = r;
            this.c = c;
        }
    }

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringBuilder sb = new StringBuilder();

        // 맵 크기
        int N = Integer.parseInt(br.readLine());
        int[][] mapArr = new int[N][N];
        int[][] memoArr = new int[N][N];
        boolean[][] visitArr = new boolean[N][N];

        for (int i = 0; i < N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine(), " ");
            for (int j = 0; j < N; j++) {
                mapArr[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                visitArr[i][j] = true;
                process(mapArr, memoArr, visitArr, i, j, i, j, 0);
            }
        }

        System.out.print(answer);
    }

    static void process(int[][] mapArr, int[][] memoArr, boolean[][] visitArr, int r, int c, int originR, int originC, int idx) {
        idx = idx + 1;
        if (memoArr[originR][originC] < idx) {
            if (answer < idx) {
                answer = idx;
            }
            memoArr[originR][originC] = idx;

        }

        for (int i = 0; i < 4; i++) {
            int nextR = r + dr[i];
            int nextC = c + dc[i];

            if (0 <= nextR && nextR < mapArr.length && 0 <= nextC && nextC < mapArr[0].length) {
                if (mapArr[r][c] < mapArr[nextR][nextC]) {
                    if (visitArr[nextR][nextC] == true) {
                        if (memoArr[nextR][nextC] + idx > memoArr[originR][originC]) {
                            if (answer < memoArr[nextR][nextC] + idx) {
                                answer = memoArr[nextR][nextC] + idx;
                            }
                        }
                        memoArr[originR][originC] = memoArr[nextR][nextC] + idx;
                    } else {
                        process(mapArr, memoArr, visitArr, nextR, nextC, originR, originC, idx);
                    }
                }
            }
        }
    }
}
