package studyAlgorithm.D220419;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/**
 캐릭터가 있는 장소는 정사각형으로 이뤄진 N * M 크기의 직사각형, 각각의 칸은 육지 또는 바다
 캐릭터는 동서남북 중 한 곳을 바라본다.

 맵의 각 칸은 (A,B)로 나타낼 수 있고, A는 북쪽으로부터 떨어진 칸의 개수, B는 서쪽으로부터 떨어진 칸의 개수
 캐릭터는 상하좌우로 움직일 수 있고, 바다로 되어 있는 공간에는 갈 수 없다.
 캐릭터의 움직임을 설정하기 위해 정해 놓은 매뉴얼은 이러하다.

 1. 현재 위치에서 현재 방향을 기준으로 왼쪽 방향(반시계 방향으로 90도 회전한 방향)부터 차례대로 갈 곳을 정한다.

 2. 캐릭터의 바로 왼쪽 방향에 아직 가보지 않은 칸이 존재한다면, 왼쪽 방향으로 회전한 다음 왼쪽으로 한 칸을 전진한다. 왼쪽 방향에 가보지 않은 칸이 없다면, 왼쪽 방향으로 회전만 수행하고 1단계로 돌아간다.

 3. 만약 네 방향 모두 이미 가본 칸이거나 바다로 되어 있는 칸의 경우에는, 바라보는 방향을 유지한 채로 한 칸 뒤로 가고 1단계로 돌아간다. 단, 이때 뒤쪽 방향이 바다인 칸이라 뒤로 갈 수 없는 경우에는 움직임을 멈춘다.

4 4
1 1 0
1 1 1 1
1 0 0 1
1 1 0 1
1 1 1 1

 */


public class P게임개발 {

    static int[] dr = {-1, 0, 1, 0};
    static int[] dc = {0, 1, 0, -1};
    static int answer = 1;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st;

        st = new StringTokenizer(br.readLine(), " ");

        // 세로 크기
        int N = Integer.parseInt(st.nextToken());

        // 가로 크기
        int M = Integer.parseInt(st.nextToken());

        st = new StringTokenizer(br.readLine() , " ");

        // 로봇 청소기가 있는 좌표
        int R = Integer.parseInt(st.nextToken());

        int C = Integer.parseInt(st.nextToken());

        // 로봇 청소기 방향( 0 : 북 / 1 : 서 / 2 : 남 / 3 : 동 )
        int D = Integer.parseInt(st.nextToken());

        // 지도 세팅 시작 //
        int[][] mapArr = new int[N][M];
        boolean[][] visitArr = new boolean[N][M];

        for(int i = 0 ; i < N ; i++){
            st = new StringTokenizer(br.readLine(), " ");
            for(int j = 0 ; j < M ; j++){
                mapArr[i][j] = Integer.parseInt(st.nextToken());
            }
        }
        // 지도 세팅 종료 //
        visitArr[R][C] = true;
        System.out.println(R + " " + C);
        process(mapArr, visitArr, R, C, D);

        System.out.println(answer);
    }

    static void process(int[][] mapArr, boolean[][] visitArr, int r, int c, int d){

        // 1. 현재 위치를 청소한다.
        if(mapArr[r][c] == 0 && visitArr[r][c] == false){
            System.out.println(r + " " + c);
            visitArr[r][c] = true;
            answer++;
        }

        // 2. 현재 위치에서 현재 방향을 기준으로 왼쪽 방향부터 차례대로 인접한 칸을 탐색
        boolean canCleanLeftDirection = false;
        int originDirection = d; // 바라보는 방향을 유지한 채로 뒤로 1칸 후진 하기 위해 방향을 저장해놓음
        for(int i = 0 ; i < 4 ; i++){
            int nextD = (d+3)%4;
            int nextR = r + dr[nextD];
            int nextC = c + dc[nextD];


            if(0 < nextR && nextR < mapArr.length && 0 < nextC && nextC < mapArr[0].length){
                if(mapArr[nextR][nextC] == 0 && visitArr[nextR][nextC] == false){
                    process(mapArr, visitArr, nextR, nextC, nextD);
                    canCleanLeftDirection = true;
                    break;
                }
            }

            // 다음 반시계 방향으로 90도 회전을 위한 소스
            d = (d + 3) % 4;
        }

        // 현재 위치를 청소하고 다음 4방향 모두 이동할 수 없을때
        // 바라보는 방향을 유지한 채로 한 칸 후진을 하고 2번으로 돌아간다.
        if(!canCleanLeftDirection){
            int nextD = (d+2)%4;
            int nextR = r + dr[nextD];
            int nextC = c + dc[nextD];

            if(0 < nextR && nextR < mapArr.length && 0 < nextC && nextC < mapArr[0].length){
                if(mapArr[nextR][nextC] == 0){
                    process(mapArr, visitArr, nextR, nextC, originDirection);
                }
            }
        }
    }
}
