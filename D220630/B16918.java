package studyAlgorithm.D220630;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

/**
 * 크기가 R * C 인 직사각형 격자판(각 칸은 비어있거나 폭탄이 들어있음)
 * 폭탄이 있는 칸은 3초 후 폭발, 폭탄이 폭발한 이후에는 폭탄이 있던 칸이 파괴되어 빈 칸이 된다, 인접한 네 칸도 함께 파괴
 * <p>
 * ex) 폭탄이 있던 칸이 (i,j)인경우
 * (i+1, j) / (i-1, j) / (i, j+1) / (i, j-1) 함께 파괴
 * <p>
 * 폭탄이 폭발할 때 인접한 칸에 폭탄이 있는 경우 인접한 칸은 폭발 없이 파괴, 연쇄 반응 X
 * <p>
 * (1) 일부 칸에 폭탄 설치
 * (2) 1초 동안 아무 행동 X
 * (3) 1초 동안 설치되어있지 않은 모든 칸에 설치
 * (4) 1초가 지난 후 3초 전에 설치된 폭탄이 폭발
 * (5) 3~4 반복?
 * <p>
 * 3 3 3
 * ...
 * .O.
 * ...
 * <p>
 * <p>
 * 6 7 4
 * .......
 * ...O...
 * ....O..
 * .......
 * OO.....
 * OO.....
 */
public class B16918 {

    static int[] dr = {-1, 0, 1, 0};
    static int[] dc = {0, 1, 0, -1};

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");

        int R = Integer.parseInt(st.nextToken());
        int C = Integer.parseInt(st.nextToken());
        int N = Integer.parseInt(st.nextToken());

        char[][] mapArr = new char[R][C];

        // 폭탄의 남은 시간을 기록하기 위한 Arr
        int[][] timeArr = new int[R][C];

        // 폭탄 설치 초기 상태
        for (int i = 0; i < R; i++) {
            String inputString = br.readLine();
            for (int j = 0; j < C; j++) {
                char inputChar = inputString.charAt(j);

                if (inputChar == 'O') {
                    timeArr[i][j] = 3;
                }

                mapArr[i][j] = inputChar;
            }
        }


        //printMap(mapArr);
        //System.out.println("초기상태");

        for (int i = 1; i <= N; i++) {
            // 시간경과
            timeProgress(timeArr);

            if (i == 1) {

            } else {
                setBomb(mapArr, timeArr);        // 빈칸 폭탄 설치
                detonateBomb(mapArr, timeArr);  // 시간이 0인 폭탄 폭파
            }

            //printMap(mapArr);
            //System.out.println(i + "초");
            //System.out.println("---");
        }

        printMap(mapArr);
    }


    static void timeProgress(int[][] timeArr) {
        for (int i = 0; i < timeArr.length; i++) {
            for (int j = 0; j < timeArr[0].length; j++) {
                if (timeArr[i][j] > 0) {
                    timeArr[i][j] = timeArr[i][j] - 1;
                }
            }
        }
    }

    static void detonateBomb(char[][] mapArr, int[][] timeArr) {
        for (int i = 0; i < mapArr.length; i++) {
            for (int j = 0; j < mapArr[0].length; j++) {
                if (timeArr[i][j] == 0) {
                    mapArr[i][j] = '.';

                    for (int k = 0; k < 4; k++) {
                        int nextR = i + dr[k];
                        int nextC = j + dc[k];

                        if (0 <= nextR && nextR < mapArr.length && 0 <= nextC && nextC < mapArr[0].length) {
                            if (mapArr[nextR][nextC] == 'O') {
                                mapArr[nextR][nextC] = '.';
                            }
                        }
                    }

                }
            }
        }
    }

    static void printMap(char[][] mapArr) {
        for (int i = 0; i < mapArr.length; i++) {
            for (int j = 0; j < mapArr[0].length; j++) {
                System.out.print(mapArr[i][j]);
            }
            System.out.println("");
        }
    }

    static void setBomb(char[][] mapArr, int[][] timeArr) {
        for (int i = 0; i < mapArr.length; i++) {
            for (int j = 0; j < mapArr[0].length; j++) {
                if (mapArr[i][j] == '.') {
                    mapArr[i][j] = 'O';
                    timeArr[i][j] = 3;
                }
            }
        }
    }
}

