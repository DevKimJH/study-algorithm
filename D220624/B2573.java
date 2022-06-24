package studyAlgorithm.D220624;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;


/**
 5 7
 0000000
 0245300
 0302520
 0762400
 0000000

 0000000
 0024100
 0101500
 0541200
 0000000

 0000000
 0003000
 0000400
 0320000
 0000000

 5 7
 0 0 0 0 0 0 0
 0 0 2 4 1 0 0
 0 1 0 1 5 0 0
 0 5 4 1 2 0 0
 0 0 0 0 0 0 0

 5 7
 0 0 0 0 0 0 0
 0 0 0 5 0 0 0
 0 0 0 0 0 0 0
 0 0 7 0 0 0 0
 0 0 0 0 0 0 0
 0 0 0 0 0 0 0

 배열에서 빙산의 각 부분에 해당되는 칸에 있는 높이는 일년마다 그 칸에 동서남북 네 방향으로 붙어있는 0이 저장된 칸의 개수만큼 줄어든다.
 단, 각 칸에 저장된 높이는 0보다 더 줄어들지 않는다.
 빙산이 두 덩어리 이상으로 분리되는 최초의 시간(년)
 */
public class B2573 {
    static int[] dr = {-1, 0, 1, 0};
    static int[] dc = {0, 1, 0, -1};

    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");

        // 행
        int N = Integer.parseInt(st.nextToken());

        // 열
        int M = Integer.parseInt(st.nextToken());

        int[][] arrMap = new int[N][M];
        int[][] countZeroArr = new int[N][M];
        boolean[][] visitArr = new boolean[N][M];

        for(int i = 0 ; i < N ; i++){
            st = new StringTokenizer(br.readLine(), " ");
            for(int j = 0 ;j < M ; j++){
                arrMap[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        // 근처 0 체크
        int year = 0;
        boolean isBreak = false;


        // 처음부터 2조각인지 확인
        int count = 0;
        loop:
        for(int i = 0 ; i < N ; i++){
            for(int j = 0 ; j < M ; j++){
                if(arrMap[i][j] > 0 && visitArr [i][j] == false){
                    count++;
                    if(count>1) {
                        isBreak = true;
                        break loop;
                    }
                    checkDFS(arrMap, visitArr, i, j);
                }
            }
        }
        //////////

        while(!isBreak){
            countZeroArr = new int[N][M];
            visitArr = new boolean[N][M];
            boolean isMeltAllIce = true;
            year++;

            // 0 카운트
            for(int i = 0 ; i < N ; i++){
                for(int j = 0 ; j < M ; j++){
                    if(arrMap[i][j] > 0){
                        process(arrMap, countZeroArr, i, j);
                    }
                }
            }

            // 체크된 0카운트만큼 빙산 녹이기
            for(int i = 0 ; i < N ; i++){
                for(int j = 0 ; j < M ; j++){
                    arrMap[i][j] = arrMap[i][j] - countZeroArr[i][j];
                    if(arrMap[i][j] < 0) arrMap[i][j] = 0;
                    if(arrMap[i][j] > 0) isMeltAllIce = false;

                }
            }

            // 덩어리 체크
            count = 0;
            loop:
            for(int i = 0 ; i < N ; i++){
                for(int j = 0 ; j < M ; j++){
                    if(arrMap[i][j] > 0 && visitArr [i][j] == false){
                        count++;
                        if(count>1) {
                            isBreak = true;
                            break loop;
                        }
                        checkDFS(arrMap, visitArr, i, j);
                    }
                }
            }

            // 모든 빙하가 녹았을 경우 0 출력
            if(isMeltAllIce == true) {
                year = 0;
                break;
            }
        }
        System.out.println(year);
    }

    static void process(int[][] arrMap, int[][] countZeroArr, int r, int c){

        int countZero = 0;
        int rowLength = arrMap.length;
        int colLength = arrMap[0].length;

        for(int i = 0 ; i < 4 ; i++){
            int nextR = r + dr[i];
            int nextC = c + dc[i];

            if(0 <= nextR && nextR < rowLength && 0 <= nextC && nextC < colLength){
                if(arrMap[nextR][nextC] == 0){
                    //++countZero;
                    ++countZeroArr[r][c];
                }
            }
        }

        //arrMap[r][c] = arrMap[r][c] - countZero;
        //if(arrMap[r][c] < 0) arrMap[r][c] = 0;
    }

    static void checkDFS(int[][] arrMap, boolean[][] visitArr, int r, int c){
        visitArr[r][c] = true;

        for(int i = 0 ; i < 4 ; i++){
            int nextR = r + dr[i];
            int nextC = c + dc[i];

            if(0 <= nextR && nextR < arrMap.length && 0 <= nextC && nextC < arrMap[0].length){
                if(arrMap[nextR][nextC] > 0 && visitArr[nextR][nextC] == false){
                    checkDFS(arrMap, visitArr, nextR, nextC);
                }
            }
        }
    }
}

