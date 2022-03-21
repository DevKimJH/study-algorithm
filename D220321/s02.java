package studyAlgorithm.D220321;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;


/**
 자연수 N과 시계/반시계 방향을 결정하는 boolean 값, clockwise가 주어진다.
 설명의 그림과 같이 소용돌이 모양(Clockwise가 참이면 시계방향, 거짓이면 반시계방향)으로
 n*n 정수 배열을 채워 return
 */
public class s02 {
    static int[] dx = { 1, 0, -1, 0};
    static int[] dy = { 0, 1, 0, -1};

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st;

        int n = 5;
        boolean clockwise = true;
        int[][] mapArr = new int[n][n];
        int[][] answer = new int[n][n];




        process(mapArr, n, 0, 0, 0, 1);
        process(mapArr, n, 1, n-1, 0, 1);
        process(mapArr, n, 2, n-1, n-1, 1);
        process(mapArr, n, 3, 0, n-1, 1);

        for(int i = 0 ; i < n ; i++){
            for(int j = 0 ; j < n ; j++){
                System.out.print(mapArr[i][j]);
            }
            System.out.println("");
        }
    }

    // i가 0이면 오른쪽으로
    // i가 1이면 아래로
    // i가 2면 왼쪽으로
    // i가 3이면 위로
    static void process(int[][] mapArr, int idx, int direction, int x, int y, int mark){

        if(idx == 1) {
            mapArr[y][x] = mark;
            return;
        }

        for(int i = 0 ; i < idx-1 ; i++){
            mapArr[y][x] = mark;
            x = x + dx[direction];
            y = y + dy[direction];
            mark++;
        }

        x = x - dx[direction];
        y = y - dy[direction];
        direction = (direction+1) % 4;
        x = x + dx[direction];
        y = y + dy[direction];




        process(mapArr, idx-2, direction, x, y, mark);
    }
}
