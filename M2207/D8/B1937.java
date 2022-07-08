package studyAlgorithm.M2207.D8;


import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class B1937 {

    static int[] dr = {-1, 0, 1, 0};
    static int[] dc = {0, 1, 0, -1};
    static int answer = 0;
    static int N;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        // 맵 크기 설정
        N = Integer.parseInt(br.readLine());

        int[][] mapArr = new int[N][N];
        int[][] memoArr = new int[N][N];

        // 지도 설정
        for (int i = 0; i < N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine(), " ");
            for (int j = 0; j < N; j++) {
                mapArr[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                answer = Math.max(answer, process(i, j, mapArr, memoArr));
            }
        }


        System.out.print(answer);

    }

    static int process(int r, int c, int[][] mapArr, int[][] memoArr) {
        if (memoArr[r][c] != 0) {
            return memoArr[r][c];
        }

        int day = 1;
        for (int i = 0; i < 4; i++) {
            int nextR = r + dr[i];
            int nextC = c + dc[i];

            if (0 <= nextR && nextR < N && 0 <= nextC && nextC < N) {
                if (mapArr[r][c] < mapArr[nextR][nextC]) {
                    day = Math.max(process(nextR, nextC, mapArr, memoArr) + 1, day);
                    memoArr[r][c] = day;
                }
            }
        }

        return day;
    }
}


