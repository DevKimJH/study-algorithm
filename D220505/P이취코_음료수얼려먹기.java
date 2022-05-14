package studyAlgorithm.D220505;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;


/**

4 5
00110
00011
11111
00000
---
3


15 14
00000111100000
11111101111110
11011101101110
11011101100000
11011111111111
11011111111100
11000000011111
01111111111111
00000000011111
01111111111000
00011111111000
00000001111000
11111111110011
11100011111111
11100011111111
 --
 8
 */
public class P이취코_음료수얼려먹기 {

    static int[] dr = {-1, 0, 1, 0};
    static int[] dc = {0, 1, 0, -1};

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st;

        st = new StringTokenizer(br.readLine(), " ");

        // 세로길이
        int N = Integer.parseInt(st.nextToken());

        // 가로길이
        int M = Integer.parseInt(st.nextToken());

        int[][] mapArr = new int[N][M];
        boolean[][] visitArr = new boolean[N][M];

        for(int i = 0 ; i < N ; i++){
            String inputRow = br.readLine();
            for(int j = 0; j < M ; j++){
                mapArr[i][j] = inputRow.charAt(j)-48;
            }
        }



        int answer = 0;

        for(int r = 0 ; r < N ; r++){
            for(int c = 0 ; c < M ; c++){
                if(visitArr[r][c] == false && mapArr[r][c] == 0){
                    process(r, c, mapArr, visitArr);
                    answer++;
                }
            }
        }

        System.out.println(answer);
    }

    static void process(int r, int c, int[][] mapArr, boolean[][] visitArr){
        // 1. 방문
        if(visitArr[r][c] == false){
            visitArr[r][c] = true;
        }

        for(int k = 0 ; k < 4 ; k++){
            int nextR = r + dr[k];
            int nextC = c + dc[k];

            if(0 <= nextR && nextR < mapArr.length && 0 <= nextC && nextC < mapArr[0].length){
                if(visitArr[nextR][nextC] == false && mapArr[nextR][nextC] == 0){
                    process(nextR, nextC, mapArr, visitArr);
                }
            }
        }
    }
}
