package studyAlgorithm.D220313;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;


/**
 크기가 N * M인 지도
 지도의 오른쪽은 동쪽, 위쪽은 북쪽
 지도의 좌표는 (r,c)
 r = 북쪽으로부터 떨어진 칸의 개수
 c = 서쪽으로부터 떨어진 칸의 개수

 2
 4 1 3
 5
 6

 지도 위에 윗 면이 1이고, 동쪽을 바라보는 방향이 3인 상태로 놓여져 있으며, 놓여져 있는 좌표는 (X,Y)
 가장 처음에 주사위에는 모든 면에 0이 적혀져 있음

 지도의 각 칸에는 정수가 하나씩 쓰여져 있다. 주사위를 구렸을 때, 이동하 칸에 쓰여있는 수가 0이면,
 주사위의 바닥면에 쓰여 있는 수가 칸에 복사된다. 0이 아닌 경우에는 칸에 쓰여있는 수가 주사위의 바닥면으로 복사,
 칸에 쓰여 있는 수는 0이 된다.

 주사위를 놓는 곳의 좌표와 이동시키는 명령이 주어졌을 때, 주사위가 이동했을때마다 상단에쓰여 있는 값을 구하는 프로그램을 작성하시오

 입력
 ---
 첫째 줄
 지도의 세로 크기 N
 지도의 가로 크기 M
 주사위를 놓는 곳의 좌표 X, Y
 명령의 개수 K

 둘째 줄
 N개의 줄에 지도에 쓰여 있는 수가 북쪽으로부터 남쪽으로, 각 죽을 서쪽부터 동쪽 순서대로 주어진다.

 마지막 줄
 이동하는 명령 동쪽1 서쪽 2 북쪽 3 남쪽 4
 */

public class b14499주사위굴리기 {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st;

        st = new StringTokenizer(br.readLine(), " ");

        // 주사위
        int[][] dice = new int[4][3];


        // 지도 세로 크기
        int N = Integer.parseInt(st.nextToken());

        // 지도 가로 크기
        int M = Integer.parseInt(st.nextToken());

        // 주사위 놓는 좌표
        int x = Integer.parseInt(st.nextToken());
        int y = Integer.parseInt(st.nextToken());

        // 명령의 개수
        int K = Integer.parseInt(st.nextToken());

        // 지도 세팅
        int[][] arr = new int[N][M];
        for(int i = 0 ; i < N ; i++){
            st = new StringTokenizer(br.readLine(), " " );
            for(int j = 0 ;j < M ; j++){
                arr[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        // 명령 세팅
        st = new StringTokenizer(br.readLine(), " ");
        Queue<Integer> queue = new LinkedList();

        for(int i = 0 ; i < K ; i++){
            queue.add(Integer.parseInt(st.nextToken()));
        }


        // 시작
        while(!queue.isEmpty()){
            // 명령 뽑기
            int inputCommand = queue.poll();
            int tmp;
            switch(inputCommand){
                // 동쪽 이동
                case 1:
                    if(x+1 >= M){
                        continue;
                    }
                    x++;
                    tmp = dice[1][0];
                    dice[1][0] = dice[3][1];
                    dice[3][1] = dice[1][2];
                    dice[1][2] = dice[1][1];
                    dice[1][1] = tmp;
                    break;
                // 서쪽 이동
                case 2:
                    if(x-1 < 0){
                        continue;
                    }
                    x--;
                    tmp = dice[1][0];
                    dice[1][0] = dice[1][1];
                    dice[1][1] = dice[1][2];
                    dice[1][2] = dice[3][1];
                    dice[3][1] = tmp;

                    break;
                // 북쪽 이동
                case 3:
                    if(y-1 < 0){
                        continue;
                    }
                    y--;
                    tmp = dice[1][1];
                    dice[1][1] = dice[2][1];
                    dice[2][1] = dice[3][1];
                    dice[3][1] = dice[0][1];
                    dice[0][1] = tmp;
                    break;
                // 남쪽 이동
                case 4:
                    if(y+1 >= N) {
                        continue;
                    }
                    y++;
                    tmp = dice[1][1];
                    dice[1][1] = dice[0][1];
                    dice[0][1] = dice[3][1];
                    dice[3][1] = dice[2][1];
                    dice[2][1] = tmp;
                    break;
            }

            // 이동한 칸에 쓰여 있는 수가 0이면, 주사위 바닥면에 쓰여 있는 수가 칸에 복사
            // 0이 아닌 경우 칸에 쓰여 있는 수가 주사위의 바닥면으로 복사. 칸에 쓰여 있는 수는 0이 된다.

            if(arr[y][x] == 0){
                arr[y][x] = dice[3][1];
            }
            else{
                dice[3][1] = arr[y][x];
                arr[y][x] = 0;
            }

            // 주사위 상단에 쓰여 있는 값 출력
            System.out.println(dice[1][1]);
        }
    }
}

