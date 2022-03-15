package studyAlgorithm.D220313;

import java.io.*;
import java.util.*;

public class b14499주사위굴리기{

    static int[] dice = new int[7];

    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        int[] dx = {1, -1, 0, 0};
        int[] dy = {0, 0, -1, 1};

        st = new StringTokenizer(br.readLine(), " ");

        // 세로 크기
        int N = Integer.parseInt(st.nextToken());

        // 가로 크기
        int M = Integer.parseInt(st.nextToken());

        // X좌표
        int y = Integer.parseInt(st.nextToken());

        // Y좌표
        int x = Integer.parseInt(st.nextToken());

        // 명령의 개수
        int k = Integer.parseInt(st.nextToken());

        // 지도 세팅
        int[][] mapArr = new int[N][M];

        for(int i = 0 ; i < N ; i++){
            st = new StringTokenizer(br.readLine(), " ");
            for(int j = 0 ; j < M ; j++){
                mapArr[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        st = new StringTokenizer(br.readLine(), " ");

        // 명령 세팅
        for(int i = 0 ; i < k ; i++){
            int command = Integer.parseInt(st.nextToken());

            // 1. 지도 범위 체크 후 주사위를 방향에 맞게 굴린다.
            int nx = x + dx[command-1];
            int ny = y + dy[command-1];

            // 1-1. 이동할 범위가 지도를 벗어나지않으면
            if(0 <= nx && nx < M && 0 <= ny && ny < N){
                // 1-2. 주사위를 굴린다
                rollDice(command);
                x = nx;
                y = ny;

                // 2. 이동한 칸 숫자 확인
                if(mapArr[y][x] == 0){
                    // 2-1. 0이면 주사위 바닥 수가 지도로 복사
                    mapArr[y][x] = dice[6];
                }
                else{
                    // 2.2 0이 아니면 지도 칸에 쓰인 수가 주사위로 복사
                    dice[6] = mapArr[y][x];

                    // 2-3. 지도 칸은 0이 됨
                    mapArr[y][x] = 0;
                }

                // 3. 이동이 끝나면 주사위 윗면 숫자 출력
                System.out.println(dice[1]);
            }
        }
    }

    static void rollDice(int command){
        int[] temp = dice.clone();
        switch(command){
            // 동
            case 1:
                dice[1] = temp[4];
                dice[3] = temp[1];
                dice[4] = temp[6];
                dice[6] = temp[3];
                break;
            // 서
            case 2:
                dice[1] = temp[3];
                dice[3] = temp[6];
                dice[4] = temp[1];
                dice[6] = temp[4];
                break;
            // 북
            case 3:
                dice[1] = temp[5];
                dice[2] = temp[1];
                dice[5] = temp[6];
                dice[6] = temp[2];
                break;
            // 남
            case 4:
                dice[1] = temp[2];
                dice[2] = temp[6];
                dice[5] = temp[1];
                dice[6] = temp[5];
                break;
        }
    }
}