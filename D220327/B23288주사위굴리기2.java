package studyAlgorithm.D220327;

import java.util.*;
import java.io.*;


/*
    1. 이동 방향으로 한 칸 굴러감. 이동 방향에 칸이 없다면 이동방향을 반대로 한 다음 한 칸 굴러간다.
    2. 도착한 칸 (x,y)에 대한 점수를 획득
    3. 주사위의 아랫면에 있는 정수 A와 칸 (x,y)에 있는 정수 B를 비교해 이동 방향을 결정

        - A > B인 경우 이동 방향 90도 시계 방향
        - A < B인 경우 이동 방향 90도 반시계
        - A = B인 경우 이동방향 변화 X

    (x,y)에 있는 정수를 B라고 했을 때, (x,y)에서 동서남북 방향으로 연속해서 이동할 수 있는 칸의 수 C를 모두 구한다.
    이동할 수 있는 칸에는 모두 정수 B가 있어야 한다. 점수는 B와 C를 곱한 값

4 5 1000
4 1 2 3 3
6 1 1 3 3
5 6 1 3 2
5 5 6 5 5


*/

public class B23288주사위굴리기2{
    static int[] dx = {0, 1, 0, -1};
    static int[] dy = {-1, 0, 1, 0};

    static int[][] mapArr;
    static boolean[][] visitArr;

    static int x= 1;
    static int y= 1;
    static int cntBlock = 0;
    static int direction = 1;

    static class Node{
        int x;
        int y;

        Node(int x, int y){
            this.x = x;
            this.y = y;
        }
    }

    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        st = new StringTokenizer(br.readLine(), " ");

        // 지도의 세로 크기
        int N = Integer.parseInt(st.nextToken());

        // 지도의 가로 크기
        int M = Integer.parseInt(st.nextToken());

        // 이동하는 횟수
        int K = Integer.parseInt(st.nextToken());

        // 지도 세팅
        mapArr = new int[N+1][M+1];

        for(int i = 1 ; i <= N ; i++){
            st = new StringTokenizer(br.readLine(), " ");
            for(int j = 1 ; j <= M ; j++){
                mapArr[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        // 주사위
        int[] dice = {2,4,1,3,5,6};
        int answer = 0;

        for(int i = 0 ; i < K ; i++){
            visitArr = new boolean[N+1][M+1];
            cntBlock = 0;
            answer += process(dice);
        }

        System.out.print(answer);
    }

    static int process(int[] dice){
        // 1. 이동방향으로 한 칸 굴러감
        rollDice(dice);

        // 2. 도착한 칸 점수 획득
        int score = getPoint(x, y);

        // 3. 이동 방향 결정
        getNextDirection(x, y, dice);

        return score;
    }

    static void rollDice(int[] dice){
        int tmp = 0;

        switch(direction){
            // 북쪽
            case 0:
                if(y == 1){
                    direction = 2;
                    rollDice(dice);
                }
                else{
                    y -=1;
                    tmp = dice[2];
                    dice[2] = dice[4];
                    dice[4] = dice[5];
                    dice[5] = dice[0];
                    dice[0] = tmp;
                }
                break;
            // 동쪽
            case 1:
                if(x == mapArr[0].length-1){
                    direction = 3;
                    rollDice(dice);
                }
                else{
                    x += 1;
                    tmp = dice[2];
                    dice[2] = dice[1];
                    dice[1] = dice[5];
                    dice[5] = dice[3];
                    dice[3] = tmp;
                }
                break;
            // 남쪽
            case 2:
                if(y == mapArr.length-1){
                    direction = 0;
                    rollDice(dice);
                }
                else{
                    y += 1;
                    tmp = dice[2];
                    dice[2] = dice[0];
                    dice[0] = dice[5];
                    dice[5] = dice[4];
                    dice[4] = tmp;
                }
                break;
            // 서쪽
            case 3:
                if(x==1){
                    direction = 1;
                    rollDice(dice);
                }
                else{
                    x -= 1;
                    tmp = dice[2];
                    dice[2] = dice[3];
                    dice[3] = dice[5];
                    dice[5] = dice[1];
                    dice[1] = tmp;
                }
                break;
        }
    }

    // BFS
    static int getPoint(int x, int y){
        Queue<Node> queue = new LinkedList();
        queue.add(new Node(x, y));
        visitArr[y][x] = true;

        while(!queue.isEmpty()){
            Node node = queue.poll();
            cntBlock++; // 연속되는 블록 카운트

            for(int i = 0 ; i < 4 ; i++){
                int nextX = node.x + dx[i];
                int nextY = node.y + dy[i];

                if(1 <= nextX && nextX < mapArr[0].length && 1 <= nextY && nextY < mapArr.length){
                    if(visitArr[nextY][nextX] == false && mapArr[nextY][nextX] == mapArr[y][x]){
                        queue.add(new Node(nextX, nextY));
                        visitArr[nextY][nextX] = true;
                    }
                }
            }
        }

        return cntBlock * mapArr[y][x];
    }

    // 이동 방향 결정
    static void getNextDirection(int x, int y, int[] dice){
        // A > B인 경우 진행 방향에서 시계 방향 90도 회전
        if(dice[5] > mapArr[y][x]){
            direction = (direction+1)%4;
        }
        // A < B인 경우 진행 방향에서 반시계 반향 90도 회전
        else if(dice[5] < mapArr[y][x]){
            if(direction == 0){
                direction = 3;
            }
            else{
                direction--;
            }
        }
        // A = B인 경우 방향 유지
        else if(dice[5] == mapArr[y][x]){

        }

    }
}