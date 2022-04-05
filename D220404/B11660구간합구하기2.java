package studyAlgorithm.D220404;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;


/**
 N * N개의 수가 N * N 크기의 표에 채워져 있다.
 표 안의 수 중 (X1, Y1) 에서 (X2, Y2)까지의 합을 구하려 한다. X는 행, Y는 열을 의미한다.

 입력
 ---
 1번째 줄에 표의 크기 N과 합을 구해야 하는 횟수 M이 주어진다.
 2번째 줄부터 N개의 줄에는 표에 채워져 있는 수가 1행부터 차례대로 주어진다.
 다음 M개의 줄에는 4개의 정수 X1, Y1, X2, Y2가 주어지며, (X1,Y1)에서 (X2, Y2)의 합을 구해 출력해야 한다.

4 3
1 2 3 4
2 3 4 5
3 4 5 6
4 5 6 7
2 2 3 4
3 4 3 4
1 1 4 4
 */
public class B11660구간합구하기2 {

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st;
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        st = new StringTokenizer(br.readLine(), " ");

        // 2차원 배열의 크기
        int N = Integer.parseInt(st.nextToken());
        
        // 구간 합 질의의 개수
        int M = Integer.parseInt(st.nextToken());

        // 배열 세팅
        int[][] numArr = new int[N+1][N+1];
        int[][] sumArr = new int[N+1][N+1];

        for(int i = 1 ; i <= N ; i++){
            st = new StringTokenizer(br.readLine(), " ");
            for(int j = 1 ; j <= N ; j++){
                numArr[i][j] = Integer.parseInt(st.nextToken());

                if(j == 1){
                    sumArr[i][j] = sumArr[i-1][N] + numArr[i][j];
                }
                else{
                    sumArr[i][j] = sumArr[i][j-1] + numArr[i][j];
                }

            }
        }

        // 구간 합 질의
        for(int j = 0 ; j < M ; j++){
            st = new StringTokenizer(br.readLine(), " ");

            int firstX = Integer.parseInt(st.nextToken());
            int firstY = Integer.parseInt(st.nextToken());
            int secondX = Integer.parseInt(st.nextToken());
            int secondY = Integer.parseInt(st.nextToken());

            if(firstX == secondX && firstY == secondY){
                bw.write(String.valueOf(numArr[secondX][secondY]));
            }
            else{
                bw.write(String.valueOf(sumArr[secondX][secondY] - sumArr[firstX][firstY]));
            }

            bw.write('\n');
        }

        bw.flush();
    }
}
