package studyAlgorithm.D220620;

import java.io.BufferedReader;
import java.io.InputStreamReader;

/**
 * 크기가 N*N인 그리드
 * 각 칸에는 R G B 색칠
 * 같은 색상이 상하좌우로 인접해 있는 경우 두 글자는 같은 구역에 속한다
 * <p>
 * RRRBB
 * GGBBB
 * BBBRR
 * BBRRR
 * RRRRR
 * 정상 ( 빨2 / 파1 / 초1 )
 * 색약 ( 빨강초록 2 / 파 1 )
 * 정상인 사람이 봤을 때와 색약인 사람이 봤을 때
 */

public class B10026 {
    static int[] dr = {-1, 0, 1, 0};
    static int[] dc = {0, 1, 0, -1};

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());
        char[][] colorMap = new char[N][N];
        boolean[][] visitMap = new boolean[N][N];
        boolean[][] visitMap2 = new boolean[N][N];
        int answer = 0;
        int answer2 = 0;

        for (int i = 0; i < N; i++) {
            String inputStr = br.readLine();
            for (int j = 0; j < N; j++) {
                colorMap[i][j] = inputStr.charAt(j);
            }
        }

        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                if (visitMap[i][j] == false) {
                    answer++;
                    process(i, j, colorMap, visitMap);
                }

                if (visitMap2[i][j] == false) {
                    answer2++;
                    process2(i, j, colorMap, visitMap2);
                }
            }
        }

        System.out.println(answer + " " + answer2);
    }


    static void process(int r, int c, char[][] colorMap, boolean[][] visitMap) {
        visitMap[r][c] = true;
        char color = colorMap[r][c];

        int colorMapLength = colorMap.length;
        for (int i = 0; i < 4; i++) {
            int nextR = r + dr[i];
            int nextC = c + dc[i];

            if (0 <= nextR && nextR < colorMapLength && 0 <= nextC && nextC < colorMapLength) {
                if (visitMap[nextR][nextC] == false && colorMap[nextR][nextC] == color) {
                    process(nextR, nextC, colorMap, visitMap);
                }
            }
        }
    }

    static void process2(int r, int c, char[][] colorMap, boolean[][] visitMap) {
        visitMap[r][c] = true;
        char color = colorMap[r][c];

        int colorMapLength = colorMap.length;
        for (int i = 0; i < 4; i++) {
            int nextR = r + dr[i];
            int nextC = c + dc[i];

            if (0 <= nextR && nextR < colorMapLength && 0 <= nextC && nextC < colorMapLength) {
                if (visitMap[nextR][nextC] == false) {
                    if (color == 'R' || color == 'G') {
                        if (colorMap[nextR][nextC] == 'R' || colorMap[nextR][nextC] == 'G') {
                            process2(nextR, nextC, colorMap, visitMap);
                        }
                    } else if (color == 'B') {
                        if (colorMap[nextR][nextC] == 'B') {
                            process2(nextR, nextC, colorMap, visitMap);
                        }
                    }
                }
            }
        }
    }
}

