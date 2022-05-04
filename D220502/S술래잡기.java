package studyAlgorithm.D220502;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class S술래잡기 {

    static int[] dr = {-1, 0, 1, 0};
    static int[] dc = {0, 1, 0, -1};

    static class Player{
        int r;
        int c;
        int moveDirection;

        // Catcher용
        int moveCnt;        // 얼마나 이동하는지
        int saveMoveCnt;    // 얼마나 이동하는지 저장하고 있는 변수
        int idxOfTurn;      // 첫번째 회전인지 두번째 회전인지 체크
        boolean moveReverse;

        Player(int r, int c, int moveDirection){
            this.r = r;
            this.c = c;
            this.moveDirection = moveDirection;
        }

        Player(int r, int c, int moveDirection, int moveCnt, int saveMoveCnt, int idxOfTurn){
            this.r = r;
            this.c = c;
            this.moveDirection = moveDirection;
            this.moveCnt = moveCnt;
            this.saveMoveCnt = saveMoveCnt;
            this.idxOfTurn = idxOfTurn;
            this.moveReverse = false;
        }
    }

/*
5 3 1 1
2 4 1
1 4 2
4 2 1
2 4

5 24 9 100
3 4 1
5 1 2
3 2 1
5 4 1
5 2 1
1 2 2
2 4 1
4 3 2
4 1 2
4 2 1
2 1 1
1 5 1
3 1 2
2 2 1
1 4 1
4 4 1
4 5 2
3 5 1
5 3 1
2 3 2
5 5 2
1 3 1
2 5 1
1 1 1
1 1
1 5
3 2
3 1
4 1
5 5
5 1
2 4
2 5

1 좌우 (우)
2 상하 (하)
5 2 0 10
1 4 2
2 4 1

 */
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");

        // 지도의 크기
        int N = Integer.parseInt(st.nextToken());
        int[][] mapArr = new int[N][N];
        int[][] treeMapArr = new int[N][N];

        // 도망자의 수
        int M = Integer.parseInt(st.nextToken());

        // 나무의 수
        int H = Integer.parseInt(st.nextToken());

        // 게임 진행 턴
        int K = Integer.parseInt(st.nextToken());

        int answer =0;

        //// 도망자 세팅 시작 ////
        // 이동방향 1 (좌우) 2(상하)
        // 1의 초기 시작 오른쪽
        // 2의 초기 시작 아래쪽
        Player[] runners = new Player[M];
        for(int i = 0 ; i < M ; i++){
            st = new StringTokenizer(br.readLine(), " ");
            int r = Integer.parseInt(st.nextToken())-1;
            int c = Integer.parseInt(st.nextToken())-1;
            int moveDirection = Integer.parseInt(st.nextToken());

            runners[i] = new Player(r, c, moveDirection);
        }
        //// 도망자 세팅 종료 ////

        //// 나무 세팅 시작 ////
        for(int i = 0 ; i < H ; i++){
            st = new StringTokenizer(br.readLine(), " ");
            int r = Integer.parseInt(st.nextToken())-1;
            int c = Integer.parseInt(st.nextToken())-1;

            treeMapArr[r][c] = 1;
        }
        //// 나무 세팅 종료 ////

        int startR = (N-1)/2;
        int startC = (N-1)/2;

        Player catcher = new Player(startR, startC, 0, 1, 1, 2);

        // K턴만큼 게임 진행
        for(int T = 1 ; T <= K ; T++){
            //// 1. 도망자가 움직인다. ////
            for(int i = 0 ; i < M ; i++){
                if(runners[i] == null) continue;
                int runnerR = runners[i].r;
                int runnerC = runners[i].c;
                int runnerMoveDirection = runners[i].moveDirection;
                // 도망자와 술래와의 거리가 3이하인 도망자만 움직인다.
                if(Math.abs(runnerR - startR) + Math.abs(runnerC - startC) <= 3){
                    int nextR = runnerR + dr[runnerMoveDirection];
                    int nextC = runnerC + dc[runnerMoveDirection];

                    // 맵을 벗어나지 않고
                    if(0 <= nextR && nextR < N && 0 <= nextC && nextC < N){
                        // 움직이는 칸에 술래가 있지 않으면 움직인다.
                        if(nextR == catcher.r && nextC == catcher.c){

                        }
                        else{
                            runners[i].r = nextR;
                            runners[i].c = nextC;
                        }
                    }
                    // 맵을 벗어날 경우
                    else{
                        runnerMoveDirection = (runnerMoveDirection+2)%4;
                        nextR = runnerR + dr[runnerMoveDirection];
                        nextC = runnerC + dc[runnerMoveDirection];
                        runners[i].moveDirection = runnerMoveDirection;

                        // 움직이는 칸에 술래가 있지 않으면 움직인다.
                        if(nextR == catcher.r && nextC == catcher.c){

                        }
                        else{
                            runners[i].r = nextR;
                            runners[i].c = nextC;
                        }
                    }
                }
            }
            //// 1. 도망자 이동 종료 ////

            //// 2. 술래의 이동 ////
            // 달팽이(나선형)으로 이동
            int nextR = catcher.r + dr[catcher.moveDirection];
            int nextC = catcher.c + dc[catcher.moveDirection];

            // 맵을 벗어나지 않으면 이동
            if (0 <= nextR && nextR < N && 0 <= nextC && nextC < N) {
                catcher.r = nextR;
                catcher.c = nextC;
                catcher.moveCnt = catcher.moveCnt-1; // 한번 움직였으니 moveCnt -1

                // 움직일만큼 움직여서 회전해야 할 타이밍
                if(catcher.moveCnt == 0){
                    if(catcher.moveReverse == true){
                        catcher.moveDirection = catcher.moveDirection-1; // 방향 회전
                        if(catcher.moveDirection < 0){
                            catcher.moveDirection = 3;
                        }
                    }
                    else if(catcher.moveReverse == false){
                        catcher.moveDirection = (catcher.moveDirection + 1) % 4; // 방향 회전
                    }

                    catcher.idxOfTurn = catcher.idxOfTurn-1;                 // 회전수 하나 깜

                    // 마지막 회전이 아닐 경우
                    if (catcher.idxOfTurn > 0) {
                        catcher.moveCnt = catcher.saveMoveCnt;
                    }

                    // 마지막 회전이면
                    if (catcher.idxOfTurn == 0) {
                        if(catcher.moveReverse == true){
                            catcher.saveMoveCnt = catcher.saveMoveCnt-1;
                        }
                        else if(catcher.moveReverse == false){
                            catcher.saveMoveCnt = catcher.saveMoveCnt+1;
                        }
                        catcher.moveCnt = catcher.saveMoveCnt;
                        catcher.idxOfTurn = 2;
                    }
                }
            }

            if(catcher.r == 0 && catcher.c == 0){
                catcher.idxOfTurn = 3;
                catcher.saveMoveCnt = N-1;
                catcher.moveCnt = N-1;
                catcher.moveDirection = (catcher.moveDirection + 2) % 4;
                catcher.moveReverse = true;
            }


            if(catcher.r == startR && catcher.c == startC && catcher.moveReverse == true){
                catcher.idxOfTurn = 2;
                catcher.saveMoveCnt = 1;
                catcher.moveCnt = 1;
                catcher.moveDirection = (catcher.moveDirection-1) % 4;
                catcher.moveReverse = false;
            }

            //// 2. 술래의 이동 종료 ////

            //// 3. 도망자 잡기 시작 ////
            int catcherR = catcher.r;
            int catcherC = catcher.c;
            int moveDirection = catcher.moveDirection;
            nextR = catcherR;
            nextC = catcherC;

            int countCatch = 0;

            // 현재 술래의 위치 확인
            for(int j = 0 ; j < M ; j++){
                if(runners[j] != null){
                    if(nextR == runners[j].r && nextC == runners[j].c){
                        if(treeMapArr[nextR][nextC] == 0){
                            countCatch++;
                        }
                    }
                }
            }

            //System.out.println("T:"+T + " R:" + nextR + " C:" + nextC + " MD:" + moveDirection);

            // 방향을 유지한 상태로 2칸 더 확인
            for(int i = 0 ; i < 2 ; i++){
                nextR = nextR + dr[moveDirection];
                nextC = nextC + dc[moveDirection];

                /*
                if(0 <= nextR && nextR < N && 0 <= nextC && nextC < N){

                }
                else{
                    moveDirection = ( moveDirection + 2 ) % 4;
                    nextR = nextR + dr[moveDirection] + dr[moveDirection];
                    nextC = nextC + dc[moveDirection] + dc[moveDirection];
                }
                */

                for(int j = 0 ; j < M ; j++){
                    if(runners[j] != null){
                        if(nextR == runners[j].r && nextC == runners[j].c){
                            if(treeMapArr[nextR][nextC] == 0){
                                countCatch++;
                                runners[j] = null;
                            }
                        }
                    }
                }
                //System.out.println("T:"+T + " R:" + nextR + " C:" + nextC + " MD:" + moveDirection);
            }
            answer = answer + (countCatch * T);
        }
        System.out.println(answer);
    }
}
